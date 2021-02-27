package algoexpert;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class SumOfTwoNumbers {
    // o(n^2) time | o(1) space
    public static int[] twoNumberSum(int[] array, int targetSum) {
        for (int i = 0; i < array.length - 1; i++) {
            for (int j = i + 1; j < array.length; j++) {
                if (array[i] + array[j] == targetSum) {
                    return new int[]{array[i], array[j]};
                }
            }
        }
        return new int[0];
    }

    // o(n) time | o(n) space
    public static int[] twoNumbersSumWithlessTimeComplexity(int[] array, int targetSum) {
        Set<Integer> nums = new HashSet<>();
        for (int i : array) {
            int requiredNumber = targetSum - i;
            if (nums.contains(requiredNumber)) {
                return new int[]{i, requiredNumber};
            } else {
                nums.add(i);
            }
        }

        return new int[0];
    }

    // o(n) time | o(n) space
    public static int[] twoNumbersSumWithBestTimeAndSpaceComplexity(int[] array, int targetSum) {
        Arrays.sort(array);
        int left = 0;
        int right = array.length - 1;
        while(left < right) {
            int currentsum = array[left]+array[right];
            if(currentsum < targetSum) {
                left++;
            } else if(currentsum > targetSum) {
                right--;
            }else {
                return new int[] {array[left], array[right]};
            }
        }
        return new int[0];
    }

    public static void main(String args[]) {
        int[] nums = new int[]{1, 3, 5, -2, 7, 9};
//        int[] output = twoNumberSum(nums, 11);
        int[] output = twoNumbersSumWithlessTimeComplexity(nums, 3);
//        int[] output = twoNumbersSumWithBestTimeAndSpaceComplexity(nums, 3);
//        for (int i: output) {
//            System.out.print(i+" ");
//        }
        System.out.println(Arrays.toString(output));
    }
}
