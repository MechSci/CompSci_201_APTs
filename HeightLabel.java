public class HeightLabel {
    public TreeNode rewire(TreeNode t) {
        if(t == null){
            return null;
        }
        if(t.left == null && t.right == null){
            return new TreeNode(1);
        }
        TreeNode leftChild = rewire(t.left);
        TreeNode rightChild = rewire(t.right);
        if(leftChild == null){
            return new TreeNode(1+ rightChild.info, null, rightChild);
        }
        if(rightChild == null){
            return new TreeNode(1 + leftChild.info, leftChild, null);
        }
        return new TreeNode(1 + Math.max(leftChild.info, rightChild.info), leftChild, rightChild);
    }
}
