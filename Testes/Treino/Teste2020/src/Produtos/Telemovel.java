package Produtos;

import java.util.*;

public class Telemovel extends Produto{
    private final String marca;
    private final String modelo;
    private final Set<String> notas = new HashSet<>();

    public Telemovel(String marca, String modelo, double precoBase) {
        super(ProdutoType.TELEMOVEL, precoBase);
        this.marca = marca;
        this.modelo = modelo;
    }

    @Override
    public String toString() {
        return super.toString() + " ["+super.getCode() + ": " + marca + " - " + modelo + " " + notas + "]";
    }

    @Override
    public String getDescricao() {
        return marca + "/"+modelo;
    }

    public void addNota(String nota) {
        notas.add(nota);
    }

    // Getters

    public String getMarca() {
        return this.marca;
    }

    public String getModelo() {
        return this.modelo;
    }

    public Set<String> getNotas() {
        return this.notas;
    }


}
