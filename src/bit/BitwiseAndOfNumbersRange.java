package bit;

/**
 * 给定范围 [m, n]，其中 0 <= m <= n <= 2147483647，返回此范围内所有数字的按位与（包含 m, n 两端点）。
 * 输入: [5,7]
 * 输出: 4
 *
 * 解法：
 * 1 暴力法，遍历m到n数字，进行and操作
 * 2 m->n范围内所有数字and操作，相当于取m和n的最左侧公共部分，即公共左边首部(left header)
 */
public class BitwiseAndOfNumbersRange {

    public static void main(String[] args) {
        System.out.println(rangeBitwiseAnd(26, 30));
    }

    static int rangeBitwiseAnd(int m, int n) {
        int mask = Integer.MAX_VALUE;

        while ((m & mask) != (n & mask)) {
            mask <<= 1;
        }
        return m & mask;
    }
}
