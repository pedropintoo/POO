package aula07.ex3;

public class Team {
    private String name;
    private String nameManager;
    private int scoredGoals;
    private int concededGoals;
    private Robot[] robots;

    public Team(String name, String nameManager, Robot[] robots) {
        this.name = name;
        this.nameManager = nameManager;
        this.robots = robots;
    }

    // Getters

    public String getName() {
        return this.name;
    }

    public String getNameManager() {
        return this.nameManager;
    }

    public int getScoredGoals() {
        return this.scoredGoals;
    }

    public int getConcededGoals() {
        return this.concededGoals;
    }

    public Robot[] getRobots() {
        return this.robots;
    }

    // Setters

    public void setName(String name) {
        this.name = name;
    }

    public void setNameManager(String nameManager) {
        this.nameManager = nameManager;
    }

    public void setScoredGoals(int scoredGoals) {
        this.scoredGoals = scoredGoals;
    }

    public void setConcededGoals(int concededGoals) {
        this.concededGoals = concededGoals;
    }

    public void setRobots(Robot[] robots) {
        this.robots = robots;
    }
}
