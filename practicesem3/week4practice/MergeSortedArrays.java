package practicesem3.week4practice;

import java.util.Arrays;
import java.util.Scanner;

public class MergeSortedArrays {

    static int[] mergeSortedArrays(int[] arr1, int[] arr2) {
        int[] result = new int[arr1.length + arr2.length];

        int i = 0, j = 0, k = 0;

        while (i < arr1.length && j < arr2.length) {
            if (arr1[i] <= arr2[j]) {
                result[k++] = arr1[i++];
            } else {
                result[k++] = arr2[j++];
            }
        }

        while (i < arr1.length) {
            result[k++] = arr1[i++];
        }

        while (j < arr2.length) {
            result[k++] = arr2[j++];
        }

        return result;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter first array size: ");
        int n = sc.nextInt();
        int[] arr1 = new int[n];

        System.out.println("Enter first sorted array:");
        for (int i = 0; i < n; i++) {
            arr1[i] = sc.nextInt();
        }

        System.out.print("Enter second array size: ");
        int m = sc.nextInt();
        int[] arr2 = new int[m];

        System.out.println("Enter second sorted array:");
        for (int i = 0; i < m; i++) {
            arr2[i] = sc.nextInt();
        }

        System.out.println(Arrays.toString(
                mergeSortedArrays(arr1, arr2)));

        sc.close();
    }
}
