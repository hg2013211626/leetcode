package org.example.month11;

import java.util.*;

/**
 * @BelongsProject: leetcode
 * @BelongsPackage: org.example.month11
 * @Author: huanggen
 * @CreateTime: 2023-11-18  16:27
 * @Description: TODO
 * @Version: 1.0
 */
public class Solution {

    /**
     *
     * @param nums
     * @return
     */
    public static int maximumSum(int[] nums) {
        Map<Integer, List<Integer>> dataMap = new HashMap<>();
        for (int num : nums) {
            int sum = getIntSum(num);
            if (dataMap.containsKey(sum)) {
                dataMap.get(sum).add(num);
            } else {
                List<Integer> innerList = new ArrayList<>();
                innerList.add(num);
                dataMap.put(sum, innerList);
            }
        }
        int result = -1;
        for(Map.Entry<Integer, List<Integer>> entry : dataMap.entrySet()) {
            if(entry.getValue().size() > 1) {
                List<Integer> values = entry.getValue();
                Collections.sort(values);
                int sumValue = values.get(values.size()-1) + values.get(values.size()-2);
                if(result < sumValue) {
                     result = sumValue;
                }
            }
        }
        return result;
    }

    private static int getIntSum(int num) {
        int data = num / 10;
        int yu = num % 10;
        int result = yu;
        while (data != 0) {
            yu = data % 10;
            data = data / 10;
            result = result + yu;
        }
        return result;
    }


    /**
     * 406. 根据身高重建队列
     * @param people
     * @return
     */
    public int[][] reconstructQueue(int[][] people) {
        return null;

    }


    public static void main(String[] args) {
        int[] nums = {10,12,19,14};
        System.out.println(maximumSum(nums));
    }


}
