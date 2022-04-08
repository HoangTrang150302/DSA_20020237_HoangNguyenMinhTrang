package Buoi10;

public class LCA {
    private class Node
    {
        int data;
        Node left;
        Node right;
    }

    public static boolean find(Node root, int data)
    {
        if (root == null)
        {
            return false;
        }
        if (root.data == data)
        {
            return true;
        }
        boolean check1 = find(root.left, data);
        if (check1) return true;
        boolean check2 = find(root.right, data);
        return check2;
    }

    public static Node lca(Node root, int v1, int v2) {
        if (find(root.left, v1) && find(root.left, v2))
        {
            return lca(root.left, v1, v2);
        }
        else if (find(root.right, v1) && find(root.right, v2))
        {
            return lca(root.right, v1, v2);
        }
        return root;
    }
}
