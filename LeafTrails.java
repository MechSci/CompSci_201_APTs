import java.util.TreeMap;
import java.util.Map;

public class LeafTrails {
    public Map<Integer, String> pathAndVals = new TreeMap<>();

    public String[] trails(TreeNode tree) {
        traverse(tree, "");
        String[] paths = pathAndVals.values().toArray(new String[0]);
        return paths;
    }

    private void traverse(TreeNode root, String codedPath){
        if(root == null){
            return;
        }
        traverse(root.left, codedPath + "0");
        traverse(root.right, codedPath + "1");
        if(root.left == null && root.right == null){
            pathAndVals.put(root.info, codedPath);
        }
    }
}
