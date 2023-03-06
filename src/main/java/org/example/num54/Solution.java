package org.example.num54;

public class Solution {

    public static int maxSubArray(int[] nums) {
        int pre = 0;
        int result = nums[0];
        for (int i = 0; i < nums.length; i++) {
            pre = Math.max(pre+nums[i],nums[i]);
            result = Math.max(pre,result);
        }
        return result;

    }

    public static void main(String[] args) {
        int[] nums = {5,4,-1,7,8};
        System.out.println(maxSubArray(nums));
    }

}
