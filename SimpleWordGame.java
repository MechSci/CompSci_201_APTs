import java.util.Arrays;
import java.util.HashSet;

public class SimpleWordGame {
    public int points(String[] player, String[] dictionary) {
        int score = 0;
        HashSet<String> remd = new HashSet<>(Arrays.asList(player));
        HashSet<String> dict = new HashSet<>(Arrays.asList(dictionary));
        for (String word : remd) {
            if(dict.contains(word)){
                score += Math.pow(word.length(), 2);
            }
        }
        return score;
    }
}
