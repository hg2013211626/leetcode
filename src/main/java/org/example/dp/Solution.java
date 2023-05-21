package org.example.dp;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author kenfeng
 * @date 2023/04/03/下午1:07
 * @description TODO
 */
public class Solution {

    /**
     * https://leetcode.cn/problems/climbing-stairs/
     * 70. 爬楼梯
     *
     * @param n 楼梯层数
     * @return 种类数
     */

    public int climbStairs(int n) {
        // 这种递归的方案是超时的
        if (n == 1) {
            return 1;
        } else if (n == 2) {
            return 2;
        } else {
            return climbStairs(n - 1) + climbStairs(n - 2);
        }
    }

    public int climbStairs1(int n) {
        // 这种没有超时
        int p = 0, q = 0, r = 1;
        for (int i = 1; i <= n; i++) {
            p = q;
            q = r;
            r = q + p;
        }
        return r;
    }

    /**
     * @param s
     * @return
     */
    public String longestPalindrome(String s) {
        return "";
    }


    public int lengthOfLIS(int[] nums) {
        int dp[] = new int[nums.length];
        Arrays.fill(dp, 1);
        dp[0] = 1;
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[j] <= nums[i]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }
        int result = 0;
        for (int i = 0; i < dp.length; i++) {
            result = Math.max(result, dp[i]);
        }
        return result;

    }

    public int lengthOfLISNum2(int[] nums) {
        int top[] = new int[nums.length];
        int plice = 0;

        for (int i = 0; i < nums.length; i++) {
            int poker = nums[i];
            int left = 0, right = plice;

            while (left < right) {
                int mid = (left + right) / 2;
                if (top[mid] > poker) {
                    right = mid;
                } else if (top[mid] < poker) {
                    left = mid + 1;
                } else {
                    right = mid;
                }
            }
            if(left == plice) {
                plice ++;
            }
            top[left] = poker;
        }
        return plice;
    }

    public int maxEnvelopes(int[][] envelopes) {
        Arrays.sort(envelopes, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] == o2[0] ? o2[1] - o1[1] : o2[0] - o1[0];
            }
        });

    }


}
