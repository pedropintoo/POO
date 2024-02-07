package EPP;

import POO2223.Storage.StorageUnit;
import POO2223.Storage.UnitType;

import java.time.LocalDate;
import java.util.*;


public class StorageService implements StorageServiceInterface{
    private String name;
    private String endereco;
    // Lista unidade de arrumacao e clientes
    private List<StorageUnit> storageUnitList = new ArrayList<>();
    private Map<Client, ArrayList<Rental>> clientRentalList = new HashMap<>();

    public StorageService(String name, String endereco) {
        this.name = name;
        this.endereco = endereco;
    }

    @Override
    public boolean registerClient(int taxId, String name, ClientType type) {
        Client client = new Client(taxId, name, type);
        if(clientRentalList.containsKey(client)){
            return false;
        }
        clientRentalList.put(new Client(taxId, name, type), new ArrayList<Rental>());

        return clientRentalList.containsKey(client);
    }

    @Override
    public Client getClient(int taxId) {
        for( Client client : clientRentalList.keySet()){
            if(client.getTaxId() == taxId){
                return client;
            }
        }
        return null;
    }

    @Override
    public void addStorageUnit(StorageUnit storageUnit) {
        storageUnitList.add(storageUnit);
    }

    @Override
    public void addStorageUnits(Collection<StorageUnit> storageUnits) {
        storageUnitList.addAll(storageUnits);
    }

    @Override
    public boolean checkAvailability(StorageUnit storageUnit, LocalDate startDate, LocalDate endDate) {
        StorageUnit available = storageUnitList.stream()
                .filter(stu -> stu.equals(storageUnit) && stu.getRental() != null && stu.getRental().getStartDate().equals(startDate)
                        && stu.getRental().getEndDate().equals(endDate))
                .findFirst()
                .orElse(null);

        return available != null;
    }

    @Override
    public List<StorageUnit> findAvailableUnits(UnitType unitType, LocalDate fromDate, int duration, int[] minDimensions) {
        return storageUnitList.stream()
                .filter(stu -> stu.getType().equals(unitType)
                        && stu.getRental().getStartDate().equals(fromDate)
                        && stu.getRental().getDuration() == duration
                        && stu.getDimensoes()[0] >= minDimensions[0]
                        && stu.getDimensoes()[1] >= minDimensions[1]
                        && stu.getDimensoes()[2] >= minDimensions[2])
                .toList();

    }

    @Override
    public double calculateTotalCost(StorageUnit unit, int duration) {
        return unit.getPrecoDia()*duration;
    }

    @Override
    public List<String> listRentals() {
        List<String> list = new ArrayList<>();
        for( Map.Entry<Client, ArrayList<Rental>> entry : clientRentalList.entrySet()){
            list.add(entry.getKey().toString() + " - ");
            entry.getValue().forEach(x -> list.add(x.toString()));
            list.add("\n");
        }
        return list;
    }

    @Override
    public List<String> listRentals(UnitType unitType) {
        return null;
    }

    @Override
    public boolean rentStorageUnit(Client client, StorageUnit unit, LocalDate startDate, int duration) {
        // Apenas clientes do tipo empresarial podem alugar WarehouseStorage
        if(client.getType().equals(ClientType.PERSONAL) && unit.getType().equals(UnitType.WAREHOUSE))
            return false;


        if( !checkAvailability(unit, startDate, startDate.plusDays(duration)))
            return false;

        if(!clientRentalList.containsKey(client)){
            registerClient(client.getTaxId(), client.getName(), client.getType());
        }
        unit.setRental(new Rental(startDate, startDate.plusDays(duration)));

        return clientRentalList.get(client).add(unit.getRental());

    }

    public List<StorageUnit> getAvailableUnitsBySize(LocalDate startDate, int size){

        return null;
    }
}
