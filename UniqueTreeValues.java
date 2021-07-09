import java.util.ArrayList;
import java.util.Arrays;

public class UniqueTreeValues {
    public ArrayList<Integer> uniqueVals = new ArrayList<>();

    public int[] unique(TreeNode root){
        traverse(root);
        int[] arr = new int[uniqueVals.size()];
        for(int i=0; i < uniqueVals.size(); i++){
            arr[i] = uniqueVals.get(i);
        }
        Arrays.sort(arr);
        return arr;
    }

    private void traverse(TreeNode currentRoot){
        if(currentRoot == null){
            return;
        }
        if(! uniqueVals.contains(currentRoot.info)){
            uniqueVals.add(currentRoot.info);
        }
        unique(currentRoot.left);
        unique(currentRoot.right);
    }
}
