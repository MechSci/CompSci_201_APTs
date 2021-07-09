import java.util.ArrayList;
import java.util.Stack;

public class LeafCollector {
    /*public String[] getLeaves(TreeNode tree){
        Stack<TreeNode> current = new Stack<>();
        ArrayList<String> currentList = new ArrayList<>();
        TreeNode currentNode;
        while(tree != null){
            current.push(tree);
            while(current.size() != 0){
                currentNode = current.pop();
                if(currentNode == null){}
                else if(currentNode.left == null && currentNode.right == null){
                    currentList.add(String.valueOf(currentNode.info));
                }
                current.push(currentNode.right);
                current.push(currentNode.left);
            }
        }
    }
}
     */
    public String[] getLeaves(TreeNode tree){
        ArrayList<String> current = new ArrayList<>();
        ArrayList<String> total = new ArrayList<>();
        while(tree.left != null || tree.right != null){
            find(tree, current);
            remove(tree);
            total.add(String.join(" ", current));
            current.clear();
        }
        total.add(String.valueOf(tree.info));
        return total.toArray(new String[0]);
    }

    private void find(TreeNode tree, ArrayList<String> current){
        if(tree == null){
            return;
        }
        find(tree.left, current);
        find(tree.right, current);
        if(tree.left == null && tree.right == null){
            current.add(String.valueOf(tree.info));
            tree.info = -1;
        }
    }
    private void remove(TreeNode tree){
        if(tree == null){
            return;
        }
        if(tree.left == null && tree.right == null){
            return;
        }
        remove(tree.left);
        remove(tree.right);
        if(tree.left != null){
            if(tree.left.info == -1){
                tree.left = null;
            }
        }
        if(tree.right != null){
            if(tree.right.info == -1){
                tree.right = null;
            }
        }
    }
}
