package Entidades;

import Entidades.*;
import java.util.*;

public class Equipa {
    private final String nome;
    private final String treinador;
    private int golosMarcados;
    private int golosSofridos;

    private final Set<Robo> listaRobos = new HashSet<>();;

    public Equipa(String nome, String treinador) {
        this.nome = nome;
        this.treinador = treinador;
    }

    @Override
    public String toString() {
        StringBuilder str = new StringBuilder();
        listaRobos.forEach(robo -> str.append(robo.toString()).append(" *;* "));

        return nome+", treinada por "+treinador + "("+listaRobos.size()+" jogadores)\n  robos= "
                + str + "\n  golosMarcados="+golosMarcados+"\n";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Equipa equipa)) return false;

        if (getGolosMarcados() != equipa.getGolosMarcados()) return false;
        if (getGolosSofridos() != equipa.getGolosSofridos()) return false;
        if (getNome() != null ? !getNome().equals(equipa.getNome()) : equipa.getNome() != null) return false;
        if (getTreinador() != null ? !getTreinador().equals(equipa.getTreinador()) : equipa.getTreinador() != null)
            return false;
        return getListaRobos() != null ? getListaRobos().equals(equipa.getListaRobos()) : equipa.getListaRobos() == null;
    }

    @Override
    public int hashCode() {
        int result = getNome() != null ? getNome().hashCode() : 0;
        result = 31 * result + (getTreinador() != null ? getTreinador().hashCode() : 0);
        result = 31 * result + getGolosMarcados();
        result = 31 * result + getGolosSofridos();
        result = 31 * result + (getListaRobos() != null ? getListaRobos().hashCode() : 0);
        return result;
    }

    public void add(Robo robo){
        listaRobos.add(robo);
    }

    public void remove(Robo robo){
        listaRobos.remove(robo);
    }

    // Getters


    public String getNome() {
        return this.nome;
    }

    public String getTreinador() {
        return this.treinador;
    }

    public int getGolosMarcados() {
        this.golosMarcados = listaRobos.stream()
                .mapToInt(Robo::getGolos)
                .sum();
        return this.golosMarcados;
    }

    public int getGolosSofridos() {
        return this.golosSofridos;
    }

    public Set<Robo> getListaRobos() {
        return this.listaRobos;
    }

    public Robo[] getRobos() {
        Robo[] robo = new Robo[listaRobos.size()];
        int i = 0;
        for(Robo rb :listaRobos){
            robo[i] = rb;
            i++;
        }
        return robo;
    }
}
