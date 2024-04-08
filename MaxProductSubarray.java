/**
 * Copyright (c) 2024 Drishti-Soft Solutions Pvt. Ltd.
 *
 * @author: nikhilsrivastava
 * Date:  Jan 17, 2024
 */
package com.ameyo.configuration.services.dagenturiresolver;

/**
 *
 */

public class MaxProductSubarray {

    static class Result {
        int start;
        int end;

        public Result(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }

    public static Result findMaxProductSubarrayIndices(int[] nums) {
        if (nums == null || nums.length == 0) {
            throw new IllegalArgumentException("Input array is null or empty");
        }

        int n = nums.length;
        int maxProductEndingHere = nums[0];
        int minProductEndingHere = nums[0];
        int maxProduct = nums[0];
        int start = 0;
        int end = 0;
        int resultStart = 0;

        for (int i = 1; i < n; i++) {
            int current = nums[i];

            if (current < 0) {
                // Swap maxProductEndingHere and minProductEndingHere if the current number is negative
                int temp = maxProductEndingHere;
                maxProductEndingHere = minProductEndingHere;
                minProductEndingHere = temp;

                // Update the starting index for the maximum product subarray
                resultStart = i;
            }

            maxProductEndingHere = Math.max(current, maxProductEndingHere * current);
            minProductEndingHere = Math.min(current, minProductEndingHere * current);

            if (maxProductEndingHere > maxProduct) {
                maxProduct = maxProductEndingHere;
                start = resultStart;
                end = i;
            }

            if (maxProductEndingHere == 0) {
                // If the product becomes zero, reset the starting index
                maxProductEndingHere = 1;
                resultStart = i + 1;
            }
        }

        return new Result(start, end);
    }

    public static void main(String[] args) {
        int[] nums = {1, -2, 3, -4, 5, -6};
        Result result = findMaxProductSubarrayIndices(nums);

        System.out.println("Max Product Subarray Indices: [" + result.start + ", " + result.end + "]");
    }
}
