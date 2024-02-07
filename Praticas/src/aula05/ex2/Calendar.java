package aula05.ex2;

import aula05.ex1.DateYMD;


public class Calendar {
    // Declaration
    final private int year, firstWeekdayOfYear;
    final private String[][] events = new String[12][31];

    Calendar(int year, int firstWeekdayOfYear){
        this.year = year;
        this.firstWeekdayOfYear = firstWeekdayOfYear;
    }

    public String toString(){
        // TODO: Print the 12 month of the year

        String toPrint = "";

        for(int i = 1; i <= 12; i++){
            toPrint += printMonth(i);
        }
        return toPrint;
    }
    public String printMonth(int month){
        // TODO: Print the month

        // Declarations
        String toPrint, eventPrint;
        String[] allMonths = {"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};
        int year = getYear();
        int dayWeek = getfirstWeekdayOfMonth(month);
        int totalDays = DateYMD.monthDays(month,year);


        toPrint = "\n"; // for prettying

        // Header
        toPrint += String.format("%19s\n",allMonths[month-1]+" "+year);
        toPrint += " Su  Mo  Tu  We  Th  Fr  Sa\n";


        for(int i = 0; i < dayWeek-1; i++){
            toPrint += "    "; // spaces behind the first day of the month
        }

        // Days
        for(int i = 1; i <= totalDays ;i++){
            if(dayWeek % 8 == 0){
                toPrint += "\n"; // new line each weak
                dayWeek=1;
            }

            // eventPrint = "*" if event exist
            if(events[month-1][i-1] != null){
                eventPrint = events[month-1][i-1];
            }
            else{
                eventPrint = " "; // Spacing for correct format, if event does not exist
            }

            toPrint += String.format("%3s ",eventPrint+i); // add '*' before a dayNumber if event exist

            dayWeek++;
        }
        return toPrint + "\n"; // '\n' for prettying
    }

    // Public methods
    public void addEvent(DateYMD date){
        if(events[date.getMonth()-1][date.getDay()-1] == "*"){
            System.out.println("This day already have a event!");
        }
        else events[date.getMonth()-1][date.getDay()-1] = "*";
    }
    public void removeEvent(DateYMD date){
        if(events[date.getMonth()-1][date.getDay()-1] == null){
            System.out.println("This day already have not a event!");
        }
        else events[date.getMonth()-1][date.getDay()-1] = "";
    }

    // Getters
    public int getYear(){
        return this.year;
    }
    private int getFirstWeekdayOfYear(){
        return this.firstWeekdayOfYear;
    }
    private int getfirstWeekdayOfMonth(int month){
        // TODO: Calculate all firstWeekday of each previous month and STOP in the suggest month

        // Declarations
        int weekDay = getFirstWeekdayOfYear();
        int totalDays;

        // if the month = 1 return the firstWeekdayOfYear
        for(int i = 1; i < month; i++){
            totalDays = DateYMD.monthDays(i, getYear()); // checking the monthDays of last month
            // Days
            for(int j = 1; j <= totalDays ;j++){
                if(weekDay % 8 == 0){
                    // each weak
                    weekDay=1;
                }

                weekDay++;
            }
        }

        // Correct the problem of ending month in Saturday and return 8 for next month
        return weekDay<=7? weekDay: 1;
    }


}
