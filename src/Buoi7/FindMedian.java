package Buoi7;

import java.util.Scanner;

public class FindMedian {

    private static int[] partition(int[] ar, int index) {
        int pivot = ar[index];

        int left = 0;
        int right = 0;
        int eq = 0;
        for (int i=0; i<ar.length; i++) {
            if (i == index) {
                continue;
            }

            if (ar[i] == pivot) {
                eq++;
            } else if (ar[i] < pivot) {
                left++;
            } else {
                right++;
            }
        }

        if (left != right) {
            for (int i=0; i<eq; i++) {
                if (left <= right) {
                    left++;
                } else {
                    right++;
                }
            }
        }

        return new int[]{left, right};
    }

    public static void main(String[] args) {
        //Scanner sc = new Scanner(System.in);
        int n = 7;

        int ar[] ={ 12, 3, 5, 7, 4, 19, 26 };
        /*for (int i=0; i<n; i++) {
            ar[i] = sc.nextInt();
        }*/

        int median = -1;
        for (int i=0; i<n; i++) {
            int[] p = partition(ar, i);
            if (p[0] == p[1]) {
                median = ar[i];
                break;
            }
        }

        System.out.println(median);
    }
}
