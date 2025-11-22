public class DateTools {
    private DateTools(){}

    //计算器1：天数转年份
    public static Date day_to_year(int numOfDay) {

        //先整除算年数，然后求余
        int year = numOfDay / 365;
        numOfDay %= 365;

        //再算月数，需要考虑大小月日期不同
        //大月31天，小月30天，二月28天（不考虑闰年）
        int month = 0;  //表示几个月（月数-1）
        while (numOfDay > 30) {

            //大小月判定
            numOfDay -= Helpers.monthCheck(month + 1);

            //计算一次月数加一
            month++;
        }

        //返回日期
        return new Date(year, month, numOfDay);
    }

    ///////////////////////////////////////////////////////

    //计算器2：日期推算
    //直接在传入的日期上操作
    //需要考虑两种情况：闰年和平年
    public static Date date_plus_day(Date date, int numOfDays) {

        while (numOfDays >= 365){

            //预处理：将日期调整为整年
            //第一步：将days减去当前年份的剩余天数
            int dayOfYear;  //一年的天数
            if (Helpers.yearCheck(date.year))
                dayOfYear = 366;
            else
                dayOfYear = 365;

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
        return date;
    }

    //////////////////////////////////////////////////////

    //计算器3：计算日期间隔
    //输入起始日期和结束日期，输出间隔天数
    //输出-1表示错误
    public static int date_interval(Date startDate, Date endDate) {
        int dateInterval = 0;

        //先算年份
        int startYear = startDate.year;     //起始年
        int endYear = endDate.year;     //结束年
        //如果起始年大于结束年，返回-1
        if (startYear > endYear)
            return -1;

        //否则从起始年开始依次加上每年的日期
        else {
            for (int i = startYear; i < endYear; i++) {
                dateInterval += Helpers.yearCheck(i + 1) ? 366 : 365;
            }
        }

        //然后算月份
        int startMonth = startDate.month;   //起始月
        int endMonth = endDate.month;   //结束月
        int numOfDay;
        //如果结束月大于起始月，直接从起始月开始加上每年的日期
        if (endMonth > startMonth) {
            numOfDay = Helpers.getDayOfMonth(startDate, endDate);
        } else
            numOfDay = (Helpers.yearCheck(endYear + 1) ? 366 : 365) - Helpers.getDayOfMonth(endDate, startDate);
        dateInterval += numOfDay;

        return dateInterval;
    }
}
