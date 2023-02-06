package FirstExercise.binarytree;

import java.util.List;

@SuppressWarnings({"all"})
public class T559 {
    public int maxDepth(Node root) {
        return getHeight(root);
    }

    public int getHeight(Node root) {
        if (root == null) {
            return 0;
        }
        int max = 0;
        for (int i = 0; i < root.children.size(); i++) {
            int height = getHeight(root.children.get(i));
            if (height > max) {
                max = height;
            }
        }
        return max + 1;
    }

    class Node {
        public int val;
        public List<Node> children;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    };
}
