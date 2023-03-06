package org.example.num217;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Solution {
    public static boolean containsDuplicate(int[] nums) {
        Map<Integer, Integer> contains = new HashMap<>();
        for (int num : nums) {
            if(contains.containsKey(num)) {
                return true;
            } else {
                contains.put(num,1);
            }
        }
        return false;
    }
}
