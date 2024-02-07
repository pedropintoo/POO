package Espacos;

public class CaravanSpace extends CampingSpace{
    private final SpaceType type;
    public CaravanSpace(String localizacao, int[] dimensoes, int precoPorDia) {
        super(localizacao, dimensoes, precoPorDia, 3*365);
        this.type = SpaceType.CARAVAN;
    }

    @Override
    public String toString() {
        return "Caravan " + super.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof CaravanSpace that)) return false;

        return getType() == that.getType();
    }

    @Override
    public int hashCode() {
        return getType() != null ? getType().hashCode() : 0;
    }

    // Getters


    @Override
    public SpaceType getType() {
        return this.type;
    }
}
