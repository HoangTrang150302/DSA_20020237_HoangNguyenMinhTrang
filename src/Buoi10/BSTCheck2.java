package Buoi10;

import java.util.ArrayList;
import java.util.List;


public class BSTCheck2 {
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

     boolean checkBST(Node root) {
         if (root == null)
         {
             return true;
         }
         boolean check = checkBST(root.left);
         if (!check)
         {
             return false;
         }
         arr.add(root.data);
         check = checkBST(root.right);
         if (!check)
         {
             return false;
         }

         for (int i = 0; i < arr.size() - 1; i++)
         {
             if (arr.get(i) > arr.get(i + 1))
             {
                 return false;
             }
         }
         return true;
     }
}
