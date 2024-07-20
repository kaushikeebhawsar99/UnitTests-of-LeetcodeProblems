package com.leetcode;

public class RemoveDuplicatesFromSortedArray {
    public int removeDuplicates(int[] nums) {
        // Handle edge case: if the input array is null
        if (nums == null) {
            throw new IllegalArgumentException("Input array cannot be null");
        }

        // Handle edge case: if the input array is empty
        if (nums.length == 0) {
            return 0;
        }

        // Initialize the pointer for the unique elements
        int j = 1;

        // Iterate through the array starting from the second element
        for (int i = 1; i < nums.length; i++) {
            // If the current element is not equal to the previous one,
            // it means it is a unique element
            if (nums[i] != nums[i - 1]) {
                nums[j] = nums[i];
                j++;
            }
        }

        // Return the number of unique elements
        return j;
    }
}
