package aula07.ex2;

public abstract class Date implements Comparable {
    // Can not be initialized !



    @Override
    public int compareTo(Object o){
        // -1 menor, 1 maior, 0 igual
        if(this.equals(o)) return 0;
        if (o instanceof Date){
            if(((Date) o).getYear() >= getYear()){
                return ((Date) o).getYear() >= getYear() ? 1 : 0;
            }
            if(((Date) o).getMonth() >= getMonth()){
                return ((Date) o).getMonth() >= getMonth() ? 1 : 0;
            }
            if(((Date) o).getDay() >= getDay()){
                return ((Date) o).getDay() >= getDay() ? 1 : 0;
            }
        }
        return -1;
    }
    // Static methods
    public static boolean validMonth(int month){
        return (month>=1 && month<=12);
    }
    public static int monthDays(int month, int year){
        return switch (month) {
            case 2 -> leapYear(year) ? 29 : 28;
            case 4, 6, 9, 11 -> 30;
            default -> 31;
        };
    }
    public static boolean leapYear(int year){
        return (year%4 == 0 && (year%100 != 0 || year%400 == 0));
    }
    public static boolean valid(int day, int month, int year){
        return day>=1 && day<=monthDays(month,year) && validMonth(month) && year>=1;
    }
    // Increment and decrement any amount of days with good performance ( not increment 1 day in loop ! )
    public abstract void increment(int incDays);

    public abstract void decrement(int decDays);

    // Getters
    public abstract int getDay();
    public abstract int getMonth();
    public abstract int getYear();

}
