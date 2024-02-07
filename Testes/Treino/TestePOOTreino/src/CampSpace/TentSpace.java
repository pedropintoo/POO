package CampSpace;

public class TentSpace extends CampingSpace{
    public TentSpace(String localizacao, int[] dimensao, int precoPorDia) {
        super(localizacao, dimensao, precoPorDia);
        super.setType(SpaceType.TENT);
    }
}
