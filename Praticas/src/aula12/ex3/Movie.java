package aula12.ex3;

public class Movie {
    private String name, rating;
    private Double score;
    private MovieGenre genre;
    private int runningTime;

    public Movie(String name, Double score, String rating, MovieGenre genre, int runningTime) {
        this.name = name;
        this.rating = rating;
        this.score = score;
        this.genre = genre;
        this.runningTime = runningTime;
    }

    @Override
    public String toString(){
        return String.format("%-40s|%-15.1f|%-15s|%-15s|%-15d", this.name, this.score, this.rating, this.genre, this.runningTime);
    }

    // Getters

    public String getName() {
        return this.name;
    }

    public Double getScore(){
        return this.score;
    }

    public int getRunningTime() {
        return this.runningTime;
    }

    public MovieGenre getGenre() {
        return this.genre;
    }
}
