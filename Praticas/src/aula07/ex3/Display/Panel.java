package aula07.ex3.Display;

import aula07.ex3.Robot;
import aula07.ex3.Ball;
import aula07.ex3.Game;

import java.awt.*;

import java.awt.event.*;
import java.util.ArrayList;
import java.util.Collections;
import javax.swing.*;

public class Panel extends JPanel implements ActionListener{
    public int testCounter = 0;
    // Declarations

    private static final int DELAY = 3; // milliseconds

    private final int PANEL_WIDTH = 1200;
    private final int PANEL_HEIGHT = 800;

    private final int BALL_WIDTH = 50;
    private final int BALL_HEIGHT = 50;
    private final int BALL_RADIO = 50/2;

    private final int ROBOT_WIDTH = 75;
    private final int ROBOT_HEIGHT = 75;
    private final int ROBOT_RADIO = 75/2;

    private Image ballImage;
    private Image fieldImage;
    private Image robotsTeam1Image;
    private Image robotsTeam2Image;

    private Timer timer;

    private ArrayList<Integer> xBallTemp = new ArrayList<Integer>();
    private ArrayList<Integer> yBallTemp = new ArrayList<Integer>();

    private Game game;
    private Ball ball;

    private Robot[] robotsTeam1;
    private Robot[] robotsTeam2;


    Panel(Game game){

        this.game = game;
        this.ball = this.game.getBall();
        this.robotsTeam1 = this.game.getTeams()[0].getRobots();
        this.robotsTeam2 = this.game.getTeams()[1].getRobots();

        // Setting the default positions

        this.game.defaultPosition(PANEL_WIDTH, PANEL_HEIGHT, BALL_WIDTH, BALL_HEIGHT, ROBOT_WIDTH, ROBOT_HEIGHT);

        this.setPreferredSize(new Dimension(PANEL_WIDTH, PANEL_HEIGHT));

        this.fieldImage = new ImageIcon("src\\aula07\\ex3\\Icons\\field.png").getImage();
        this.ballImage = new ImageIcon(this.ball.getIconPath()).getImage();  // Non-static Method in Ball
        this.robotsTeam1Image = new ImageIcon(Robot.getIconPaths()[0]).getImage(); // Static method in Robot
        this.robotsTeam2Image = new ImageIcon(Robot.getIconPaths()[1]).getImage();

        timer = new Timer(Panel.DELAY,this);
        timer.start();

    }

