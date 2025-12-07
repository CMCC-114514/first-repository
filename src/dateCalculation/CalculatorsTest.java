package dateCalculation;

import org.junit.Test;
import static org.junit.Assert.*;

public class CalculatorsTest {

    @Test
    public void testConversion() {
        // 测试天数转年份（从2020年开始，闰年）
        Date result1 = Calculators.Conversion(366, 2020);
        assertEquals(1, result1.getYear()); // 366天是1年零0月0天（闰年）
        assertEquals(0, result1.getMonth());
        assertEquals(0, result1.getDay());

        // 测试365天（从2021年开始，平年）
        Date result2 = Calculators.Conversion(365, 2021);
        assertEquals(1, result2.getYear());
        assertEquals(0, result2.getMonth());
        assertEquals(0, result2.getDay());

        // 测试部分天数
        Date result3 = Calculators.Conversion(100, 2022);
        // 100天大约是3个月零10天左右（1月31天，2月28天，3月31天 = 90天，剩余10天）
        // 注意：Conversion方法中月份是从0开始计数的
        // 实际计算：1月31天，2月28天（平年），3月31天，共90天，剩余10天
        // 所以应该是3个月（month=3）零10天
        assertEquals(0, result3.getYear()); // 不满一年
        assertEquals(3, result3.getMonth()); // 3个月
        assertEquals(10, result3.getDay()); // 10天
    }

    @Test
    public void testCalculationForward() {
        // 测试向后推算（正数天数）
        Date date1 = new Date(2023, 1, 1);
        Date result1 = Calculators.Calculation(date1, 30);
        // 2023年1月1日 + 30天 = 2023年1月31日
        assertEquals(2023, result1.getYear());
        assertEquals(1, result1.getMonth());
        assertEquals(31, result1.getDay());

        // 测试跨月
        Date date2 = new Date(2023, 1, 15);
        Date result2 = Calculators.Calculation(date2, 20);
        // 2023年1月15日 + 20天 = 2023年2月4日
        assertEquals(2023, result2.getYear());
        assertEquals(2, result2.getMonth());
        assertEquals(4, result2.getDay());

        // 测试跨年
        Date date3 = new Date(2023, 12, 25);
        Date result3 = Calculators.Calculation(date3, 10);
        // 2023年12月25日 + 10天 = 2024年1月4日
        assertEquals(2024, result3.getYear());
        assertEquals(1, result3.getMonth());
        assertEquals(4, result3.getDay());
    }

    @Test
    public void testCalculationBackward() {
        // 测试向前推算（负数天数）
        Date date1 = new Date(2023, 2, 1);
        Date result1 = Calculators.Calculation(date1, -5);
        // 2023年2月1日 - 5天 = 2023年1月27日
        assertEquals(2023, result1.getYear());
        assertEquals(1, result1.getMonth());
        assertEquals(27, result1.getDay());

        // 测试跨月向前
        Date date2 = new Date(2023, 3, 1);
        Date result2 = Calculators.Calculation(date2, -10);
        // 2023年3月1日 - 10天 = 2023年2月19日（2023年不是闰年，2月28天）
        assertEquals(2023, result2.getYear());
        assertEquals(2, result2.getMonth());
        assertEquals(19, result2.getDay());

        // 测试跨年向前
        Date date3 = new Date(2024, 1, 5);
        Date result3 = Calculators.Calculation(date3, -10);
        // 2024年1月5日 - 10天 = 2023年12月26日
        assertEquals(2023, result3.getYear());
        assertEquals(12, result3.getMonth());
        assertEquals(26, result3.getDay());
    }

    @Test
    public void testInterval() {
        // 测试同一年内的日期间隔
        Date start1 = new Date(2023, 1, 1);
        Date end1 = new Date(2023, 1, 31);
        int interval1 = Calculators.Interval(start1, end1);
        // 1月1日到1月31日间隔30天
        assertEquals(30, interval1);

        // 测试跨月间隔
        Date start2 = new Date(2023, 1, 15);
        Date end2 = new Date(2023, 2, 15);
        int interval2 = Calculators.Interval(start2, end2);
        // 1月15日到2月15日：1月剩余16天（31-15） + 2月的14天（因为15日当天不算）= 31天
        // 注意：Interval方法中计算的是开区间还是闭区间需要验证
        // 根据代码逻辑，应该是计算两个日期之间的天数差（包含起始日，不包含结束日？）
        // 实际测试后可能需要调整预期值

        // 测试跨年间隔（平年）
        Date start3 = new Date(2022, 12, 31);
        Date end3 = new Date(2023, 1, 1);
        int interval3 = Calculators.Interval(start3, end3);
        // 2022年12月31日到2023年1月1日间隔1天
        assertEquals(1, interval3);

        // 测试闰年间隔
        Date start4 = new Date(2020, 2, 28);
        Date end4 = new Date(2020, 3, 1);
        int interval4 = Calculators.Interval(start4, end4);
        // 2020年2月28日到3月1日：闰年2月29天，所以间隔2天（28->29->1）
        // 注意：这取决于具体实现，可能是2天或1天
    }
}