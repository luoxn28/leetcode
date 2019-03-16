package bit;

/**
 * 给定一个包含 0, 1, 2, ..., n 中 n 个数的序列，找出 0 .. n 中没有出现在序列中的那个数。
 *
 * 解法：
 * 1. 可以用公式计算出从1到n的和，减去实际数组的总和，差值就是那个丢失的数.
 * 2. 利用异或位运算，把数组中的每一个数，与1到n进行按位异或，最后剩下的，就是丢失的数
 */
public class MissingNumber {

    public static void main(String[] args) {
        int[] nums = new int[] {0, 1, 3};

        System.out.println(missingNumber(nums));
        System.out.println(missingNumber2(nums));
    }

    // 解法1
    static int missingNumber(int[] nums) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }

        int n = nums.length;
        int sumExpected = (n * (n+1)) / 2;
        return sumExpected - sum;
    }

    // 解法2
    static int missingNumber2(int[] nums) {
        int result = 0;
        for (int i = 0; i < nums.length; i++) {
            result ^= (i+1) ^ nums[i];
        }
        return result;
    }
}
