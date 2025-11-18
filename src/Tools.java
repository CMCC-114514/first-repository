public class Tools {
    private Tools(){}

    //计算器1：天数转年份
    public static Date calculator1(int day) {

        //先算年数，考虑闰年的情况
        int year = 1;
        while (day >= 366) {

            //闰年：年数能被4整除
            if (year % 4 == 0 || year % 400 != 0)
                day -= 366;

            //非闰年：世纪年不能被400整除或者普通年不能被4整除
            else
                day -= 365;

            //算完一次年数加一
            year++;
        }

        //再算月数，要考虑闰二月的情况
        int month = 1;
        while(day > 31) {
            switch (month) {
                case 1:
                case 3:
                case 5:
                case 7:
                case 8:
                case 10:
                case 12: {
                    day -= 31;
                    break;
                }
                case 4:
                case 6:
                case 9:
                case 11: {
                    day -= 30;
                    break;
                }
                case 2: {
                    if (year % 4 == 0 || year % 400 != 0)
                        day -= 29;
                    else
                        day -= 28;
                }
            }
            month++;
        }

        return new Date(year - 1, month - 1, day + 1);
    }
}
