package aula08.ex2.Prato;


import aula08.ex2.Alimento.Alimento;
import aula08.ex2.Alimento.Vegetariano;

public class PratoVegetariano extends Prato{

    public PratoVegetariano(String nome) {
        super(nome);
    }

    @Override
    public String toString() {
        return super.toString() + " Vegetariano";
    }


    @Override
    public boolean addIngrediente(Alimento alimento) {
        if (alimento instanceof Vegetariano) {
            return super.addIngrediente(alimento);
        }
        else
            return false;
    }


}
