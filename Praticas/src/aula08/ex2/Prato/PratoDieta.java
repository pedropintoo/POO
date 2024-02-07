package aula08.ex2.Prato;

import aula08.ex2.Alimento.Alimento;

public class PratoDieta extends Prato {
    private final double limiteCalorias;
    private double totalCalorias = 0;

    public PratoDieta(String nome, double limiteCalorias) {
        super(nome);
        this.limiteCalorias = limiteCalorias;
    }

    @Override
    public String toString() {
        return super.toString() + " Dieta ("+this.limiteCalorias+" Calorias)";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof PratoDieta that)) return false;
        if (!super.equals(o)) return false;

        if (Double.compare(that.limiteCalorias, limiteCalorias) != 0) return false;
        return Double.compare(that.totalCalorias, totalCalorias) == 0;
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        long temp;
        temp = Double.doubleToLongBits(limiteCalorias);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(totalCalorias);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }

    @Override
    public boolean addIngrediente(Alimento alimento) {
        if (limiteCalorias >= totalCalorias + alimento.getCalorias()) {
            this.totalCalorias += alimento.getCalorias();
            return super.addIngrediente(alimento);
        }
        else
            return false;
    }
}
