package Buoi9;

import Buoi10.BSTHeight;

import java.util.*;
import java.io.*;

public class InOrder {

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

    public static void inOrder(Node root) {
        if (root.left != null)
        {
            inOrder(root.left);
        }
        System.out.print(root.data + " ");
        if (root.right != null)
        {
            inOrder(root.right);
        }
    }

    public static Node insert(Node root, int data) {
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
        Scanner scan = new Scanner(System.in);
        int t = scan.nextInt();
        Node root = null;
        while(t-- > 0) {
            int data = scan.nextInt();
            root = insert(root, data);
        }
        scan.close();
        inOrder(root);
    }
}
