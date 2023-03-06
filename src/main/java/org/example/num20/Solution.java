package org.example.num20;

import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class Solution {

    public static Map<Character,Character> dataMap = new HashMap<>();
    static {
        dataMap.put('}','{');
        dataMap.put(')','(');
        dataMap.put(']','[');
    }

    public static boolean isValid(String s) {
        if(s.equals("") || null == s) {
            return true;
        }
        Stack stack = new Stack();
        for(int i=0;i<s.length();i++) {
            Character data = s.charAt(i);
            if(data == '(' || data == '{' || data == '[') {
                stack.push(data);
            } else {
                Character result = dataMap.get(data);
                if(stack.isEmpty() || stack.peek() != result) {
                    return false;
                }else {
                    stack.pop();
                }
            }
        }
        if(stack.isEmpty()) {
            return true;
        } else {
            return false;
        }
    }

    public static void main(String[] args) {
        System.out.println(isValid("]"));
    }

}
