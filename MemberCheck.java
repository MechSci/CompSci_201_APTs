import java.util.*;

public class MemberCheck {
    public String[] whosDishonest(String[] club1, String[] club2, String[] club3) {
        ArrayList<String> clubOne = new ArrayList<>(Arrays.asList(club1));
        ArrayList<String> clubTwo = new ArrayList<>(Arrays.asList(club2));
        ArrayList<String> clubThree = new ArrayList<>(Arrays.asList(club3));
        Set<String> dupes = new HashSet<>();
        for (int i = 0; i < club1.length; i++) {
            String current = club1[i];
            if (clubTwo.indexOf(current) != -1) {
                dupes.add(current);
            }
            if (clubThree.indexOf(current) != -1) {
                dupes.add(current);
            }
        }
        for (int i = 0; i < club2.length; i++) {
            String current = club2[i];
            if (clubThree.indexOf(current) != -1) {
                dupes.add(current);
            }
        }
        ArrayList<String> dupeList = new ArrayList<>(dupes);
        Collections.sort(dupeList);
        String[] sortDupes = dupeList.toArray(new String[0]);
        return sortDupes;
    }
}
