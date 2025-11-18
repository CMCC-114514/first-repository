public class Tools {
    private Tools(){}

    //计算器1：天数转年份
    public static Date day_to_year(int day) {

        //先整除算年数，然后求余
        int year = day / 365;
        day %= 365;

        //再算月数，需要考虑大小月日期不同
        //大月31天，小月30天，二月28天（不考虑闰年）
        int month = 0;
        while (day > 30) {
            switch (month) {
                //大月31天
                case 0:
                case 2:
                case 4:
                case 6:
                case 7:
                case 9:
                case 11: {
                    day -= 31;
                    break;
                }
                //小月30天
                case 3:
                case 5:
                case 8:
                case 10: {
                    day -= 30;
                    break;
                }
                //二月28天
                case 1: day -= 28;
            }
            //计算一次月数加一
            month++;
        }
        //返回日期
        return new Date(year, month, day);
    }

    //计算器2：日期加天数
    public static void date_plus_day(Date date, int days) {

        //预处理：将日期调整为整年
        //将days减去当前年份的剩余天数，然后将日期重置到下年的1月1日
        int dayOfYear;
        if (date.year % 4 == 0 || date.year % 400 == 0)
            dayOfYear = 366;
        else
            dayOfYear = 365;
        int dayCount = getDayCount(date);
        days -= dayOfYear - dayCount;

        date.year++;
        date.month = date.day = 1;

        //然后对days进行年份换算
        Date date1 = day_to_year(days);

        //然后年份直接相加，月份和天需要进行判断在相加
        date.year += date1.year;



        System.out.println(dayCount);
        return ;
    }

    private static int getDayCount(Date date) {
        int dayCount = 0;   //计算当前年份的剩余天数
        for (int i = 1; i < date.month; i++) {
            switch (i) {
                case 1:
                case 3:
                case 5:
                case 7:
                case 8:
                case 10:
                case 12: {
                    dayCount += 31;
                    break;
                }
                case 4:
                case 6:
                case 9:
                case 11: {
                    dayCount += 30;
                    break;
                }
                case 2: {
                    if (date.year % 4 == 0 || date.year % 400 == 0)
                        dayCount += 29;
                    else
                        dayCount += 28;
                }
            }
        }
        dayCount += date.day - 1;
        return dayCount;
    }
}
