package aula07.ex3;

import static java.awt.Color.BLUE;

public class Robot extends MovableObject{
    private String id;
    private RobotType type;
    private int scoredGoals;
    private static String[] iconPaths = {"src\\aula07\\ex3\\Icons\\robot1.png","src\\aula07\\ex3\\Icons\\robot2.png"};

    private static final double MIN_DISTANCE = 125;

    public Robot(String id, RobotType type) {
        this.id = id;
        this.type = type;

        switch (type) {
            case GOALKEEPER -> {
                setXVelocity(0);
                setYVelocity(1);
            }
            case DEFENSE -> {
                setXVelocity(1);
                setYVelocity(1);
            }
            case MIDDLE -> {
                setXVelocity(2);
                setYVelocity(2);
            }
            case STRIKER -> {
                setXVelocity(4);
                setYVelocity(4);
            }
        }


    }

    public void trackMove(int trackX, int trackY){
        int xVelocity = this.getXVelocity();
        int yVelocity = this.getYVelocity();

        if(trackX < this.getX() && xVelocity > 0 || trackX > this.getX() && xVelocity < 0)
            this.setXVelocity((-1)*xVelocity);

        if(trackY < this.getY() && yVelocity > 0 || trackY > this.getY() && yVelocity < 0)
            this.setYVelocity((-1)*yVelocity);;

        this.move(getX()+this.getXVelocity(), getY()+this.getYVelocity());
    }

    public boolean checkCollision(MovableObject object, int objectRadio, int robotRadio){
        int xBallCenter = object.getX()+objectRadio;
        int yBallCenter = object.getY()+objectRadio;

        int xRobotCenter = getX()+robotRadio;
        int yRobotCenter = getY()+robotRadio;

        double distance = Math.sqrt(Math.pow((xBallCenter-xRobotCenter),2) + Math.pow(yBallCenter-yRobotCenter,2));
        int sumRadius = objectRadio + robotRadio;

        return distance <= sumRadius;
    }

    public void collide(MovableObject object){
        double k = 2;

        int rc1 = this.getX() - object.getX();
        int rc2 = this.getY() - object.getY();

        if(Math.random() >= 0.5){
            object.setXVelocity((int) (-k * ((Math.abs(rc1)) * (rc1 >= 0 ? 1 : -1) + 5))/5);
            object.setYVelocity((int) (-k * ((Math.abs(rc2)) * (rc2 >= 0 ? 1 : -1) + 5))/8);
        }
        else{
            object.setXVelocity((int) (-k * ((Math.abs(rc1)) * (rc1 >= 0 ? 1 : -1) - 5))/5);
            object.setYVelocity((int) (-k * ((Math.abs(rc2)) * (rc2 >= 0 ? 1 : -1) - 5))/8);
        }

        if(object instanceof Ball ball){
            ball.kickBy(this);
        }
    }



    public void score(){
        this.scoredGoals++;
    }

    // Static Methods

    public static void setIconPaths(String[] iconPaths) {
        Robot.iconPaths = iconPaths;
    }

    public static String[] getIconPaths() {
        return Robot.iconPaths;
    }

    // Getters

    public String getId() {
        return this.id;
    }

    public RobotType getType() {
        return this.type;
    }

    public int getScoredGoals() {
        return this.scoredGoals;
    }


    // Setters

    public void setId(String id) {
        this.id = id;
    }

    public void setType(RobotType type) {
        this.type = type;
    }

    public void setScoredGoals(int scoredGoals) {
        this.scoredGoals = scoredGoals;
    }


}
