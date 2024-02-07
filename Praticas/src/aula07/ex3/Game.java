package aula07.ex3;

import aula07.ex3.Display.Frame;

public class Game {
    private Team[] teams = new Team[2];
    private Ball ball;
    private int gameDuration;
    private int gameCurrentTime;

    public Game(Team[] teams, Ball ball, int gameDuration) {
        this.teams = teams;
        this.ball = ball;
        this.gameDuration = gameDuration;
    }

    public void defaultPosition(int PANEL_WIDTH, int PANEL_HEIGHT,int BALL_WIDTH, int BALL_HEIGHT,int ROBOT_WIDTH, int ROBOT_HEIGHT){
        Robot[] robotsTeam1 = this.getTeams()[0].getRobots();
        Robot[] robotsTeam2 = this.getTeams()[1].getRobots();

        // Ball
        ballPosition(PANEL_WIDTH, PANEL_HEIGHT);


        // Team1
        // ST
        robotsTeam1[0].setX(((PANEL_WIDTH-5)/4 - ROBOT_WIDTH/2));
        robotsTeam1[0].setY((PANEL_HEIGHT-5)/2 - ROBOT_HEIGHT/2);
        // MD
        robotsTeam1[1].setX(((PANEL_WIDTH-5)/7 - ROBOT_WIDTH/2));
        robotsTeam1[1].setY((PANEL_HEIGHT-5)/3 + - ROBOT_HEIGHT/2);
        // GOOLKEPPER / CB
        robotsTeam1[2].setX(((PANEL_WIDTH-5)/20 - ROBOT_WIDTH/2));
        robotsTeam1[2].setY(2*(PANEL_HEIGHT-5)/3 - ROBOT_HEIGHT/2);

        // Team2
        // ST
        robotsTeam2[0].setX((3*(PANEL_WIDTH-5)/4 - ROBOT_WIDTH/2));
        robotsTeam2[0].setY((PANEL_HEIGHT-5)/2 - ROBOT_HEIGHT/2);
        // MD
        robotsTeam2[1].setX((6*(PANEL_WIDTH-5)/7 - ROBOT_WIDTH/2));
        robotsTeam2[1].setY((PANEL_HEIGHT-5)/3 + - ROBOT_HEIGHT/2);
        // GOOLKEPPER / CB
        robotsTeam2[2].setX((19*(PANEL_WIDTH-5)/20 - ROBOT_WIDTH/2));
        robotsTeam2[2].setY(2*(PANEL_HEIGHT-5)/3 - ROBOT_HEIGHT/2);

    }

    public void ballPosition(int PANEL_WIDTH , int PANEL_HEIGHT){
        this.ball.setXVelocity(0);
        this.ball.setYVelocity(0);
        int random1 = (int) (Math.random() * 500);
        int random2 = (int) (Math.random() * 300);

        this.ball.setX(PANEL_WIDTH - (PANEL_WIDTH-5)/3 - random1);  // -5 is for adjust :D
        this.ball.setY(PANEL_HEIGHT - (PANEL_HEIGHT-5)/3 - random2);
    }

    public void startGame(){
        double gameStartTime = System.currentTimeMillis();

        // Start the game
        Frame frame = new Frame(this);

        while (!isGameEnd()) {

            // Calculate the current time
            this.gameCurrentTime = (int) ((System.currentTimeMillis() - gameStartTime)/1000); // Convert to seconds

            // Stop the game
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        frame.setVisible(false); //you can't see me!
        frame.dispose(); //Destroy the JFrame object

    }

    public boolean isGameEnd(){
        return gameDuration < gameCurrentTime;
    }


    // Getters

    public Team[] getTeams() {
        return this.teams;
    }

    public Ball getBall() {
        return this.ball;
    }
    public int getGameDuration() {
        return this.gameDuration;
    }

    public void setGameDuration(int gameDuration) {
        this.gameDuration = gameDuration;
    }

    public int getGameCurrentTime() {
        return this.gameCurrentTime;
    }

    // Setters

    public void setTeams(Team[] teams) {
        this.teams = teams;
    }
    public void setBall(Ball ball) {
        this.ball = ball;
    }

    public void setGameCurrentTime(int gameCurrentTime) {
        this.gameCurrentTime = gameCurrentTime;
    }
}
