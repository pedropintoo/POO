package CampSpace;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CampingSpace {
    private final String localizacao;
    private final int[] dimensao;
    private final double precoPorDia;
    private SpaceType type;
    private int duracaoMax;
    private int custoTotal;

    List<Booking> listBookings = new ArrayList<>();

    public CampingSpace(String localizacao, int[] dimensao, int precoPorDia) {
        this.localizacao = localizacao;
        this.dimensao = dimensao;
        this.precoPorDia = precoPorDia;
    }


    @Override
    public String toString() {
        return type.name().charAt(0) + type.name().substring(1).toLowerCase() + " space located in " + localizacao +
                ", dimension "+dimensao[0]+"x"+dimensao[1]+", "+ precoPorDia+"/day" ;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof CampingSpace that)) return false;

        if (Double.compare(that.getPrecoPorDia(), getPrecoPorDia()) != 0) return false;
        if (getDuracaoMax() != that.getDuracaoMax()) return false;
        if (custoTotal != that.custoTotal) return false;
        if (getLocalizacao() != null ? !getLocalizacao().equals(that.getLocalizacao()) : that.getLocalizacao() != null)
            return false;
        if (!Arrays.equals(getDimensao(), that.getDimensao())) return false;
        if (getType() != that.getType()) return false;
        return getListBookings() != null ? getListBookings().equals(that.getListBookings()) : that.getListBookings() == null;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = getLocalizacao() != null ? getLocalizacao().hashCode() : 0;
        result = 31 * result + Arrays.hashCode(getDimensao());
        temp = Double.doubleToLongBits(getPrecoPorDia());
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + (getType() != null ? getType().hashCode() : 0);
        result = 31 * result + getDuracaoMax();
        result = 31 * result + custoTotal;
        result = 31 * result + (getListBookings() != null ? getListBookings().hashCode() : 0);
        return result;
    }

    public void addBooking(Booking booking){
        listBookings.add(booking);
    }

    public void setType(SpaceType type) {
        this.type = type;
        // Definir duracao max
        switch (type){
            case CARAVAN -> this.duracaoMax = 3 * 365;
            case CAR -> this.duracaoMax = 3 * 30;
            case TENT -> this.duracaoMax = 10;
        }
    }

    public String getLocalizacao() {
        return this.localizacao;
    }

    public int[] getDimensao() {
        return this.dimensao;
    }

    public int getArea(){
        return dimensao[0] * dimensao[1];
    }

    public double getPrecoPorDia() {
        return this.precoPorDia;
    }

    public SpaceType getType() {
        return this.type;
    }

    public int getDuracaoMax() {
        return this.duracaoMax;
    }

    public List<Booking> getListBookings() {
        return this.listBookings;
    }
}
