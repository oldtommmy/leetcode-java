package secondExercise.binaryTree;

import FirstExercise.binarytree.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class T257 {

    List<String> ans = new ArrayList<>();
    List<Integer> path = new ArrayList<>();

    public List<String> binaryTreePaths(TreeNode root) {
        if (root == null) {
            return ans;
        }
        reverse(root);
        return ans;
    }

    public void reverse(TreeNode node) {

        if (node.left == null && node.right == null) {
            path.add(node.val);
            StringBuilder builder = new StringBuilder();
            for (int i = 0; i < path.size() - 1; i++) {
                builder.append(path.get(i)).append("->");
            }
            builder.append(path.get(path.size() - 1));
            ans.add(builder.toString());
            return;
        }
        path.add(node.val);
        if (node.left != null) {
            reverse(node.left);
            path.remove(path.size() - 1);
        }
        if (node.right != null) {
            reverse(node.right);
            path.remove(path.size() - 1);
        }

    }

}
