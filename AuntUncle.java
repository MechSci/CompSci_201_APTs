import java.util.ArrayList;
import java.util.Set;
import java.util.TreeSet;

public class AuntUncle {
    private FamilyNode you = null;

    public String[] list(String[] parents, String target) {
        String[] currentFam;
        ArrayList<String[]> splitFamilies = new ArrayList<>();
        for(int i=0; i < parents.length; i++){
            splitFamilies.add(parents[i].split(" "));
            if(splitFamilies.get(i)[2].equals(target)){
                currentFam = splitFamilies.get(i);
                you = new FamilyNode(currentFam[2], new FamilyNode(currentFam[0]), new FamilyNode(currentFam[1]));
            }
        }
        if(you == null || you.parent1 == null){
            return new String[0];
        }

        for(int i=0; i < splitFamilies.size(); i++){
            if(splitFamilies.get(i)[2].equals(you.parent1.name)){
                you.parent1.parent1 = new FamilyNode(splitFamilies.get(i)[0]);
                you.parent1.parent2 = new FamilyNode(splitFamilies.get(i)[1]);
            }
            if(splitFamilies.get(i)[2].equals(you.parent2.name)){
                you.parent2.parent1 = new FamilyNode(splitFamilies.get(i)[0]);
                you.parent2.parent2 = new FamilyNode(splitFamilies.get(i)[1]);
            }
        }

        ArrayList<String> grandparents = new ArrayList<>();
        if(you.parent1.parent1 != null)
            grandparents.add(you.parent1.parent1.name);
        if(you.parent1.parent2 != null)
            grandparents.add(you.parent1.parent2.name);
        if(you.parent2.parent1 != null)
            grandparents.add(you.parent2.parent1.name);
        if(you.parent2.parent2 != null)
            grandparents.add(you.parent2.parent2.name);
        if(grandparents.size() == 0)
            return new String[0];
        Set<String> auntsUncles = new TreeSet<>();
        for(int i=0; i < splitFamilies.size(); i++){
            if(grandparents.contains(splitFamilies.get(i)[0]) && ! isParent(splitFamilies.get(i)[2]) && ! splitFamilies.get(i)[2].equals(you.name)){
                auntsUncles.add(splitFamilies.get(i)[2]);
            }
            if(grandparents.contains(splitFamilies.get(i)[1]) && ! isParent(splitFamilies.get(i)[2]) && ! splitFamilies.get(i)[2].equals(you.name)){
                auntsUncles.add(splitFamilies.get(i)[2]);
            }
        }
        return auntsUncles.toArray(new String[0]);
    }
    private boolean isParent(String name) {
        return name.equals(you.parent1.name) || name.equals(you.parent2.name);
    }
}
