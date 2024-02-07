package CampSpace;

public class CarSpace extends CampingSpace{
    public CarSpace(String localizacao, int[] dimensao, int precoPorDia) {
        super(localizacao, dimensao, precoPorDia);
        super.setType(SpaceType.CAR);
    }
}
