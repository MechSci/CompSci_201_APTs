public class PathSum {
    public int hasPath(int target, TreeNode tree){
        if(tree == null){
            return 0;
        }
        if(tree.left == null && tree.right == null){
            if(tree.info == target){
                return 1;
            }
            return 0;
        }
        int isTrueLeft = hasPath(target - tree.info, tree.left);
        int isTrueRight = hasPath(target - tree.info, tree.right);
        if(isTrueLeft == 1 || isTrueRight == 1){
            return 1;
        }
        return 0;
    }
}
