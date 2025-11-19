import java.util.Scanner;

public class Main {
    static void main() {
        Scanner sc = new Scanner(System.in);
        //int day = sc.nextInt();

        Date d1 = new Date(1145,1,4);
        d1 = Tools.date_plus_day(d1, 114514);
        //Date d2 = Tools.day_to_year(350234);
        d1.showDate();
        //d2.showNumOfYears();

    }
}