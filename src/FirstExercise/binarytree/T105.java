package FirstExercise.binarytree;

@SuppressWarnings({"all"})
public class T105 {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return reverse(preorder,0,preorder.length,inorder,0,inorder.length);
    }

    public TreeNode reverse(int[] pre, int preBegin, int preEnd, int[] in, int inBegin, int inEnd) {

        if (preBegin == preEnd) {
            return null;
        }

        TreeNode root = new TreeNode(pre[preBegin]);
        if (preEnd - preBegin == 1) {
            return root;
        }

        int cut;
        for (cut = inBegin; cut < inEnd; cut++) {
            if (in[cut] == root.val) {
                break;
            }
        }

        int leftInBegin = inBegin;
        int leftInEnd = cut;
        int rightInBegin = cut + 1;
        int rightInEnd = inEnd;

        int leftPreBegin = preBegin + 1;
        int leftPreEnd = preBegin + cut - inBegin + 1;
        int rightPreBegin = preBegin + cut - inBegin + 1;
        int rightPreEnd = preEnd;

        root.left = reverse(pre,leftPreBegin,leftPreEnd,in,leftInBegin,leftInEnd);
        root.right = reverse(pre, rightPreBegin, rightPreEnd, in, rightInBegin, rightInEnd);

        return root;
    }
}
