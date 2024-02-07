import Espacos.*;

import java.util.Objects;

public class Client {
    private final int taxId;
    private final String name;
    private final ClientType type;

    public Client(int taxId, String name, ClientType type) {
        this.taxId = taxId;
        this.name = name;
        this.type = type;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Client client)) return false;

        if (getTaxId() != client.getTaxId()) return false;
        if (!Objects.equals(name, client.name)) return false;
        return getType() == client.getType();
    }

    @Override
    public int hashCode() {
        int result = getTaxId();
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (getType() != null ? getType().hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return name + " ["+type.name()+": "+taxId+"]";
    }

    // Getters

    public int getTaxId() {
        return this.taxId;
    }

    public ClientType getType() {
        return this.type;
    }
}
