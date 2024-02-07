package aula07.ex3;

public class Ball extends MovableObject{
    private String color;
    private String iconPath;
    private Robot lastKick;

    public Ball(String color) {
        this.color = color;
        this.iconPath = "src\\aula07\\ex3\\Icons\\ball_"+color+".png";
        setXVelocity(0);
        setYVelocity(0);
    }

    public void kickBy(Robot robot){
        this.lastKick = robot;
    }

    public Robot getLastKick(){
        return this.lastKick;
    }

    // Getters

    public String getColor() {
        return this.color;
    }

    public String getIconPath() {
        return this.iconPath;
    }
    // Setters

    public void setColor(String color) {
        this.color = color;
    }

    public void setIconPath(String iconPath) {
        this.iconPath = iconPath;
    }
}
