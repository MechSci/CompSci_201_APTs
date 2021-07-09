import java.util.Map;
import java.util.TreeMap;

public class SortedFreqs {
    public int[] freqs(String[] data) {
        Map<String, Integer> orderedUnique = new TreeMap<>();
        for (String word : data) {
            orderedUnique.putIfAbsent(word, 0);
            orderedUnique.put(word, orderedUnique.get(word) + 1);
        }
        Object[] freqsInteger = orderedUnique.values().toArray();
        int[] freqs = new int[orderedUnique.values().size()];
        for(int i=0; i < orderedUnique.values().size(); i++){
            freqs[i] = (int) freqsInteger[i];
        }
        return freqs;
    }
}
