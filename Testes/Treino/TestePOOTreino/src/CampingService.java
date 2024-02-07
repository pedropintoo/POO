import CampSpace.*;

import java.time.LocalDate;
import java.util.*;

public class CampingService implements CampingServiceInterface{
    private final String name;
    private final String address;

    private List<CampingSpace> listCampingSpaces = new ArrayList<>();
    private List<Client> listClients = new ArrayList<>();
    private Map<Client,ArrayList<Booking>> mapClientBooking = new HashMap<>();

    public CampingService(String name, String address) {
        this.name = name;
        this.address = address;
    }

    @Override
    public boolean registerClient(int taxId, String name, ClientType type) {
        if (getClient(taxId) == null) {
            listClients.add(new Client(taxId, name, type));
            ArrayList<Booking> startList = new ArrayList<>(){};
            mapClientBooking.put(getClient(taxId),startList);
            return true;
        }

        return false;
    }

    @Override
    public Client getClient(int taxId) {
        return listClients.stream()
                .filter(client -> client.getnContribuinte() == taxId)
                .findFirst()
                .orElse(null);
    }

    @Override
    public void addCampingSpace(CampingSpace campingSpace) {
        listCampingSpaces.add(campingSpace);
    }

    @Override
    public void addCampingSpaces(Collection<CampingSpace> campingSpaces) {
        listCampingSpaces.addAll(campingSpaces);
    }

    @Override
    public boolean checkAvailable(CampingSpace campingSpace, LocalDate startDate, LocalDate endDate) {
        int duration = (int) (endDate.toEpochDay() - startDate.toEpochDay());
        if(duration > campingSpace.getDuracaoMax()) return false;

        List<Booking> listBook = campingSpace.getListBookings();
        for(Booking booking : listBook){
            LocalDate start = booking.getStartDate();
            LocalDate end = booking.getEndDate();
            if(start.equals(startDate) || start.equals(endDate) || end.equals(endDate) || end.equals(startDate) ||
               start.isAfter(startDate) && end.isBefore(endDate) ||
               start.isAfter(startDate) && start.isBefore(endDate) && end.isAfter(endDate) ||
               start.isBefore(startDate) && end.isAfter(endDate) ||
               start.isBefore(startDate) && end.isAfter(startDate) && end.isBefore(endDate)){
                return false;
            }
        }
        return true;
    }

    @Override
    public List<CampingSpace> findAvailableCampingSpaces(SpaceType spaceType, LocalDate fromDate, int duration, int[] minDimensions) {

        return listCampingSpaces.stream()
                .filter(campingSpace -> campingSpace.getType() == spaceType
                        && campingSpace.getDimensao()[0] >= minDimensions[0] && campingSpace.getDimensao()[1] >= minDimensions[1]
                        && checkAvailable(campingSpace,fromDate, fromDate.plusDays(duration)))
                .toList();

    }

    @Override
    public boolean bookCampingSpace(Client client, CampingSpace campingSpace, LocalDate startDate, int duration) {


        if(campingSpace.getType() == SpaceType.CARAVAN && client.getType() == ClientType.NORMAL) return false;

        LocalDate endDate = startDate.plusDays(duration);
        if(checkAvailable(campingSpace,startDate,endDate)){

            Booking booking = new Booking(startDate, endDate);
            campingSpace.addBooking(booking);
            List<Booking> list = mapClientBooking.get(client);
            list.add(booking);
            booking.setSpace(campingSpace);
            return true;
        }
        return false;
    }

    @Override
    public double calculateTotalCost(CampingSpace campingSpace, int duration) {
        return campingSpace.getPrecoPorDia() * duration;
    }

    @Override
    public List<String> listBookings() {
        List<String> str = new ArrayList<>();
        mapClientBooking.forEach((k,v) -> {
            if(v.size() > 0){
                str.add(k + " - ");
                for(Booking booking : v){
                    str.add(booking + ", total cost " + calculateTotalCost(booking.getSpace(), booking.getDuration()) + "\n");
                }

            }

        });

        return str;
    }

    @Override
    public List<String> listBookings(SpaceType spaceType) {
        return null;
    }

    public String getAddress() {
        return this.address;
    }
    // listar todos os espaços disponíveis a partir de 2023/12/01 por 60 dias, por ordem decrescente de área total
    public List<CampingSpace> getAvailableSpacesByTotalArea(LocalDate fromDate, int duration){
        return listCampingSpaces.stream()
                .filter(campingSpace -> checkAvailable(campingSpace,fromDate,fromDate.plusDays(duration)))
                .sorted(Comparator.comparing(CampingSpace::getArea).reversed())
                .toList();
    }

}
