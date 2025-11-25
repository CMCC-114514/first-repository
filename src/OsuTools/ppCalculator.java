package OsuTools;

//osu表现分计算器
public class ppCalculator {
    private ppCalculator(){}

    public static double mania(double sr, int noteCount, Score score) {
        double ppMax;
        ppMax = Math.pow(Math.max(sr - 0.15, 0.05), 2.2) * (1 + 0.1 * Math.min(1, noteCount/1500)) * 8;

        double accPP;
        accPP = score.setAccPP();
        if (accPP <= 80)
            accPP = 0;

        double pp;
        pp = ppMax * (accPP - 0.8);
        return pp;
    }
}
