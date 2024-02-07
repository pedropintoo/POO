package test.TestePratico;

public class Package {
    private final int id;
    private final double weight;
    private final String destination;
    private final String sender;

    public Package(int id, double weight, String destination, String sender) {
        this.id = id;
        this.weight = weight;
        this.destination = destination;
        this.sender = sender;
    }

    @Override
    public String toString() {
        return "[" + id +"] " + weight + "kg | " + destination + " <-- " + sender;
    }

    // Getters
    public int getId() {
        return this.id;
    }

    public double getWeight() {
        return this.weight;
    }

    public String getDestination() {
        return this.destination;
    }

    public String getSender() {
        return this.sender;
    }

}
