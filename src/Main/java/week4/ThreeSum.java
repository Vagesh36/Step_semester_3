package main.java.week4;

import java.util.Arrays;
import java.util.Scanner;

public class ThreeSum {

    static void threeSum(int[] nums) {

        Arrays.sort(nums);

        boolean found = false;

        System.out.println("Triplets:");

        for (int i = 0; i < nums.length - 2; i++) {

            // Skip duplicate first values
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }

            int left = i + 1;
            int right = nums.length - 1;

            while (left < right) {

                int sum = nums[i] + nums[left] + nums[right];

                if (sum == 0) {

                    System.out.println(
                            "[" + nums[i] + ", "
                            + nums[left] + ", "
                            + nums[right] + "]"
                    );

                    found = true;

                    // Skip duplicate left values
                    while (left < right &&
                           nums[left] == nums[left + 1]) {
                        left++;
                    }

                    // Skip duplicate right values
                    while (left < right &&
                           nums[right] == nums[right - 1]) {
                        right--;
                    }

                    left++;
                    right--;

                } else if (sum < 0) {

                    left++;

                } else {

                    right--;
                }
            }
        }

        if (!found) {
            System.out.println("No triplets found.");
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of elements: ");
        int n = sc.nextInt();

        int[] nums = new int[n];

        System.out.println("Enter elements:");

        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }

        threeSum(nums);

        sc.close();
    }
}