import java.util.*;

public class Thesaurus {
    /*
    public static void main(String[] args) {
        String[] entry = new String[]{"ape monkey wrench", "wrench twist strain", "monkey twist frugue strain" };
        edit(entry);
    }
     */

    public String[] edit(String[] entry) {
        ArrayList<HashSet<String>> hashSetsEntry = new ArrayList<>();
        for (String list : entry) {
            hashSetsEntry.add(new HashSet<>(Arrays.asList(list.split(" "))));
        }
        int combines = 1;
        while(combines > 0){
            combines = 0;
            for(int i=0; i < hashSetsEntry.size(); i++){
                for(int j = i+1; j < hashSetsEntry.size(); j++) {
                    if (check(hashSetsEntry, i, j)) {
                        hashSetsEntry.get(i).addAll(hashSetsEntry.get(j));
                        hashSetsEntry.remove(j);
                        combines++;
                    }
                }
            }
        }
        ArrayList<ArrayList<String>> toSort = new ArrayList<>();
        for (HashSet<String> list : hashSetsEntry) {
            toSort.add(new ArrayList<String>(list));
        }
        for (ArrayList<String> strings : toSort) {
            Collections.sort(strings);
        }
        ArrayList<String> sorted = new ArrayList<>();
        for (ArrayList<String> strings : toSort) {
            sorted.add(String.join(" ", strings));
        }
        Collections.sort(sorted);
        return sorted.toArray(new String[0]);
    }
    private boolean check(ArrayList<HashSet<String>> updatedEntry, int index1, int index2){
        HashSet<String> set1 = (HashSet) updatedEntry.get(index1).clone();
        int size1 = set1.size();
        HashSet<String> set2 = (HashSet) updatedEntry.get(index2).clone();
        set1.addAll(set2);
        if(set1.size() < size1 + set2.size() - 1){
            return true;
        }
        return false;
    }
}
