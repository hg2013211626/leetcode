package org.labuladong.chapter13;

import java.util.Stack;

/**
 * @BelongsProject: leetcode
 * @BelongsPackage: org.labuladong.chapter13
 * @Author: huanggen
 * @CreateTime: 2023-07-09  20:22
 * @Description: 一文秒杀三道括号提
 * @Version: 1.0
 */
public class Chapter131 {


    /**
     * 921. 使括号有效的最少添加
     *
     * @param s
     * @return
     */
    public int minAddToMakeValid(String s) {
        int left = 0;
        int right = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                right++;
            }
            if (s.charAt(i) == ')') {
                right--;
                if (right == -1) {
                    right = 0;
                    left++;
                }
            }
        }
        return left + right;

    }


    /**
     * 1541. 平衡括号字符串的最少插入次数
     *
     * @param s
     * @return
     */
    public int minInsertions(String s) {
        // 当前前面已经确定要插入的
        int res = 0;
        // 右括号
        int right = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                right += 2;
                if (right % 2 == 1) {
                    res++;
                    right--;
                }
            }
            if (s.charAt(i) == ')') {
                right--;
                if (right == -1) {
                    res++;
                    right = 1;
                }
            }
        }
        return res + right;
    }

    /**
     * 32. 最长有效括号
     *
     * @param s
     * @return
     */
    public int longestValidParentheses(String s) {
        // 当前前面已经确定要插入的
        int res = 0;
        // 右括号
        int right = 0;

        int length = 0;

        int max = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                right ++;
                length ++;
            }
            if (s.charAt(i) == ')') {
                right--;
                length ++;
                if(right == -1) {
                    right = 0;
                    max = Math.max(max, length);
                    length = 0;
                }
            }
        }
        return 0;
    }


    public static void main(String[] args) {
        Chapter131 chapter131 = new Chapter131();
        String s = "(()))(()))()())))";
        System.out.println(chapter131.longestValidParentheses(s));
    }


}
