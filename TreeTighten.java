public class TreeTighten {
    public TreeNode tighten(TreeNode t) {
        if(t == null){
            return null;
        }
        TreeNode leftNode = tighten(t.left);
        TreeNode rightNode = tighten(t.right);
        if(t.left == null && t.right == null){
            return t;
        }
        if(t.left == null){
            return rightNode;
        }
        if(t.right == null){
            return leftNode;
        }
        return new TreeNode(t.info, leftNode, rightNode);
    }
}
