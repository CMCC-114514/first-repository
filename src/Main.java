import TimeTools.Date;
import TimeTools.DateCalculator;

import java.util.Scanner;

public class Main {
    static void main() {
        Scanner sc = new Scanner(System.in);
        System.out.println("日期时间计算器\n1.日期计算\n2.时间计算");
        int choose = sc.nextByte();
        if (choose == 1) {
            System.out.println("日期计算器\n1.天数转日期\n2.日期推算\n3.日期间隔");
            choose = sc.nextByte();
            if (choose == 1) {
                System.out.print("输入天数：");
                int numOfDays = sc.nextInt();
                System.out.print(numOfDays + "天是" + DateCalculator.day_to_year(numOfDays).showNumOfYears());
            } else if (choose == 2) {
                System.out.print("输入起始日期（如2024 8 19）：");
                Date start = new Date(sc.nextInt(), sc.nextInt(), sc.nextInt());
                System.out.println("输入天数：");
                int numOfDays = sc.nextInt();
                System.out.println(start.showDate() + "的" + numOfDays + "天后是" + DateCalculator.date_plus_day(start, numOfDays).showDate());
            } else if (choose == 3) {
                System.out.print("输入起始日期（如2024 8 19）：");
                Date start = new Date(sc.nextInt(), sc.nextInt(), sc.nextInt());
                System.out.print("输入结束日期（如2025 11 14）：");
                Date end = new Date(sc.nextInt(), sc.nextInt(), sc.nextInt());
                System.out.println(start.showDate() + "到" + end.showDate() + "有" + DateCalculator.date_interval(start, end) + "天");
            }
        }
    }
}