package Atividades;

import java.util.*;

public class PasseioBicicleta extends Atividade{
    private Set<String> lista = new TreeSet<>();

    public PasseioBicicleta(int ID, String nome) {
        super(ID, nome);
    }

    public PasseioBicicleta(int ID, String nome, String[] lista) {
        super(ID, nome);
        this.lista = new TreeSet<>(List.of(lista));
    }

    @Override
    public String toString() {
        return super.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof PasseioBicicleta that)) return false;

        return Objects.equals(lista, that.lista);
    }

    @Override
    public int hashCode() {
        return lista != null ? lista.hashCode() : 0;
    }

    public void addLocal(String local){
        lista.add(local);
    }


    @Override
    public Collection<String> locais() {
        return new ArrayList<>(lista);
    }
}
