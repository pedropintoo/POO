package EPP.Storage;

public class GarageStorage extends StorageUnit{
    private final int duracaoMaxima = 5*365;

    public GarageStorage(String localizacao, int[] dimensoes, double precoDia) {
        super(localizacao, dimensoes, precoDia);
        super.setType(UnitType.GARAGE);
    }
}
