import java.util.ArrayList;
import java.util.List;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

class Traverse {
    List<Integer> preorder(TreeNode node) {
        List<Integer> output = new ArrayList<Integer>();
        return searchPreorder(node, output);
    }

    List<Integer> inorder(TreeNode node) {
        List<Integer> output = new ArrayList<Integer>();
        return searchInorder(node, output);
    }

    List<Integer> postorder(TreeNode node) {
        List<Integer> output = new ArrayList<Integer>();
        return searchPostorder(node, output);
    }

    List<Integer> searchPreorder(TreeNode node, List<Integer> list) {
        list.add(node.val);
        if (node.left != null) {
            searchPreorder(node.left, list);
        }
        if (node.right != null) {
            searchPreorder(node.right, list);
        }
        return list;
    }

    List<Integer> searchInorder(TreeNode node, List<Integer> list) {
        if (node.left != null) {
            searchInorder(node.left, list);
        }
        list.add(node.val);
        if (node.right != null) {
            searchInorder(node.right, list);
        }
        return list;
    }

    List<Integer> searchPostorder(TreeNode node, List<Integer> list) {
        if (node.left != null) {
            searchPostorder(node.left, list);
        }
        if (node.right != null) {
            searchPostorder(node.right, list);
        }
        list.add(node.val);
        return list;
    }

    public static void main(String[] args) {
        Traverse traverse = new Traverse();
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(2);
        root.right = new TreeNode(6);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(3);
        root.right.left = new TreeNode(5);
        root.right.right = new TreeNode(7);

        List<Integer> preorder = traverse.preorder(root);
        List<Integer> inorder = traverse.inorder(root);
        List<Integer> postorder = traverse.postorder(root);

        System.out.print("Preorder: ");
        for (int i = 0; i < preorder.size(); i++) {
            System.out.print(preorder.get(i));
        }
        System.out.println();

        System.out.print("Inorder: ");
        for (int i = 0; i < inorder.size(); i++) {
            System.out.print(inorder.get(i));
        }
        System.out.println();

        System.out.print("Postorder: ");
        for (int i = 0; i < postorder.size(); i++) {
            System.out.print(postorder.get(i));
        }
        System.out.println();
    }
}
