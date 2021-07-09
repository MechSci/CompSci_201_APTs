import java.util.ArrayList;
import java.util.Arrays;

public class Common {
    public int count (String a, String b) {
        int count = 0;
        String[] f = a.split("");
        String[] s = b.split("");
        Arrays.sort(f);
        Arrays.sort(s);
        ArrayList<String> first = new ArrayList<>(Arrays.asList(f));
        ArrayList<String> second = new ArrayList<>(Arrays.asList(s));
        for (String letter : second) {
            if(first.contains(letter)){
                count++;
                first.set(first.indexOf(letter), "A");
            }
        }
        return count;
    }
}