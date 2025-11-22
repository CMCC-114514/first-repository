public class Helpers {
    private Helpers(){}

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
            case 1, 3, 5, 7, 8, 10, 12 -> 31;

            //小月
            case 4, 6, 9, 11 -> 30;

            //二月
            case 2 -> 28;

            //输入了错误的月份就输出-1，表示错误
            default -> -1;
        };
    }

    //辅助函数：计算当前年份过去的天数
    public static int getDayCount(Date date) {
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

    //辅助函数：计算两个月份之间的天数
    //比如计算6月到9月需要多少天
    public static int getDayOfMonth(Date startDate, Date endDate) {
        int numOfDay = 0;
        for (int i = startDate.month; i < endDate.month; i++) {
            numOfDay += Helpers.monthCheck(i);
            if (i == 2)     //要考虑结束年是否为闰年
                numOfDay += Helpers.yearCheck(endDate.year) ? 1 : 0;
        }
        return numOfDay;
    }
}
