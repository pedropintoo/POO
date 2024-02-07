import Espacos.*;

import java.time.LocalDate;

import java.time.temporal.ChronoUnit;
import java.util.*;

public class CampingService implements CampingServiceInterface{
    private final String nome;
    private final String address;

    private final ArrayList<CampingSpace> listCampingSpaces = new ArrayList<>();
    private final Set<Client> listClients = new HashSet<>();
    private final Map<Client,ArrayList<Booking>> mapClients = new HashMap<>();

    public CampingService(String nome, String address) {
        this.nome = nome;
        this.address = address;
    }

    @Override
    public String toString() {
        return "Camping Service "+nome+" in "+address;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof CampingService that)) return false;

        if (!Objects.equals(nome, that.nome)) return false;
        if (!Objects.equals(address, that.address)) return false;
        if (listCampingSpaces != null ? !listCampingSpaces.equals(that.listCampingSpaces) : that.listCampingSpaces != null)
            return false;
        if (listClients != null ? !listClients.equals(that.listClients) : that.listClients != null) return false;
        return mapClients != null ? mapClients.equals(that.mapClients) : that.mapClients == null;
    }

    @Override
    public int hashCode() {
        int result = nome != null ? nome.hashCode() : 0;
        result = 31 * result + (address != null ? address.hashCode() : 0);
        result = 31 * result + (listCampingSpaces != null ? listCampingSpaces.hashCode() : 0);
        result = 31 * result + (listClients != null ? listClients.hashCode() : 0);
        result = 31 * result + (mapClients != null ? mapClients.hashCode() : 0);
        return result;
    }

    @Override
    public boolean registerClient(int taxId, String name, ClientType type) {
        Client client = new Client(taxId, name, type);
        if(!listClients.contains(client)){
            mapClients.put(client, new ArrayList<>());
            return listClients.add(client);
        }
        return false;
    }

    @Override
    public Client getClient(int taxId) {
        return listClients.stream()
                .filter(client -> client.getTaxId() == taxId)
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
        Set<Booking> listBookings = campingSpace.getListBookings();

        int duration = (int) startDate.until(endDate, ChronoUnit.DAYS);
        if(campingSpace.getDuracaoMax() < duration)
            return false;

        int nBookingsNotAvailable = listBookings.stream()
                .filter(bk ->
                        bk.getStartDate().equals(startDate) ||
                        bk.getStartDate().equals(endDate) ||
                        bk.getEndDate().equals(startDate) ||
                        bk.getEndDate().equals(endDate) ||
                        (bk.getStartDate().isBefore(endDate) && bk.getEndDate().isAfter(startDate)))
                .toList().size();

        return nBookingsNotAvailable == 0;

    }

    @Override
    public List<CampingSpace> findAvailableCampingSpaces(SpaceType spaceType, LocalDate fromDate, int duration, int[] minDimensions) {
        return listCampingSpaces.stream()
                .filter(campingSpace ->
                        campingSpace.getDimensoes()[0] >= minDimensions[0] &&
                        campingSpace.getDimensoes()[1] >= minDimensions[1] &&
                        campingSpace.getType().equals(spaceType) &&
                        checkAvailable(campingSpace, fromDate, fromDate.plusDays(duration)))
                .toList();
    }

    @Override
    public boolean bookCampingSpace(Client client, CampingSpace campingSpace, LocalDate startDate, int duration) {
        if(!listClients.contains(client) || !listCampingSpaces.contains(campingSpace) || (campingSpace.getType().equals(SpaceType.CARAVAN) && client.getType().equals(ClientType.NORMAL))){
            return false;
        }

        if(checkAvailable(campingSpace,startDate,startDate.plusDays(duration))){
            Booking booking = new Booking(campingSpace, startDate, duration);
            campingSpace.addBooking(booking);
            return mapClients.get(client).add(booking);
        }
        return false;
    }

    @Override
    public double calculateTotalCost(CampingSpace campingSpace, int duration) {
        return campingSpace.getPrecoPorDia()*duration;
    }

    @Override
    public List<String> listBookings() {
        List<String> stringList = new ArrayList<>();
        mapClients.forEach(((client, bookings) -> {
            if(bookings.size() != 0){ // Apenas os clientes com eventos!
                stringList.add(client.toString());
                bookings.forEach(booking -> stringList.add(" - "+booking+
                        String.format(", total cost %.2f\n",
                                calculateTotalCost(booking.getCampingSpaceAssociated(),booking.getDuration())))
                );
            }

        }));
        return stringList;
    }

    @Override
    public List<String> listBookings(SpaceType spaceType) {
        List<String> stringList = new ArrayList<>();
        mapClients.values()
                .forEach(bookings -> bookings.stream().filter(booking -> booking.getCampingSpaceAssociated().getType().equals(spaceType))
                        .forEach(booking -> stringList.add(booking.toString())));
        return stringList;
    }

    public List<String> getAvailableSpacesByTotalArea(LocalDate fromDate, int duration) {
        List<String> stringList = new ArrayList<>();
        listCampingSpaces.stream()
                .filter(campingSpace -> checkAvailable(campingSpace, fromDate, fromDate.plusDays(duration)))
                .sorted(Comparator.comparing(CampingSpace::getArea).reversed())
                .forEach(campingSpace -> stringList.add(campingSpace.toString()));
        return stringList;
    }
}
