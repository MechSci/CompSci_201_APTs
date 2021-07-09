import java.util.*;

public class FruitPageant {
    public String[] theBest(String[] votes){
        ArrayList<String[]> separated = new ArrayList<>();
        ArrayList<String> fruits = new ArrayList<>();
        for (String vote : votes) {
            separated.add(vote.split(":"));
        }
        for (String[] strings : separated) {
            fruits.add(strings[1]);
        }
        Set<String> unique = new HashSet<>(fruits);
        int maxNumber = 0;
        int currentFreq;
        ArrayList<String> endList = new ArrayList<>();
        for (String thing : unique) {
            currentFreq = Collections.frequency(fruits, thing);
            if(currentFreq == maxNumber){
                endList.add(thing);
            }
            if(currentFreq > maxNumber){
                endList.clear();
                endList.add(thing);
                maxNumber = currentFreq;
            }
        }

        Comparator<String> byLength = Comparator.comparing(String::length);
        Comparator<String> naturalOrder = Comparator.naturalOrder();
        Comparator<String> comper = byLength.thenComparing(naturalOrder);
        Collections.sort(endList, comper);
        return endList.toArray(new String[0]);
    }
}
