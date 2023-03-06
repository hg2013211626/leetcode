package org.example.binarySearch.num69;

/**
 * @author Huang gen(kenfeng)
 * @description 二分搜索 -- x 的平方根
 * @Since 2021-08-22-16:07
 **/
public class Solution {
    public static int mySqrt(int x) {
        if (x == 1){
            return 1;
        }else {
            int start = 0;
            int end  = x ;
            int result = 0;
            while(start <= end ){
                int current = start + (end - start) / 2;
                if((long)current * current <= x){
                    result = current;
                    start = current + 1;
                } else {
                    end = current - 1;
                }
            }
            return result;
        }
    }

    public static void main(String[] args) {
        System.out.println(mySqrt(2147395599));
    }

}
