import java.util.Objects;

public abstract class User {
    private final int id;
    private final String nome;

    public User(int id, String nome) {
        this.id = id;
        this.nome = nome;
    }

    @Override
    public String toString() {
        return nome + " [id: "+id+"]";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof User user)) return false;

        if (id != user.id) return false;
        return Objects.equals(nome, user.nome);
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (nome != null ? nome.hashCode() : 0);
        return result;
    }

    public abstract UserType getType();

    // Getters

    public int getId() {
        return this.id;
    }

    public String getNome() {
        return this.nome;
    }
}
