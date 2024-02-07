package aula07.ex2;

public class DateND extends Date{
    private int daysDistanceToBase;
    public static DateYMD baseDate = new DateYMD(1,1,2020);

    public DateND(int daysDistanceToBase){
        this.daysDistanceToBase = daysDistanceToBase;
    }

    @Override
    public String toString(){
        Date tempDate = new DateYMD(DateND.baseDate.getDay(),DateND.baseDate.getMonth(),DateND.baseDate.getYear());
        if(this.daysDistanceToBase > 0)
            tempDate.increment(this.daysDistanceToBase);
        else
            tempDate.decrement((-1)*this.daysDistanceToBase); // Positive
        return tempDate.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof DateND dateND)) return false;

        return getDaysDistanceToBase() == dateND.getDaysDistanceToBase();
    }

    @Override
    public int hashCode() {
        return getDaysDistanceToBase();
    }

    // Public Methods

    @Override
    public void increment(int incDays) {
        this.daysDistanceToBase += incDays;
    }

    @Override
    public void decrement(int decDays) {
        this.daysDistanceToBase -= decDays;
    }


    // Getters

    @Override
    public int getDay() {
        Date tempDate = new DateYMD(DateND.baseDate.getDay(),DateND.baseDate.getMonth(),DateND.baseDate.getYear());
        tempDate.increment(this.daysDistanceToBase);
        return tempDate.getDay();
    }

    @Override
    public int getMonth() {
        Date tempDate = new DateYMD(DateND.baseDate.getDay(),DateND.baseDate.getMonth(),DateND.baseDate.getYear());
        tempDate.increment(this.daysDistanceToBase);
        return tempDate.getMonth();
    }

    @Override
    public int getYear() {
        Date tempDate = new DateYMD(DateND.baseDate.getDay(),DateND.baseDate.getMonth(),DateND.baseDate.getYear());
        tempDate.increment(this.daysDistanceToBase);
        return tempDate.getYear();
    }

    public int getDaysDistanceToBase() {
        return this.daysDistanceToBase;
    }

    public void setDaysDistanceToBase(int daysDistanceToBase) {
        this.daysDistanceToBase = daysDistanceToBase;
    }

}
