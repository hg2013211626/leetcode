package org.example.array;

/**
 * @Auther: Kenfeng
 * @Date: 2023/01/08/下午5:55
 * @Description: 丑数全集
 */
public class Ugly {

    /**
     * 263. 丑数:就是只包含质因数 2、3 和/或 5 的正整数
     * @param n
     * @return
     */
    public boolean isUgly(int n) {
        if(n < 1) {
            return false;
        }
        while (n % 5 == 0) {
            n = n / 5;
        }
        while (n % 3 == 0) {
            n = n / 3;
        }
        while (n % 2 == 0) {
            n = n / 2;
        }
        return n == 1;
    }

    /**
     * 264. 丑数 II
     * @param n
     * @return
     */
    public int nthUglyNumber(int n) {
        
    }


}
