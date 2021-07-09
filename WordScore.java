import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class WordScore {
    public int[] score(String[] words, String want, String avoid) {
        Set<String> good = new HashSet<>(Arrays.asList(want.split("")));
        Set<String> bad = new HashSet<>(Arrays.asList(avoid.split("")));
        int[] arr = new int[words.length];
        for(int i=0; i < words.length; i++){
            String[] word = words[i].split("");
            for(String letter : word){
                if(good.contains(letter)){
                    arr[i] += 1;
                }
                if(bad.contains(letter)){
                    arr[i] -= 1;
                }
            }
        }
        return arr;
    }
}
