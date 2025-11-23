public class Main {
    static void main() {
        Date startdate = new Date(2024, 10, 10);
        Date enddate = new Date(2026, 6, 27);

        System.out.println(DateTools.date_interval(startdate, enddate));
    }
}