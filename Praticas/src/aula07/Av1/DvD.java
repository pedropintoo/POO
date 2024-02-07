package aula07.Av1;

public class DvD extends LibraryItem{
    private int duration;

    DvD(String title, int duration) {
        super(title);
        this.duration = duration;
    }
}
