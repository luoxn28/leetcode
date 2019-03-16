package bit;

/**
 * 给定一个非空整数数组，除了某个元素只出现一次以外，其余每个元素均出现两次。找出那个只出现了一次的元素。
 *
 * 解法：
 * 1. 对所有元素异或操作，相同的数据异或为0，0和任何数异或不变
 */
public class SingleNumber {

    public static void main(String[] args) {
        int[] nums = new int[] {1, 2, 1, 3, 2};

        System.out.println(singleNumber(nums));
    }

    static int singleNumber(int[] nums) {
        int result = 0;
        for (int num : nums) {
            result ^= num;
        }
        return result;
    }
}
