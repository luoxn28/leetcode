package bit;

/**
 * 给定一个整数，写一个函数来判断它是否是 3 的幂次方。
 *
 * 解法：
 * 1. 不断除以3，看能否整除
 * 2. 数学法，把该整数对3取对数，如果结果是整数，说明该整数是3的幂。浮点数取余1相当于提取浮点数小数点部分
 */
public class PowerOfThree {

    public static void main(String[] args) {
        System.out.println(isPowerOfThree(26));
        System.out.println(isPowerOfThree(27));
    }

    static boolean isPowerOfThree(int n) {
        return (Math.log10(n) / Math.log10(3)) % 1 == 0;
    }
}
