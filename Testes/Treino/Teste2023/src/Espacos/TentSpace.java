package Espacos;

public class TentSpace extends CampingSpace{
    private final SpaceType type;
    public TentSpace(String localizacao, int[] dimensoes, int precoPorDia) {
        super(localizacao, dimensoes, precoPorDia, 10);
        this.type = SpaceType.TENT;
    }

    @Override
    public String toString() {
        return "Tent " + super.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof TentSpace tentSpace)) return false;

        return getType() == tentSpace.getType();
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
