package org.example.month07;

/**
 * @BelongsProject: leetcode
 * @BelongsPackage: org.example.month07.Solution
 * @Author: huanggen
 * @CreateTime: 2024-07-21  11:38
 * @Description: TODO
 * @Version: 1.0
 */
public class Solution {

    /**
     * 删除一次得到子数组的最大和
     * @param arr
     * @return
     */
    public int maximumSum(int[] arr) {
        int dp0 = arr[0];
        int dp1 = 0;
        int result = arr[0];
        for(int i = 1; i < arr.length; i++) {
            dp0 = Math.max(dp0, dp1+arr[i]);
            dp1 = Math.max(dp0, 0) + arr[i];
            result = Math.max(result, Math.max(dp0,dp1));
        }
        return result;
    }
}
