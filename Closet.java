import java.util.*;

public class Closet {
    public String anywhere(String[] list) {
        Set<String> common = new HashSet<>();
        for(int i=0; i < list.length; i++){
            common.addAll(Arrays.asList(list[i].split(" ")));
        }
        ArrayList<String> unsorted = new ArrayList<>(common);
        Collections.sort(unsorted);
        String all = String.join(" ", unsorted);
        return all;
    }
}
