package geometricCalculation;

import java.util.Scanner;

public class Run {
    static final int RECTANGLE = 1;
    static final int CIRCLE = 2;
    static final int TRIANGLE = 3;
    static final int RHOMBOID = 4;
    static final int TRAPEZOID = 5;
    static final int CONE = 6;
    static final int SPHERE = 7;
    static final int CUBOID = 8;
    static final int CYLINDER = 9;

    public static void clearConsole() {
        System.out.print("\u001b[H\u001b[2J");
        System.out.flush();
    }

    public static void main() {
        Scanner sc = new Scanner(System.in);
        clearConsole();
        System.out.print("========== 简易几何计算 ==========\n1. 矩形\n2. 圆形\n3. 三角形\n4. 平行四边形\n5. 梯形\n6. 圆锥\n7. 球体\n8. 长方体\n9. 圆柱\n输入选项：");
        byte choose = sc.nextByte();
        switch (choose) {
            case 1 -> Calculators.rectangle();
            case 2 -> Calculators.circle();
            case 3 -> Calculators.triangle();
            case 4 -> Calculators.rhomboid();
            case 5 -> Calculators.trapezoid();
            case 6 -> Calculators.cone();
            case 7 -> Calculators.sphere();
            case 8 -> Calculators.cuboid();
            case 9 -> Calculators.cylinder();
        }

    }
}

