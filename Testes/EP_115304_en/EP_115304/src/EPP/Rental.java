package POO2223;

import POO2223.Storage.StorageUnit;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class Rental {
    private LocalDate startDate;
    private LocalDate endDate;
    private int duration;

    public Rental(LocalDate startDate, LocalDate endDate) {
        this.startDate = startDate;
        this.endDate = endDate;
        this.duration = (int) startDate.until(endDate, ChronoUnit.SECONDS);
    }

    @Override
    public String toString() {
        return "["+startDate.toString() + " : "+endDate.toString()+"]";
    }

    // Getters
    public LocalDate getStartDate() {
        return this.startDate;
    }

    public LocalDate getEndDate() {
        return this.endDate;
    }

    public int getDuration() {
        return this.duration;
    }
}
