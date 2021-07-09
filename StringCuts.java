import java.util.ArrayList;

public class StringCuts {
    public String[] filter(String[] list, int minLength) {
        ArrayList<String> filterDraft = new ArrayList<>();
        for (String word : list) {
            if(!(filterDraft.contains(word)) && !(word.length() < minLength)){
                filterDraft.add(word);
            }
        }
        String[] filtered = new String[filterDraft.size()];
        for(int i=0; i < filtered.length; i++){
            filtered[i] = filterDraft.get(i);
        }
        return filtered;
    }
}
