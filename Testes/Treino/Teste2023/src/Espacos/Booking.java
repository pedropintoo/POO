package Espacos;

import java.time.LocalDate;

public class Booking {
    private final CampingSpace campingSpaceAssociated;
    private final LocalDate startDate;
    private final LocalDate endDate;
    private final int duration;


    public Booking(CampingSpace campingSpaceAssociated, LocalDate startDate, int duration) {
        this.campingSpaceAssociated = campingSpaceAssociated;
        this.startDate = startDate;
        this.endDate = startDate.plusDays(duration);
        this.duration = duration;
    }

    @Override
    public String toString() {
        return "["+startDate+" : "+endDate+"] "+campingSpaceAssociated;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Booking booking)) return false;

        if (getDuration() != booking.getDuration()) return false;
        if (getCampingSpaceAssociated() != null ? !getCampingSpaceAssociated().equals(booking.getCampingSpaceAssociated()) : booking.getCampingSpaceAssociated() != null)
            return false;
        if (getStartDate() != null ? !getStartDate().equals(booking.getStartDate()) : booking.getStartDate() != null)
            return false;
        return getEndDate() != null ? getEndDate().equals(booking.getEndDate()) : booking.getEndDate() == null;
    }

    @Override
    public int hashCode() {
        int result = getCampingSpaceAssociated() != null ? getCampingSpaceAssociated().hashCode() : 0;
        result = 31 * result + (getStartDate() != null ? getStartDate().hashCode() : 0);
        result = 31 * result + (getEndDate() != null ? getEndDate().hashCode() : 0);
        result = 31 * result + getDuration();
        return result;
    }

    public static int calcDuration(LocalDate startDate, LocalDate endDate){
        return (int) (endDate.toEpochDay() - startDate.toEpochDay());
    }

    // Getters

    public CampingSpace getCampingSpaceAssociated() {
        return this.campingSpaceAssociated;
    }

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
