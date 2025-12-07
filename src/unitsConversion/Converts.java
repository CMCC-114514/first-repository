package unitsConversion;
import java.util.Scanner;

class Converts {
    private Converts(){}
    static Scanner sc = new Scanner(System.in);

    //换算方法1：长度换算
    public static void length() {

        //选择单位
        String[] units = {"毫米", "厘米", "米", "公里", "英寸", "英尺", "英里", "分", "寸", "尺", "里"};
        for (int i = 0; i < units.length; i++) {
            System.out.println(i+1 + ". " + units[i]);
        }
        System.out.print("选择一个单位：");
        byte choose = sc.nextByte();

        //输入数值
        System.out.print("输入数值：");
        double num = sc.nextDouble();

        //将选择的单位转化为标准单位
        double std = AuxFunctions.getLengthStd(choose, num);

        //计算结果
        double[] result = {std*1e3, std*1e2, std, std/1e3, std*39.37, std*3.281, std/1609.347, std*300, std*30, std*3, std/500};

        //输出结果
        System.out.println(num + units[choose - 1] + "等于：");
        for (int i = 0; i < result.length; i++) {
            if (i == choose - 1) {
                continue;
            }
            System.out.println(result[i] + " " + units[i]);
        }
    }

    //换算方法2：面积换算
    public static void area() {

        //选择单位
        String[] units = {"平方毫米", "平方厘米", "平方米", "平方分米", "平方公里", "市亩", "平方英寸", "平方英尺", "平方英里", "平方码", "英亩", "公顷"};
        for (int i = 0; i < units.length; i++) {
            System.out.println(i+1 + ". " + units[i]);
        }
        System.out.print("选择一个单位：");
        byte choose = sc.nextByte();

        //输入数值
        System.out.print("输入数值：");
        double num = sc.nextDouble();

        //将选择的单位转化为标准单位
        double std = AuxFunctions.getAreaStd(choose, num);

        //计算结果
        double[] result = {std*1e6, std*1e4, std, std*100, std/1e6, std/(2000.0 / 3.0), std*1550, std*10.7639, std/2589988.1, std*1.196, std/4046.94, std/1e4};

        //输出结果
        System.out.println(num + units[choose - 1] + "等于：");
        for (int i = 0; i < result.length; i++) {
            if (i == choose - 1) {
                continue;
            }
            System.out.println(result[i] + " " + units[i]);
        }
    }

    //换算方法3：体积换算
    public static void volume() {

        //选择单位
        String[] units = {"毫升", "升", "立方米", "加仑", "盎司"};
        for (int i = 0; i < units.length; i++) {
            System.out.println(i+1 + ". " + units[i]);
        }
        System.out.print("选择一个单位：");
        byte choose = sc.nextByte();

        //输入数值
        System.out.print("输入数值：");
        double num = sc.nextDouble();

        //将选择的单位转化为标准单位
        double std = AuxFunctions.getVolumeStd(choose, num);

        //计算结果
        double[] result = {std*1e6, std*1e3, std, std*264.172, std*33818.06};

        //输出结果
        System.out.println(num + units[choose - 1] + "等于：");
        for (int i = 0; i < result.length; i++) {
            if (i == choose - 1) {
                continue;
            }
            System.out.println(result[i] + " " + units[i]);
        }
    }

    //换算方法4：质量换算
    public static void mass() {
        //选择单位
        String[] units = {"克", "千克", "吨", "两", "斤", "磅", "盎司"};
        for (int i = 0; i < units.length; i++) {
            System.out.println(i+1 + ". " + units[i]);
        }
        System.out.print("选择一个单位：");
        byte choose = sc.nextByte();

        //输入数值
        System.out.print("输入数值：");
        double num = sc.nextDouble();

        //将选择的单位转化为标准单位
        double std = AuxFunctions.getMassStd(choose, num);

        //计算结果
        double[] result = {std*1e3, std, std/1e3, std*20, std*2, std*2.2046, std*35.274};

        //输出结果
        System.out.println(num + units[choose - 1] + "等于：");
        for (int i = 0; i < result.length; i++) {
            if (i == choose - 1) {
                continue;
            }
            System.out.println(result[i] + " " + units[i]);
        }
    }
}
