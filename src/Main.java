import java.util.Scanner;

public class Main {

    final static int DATE_CALCULATING = 1;
    final static int TIME_CALCULATING = 2;
    final static int EXIT = 3;

    //输出菜单
    static void menu() {
        System.out.println("==========时间和日期计算器==========");
        System.out.println("1.日期计算");
        System.out.println("2.时间计算");
        System.out.println("3.退出程序");
        System.out.print("输入选项：");
    }

    static void main() {
        Scanner sc = new Scanner(System.in);
        menu();
        int choose = sc.nextByte();
        switch (choose) {
            case DATE_CALCULATING -> datetools.Run.main();
            case TIME_CALCULATING -> System.out.println("功能开发中");
            case EXIT -> System.exit(0);
            default -> System.out.print("没有这个选项！");
        }
        sc.close();
    }
}