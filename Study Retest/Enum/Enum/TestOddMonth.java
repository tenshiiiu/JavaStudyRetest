package Enum;

enum OddMonth {

    SEPTEMBER(9),
    MARCH(3),
    JANUARY(1),
    MAY(5),
    NOVEMBER(11),
    JULY(7);

    private final int monthNumber;

    //Define a constructor
    OddMonth(int monthNumber) {
        this.monthNumber = monthNumber;
    }

    //Define an accessor
    public int getMonthNumber() {
        return monthNumber;
    } 

    //Complete the method to display enumerated month 
    //and its integer values

    public static void displayMonthNumber(OddMonth oddMonth) {
        System.out.println(oddMonth.name() + ": " + oddMonth.getMonthNumber());
    }
}

/**
 * TestOddMonth
 */
public class TestOddMonth {

    public static void main(String[] args) {
        
        //Display the month name and the month integer values
        for (OddMonth oddMonth : OddMonth.values()) {
            OddMonth.displayMonthNumber(oddMonth);
        }

        System.out.println("The difference = " +
                           OddMonth.JANUARY.compareTo(OddMonth.JULY)  );
    }
}




