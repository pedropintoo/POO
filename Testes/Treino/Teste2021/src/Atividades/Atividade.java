package Atividades;

public abstract class Atividade implements PontosdeInteresse{
    private final int ID;
    private final String nome;

    public Atividade(int ID, String nome) {
        this.ID = ID;
        this.nome = nome;
    }

    @Override
    public String toString() {
        return "Atividade [num="+ID+", nome="+nome+"]";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Atividade atividade)) return false;

        if (ID != atividade.ID) return false;
        return getNome() != null ? getNome().equals(atividade.getNome()) : atividade.getNome() == null;
    }

    @Override
    public int hashCode() {
        int result = ID;
        result = 31 * result + (getNome() != null ? getNome().hashCode() : 0);
        return result;
    }

    // Getters

    public String getNome() {
        return this.nome;
    }
}
