package org.example.num3;

/**
 * @author Huang gen(kenfeng)
 * @description 无重复字符的最长子串
 * @Since 2021-08-15-17:47
 **/
public class Solution {
    public static int getIndex(String str, char c) {
        int result = -1;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == c) {
                result = i;
                break;
            }
        }
        return result;
    }

    public static int lengthOfLongestSubstring(String s) {
        int start = 0;
        int end = 0;
        int maxSum = 0;
        while (end < s.length()) {
            String allStr = s.substring(start, end);
            char currStr = s.charAt(end);
            int current = getIndex(allStr, currStr);
            if (current != -1) {
                start = start + current + 1;
            }
            end++;
            if (end - start > maxSum) {
                maxSum = end - start;
            }
        }

        return maxSum;
    }

    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring(" "));
    }

}
