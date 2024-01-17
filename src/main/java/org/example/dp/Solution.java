package org.example.dp;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * @author kenfeng
 * @date 2023/04/03/下午1:07
 * @description TODO
 */
public class Solution {


    public int matrixSum(int[][] nums) {
        int sum = 0;
        int wid = nums.length;
        int hig = nums[0].length;
        int tag[][] = new int[wid][hig];
        for (int i = 0; i < wid; i++) {
            int n[] = nums[i];
            Arrays.sort(n);
            tag[i] = n;
        }

        for (int i = 0;i<hig;i++) {
            int max = Integer.MIN_VALUE;
            for(int j=0;j<wid;j++) {
                if(tag[j][i] > max) {
                    max = tag[j][i];
                }
            }
            sum += max;
        }
        return sum;
    }


    public int maxResult(int[] nums, int k) {
        int dp[] = new int[nums.length];
        dp[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            dp[i] = Integer.MIN_VALUE;
        }

        for (int i = 0; i < nums.length; i++) {
            int end = Math.min(i + k, nums.length - 1);
            for (int j = i + 1; j <= end; j++) {
                dp[j] = Math.max(dp[j], dp[i] + nums[j]);
                // 如果dp[j]>dp[i]，那么后面都可以从dp[j]来跳
                if (dp[j] >= dp[i]) {
                    break;
                }
            }
        }
        return dp[nums.length - 1];
    }


    public boolean wordBreak(String s, List<String> wordDict) {
        boolean num[] = new boolean[s.length() + 1];
        num[0] = true;
        for (int i = 1; i < s.length() + 1; i++) {
            boolean flag = false;
            for (String word : wordDict) {
                int wordLength = word.length();
                if (i < wordLength) {
                    continue;
                }
                String subStr = s.substring(i - wordLength, i);
                if (subStr.equals(word)) {
                    flag = num[i - wordLength];
                }
                if (flag) {
                    break;
                }
            }
            num[i] = flag;
        }
        return num[s.length()];
    }


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
                if (nums[j] < nums[i]) {
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
            if (left == plice) {
                plice++;
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
        return 0;
    }


}
