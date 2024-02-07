package Espacos;

public class CarSpace extends CampingSpace {
    private final SpaceType type;
    public CarSpace(String localizacao, int[] dimensoes, int precoPorDia) {
        super(localizacao, dimensoes, precoPorDia, 3*30);
        this.type = SpaceType.CAR;
    }

    @Override
    public String toString() {
        return "Car " + super.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof CarSpace carSpace)) return false;

        return getType() == carSpace.getType();
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
