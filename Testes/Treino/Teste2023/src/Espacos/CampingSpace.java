package Espacos;

import java.util.*;

public abstract class CampingSpace {
    private final String localizacao;
    private final int[] dimensoes;
    private final double precoPorDia;
    private final int duracaoMax;

    private final Set<Booking> listBookings = new HashSet<>();

    public CampingSpace(String localizacao, int[] dimensoes, double precoPorDia, int duracaoMax) {
        this.localizacao = localizacao;
        this.dimensoes = dimensoes;
        this.precoPorDia = precoPorDia;
        this.duracaoMax = duracaoMax;
    }

    @Override
    public String toString() {
        return "space located in "+localizacao+", with dimension "+dimensoes[0]+"x"+dimensoes[1]+", "+String.format("%.2f",precoPorDia)+"/day";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof CampingSpace that)) return false;

        if (Double.compare(that.getPrecoPorDia(), getPrecoPorDia()) != 0) return false;
        if (duracaoMax != that.duracaoMax) return false;
        if (!Objects.equals(localizacao, that.localizacao)) return false;
        if (!Arrays.equals(getDimensoes(), that.getDimensoes())) return false;
        return getListBookings() != null ? getListBookings().equals(that.getListBookings()) : that.getListBookings() == null;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = localizacao != null ? localizacao.hashCode() : 0;
        result = 31 * result + Arrays.hashCode(getDimensoes());
        temp = Double.doubleToLongBits(getPrecoPorDia());
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + duracaoMax;
        result = 31 * result + (getListBookings() != null ? getListBookings().hashCode() : 0);
        return result;
    }

    public boolean addBooking(Booking booking){
        return listBookings.add(booking);
    }

    public double getArea(){
        return dimensoes[0] * dimensoes[1];
    }

    // Getters


    public Set<Booking> getListBookings() {
        return this.listBookings;
    }


    public int[] getDimensoes() {
        return this.dimensoes;
    }

    public int getDuracaoMax() {
        return this.duracaoMax;
    }

    public double getPrecoPorDia() {
        return this.precoPorDia;
    }


    public abstract SpaceType getType();
}
