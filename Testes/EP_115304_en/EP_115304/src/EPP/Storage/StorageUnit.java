package EPP.Storage;

import POO2223.Rental;

import java.util.Arrays;

public class StorageUnit {
    private String localizacao;
    private int[] dimensoes; //largura, comprimento, altura
    private double precoDia;
    private UnitType type;
    private Rental rental;

    public StorageUnit(String localizacao, int[] dimensoes, double precoDia) {
        this.localizacao = localizacao;
        this.dimensoes = dimensoes;
        this.precoDia = precoDia;
        this.type = UnitType.STORAGE;
        this.rental = null;
    }

    @Override
    public String toString() {
        return rental.toString() + type.name() + " unit located in " + localizacao + ", with dimension "
                + dimensoes[0] + "x"+ dimensoes[1] + "x"+ dimensoes[2] + "x"
                + ", "+precoDia+"/dia";
    }

    // Getters

    public UnitType getType() {
        return this.type;
    }

    public Rental getRental() {
        return this.rental;
    }

    public int[] getDimensoes() {
        return this.dimensoes;
    }

    public String getLocalizacao() {
        return this.localizacao;
    }

    public double getPrecoDia() {
        return this.precoDia;
    }


    // Setters


    public void setType(UnitType type) {
        this.type = type;
    }

    public void setRental(Rental rental) {
        this.rental = rental;
    }
}
