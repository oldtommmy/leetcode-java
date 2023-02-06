package FirstExercise.binarytree;

@SuppressWarnings({"all"})
public class T106 {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        return reverse(inorder,0,inorder.length,postorder,0,postorder.length);
    }

    // 中序区间：[inorderBegin, inorderEnd)，后序区间[postorderBegin, postorderEnd)
    public TreeNode reverse(int[] inorder, int inOrderBegin, int inOrderEnd, int[] postorder, int postOrderBegin, int postOrderEnd) {


        //2. 数组不为空，从后序数组中找到最后一个元素作为节点元素
        TreeNode root = new TreeNode(postorder[postOrderEnd - 1]);
        if (postOrderEnd - postOrderBegin == 1) return root;

        int delimiterIndex;
        //3. 找到后序遍历的最后一个元素在中序数组的位置，记作切割点
        for (delimiterIndex = inOrderBegin; delimiterIndex < inOrderEnd; delimiterIndex++) {
            if (inorder[delimiterIndex] == root.val){
                break;
            }
        }
        //4. 以切割点划分中序数组，分成左右子树数组
        int leftInOrderBegin = inOrderBegin;
        int leftInOrderEnd = delimiterIndex;
        int rightInOrderBegin = delimiterIndex + 1;
        int rightInOrderEnd = inOrderEnd;

        //5. 切割后序数组
        int leftPostOrderBegin = postOrderBegin;
        int leftPostOrderEnd = postOrderBegin + delimiterIndex - inOrderBegin;
        int rightPostOrderBegin = delimiterIndex + 1;
        int rightPostOrderEnd = postOrderEnd - 1;


        //6. 递归处理后序左右分割的数组
        root.left = reverse(inorder,leftInOrderBegin,leftInOrderEnd,postorder,leftPostOrderBegin,leftPostOrderEnd);
        root.right = reverse(inorder,rightInOrderBegin,rightInOrderEnd,postorder,rightPostOrderBegin,rightPostOrderEnd);
        return root;
    }

//    public TreeNode reverse(int[] inorder, int[] postorder) {
//
//
//        //1. 如果数组为空，则说明是空节点
//        if (inorder.length == 0) {
//            return null;
//        }
//
//        //2. 数组不为空，从后序数组中找到最后一个元素作为节点元素
//        TreeNode root = new TreeNode(postorder[postorder.length-1]);
//        int delimiterIndex;
//
//        //3. 找到后序遍历的最后一个元素在中序数组的位置，记作切割点
//        for (delimiterIndex = 0; delimiterIndex < inorder.length; delimiterIndex++) {
//            if (inorder[delimiterIndex] == root.val){
//                break;
//            }
//        }
//
//        //4. 以切割点划分中序数组，分成左右子树数组
//        int[] leftInOrder = Arrays.copyOfRange(inorder,0,delimiterIndex);
//        int[] rightInOrder = Arrays.copyOfRange(inorder,delimiterIndex+1,inorder.length);
//
//
//        //5. 切割后序数组
//        int[] leftPostOrder = Arrays.copyOfRange(postorder, 0, delimiterIndex);
//        int[] rightPostOrder = Arrays.copyOfRange(postorder, delimiterIndex, postorder.length - 1);
//
//
//        //6. 递归处理后序左右分割的数组
//        root.left = reverse(leftInOrder,leftPostOrder);
//        root.right = reverse(rightInOrder,rightPostOrder);
//
//        return root;
//    }

}
