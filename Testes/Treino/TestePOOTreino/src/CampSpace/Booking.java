package CampSpace;

import java.time.LocalDate;

public class Booking {
    private final LocalDate startDate;
    private final LocalDate endDate;
    private CampingSpace space;

    public Booking(LocalDate startDate, LocalDate endDate) {
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public Booking(LocalDate startDate, int duration) {
        this.startDate = startDate;
        this.endDate = startDate.plusDays(duration);
    }

    @Override
    public String toString() {
        return "["+startDate+" : "+endDate+"] " + space;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Booking booking)) return false;

        if (getStartDate() != null ? !getStartDate().equals(booking.getStartDate()) : booking.getStartDate() != null)
            return false;
        if (getEndDate() != null ? !getEndDate().equals(booking.getEndDate()) : booking.getEndDate() != null)
            return false;
        return getSpace() != null ? getSpace().equals(booking.getSpace()) : booking.getSpace() == null;
    }

    @Override
    public int hashCode() {
        int result = getStartDate() != null ? getStartDate().hashCode() : 0;
        result = 31 * result + (getEndDate() != null ? getEndDate().hashCode() : 0);
        result = 31 * result + (getSpace() != null ? getSpace().hashCode() : 0);
        return result;
    }

    public void setSpace(CampingSpace space) {
        this.space = space;
    }

    public int getDuration(){
        return (int) (endDate.toEpochDay() - startDate.toEpochDay());
    }

    public LocalDate getStartDate() {
        return this.startDate;
    }

    public LocalDate getEndDate() {
        return this.endDate;
    }

    public CampingSpace getSpace() {
        return this.space;
    }
}
