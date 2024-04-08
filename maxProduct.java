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
public class maxProduct {

    public static void main(String[] args) {

        int[] nums = {3, 1, 4, 2, -5, 7};
        int max = nums[0], min = nums[0], ans = nums[0];
        int n = nums.length;
        int start = 0, end = 0, startIndex = 0;
        for (int i = 1; i < n; i++) {
            if (nums[i] < 0) {
                int temp = max;
                max = min;
                min = temp;
            }
            max = Math.max(nums[i], max * nums[i]);
            min = Math.min(nums[i], min * nums[i]);
            //ans=Math.max(ans,max);
            if (max > ans) {
                ans = max;
                end = i;
            }

            if (max == min) {
                start = i;
            }
        }
        System.out.println("start " + start + " end " + end);
        System.out.println(ans);
    }

}
