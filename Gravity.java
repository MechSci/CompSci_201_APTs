public class Gravity {
    public static double falling(double time, double velo) {
        double heightChange = 0.5*9.8*time*time + velo*time;
        return heightChange;
    }
}