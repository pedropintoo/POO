package aula07.ex3;

import aula07.ex3.Game;

public class Main {
    public static void main(String[] args) {
        Robot robot1 = new Robot("[1]-RobotST", RobotType.STRIKER);
        Robot robot2 = new Robot("[1]-RobotMD", RobotType.MIDDLE);
        Robot robot3 = new Robot("[1]-RobotCB", RobotType.DEFENSE);
        Team team1 = new Team("Team1","Pedro", new Robot[]{robot1, robot2, robot3});

        Robot robot4 = new Robot("[2]-RobotST", RobotType.GOALKEEPER);
        Robot robot5 = new Robot("[2]-RobotMD", RobotType.GOALKEEPER);
        Robot robot6 = new Robot("[2]-RobotCB", RobotType.GOALKEEPER);
        Team team2 = new Team("Team2","João", new Robot[]{robot4, robot5, robot6});

        Ball ball = new Ball("white");

        int gameDuration = 60000;

        Game game = new Game(new Team[]{team1,team2}, ball, gameDuration);

        game.startGame();
    }
}
