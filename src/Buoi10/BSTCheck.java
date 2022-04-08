package Buoi10;

import Buoi9.InOrder;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BSTCheck {
    private static class Node {
        Node left;
        Node right;
        int data;

        Node(int data) {
            this.data = data;
            left = null;
            right = null;
        }
    }

    List<Integer> arr = new ArrayList<>();

        public void inOrder(Node root) {
            if (root.left != null)
            {
                inOrder(root.left);
            }
            arr.add(root.data);
            if (root.right != null)
            {
                inOrder(root.right);
            }
        }

        public boolean isSorted()
        {
            for (int i = 0; i < arr.size() - 1; i++)
            {
                if (arr.get(i) > arr.get(i + 1))
                {
                    return false;
                }
            }
            return true;
        }

    boolean checkBST(Node root) {
         inOrder(root);
         return isSorted();
    }

    public void inOrder1(Node root) {
        if (root.left != null)
        {
            inOrder1(root.left);
        }
        System.out.print(root.data + " ");
        if (root.right != null)
        {
            inOrder1(root.right);
        }
    }

    public Node insert(Node root, int data) {
        if(root == null) {
            return new Node(data);
        } else {
            Node cur;
            if(data <= root.data) {
                cur = insert(root.left, data);
                root.left = cur;
            } else {
                cur = insert(root.right, data);
                root.right = cur;
            }
            return root;
        }
    }

    public static void main(String[] args) {
        BSTCheck bstCheck = new BSTCheck();
        Scanner scan = new Scanner(System.in);
        int t = scan.nextInt();
        Node root = null;
        while(t-- > 0) {
            int data = scan.nextInt();
            root = bstCheck.insert(root, data);
        }
        scan.close();
//        bstCheck.inOrder1(root);
//        System.out.println();
//        bstCheck.inOrder(root);
//
//        for (int i = 0; i < bstCheck.arr.size(); i++)
//        {
//            System.out.print(bstCheck.arr.get(i) + " ");
//        }
        System.out.println(bstCheck.checkBST(root));
    }
}
