import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class FavoriteDinosaur {
    public String theBest(String[] dinos) {
        Map<String, ArrayList<String>> tot = new HashMap<>();
        for (String pair : dinos) {
            String[] pd = pair.split(":");
            tot.putIfAbsent(pd[1], new ArrayList<>());
            tot.get(pd[1]).add(pd[0]);
        }
        String bestDino = "";
        int max = 0;
        for (String dino : tot.keySet()) {
            if(tot.get(dino).size() > max){
                max = tot.get(dino).size();
                bestDino = dino;
            }
        }
        ArrayList<String> peopleList = tot.get(bestDino);
        Collections.sort(peopleList);
        String peeps = String.join(" ", peopleList);
        String done = bestDino + " " + peeps;
        return done;
    }
}
