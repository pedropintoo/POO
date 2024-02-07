package CampSpace;

public class CaravanSpace extends CampingSpace{
    public CaravanSpace(String localizacao, int[] dimensao, int precoPorDia) {
        super(localizacao, dimensao, precoPorDia);
        super.setType(SpaceType.CARAVAN);
    }
}
