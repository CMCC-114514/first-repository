package datetools;

//日期计算器
public class DateCalculator {
    private DateCalculator(){}

    //计算器1：天数转年份
    public static Date day_to_year(int numOfDay) {

        //先整除算年数，然后求余
        int year = numOfDay / 365;
        numOfDay %= 365;

        //然后考虑闰年
        //直接在numOfDay上减去闰年的年数即可
        numOfDay -= year / 4;

        //再算月数，需要考虑大小月日期不同
        //大月31天，小月30天，二月28天（不考虑闰年）
        int month = 0;  //表示几个月（月数-1）
        while (numOfDay > 30) {

            //大小月判定
            numOfDay -= Helpers.getDayOfMonth(month + 1, 1);

            //计算一次月数加一
            month++;
        }

        //输出并返回日期
        return new Date(year, month, numOfDay);
    }

    ///////////////////////////////////////////////////////

    //计算器2：日期推算
    //直接在传入的日期上操作
    //需要考虑闰年和平年
    public static Date date_plus_day(Date date, int numOfDays) {

        //预处理：将日期调整为整年
        while (numOfDays >= 365){

            //第一步：将days减去当前年份的剩余天数
            int dayOfYear = Helpers.yearCheck(date.year) ? 366 : 365;  //一年的天数

            int dayCount = Helpers.getDayCount(date);   //当前年份已经过去的天数

            int dayLeft = dayOfYear - dayCount;  //当前年份剩余的天数

            numOfDays -= dayLeft;   //将天数减去当前年份剩余的天数，表示跳过这一年

            //第二步：将日期重置到下年的1月1日
            date.year++;
            date.month = date.day = 1;
        }

        //然后对days进行年份换算
        Date addend = day_to_year(numOfDays);

        //日期直接相加
        date.year += addend.year;
        date.month += addend.month;
        date.day += addend.day;

        //返回日期
        date.showDate();
        return date;
    }

    //////////////////////////////////////////////////////

    //计算器3：计算日期间隔
    //输入起始日期和结束日期，输出间隔天数
    //输出-1表示错误
    public static int date_interval(Date startDate, Date endDate) {
        int dateInterval = 0;

        //将起始日期调到和结束日期相同
        //调日
        if (startDate.day > endDate.day) {      //如果结束日期的天数大于起始日期，就将整月天数减去两日期之间间隔的天数
            dateInterval += Helpers.getDayOfMonth(startDate.month, startDate.year) - (startDate.day - endDate.day);
            startDate.month++;
        } else {
            dateInterval += endDate.day - startDate.day;
        }
        startDate.day = endDate.day;

        //调月
        if (startDate.month > endDate.month) {      //月份同理
            dateInterval += Helpers.yearCheck(startDate.year + 1) ? 366 : 365 - Helpers.getDayCount(endDate, startDate);
            startDate.year++;
        } else {
            dateInterval += Helpers.getDayCount(startDate, endDate);
        }
        startDate.month += endDate.month;

        //最后计算整年的天数
        for (int i = startDate.year; i < endDate.year; i++) {
            dateInterval += Helpers.yearCheck(i) ? 366 : 365;
        }

        return dateInterval;
    }
}
