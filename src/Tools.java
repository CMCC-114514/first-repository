public class Tools {
    private Tools(){}

    //辅助函数：平年闰年判定
    //平年返回false，闰年返回true
    public static boolean yearCheck(int year) {
        return (year % 4 == 0 || year % 400 == 0);
    }

    //辅助函数：大小月判定
    //大月返回1，小月返回0，二月则返回2
    public static int monthCheck(int month) {
        return switch (month) {
            //大月
            case 1, 3, 5, 7, 8, 10, 12 -> 1;

            //小月
            case 4, 6, 9, 11 -> 0;

            //二月
            case 2 -> 2;

            //输入了错误的月份就输出-1，表示错误
            default -> -1;
        };

    }

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
            int flag = monthCheck(month + 1);

            //根据判定结果减去相应天数并使月份自增
            if (flag == 0)
                numOfDay -= 30;
            else if (flag == 1)
                numOfDay -= 31;
            else if (flag == 2)
                numOfDay -= 28;
            else
                break;

            //计算一次月数加一
            month++;
        }

        //返回日期
        return new Date(year, month, numOfDay);
    }

    ///////////////////////////////////////////////////////

    //辅助函数：计算当前年份过去的天数
    private static int getDayCount(Date date) {
        int dayCount = 0;   //计算当前年份过去的天数
        for (int i = 1; i < date.month; i++) {
            int flag = monthCheck(i);
            if (flag == 0)
                dayCount += 30;
            else if (flag == 1)
                dayCount += 31;
            else if (flag == 2) {
                if (date.year % 4 == 0 || date.year % 400 == 0)
                    dayCount += 29;
                else
                    dayCount += 28;
            }
        }
        dayCount += date.day - 1;
        return dayCount;
    }

    //计算器2：日期推算
    //直接在传入的日期上操作
    //需要考虑两种情况：闰年和平年
    public static Date date_plus_day(Date date, int numOfDays) {

        while (numOfDays >= 365){

            //预处理：将日期调整为整年
            //第一步：将days减去当前年份的剩余天数
            int dayOfYear;  //一年的天数
            if (yearCheck(date.year))
                dayOfYear = 366;
            else
                dayOfYear = 365;

            int dayCount = getDayCount(date);   //当前年份已经过去的天数

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
}
