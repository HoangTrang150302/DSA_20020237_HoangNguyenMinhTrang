package Buoi10;

public class AVL {
    static Node insert(Node root, int data)
    {
        if (root == null)
        {
            Node newNode = new Node();
            newNode.left = null;
            newNode.right = null;
            newNode.val = data;
            newNode.ht = setHeight(root);
            return root;
        }
        if (data <= root.val)
        {
            root.left = insert(root.left, data);
        }
        else
        {
            root.right = insert(root.right, data);
        }
        int balance = setHeight(root.left) - setHeight(root.right);

        if (balance > 1)
        {

        }
        return root;
    }

    public static int setHeight(Node root)
    {
        if (root == null)
        {
            return -1;
        }
        return 1 + Math.max(setHeight(root.left), setHeight(root.right));
    }
}
