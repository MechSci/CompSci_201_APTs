public class FilterTreeCount {
    public int count(TreeNode tree, int low, int high) {
        if(tree == null){
            return 0;
        }
        if(tree.info >= low && tree.info <= high){
            return 1 + count(tree.left, low, high) + count(tree.right, low, high);
        }
        return count(tree.left, low, high) + count(tree.right, low, high);
    }
}
