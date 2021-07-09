public class CirclesCountry {
    public int leastBorders(int[] x, int[] y, int[] r, int x1, int y1, int x2, int y2){
        int crossed = 0;
        for (int i=0; i<x.length; i++) {
            if (r[i]*r[i] > (x1-x[i])*(x1-x[i])+(y1-y[i])*(y1-y[i])) {
                crossed++;
            }
            if (r[i]*r[i] > (x2-x[i])*(x2-x[i])+(y2-y[i])*(y2-y[i])) {
                crossed++;
            }
            if (r[i]*r[i] > (x1-x[i])*(x1-x[i])+(y1-y[i])*(y1-y[i]) && r[i]*r[i] > (x2-x[i])*(x2-x[i])+(y2-y[i])*(y2-y[i])) {
                crossed -= 2;
            }
        }
        return crossed;
    }
}
