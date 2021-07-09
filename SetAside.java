import java.util.*;

public class SetAside {
    public String common(String[] list) {
        String done = "";
        Set<String> intersect = new HashSet<>();
        intersect.addAll(Arrays.asList(list[0].split(" ")));
        for(int i=1; i < list.length; i++){
            intersect.retainAll(Arrays.asList(list[i].split(" ")));
        }
        ArrayList<String> filtered = new ArrayList<>(intersect);
        Collections.sort(filtered);
        done = String.join(" ", filtered);
        return done;
    }
}