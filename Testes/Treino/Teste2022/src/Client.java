public class Client {
    private final String nome;
    private final String localidade;

    public Client(String nome, String localidade) {
        this.nome = nome;
        this.localidade = localidade;
    }

    @Override
    public String toString() {
        return nome+" ["+localidade+"]";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Client client)) return false;

        if (getNome() != null ? !getNome().equals(client.getNome()) : client.getNome() != null) return false;
        return getLocalidade() != null ? getLocalidade().equals(client.getLocalidade()) : client.getLocalidade() == null;
    }

    @Override
    public int hashCode() {
        int result = getNome() != null ? getNome().hashCode() : 0;
        result = 31 * result + (getLocalidade() != null ? getLocalidade().hashCode() : 0);
        return result;
    }

    // Getters

    public String getNome() {
        return this.nome;
    }

    public String getLocalidade() {
        return this.localidade;
    }
}
