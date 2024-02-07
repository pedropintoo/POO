package Atividades;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class Gastronomia extends Atividade{
    private List<Restaurante> lista = new ArrayList<>();

    public Gastronomia(int ID, String name) {
        super(ID, name);
    }

    public Gastronomia(int ID, String name, List<Restaurante> lista) {
        super(ID, name);
        this.lista = lista;
    }

    @Override
    public String toString() {
        return super.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Gastronomia that)) return false;

        return getLista() != null ? getLista().equals(that.getLista()) : that.getLista() == null;
    }

    @Override
    public int hashCode() {
        return getLista() != null ? getLista().hashCode() : 0;
    }

    public void add(Restaurante restaurante){
        lista.add(restaurante);
    }

    @Override
    public Collection<String> locais() {
        Collection<String> stringCollection = new ArrayList<>();
        lista.forEach(restaurante -> stringCollection.add(restaurante.toString()));
        return stringCollection;
    }

    public int totalRestaurantes(){
        return lista.size();
    }

    // Getters

    public List<Restaurante> getLista() {
        return this.lista;
    }
}
