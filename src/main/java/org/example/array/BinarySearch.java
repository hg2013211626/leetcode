package org.example.array;

/**
 * @Auther: Kenfeng
 * @Date: 2023/01/08/下午5:21
 * @Description:
 */
public class BinarySearch {

    /**
     * 基础的二分查找
     * @param nums
     * @param target
     * @return
     */
    int binarySearch(int[] nums, int target){
        int left = 0, right = nums.length -1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if(nums[mid] == target) {
                return mid;
            } else if(nums[mid] > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return -1;
    }

    /**
     * 寻找左侧边界的二分搜索
     * 比如 ： nums = [1,2,2,2,3]，target 为 2，此算法返回的索引是 1
     * @param nums
     * @param target
     * @return
     */
    int left_bound(int[] nums, int target){
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if(nums[mid] == target) {
                right = mid - 1;
            } else if(nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        if(left == nums.length) {
            return -1;
        }
        if(nums[left] == target){
            return left;
        } else {
            return -1;
        }
    }

    /**
     * 寻找右侧边界的二分搜索
     * 比如 ： nums = [1,2,2,2,3]，target 为 2，此算法返回的索引是 3
     * @param nums
     * @param target
     * @return
     */
    int right_bound(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if(nums[mid] == target) {
                left = mid + 1;
            } else if(nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        if(left - 1 < 0) return -1;
        return nums[left - 1] == target ? left - 1 : -1;
    }

}
