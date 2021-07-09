import java.util.ArrayList;
import java.util.Collections;

public class OlympicCandles {
    public int numberOfNights(int[] candles){
        int nightCount = 0;
        int removed;
        ArrayList<Integer> current = new ArrayList<>();
        for (int candleHeight : candles) {
            current.add(candleHeight);
        }
        while(current.size() > nightCount){
            removed = 0;
            Collections.sort(current, Collections.reverseOrder());
            nightCount++;
            for(int i=0; i < nightCount; i++) {
                if(current.get(i - removed) == 1){
                    current.remove(i - removed);
                    removed++;
                }
                else{
                    current.set(i - removed, current.get(i - removed) - 1);
                }
            }
        }
        return nightCount;
    }
}
