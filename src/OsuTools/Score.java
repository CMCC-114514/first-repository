package OsuTools;

public class Score {
    public double acc;
    public int nMax;
    public int n300;
    public int n200;
    public int n100;
    public int n50;
    public int n0;

    public Score(int nMax, int n300, int n200, int n100, int n50, int n0) {
        this.nMax = nMax;
        this.n300 = n300;
        this.n200 = n200;
        this.n100 = n100;
        this.n50 = n50;
        this.n0 = n0;
    }

//    public double setAcc() {
//        return (300 * (nMax + n300) + 200 * n200 + 100 * n100 + 50 * n50) / (300 * (nMax + n300 + n200 + n100 + n50 + n0));
//    }
//
//    public double setAccV2() {
//        return (305 * nMax + 300 * n300 + 200 * n200 + 100 * n100 + 50 * n50) / (305 * (nMax + n300 + n200 + n100 + n50 + n0));
//    }

    public double setAccPP() {
        return (320 * nMax + 300 * n300 + 200 * n200 + 100 * n100 + 50 * n50) * 1.0 / (320 * (nMax + n300 + n200 + n100 + n50 + n0));
    }
}
