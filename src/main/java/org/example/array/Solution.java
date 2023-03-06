package org.example.array;

/**
 * @Auther: Kenfeng
 * @Date: 2023/01/08/下午4:06
 * @Description:
 */
public class Solution {

    /**
     * 26. 删除有序数组中的重复项
     * @param nums
     * @return
     */
    public int removeDuplicates(int[] nums) {
        if(nums.length == 0 || nums.length == 1){
            return nums.length;
        }
        int slow = 0, fast = 0;
        while (fast < nums.length) {
            if(nums[slow] != nums[fast]) {
                slow ++;
                nums[slow] = nums[fast];
            }
            fast ++;
        }
        return slow+1;
    }

    /**
     * 27. 移除元素
     * @param nums
     * @param val
     * @return
     */
    public int removeElement(int[] nums, int val) {
        if(nums.length == 0) return 0;
        int slow =0, fast = 0;
        while (fast < nums.length) {
            if(nums[fast] != val) {
                nums[slow] = nums[fast];
                slow++;
            }
            fast ++;
        }
        return slow;
    }


    /**
     *
     * @param nums
     */
    public void moveZeroes(int[] nums) {
        if(nums.length == 0) {
            return;
        }
        int slow = 0 , fast = 0;
        while (fast < nums.length) {
            if(nums[fast] != 0) {
                nums[slow] = nums[fast];
                slow ++;
            }
            fast ++;
        }
        for(int i = slow; i<nums.length;i++) {
            nums[i] = 0;
        }
    }
}
