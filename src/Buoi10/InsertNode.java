package Buoi10;

public class InsertNode {
    private class Node
    {
        int data;
        Node left;
        Node right;
    }

    public Node insert(Node root,int data) {
        if (root == null)
        {
            Node newNode = new Node();
            newNode.data = data;
            newNode.left = null;
            newNode.right = null;
            root = newNode;
        }
        else if (root.data >= data)
        {
            root.left = insert(root.left, data);
        }
        else {
            root.right = insert(root.right, data);
        }
        return root;
    }
}
