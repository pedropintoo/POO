package Produtos;

public class Electrodomestico extends Produto{
    private final String tipo;
    private final String marca;
    private final String modelo;
    private ClasseEnergetica classe;
    private double potencia;

    public Electrodomestico(String tipo, String marca, String modelo, double potencia, double precoBase) {
        super(ProdutoType.ELECTRODOMESTICO, precoBase);
        this.tipo = tipo;
        this.marca = marca;
        this.modelo = modelo;
        this.potencia = potencia;
    }

    public Electrodomestico(String tipo, String marca, String modelo, double precoBase) {
        super(ProdutoType.ELECTRODOMESTICO, precoBase);
        this.tipo = tipo;
        this.marca = marca;
        this.modelo = modelo;
    }

    @Override
    public String toString() {
        return super.toString() + " ["+super.getCode() + " " + tipo + " " + marca + " " + modelo + " " + classe.name() + " " + potencia + " W" + "]";
    }

    @Override
    public String getDescricao() {
        return tipo+":"+marca + "/"+modelo;
    }

    // Setters

    public void setClasse(ClasseEnergetica classe) {
        this.classe = classe;
    }

    public void setPotencia(double potencia) {
        this.potencia = potencia;
    }


    // Getters

    public String getTipo() {
        return this.tipo;
    }

    public String getMarca() {
        return this.marca;
    }

    public String getModelo() {
        return this.modelo;
    }

    public ClasseEnergetica getClasseEnergetica() {
        return this.classe;
    }

    public double getPotencia() {
        return this.potencia;
    }
}
