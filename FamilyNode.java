import java.util.ArrayList;

public class FamilyNode {
    public String name;
    public FamilyNode parent1, parent2;
    public ArrayList<FamilyNode> children;

    public FamilyNode(String name){
        this(name, null, null, null);
    }
    public FamilyNode(String name, FamilyNode parent1, FamilyNode parent2){
        this(name, parent1, parent2, null);
    }
    public FamilyNode(String name, FamilyNode parent1, FamilyNode parent2, ArrayList<FamilyNode> children){
        this.name = name;
        this.parent1 = parent1;
        this.parent2 = parent2;
        this.children = children;
    }
}
