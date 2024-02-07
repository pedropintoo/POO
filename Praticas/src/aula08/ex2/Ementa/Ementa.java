package aula08.ex2.Ementa;

import aula08.ex2.DiaSemana;
import aula08.ex2.Prato.Prato;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;

public class Ementa {
    private final String nome;
    private final String local;
    private final Map< DiaSemana , Prato> listaPratos =  new LinkedHashMap<>();

    public Ementa(String nome, String local) {
        this.nome = nome;
        this.local = local;

    }

    public void addPrato(Prato prato, DiaSemana diaSemana){
        this.listaPratos.put(diaSemana, prato);
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder(this.nome + " : " + this.local + "\n\n");

        for(Map.Entry<DiaSemana, Prato> entry : this.listaPratos.entrySet()){
            result.append(entry.getValue().toString());
            result.append(", dia ").append(entry.getKey());
            result.append("\n");
        }
        return result.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Ementa ementa)) return false;

        if (!Objects.equals(nome, ementa.nome)) return false;
        if (!Objects.equals(local, ementa.local)) return false;
        return listaPratos != null ? listaPratos.equals(ementa.listaPratos) : ementa.listaPratos == null;
    }

    @Override
    public int hashCode() {
        int result = nome != null ? nome.hashCode() : 0;
        result = 31 * result + (local != null ? local.hashCode() : 0);
        result = 31 * result + (listaPratos != null ? listaPratos.hashCode() : 0);
        return result;
    }
}
