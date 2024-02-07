package Espacos;

public enum SpaceType {
    CARAVAN,
    CAR,
    TENT;

    @Override
    public String toString(){
        return this.name().charAt(0)+this.name().substring(1).toLowerCase();
    }
}
