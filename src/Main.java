final static int DATE_CALCULATING = 1;
final static int UNITS_CONVERSION = 2;
final static int EXIT = 3;

void main() {
    Scanner sc = new Scanner(System.in);

    //输出菜单
    IO.print("""
            ==========多功能计算器==========
            1.日期计算
            2.单位换算
            3.退出程序
            输入选项：""");

    int choose = sc.nextByte();
    switch (choose) {
        case DATE_CALCULATING -> dateCalculation.Run.main();
        case UNITS_CONVERSION -> unitsConversion.Run.main();
        case EXIT -> System.exit(0);
        default -> IO.print("没有这个选项！");
    }
}