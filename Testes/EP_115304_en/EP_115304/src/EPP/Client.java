package POO2223;

public class Client {
    private int taxId;
    private String name;
    private ClientType type;

    public Client(int taxId, String name, ClientType type) {
        this.taxId = taxId;
        this.name = name;
        this.type = type;
    }

    @Override
    public String toString() {
        return name + " [" + type + ": " + taxId + "]";
    }

    // Getters

    public ClientType getType() {
        return this.type;
    }

    public int getTaxId() {
        return this.taxId;
    }

    public String getName() {
        return this.name;
    }
}
