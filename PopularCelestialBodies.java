import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class PopularCelestialBodies {
    /*public static void main(String[] args) {
        String[] favs = new String[]{"Titan Vormir Xandar", "Ego Vormir Titan", "Xandar Titan Earth"};
        superStars(favs);
    }

     */

    public String[] superStars(String[] favs){
        ArrayList<String> intersect = new ArrayList<>();
        ArrayList<String> prev = new ArrayList<>(Arrays.asList(favs[0].split(" ")));
        for(int i=1; i < favs.length; i++){
            ArrayList<String> current = new ArrayList<>(Arrays.asList(favs[i].split(" ")));
            for (String star : current) {
                if(prev.contains(star)){
                    intersect.add(star);
                }
            }
            prev = (ArrayList<String>) intersect.clone();
            if(i != favs.length - 1){
                intersect.clear();
            }
        }
        String[] done = intersect.toArray(new String[0]);
        Arrays.sort(done);
        return done;
    }
}
