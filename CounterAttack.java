import java.util.HashMap;
import java.util.Arrays;

public class CounterAttack {
    public int[] analyze(String str, String[] words) {
        int[] wordsFreq = new int[words.length];
        HashMap<String, Integer> wordsMap = new HashMap<>();
        for (String s : str.split(" ")) {
            wordsMap.putIfAbsent(s, 0);
            wordsMap.put(s, wordsMap.get(s) + 1);
        }
        for(int i=0; i<words.length; i++){
            wordsFreq[i] = wordsMap.getOrDefault(words[i], 0);
        }
        return wordsFreq;
    }
}
