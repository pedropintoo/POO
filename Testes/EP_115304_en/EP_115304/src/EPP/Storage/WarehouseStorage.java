package EPP.Storage;

public class WarehouseStorage extends StorageUnit{
    private final int duracaoMaxima = 10*365;

    public WarehouseStorage(String localizacao, int[] dimensoes, double precoDia) {
        super(localizacao, dimensoes, precoDia);
        super.setType(UnitType.WAREHOUSE);

    }
}
