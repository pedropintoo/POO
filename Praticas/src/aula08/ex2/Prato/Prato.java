package aula08.ex2.Prato;

import aula08.ex2.Alimento.Alimento;

import java.util.ArrayList;
import java.util.Objects;

public class Prato {
    private final String nome;
    private final ArrayList<Alimento> composicao = new ArrayList<>();

    public Prato(String nome) {
        this.nome = nome;
    }

    @Override
    public String toString() {
        String result = "";
        result += "Prato " + this.nome;
        result += ", composto por " + totalIngredientes() + " Ingredientes - Prato";

        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Prato prato)) return false;

        if (!Objects.equals(nome, prato.nome)) return false;
        return composicao != null ? composicao.equals(prato.composicao) : prato.composicao == null;
    }

    @Override
    public int hashCode() {
        int result = nome != null ? nome.hashCode() : 0;
        result = 31 * result + (composicao != null ? composicao.hashCode() : 0);
        return result;
    }

    public boolean addIngrediente(Alimento alimento){
        this.composicao.add(alimento);
        return true;
    }

    public int totalIngredientes(){
        return this.composicao.size();
    }

    public double totalPeso(){
        double totalPeso = 0.0;
        for(Alimento alimento : this.composicao){
            totalPeso += alimento.getPeso();
        }
        return totalPeso;
    }
}
