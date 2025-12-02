package datetools;

import java.util.Scanner;

//运行程序
public class Run {

    static final String DAY_TO_YEAR = "1";
    static final String DATE_PLUS_DAY = "2";
    static final String DATE_INTERVAL = "3";
    static final String EXIT = "4";

    //清除控制台
    public static void clearConsole() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    //输出菜单
    public static void menu() {
        System.out.println("////////\n日期计算器\n////////");
        System.out.println("1.天数转年数\n2.日期推算\n3.日期间隔计算\n4.退出程序");
        System.out.print("输入你的选择：");
    }

    static Date date1 = new Date();
    static Date date2 = new Date();
    static Scanner sc = new Scanner(System.in);

    //主函数
    static void main() {
        menu();
        String choose = sc.next();
        clearConsole();
        switch (choose) {
            case DAY_TO_YEAR: {
                System.out.print("输入天数：");
                int num = sc.nextInt();
                DateCalculator.day_to_year(num).showNumOfYears();
                break;
            }
            case DATE_PLUS_DAY: {
                System.out.print("输入日期，年月日用空格分开：");
                date1.year = sc.nextInt();
                date1.month = sc.nextInt();
                date1.day = sc.nextInt();

                System.out.print("输入往后推算的天数：");
                int num = sc.nextInt();
                DateCalculator.date_plus_day(date1, num);
                break;
            }
            case DATE_INTERVAL: {
                System.out.print("输入起始日期，年月日用空格分开：");
                date1.year = sc.nextInt();
                date1.month = sc.nextInt();
                date1.day = sc.nextInt();

                System.out.print("输入结束日期，年月日用空格分开：");
                date2.year = sc.nextInt();
                date2.month = sc.nextInt();
                date2.day = sc.nextInt();

                System.out.println(DateCalculator.date_interval(date1, date2));
                break;
            }
            case EXIT: {
                System.out.println("退出程序");
                System.exit(0);
                break;
            }
            default:
                System.out.println("没有这个选项");
        }
    }
}
