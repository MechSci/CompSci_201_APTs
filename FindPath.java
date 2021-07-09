import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class FindPath {
    private ArrayList<String> paths = new ArrayList<>();
    private int count = 0;

    public String path(TreeNode root, int target) {
        recurseHelper(root, target, "");
        if(count == 0){
            return "nopath";
        }
        Comparator<String> comper = Comparator.comparing(String::length).thenComparing(Comparator.naturalOrder());
        Collections.sort(paths, comper);
        return paths.get(0);
    }
    private void recurseHelper(TreeNode root, int target, String path){
        if(root == null){
            return;
        }
        if(root.info == target){
            count++;
            paths.add(path);
            return;
        }
        recurseHelper(root.left, target, path + "0");
        recurseHelper(root.right, target, path + "1");
    }
}
