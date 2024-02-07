public class Client {
    private final String name;
    private ClientType type;
    private final int nContribuinte;

    public Client(int nContribuinte, String name, ClientType type) {
        this.name = name;
        this.type = type;
        this.nContribuinte = nContribuinte;
    }

    @Override
    public String toString() {
        return name + " [" + type+": "+nContribuinte+"]";
    }

    public String getName() {
        return this.name;
    }

    public ClientType getType() {
        return this.type;
    }

    public int getnContribuinte() {
        return this.nContribuinte;
    }
}
