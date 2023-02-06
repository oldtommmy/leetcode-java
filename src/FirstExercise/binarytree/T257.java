package FirstExercise.binarytree;

import java.util.ArrayList;
import java.util.List;

public class T257 {
    public List<String> binaryTreePaths(TreeNode root) {

        List<String> ans = new ArrayList<>();
        List<Integer> paths = new ArrayList<>();
        if (root == null) {
            return ans;
        }
        traversal(root,paths,ans);
        return ans;
    }

    public void traversal(TreeNode root, List<Integer> paths, List<String> ans) {

        paths.add(root.val);
        if (root.left == null && root.right == null) {
            StringBuilder sb = new StringBuilder(); //StringBuilder 比 String 直接构造效率高很多
            for (int i = 0; i < paths.size() - 1; i++) {
                sb.append(paths.get(i)).append("->");
            }
            sb.append(paths.get(paths.size() - 1));
            ans.add(sb.toString());
            return;
        }

        if (root.left != null) {
            traversal(root.left,paths,ans);
            paths.remove(paths.size() - 1);
        }

        if (root.right != null) {
            traversal(root.right,paths,ans);
            paths.remove(paths.size() - 1);
        }

    }
}
