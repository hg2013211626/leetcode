package org.example.binarySearch.num34;

/**
 * @author Huang gen(kenfeng)
 * @description 二分查找 在排序数组中查找元素的第一个和最后一个位置
 * @Since 2021-08-22-17:10
 **/
public class Solution {
    public static int[] searchRange(int[] nums, int target) {
        int[] result = new int[2];
        int start = -1, end = -1;
        int l = 0, r = nums.length - 1, ans = -1;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if(nums[mid] == target){
                ans = mid;
                break;
            }else if(nums[mid] > target){
                r = mid -1;
            }else{
                l = mid + 1;
            }
        }
        if(ans != -1){
            start = end = ans;
            while (start > 0){
                if(nums[start - 1] == target){
                    start = start -1;
                }else {
                    break;
                }
            }
            while(end<nums.length-1){
                if(nums[end+1] == target){
                    end = end + 1;
                }else {
                    break;
                }
            }
        }
        result[0] = start;
        result[1] = end;
        return result;


    }

    public static void main(String[] args) {
        int []arr = {5,7,7,4,5,8,8,8,10};
        int result[] = searchRange(arr,8);
        System.out.println(result[0] +" "+result[1]);
    }
}
