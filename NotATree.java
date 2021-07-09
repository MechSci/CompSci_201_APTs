public class NotATree {
    public String check(TreeNode root){
        boolean isIt = helper(root);
        if(isIt == true){
            return "is a tree";
        }
        return "not a tree";
    }
    private boolean helper(TreeNode currRoot){
        if(currRoot == null){
            return false;
        }
        boolean state = helper(currRoot.left) || helper(currRoot.right);
        if(state == true){
            return true;
        }
        if(currRoot.left != null && currRoot.right != null){
            return true;
        }
        return false;
    }
}
