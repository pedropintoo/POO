package aula07.ex3;

public abstract class MovableObject {
    private int xVelocity;
    private int yVelocity;
    private int x;
    private int y;
    private double travelledDistance;


    public void move(int newX, int newY) {
        // Recalculate the travelledDistance
        double distance = Math.sqrt(Math.pow(newX-getX(),2) + Math.pow(newY-getY(),2));
        setTravelledDistance(getTravelledDistance() + distance);

        setX(newX);
        setY(newY);

    }


    // Getters

    public int getX() {
        return this.x;
    }

    public int getY() {
        return this.y;
    }

    public double getTravelledDistance() {
        return this.travelledDistance;
    }

    public int getXVelocity() {
        return this.xVelocity;
    }

    public int getYVelocity() {
        return this.yVelocity;
    }

    // Setters


    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void setTravelledDistance(double travelledDistance) {
        this.travelledDistance = travelledDistance;
    }

    public void setXVelocity(int xVelocity) {
        this.xVelocity = xVelocity;
    }

    public void setYVelocity(int yVelocity) {
        this.yVelocity = yVelocity;
    }
}
