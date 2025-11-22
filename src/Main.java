import java.util.Scanner;

public class Main {
    static void main() {
        Date sDate = new Date(2023,12,2);
        Date eDate = new Date(2024,3,2);
        System.out.println(DateTools.date_interval(sDate, eDate));
    }
}