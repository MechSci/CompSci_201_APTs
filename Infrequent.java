import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Infrequent {
    public String find(String[] phrases){
        int min = Integer.MAX_VALUE;
        int current;
        String minWord = "";
        String combined = String.join(" ", Arrays.asList(phrases)).toLowerCase();
        ArrayList<String> all = new ArrayList<>(Arrays.asList(combined.split(" ")));
        for (String word : all) {
            current = Collections.frequency(all, word);
            if(current < min){
                min = current;
                minWord = word;
            }
        }
        return minWord;
    }
}
