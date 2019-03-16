package bit;

/**
 * 给定一个非空整数数组，除了某个元素只出现一次以外，其余每个元素均出现了三次。找出那个只出现了一次的元素。
 *
 * 解法
 * 1. 使用map存储元素个数，然后遍历map找到个数为1的那个元素. 时间复杂度O(n)，空间复杂度O(n)
 * 2. 用 one 记录到当前处理的元素为止，二进制1出现“1次”（mod 3 之后的 1） 的有哪些二进制位；
 *    用 two 记录到当前计算的变量为止，二进制1出现“2次”（mod 3 之后的 2） 的有哪些二进制位。
 *    当 one 和 two 中的某一位同时为1时表示该二进制位上1出现了3次，此时需要清零。即用二进制模拟三
 *    进制运算。最终 one 记录的是最终结果。
 */
public class SingleNumberII {

    public static void main(String[] args) {
        int[] nums = new int[] {1, 4, 1, 1};

        System.out.println(singleNumber(nums));
    }

    // 解法2
    static int singleNumber(int[] nums) {
        int one = 0, two = 0, three = 0;
        for (int num : nums) {
            two |= (one & num);
            one ^= num;
            three = ~(two & one);
            two &= three;
            one &= three;
        }

        return one;
    }
}
