public class Date {

    int year;
    int month;
    int day;

    public Date() {
        this.year = this.month = this.day = 0;
    }

    public Date(int year, int month, int day) {
        this.year = year;
        this.month = month;
        this.day = day;
    }

    public void display() {
        System.out.println(year + "-" + month + "-" + day);
    }
}
