package EPP.Storage;

public class LockerStorage extends StorageUnit{
    private final int duracaoMaxima = 30;

    public LockerStorage(String localizacao, int[] dimensoes, double precoDia) {
        super(localizacao, dimensoes, precoDia);
        super.setType(UnitType.LOCKER);
    }
}
