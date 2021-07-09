import java.util.ArrayList;
import java.util.Collections;

public class MinNode {
    private String path;

    public String locate(TreeNode root){
        ArrayList<Integer> nodeInfos = new ArrayList<>();
        preOrder(root, nodeInfos);
        Collections.sort(nodeInfos);
        int minNodeInfo = nodeInfos.get(0);
        pathFinder(root, minNodeInfo, "");
        return path;
    }

    private void preOrder(TreeNode currentRoot, ArrayList<Integer> nodeInfos){
        if(currentRoot == null){
            return;
        }
        nodeInfos.add(currentRoot.info);
        preOrder(currentRoot.left, nodeInfos);
        preOrder(currentRoot.right, nodeInfos);
    }
    private void pathFinder(TreeNode root, int target, String currentPath){
        if(root == null){
            return;
        }
        if(root.info == target){
            path = currentPath;
            return;
        }
        pathFinder(root.left, target, currentPath + "0");
        pathFinder(root.right, target, currentPath + "1");
    }
}