    public void paint(Graphics g) {

        // Painting

        Graphics2D g2D = (Graphics2D) g;

        // Background
        g2D.drawImage(this.fieldImage, 0, 0, PANEL_WIDTH, PANEL_HEIGHT, null);

        // Ball
        g2D.drawImage(this.ballImage, this.ball.getX() , this.ball.getY(), BALL_WIDTH, BALL_HEIGHT, null);

        // Robots Team 1
        g2D.drawImage(this.robotsTeam1Image, this.robotsTeam1[0].getX(), this.robotsTeam1[0].getY(), ROBOT_WIDTH, ROBOT_HEIGHT, null);
        g2D.drawImage(this.robotsTeam1Image, this.robotsTeam1[1].getX(), this.robotsTeam1[1].getY(), ROBOT_WIDTH, ROBOT_HEIGHT, null);
        g2D.drawImage(this.robotsTeam1Image, this.robotsTeam1[2].getX(), this.robotsTeam1[2].getY(), ROBOT_WIDTH, ROBOT_HEIGHT, null);

        // Robots Team 2
        g2D.drawImage(this.robotsTeam2Image, this.robotsTeam2[0].getX(), this.robotsTeam2[0].getY(), ROBOT_WIDTH, ROBOT_HEIGHT, null);
        g2D.drawImage(this.robotsTeam2Image, this.robotsTeam2[1].getX(), this.robotsTeam2[1].getY(), ROBOT_WIDTH, ROBOT_HEIGHT, null);
        g2D.drawImage(this.robotsTeam2Image, this.robotsTeam2[2].getX(), this.robotsTeam2[2].getY(), ROBOT_WIDTH, ROBOT_HEIGHT, null);

        // Placar
        g2D.setFont(new Font("Arial",Font.BOLD,30));
        g2D.drawString(this.game.getTeams()[0].getScoredGoals() + " VS " + this.game.getTeams()[1].getScoredGoals(),PANEL_WIDTH/2 -45,50);

        g2D.setFont(new Font("Arial",Font.CENTER_BASELINE,20));

        g2D.drawString(this.robotsTeam1[0].getType().name()+": "+this.robotsTeam1[0].getScoredGoals(),PANEL_WIDTH/8 -45,50);
        g2D.drawString(this.robotsTeam1[1].getType().name()+": "+this.robotsTeam1[1].getScoredGoals(),PANEL_WIDTH/8 -45,100);
        g2D.drawString(this.robotsTeam1[2].getType().name()+": "+this.robotsTeam1[2].getScoredGoals(),PANEL_WIDTH/8 -45,150);

        g2D.drawString(this.robotsTeam2[0].getType().name()+": "+this.robotsTeam2[0].getScoredGoals(),7*PANEL_WIDTH/8 -45,50);
        g2D.drawString(this.robotsTeam2[1].getType().name()+": "+this.robotsTeam2[1].getScoredGoals(),7*PANEL_WIDTH/8 -45,100);
        g2D.drawString(this.robotsTeam2[2].getType().name()+": "+this.robotsTeam2[2].getScoredGoals(),7*PANEL_WIDTH/8 -45,150);


    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO: A cada 1 ms vai fazer esta função

        // Attacking the robots to the ball
        int xBall = this.ball.getX();
        int yBall = this.ball.getY();

        // Not the best algorithm but it works :D
        ArrayList<Robot> allRobots = new ArrayList<>();
        allRobots.addAll(java.util.List.of(this.robotsTeam1));
        allRobots.addAll(java.util.List.of(this.robotsTeam2));

        // Working with probabilities because the algorithm cause advantages... :(
        Collections.shuffle(allRobots);

        // TODO: Checking goal
        // Gol Team 2
        if(xBall <= 15 && yBall<=465 && yBall >= 270){

            this.game.getTeams()[0].setConcededGoals(this.game.getTeams()[0].getConcededGoals() + 1);
            this.game.getTeams()[1].setScoredGoals(this.game.getTeams()[1].getScoredGoals() + 1);

            // Score goal for robots ( not auto-goals )
            if(this.robotsTeam2[0] == this.ball.getLastKick() || this.robotsTeam2[1] == this.ball.getLastKick() || this.robotsTeam2[2] == this.ball.getLastKick()){
                System.out.println("Goal Team 2 by: "+this.ball.getLastKick().getType().name());
                this.ball.getLastKick().score();
            }
            else System.out.println("Goal Team 2 (auto-goal by: "+this.ball.getLastKick().getType().name()+")");

            this.game.defaultPosition(PANEL_WIDTH, PANEL_HEIGHT, BALL_WIDTH, BALL_HEIGHT, ROBOT_WIDTH, ROBOT_HEIGHT);
            xBall = this.ball.getX();
            yBall = this.ball.getY();
        }

        // Gol Team 1
        if(xBall >=PANEL_WIDTH-BALL_WIDTH-15 && yBall<=465 && yBall >= 270) {

            this.game.getTeams()[1].setConcededGoals(this.game.getTeams()[1].getConcededGoals() + 1);
            this.game.getTeams()[0].setScoredGoals(this.game.getTeams()[0].getScoredGoals() + 1);

            // Score goal for robots ( not auto-goals )
            if (this.robotsTeam1[0] == this.ball.getLastKick() || this.robotsTeam1[1] == this.ball.getLastKick() || this.robotsTeam1[2] == this.ball.getLastKick()){
                System.out.println("Goal Team 1 by: "+this.ball.getLastKick().getType().name());
                this.ball.getLastKick().score();
            }
            else System.out.println("Goal Team 1 (auto-goal by: "+this.ball.getLastKick().getType().name()+")");

            this.game.defaultPosition(PANEL_WIDTH, PANEL_HEIGHT, BALL_WIDTH, BALL_HEIGHT, ROBOT_WIDTH, ROBOT_HEIGHT);
            xBall = this.ball.getX();
            yBall = this.ball.getY();
        }

        // TODO: Collision Walls

        if(xBall>PANEL_WIDTH-BALL_WIDTH-15) {
            this.ball.setX(PANEL_WIDTH-BALL_WIDTH-15);
            this.ball.setXVelocity(this.ball.getXVelocity() * (-1));
        }
        if(xBall< 15){
            this.ball.setX(15);
            this.ball.setXVelocity(this.ball.getXVelocity() * (-1));
        }


        if(yBall>PANEL_HEIGHT-BALL_HEIGHT-15) {
            this.ball.setY(PANEL_HEIGHT-BALL_HEIGHT-15);
            this.ball.setYVelocity(this.ball.getYVelocity() * (-1));
        }
        if(yBall < 15){
            this.ball.setY(15);
            this.ball.setYVelocity(this.ball.getYVelocity() * (-1));
        }

        xBall = this.ball.getX();
        yBall = this.ball.getY();

        this.testCounter++;



        if(this.testCounter % 5 == 0 && Math.abs(this.ball.getXVelocity()) > 0){
            this.ball.setXVelocity(this.ball.getXVelocity()+(this.ball.getXVelocity() > 0? -1:1));
        }
        if(this.testCounter % 5 == 0 && Math.abs(this.ball.getYVelocity()) > 0){
            this.ball.setYVelocity(this.ball.getYVelocity()+(this.ball.getYVelocity() > 0? -1:1));
        }

        ball.move(xBall + this.ball.getXVelocity(), yBall + this.ball.getYVelocity());


        // TODO: Checking if ball is blocked
        int col = 0;
        if(System.currentTimeMillis() % 30 == 0){
            this.xBallTemp.add(xBall);
            this.yBallTemp.add(yBall);
            if(this.xBallTemp.size() % 5 == 0){
                int xTotal = 0;
                int yTotal = 0;
                for(int i = this.xBallTemp.size()-5 ; i < this.xBallTemp.size(); i++){
                    xTotal += (xBall - this.xBallTemp.get(i));
                    yTotal += (yBall - this.yBallTemp.get(i));
                }
                for(Robot robot : allRobots){
                    if(robot.checkCollision(this.ball, BALL_WIDTH/2, ROBOT_WIDTH/2))
                        col++;
                }
                if(Math.abs(xTotal) <= 150 && Math.abs(yTotal) <= 150 && col != 0){
                    // Restart default position
                    // this.game.defaultPosition(PANEL_WIDTH, PANEL_HEIGHT, BALL_WIDTH, BALL_HEIGHT, ROBOT_WIDTH, ROBOT_HEIGHT);

                    // Only restart ball position
                    this.game.ballPosition(PANEL_WIDTH, PANEL_HEIGHT);
                }
            }
        }


        int counterCollision;

        for(int i = 0; i < 6; i++) {
            counterCollision = 0;
            // Collision with robots
            for (int j = 0; j < 6; j++) {
                if (j > i) {
                    if (allRobots.get(i).checkCollision(allRobots.get(j), ROBOT_RADIO, ROBOT_RADIO)) {
                        counterCollision++;
                    }
                }
            }
            // Collision with ball
            if (counterCollision == 0 && !allRobots.get(i).checkCollision(this.ball, BALL_RADIO, ROBOT_RADIO)) {
                allRobots.get(i).trackMove(xBall, yBall);
            }
        }




        for(int i = 0; i<=2; i++){

            if(robotsTeam1[i].checkCollision(this.ball, BALL_WIDTH/2, ROBOT_WIDTH/2)) {
                robotsTeam1[i].collide(this.ball);
            }
            if(robotsTeam2[i].checkCollision(this.ball, BALL_WIDTH/2, ROBOT_WIDTH/2)) {
                robotsTeam2[i].collide(this.ball);
            }


        }


        //System.out.println("("+ xBall +", "+ yBall +")");


        // Repaint para re scaling
        repaint();
    }
}


