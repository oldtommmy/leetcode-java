package FirstExercise.binarytree;

@SuppressWarnings({"all"})
public class T450 {
    public TreeNode deleteNode(TreeNode root, int key) {

        if (root == null) {
            return null;
        }

        if (root.val == key) {
            if (root.left == null && root.right == null) {
                return null;
            }
            if (root.left == null && root.right != null){
                return root.right;
            }
            if (root.left != null && root.right == null) {
                return root.left;
            }
            //都不为null时，找到右子树的最小结点，将左子树置于该节点的左孩子
            TreeNode cur = root.right;
            while (cur.left != null) {
                cur = cur.left;
            }
            cur.left = root.left;
            root = root.right;
            return root;
        }

        if (root.val > key) {
            root.left = deleteNode(root.left, key);
        }
        if (root.val < key) {
            root.right = deleteNode(root.right, key);
        }
        return root;
    }
}
