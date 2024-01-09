package org.example.binarySearch.num33;

/**
 * @author Huang gen(kenfeng)
 * @description 二分查找 - 搜索旋转排序数组
 * @Since 2021-08-22-16:43
 **/
public class Solution {
    public static int search(int[] nums, int target) {
        if (nums.length == 1) {
            if (nums[0] == target) {
                return 0;
            } else {
                return -1;
            }
        } else {
            int l = 0, r = nums.length-1, ans = -1;
            while (l <= r) {
                int mid = l + (r - l) / 2;
                if (nums[mid] == target) {
                    ans = mid;
                    break;
                }
                if (nums[l] <= nums[mid]) {
                    if (nums[l] <= target && nums[mid] > target) {
                        r = mid - 1;
                    } else {
                        l = mid + 1;
                    }
                } else {
                    if (nums[r] >= target && nums[mid] < target) {
                        l = mid + 1;
                    } else {
                        r = mid - 1;
                    }
                }
            }
            return ans;
        }

    }

    public static void main(String[] args) {
        int[] nums = {3,1};
        System.out.println(search(nums,3));
    }
}
