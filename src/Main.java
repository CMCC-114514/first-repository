import java.util.Scanner;

public class Main {
    static void main() {
        Scanner sc = new Scanner(System.in);
        //int day = sc.nextInt();

        Date d = new Date(2025,11,19);
        d = Tools.date_plus_day(d, 6688);
        d.showDate();

    }
}