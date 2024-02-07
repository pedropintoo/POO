import Atividades.*;

import java.util.*;
import java.util.stream.Collectors;

public class AgenciaTuristica {
    private final String name;
    private final String address;
    private final Set<Atividade> listAtividades = new HashSet<>();

    public AgenciaTuristica(String name, String address) {
        this.name = name;
        this.address = address;
    }

    @Override
    public String toString() {
        Collection<String> stringCollection = new ArrayList<>();
        listAtividades.forEach(atividade -> stringCollection.add(atividade.toString()));
        return "Agencia Turistica "+name + "\n\t"+
                "Atividade: "+stringCollection;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof AgenciaTuristica that)) return false;

        if (getName() != null ? !getName().equals(that.getName()) : that.getName() != null) return false;
        if (getAddress() != null ? !getAddress().equals(that.getAddress()) : that.getAddress() != null) return false;
        return getListAtividades() != null ? getListAtividades().equals(that.getListAtividades()) : that.getListAtividades() == null;
    }

    @Override
    public int hashCode() {
        int result = getName() != null ? getName().hashCode() : 0;
        result = 31 * result + (getAddress() != null ? getAddress().hashCode() : 0);
        result = 31 * result + (getListAtividades() != null ? getListAtividades().hashCode() : 0);
        return result;
    }

    public int totalItems(){
        return listAtividades.stream()
                .mapToInt(atividade -> atividade.locais().size())
                .sum();
    }

    public void add(Atividade atividade){
        listAtividades.add(atividade);
    }

    public Collection<Atividade> atividades(){
        return listAtividades;
    }

    public Collection<String> getAllItems(){
        Collection<String> strCollection = new TreeSet<>();
        listAtividades.forEach(atividade -> strCollection.addAll(atividade.locais()));
        return strCollection;
    }

    // Getters

    public String getName() {
        return this.name;
    }

    public String getAddress() {
        return this.address;
    }

    public Set<Atividade> getListAtividades() {
        return this.listAtividades;
    }
}
