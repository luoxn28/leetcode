package bit;

/**
 * 判断一个int数是否是2的幂次方
 *
 * 解法：
 * 1. 2的幂次方数的二进制数只有一个1，通过n&(n-1)可以将这一个1设置为0，如果为0了，则表示确实是2的幂次方
 */
public class PowerOfTwo {

    public static void main(String[] args) {
        System.out.println(isPowerOfTwo(8));
        System.out.println(isPowerOfTwo(2));
    }

    static boolean isPowerOfTwo(int n) {
        return n > 0 && (n & (n-1)) == 0;
    }
}
