package aula08.ex2.Alimento;

public abstract class Alimento {
    private final double proteinas;
    private final double calorias;
    private final double peso;

    public Alimento(double proteinas, double calorias, double peso) {
        this.proteinas = proteinas;
        this.calorias = calorias;
        this.peso = peso;
    }

    @Override
    public String toString() {
        return "Proteinas "+proteinas+", calorias "+calorias+", peso "+peso;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Alimento alimento)) return false;

        if (Double.compare(alimento.proteinas, proteinas) != 0) return false;
        if (Double.compare(alimento.getCalorias(), getCalorias()) != 0) return false;
        return Double.compare(alimento.getPeso(), getPeso()) == 0;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        temp = Double.doubleToLongBits(proteinas);
        result = (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(getCalorias());
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(getPeso());
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }

    // Getters

    public double getCalorias() {
        return this.calorias;
    }

    public double getPeso() {
        return this.peso;
    }
}
