package aula07.ex2;

public class DateYMD extends Date {
    // Declaration
    private int day,month,year;

    // Constructor
    public DateYMD(int day, int month, int year){
        if(Date.valid(day,month,year)){
            setDay(day);
            setMonth(month);
            setYear(year);
        }
        else{
            System.out.println("The date is not correct!");
        }

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof DateYMD dateYMD)) return false;

        if (getDay() != dateYMD.getDay()) return false;
        if (getMonth() != dateYMD.getMonth()) return false;
        return getYear() == dateYMD.getYear();
    }

    @Override
    public int hashCode() {
        int result = getDay();
        result = 31 * result + getMonth();
        result = 31 * result + getYear();
        return result;
    }


    // Increment and decrement any amount of days with good performance ( not increment 1 day in loop ! )
    @Override
    public void increment(int incDays){
        // Declarations
        int maxDaysInYear, maxDaysInMonth;

        // Increment year(s)
        maxDaysInYear = Date.leapYear(getYear()) ? 366 : 365;
        while(incDays > maxDaysInYear){
            incDays -= maxDaysInYear;

            // increment 1 year
            setYear(getYear() + 1);
            maxDaysInYear = Date.leapYear(getYear()) ? 366 : 365;
        }

        // Increment month(s)
        maxDaysInMonth = Date.monthDays(getMonth(), getYear());
        while(incDays > maxDaysInMonth){
            incDays -= maxDaysInMonth;

            // increment 1 month
            incrementMonth();
            maxDaysInMonth = Date.monthDays(getMonth(), getYear());
        }

        // Increment day(s)
        while(incDays > 0){
            incDays -= 1;

            // increment 1 day
            maxDaysInMonth = incrementDay(maxDaysInMonth);
        }

    }
    private void incrementMonth(){
        if(getMonth() + 1 <= 12){
            setMonth(getMonth() + 1);
        }
        else{
            setYear(getYear() + 1);
            setMonth(1);
        }
    }
    private int incrementDay(int maxDaysInMonth){

        if(getDay() + 1 <= maxDaysInMonth){
            setDay(getDay() + 1);
        }
        else{
            incrementMonth();
            maxDaysInMonth = Date.monthDays(getMonth(), getYear());
            setDay(1);
        }
        return maxDaysInMonth;
    }

    @Override
    public void decrement(int decDays){
        // Declarations
        int maxDaysInYear, maxDaysInMonth;

        // Decrement year(s)
        maxDaysInYear = Date.leapYear(getYear()) ? 366 : 365;
        while(decDays > maxDaysInYear){
            decDays -= maxDaysInYear;

            // decrement 1 year
            setYear(getYear() - 1);
            if (!Date.valid(getDay(),getMonth(),getYear())){
                setDay(getDay() - 1); // for changing the 29/02 of leap years
            }
            maxDaysInYear = Date.leapYear(getYear()) ? 366 : 365;
        }

        // Decrement month(s)
        maxDaysInMonth = Date.monthDays(getMonth(), getYear());
        while(decDays > maxDaysInMonth){
            decDays -= maxDaysInMonth;

            // decrement 1 month
            decrementMonth();
            maxDaysInMonth = Date.monthDays(getMonth(), getYear());
        }

        // Decrement day(s)
        while(decDays > 0){
            decDays -= 1;

            // increment 1 day
            maxDaysInMonth = decrementDay(maxDaysInMonth);
        }

    }
    private void decrementMonth(){
        if(getMonth() - 1 >= 1){
            setMonth(getMonth() - 1);
            setDay(Date.monthDays(getMonth(), getYear()));
        }
        else{
            setYear(getYear() - 1);
            setMonth(12);
        }
    }
    private int decrementDay(int maxDaysInMonth){

        if(getDay() - 1 >= 1){
            setDay(getDay() - 1);
        }
        else{
            decrementMonth();
            maxDaysInMonth = Date.monthDays(getMonth(), getYear());
            setDay(maxDaysInMonth);
        }
        return maxDaysInMonth;
    }


    @Override
    public String toString(){
        return "The date is: "+getYear()+"-"+getMonth()+"-"+getDay();
    }
    public String toStringFormat(){
        return getYear()+"-"+getMonth()+"-"+getDay();
    }

    // Getters
    public int getDay() {
        return this.day;
    }
    public int getMonth() {
        return this.month;
    }
    public int getYear(){
        return this.year;
    }
    public String getFormatted(){
        return getDay() + "/" + getMonth() + "/" + getYear();
    }

    // Setters
    public void setDay(int day) {
        this.day = day;
    }
    public void setMonth(int month) {
        this.month = month;
    }
    public void setYear(int year) {
        this.year = year;
    }

}
