package Atividades;

import java.util.Objects;

public class Restaurante {
    private final String nome;
    private final TipoComida tipoComida;

    public Restaurante(String nome, TipoComida tipoComida) {
        this.nome = nome;
        this.tipoComida = tipoComida;
    }

    @Override
    public String toString() {
        return "Restaurante [nome="+nome+
                ", tipo="+tipoComida.name().charAt(0)+
                tipoComida.name().substring(1).toLowerCase()+"]";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Restaurante that)) return false;

        if (!Objects.equals(nome, that.nome)) return false;
        return tipoComida == that.tipoComida;
    }

    @Override
    public int hashCode() {
        int result = nome != null ? nome.hashCode() : 0;
        result = 31 * result + (tipoComida != null ? tipoComida.hashCode() : 0);
        return result;
    }
}
