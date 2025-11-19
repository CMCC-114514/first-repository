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

    public void showDate() {
        System.out.println(year + "年" + month + "月" + day + "日");
    }

    public void showNumOfYears() {
        System.out.println(year + "年" + month + "个月" + day + "天");
    }
}
