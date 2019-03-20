package array;

/**
 * 数组最大值最小值问题
 *
 * 1. 数据最大值与最小值的差值
 * 2. 数组最大值与最小值的差值，不过最大值下标大于最小值下标
 * 3. 数组最大值与最小值的差值，不过最大值下标小于最小值下标
 */
public class ArrayMaxMinValue {

    public static void main(String[] args) {
        int[] nums = new int[] {3, 2, 3, 1, 2};

//        System.out.println(maxMinDifferenceValue(nums));
//        System.out.println(maxAfterMinDifferenceValue(nums));
        System.out.println(maxBeforeMinDifferenceValue(nums));
    }

    /**
     * 数据最大值与最小值的差值为多少
     */
    private static int maxMinDifferenceValue(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }

        int max = nums[0], min = nums[0];
        for (int i = 1; i < nums.length; i++) {
            max = Math.max(max, nums[i]);
            min = Math.min(min, nums[i]);
        }

        return max - min;
    }

    /**
     * 数组最大值与最小值的差值，不过最大值下标大于最小值下标
     *
     * 相关问题：
     *   [leetcode 121] 买卖股票的最佳时机 https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock/
     */
    private static int maxAfterMinDifferenceValue(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }

        int result = 0;
        int min = nums[0];
        for (int i = 1; i < nums.length; i++) {
            result = Math.max(nums[i] - min, result);
            min = Math.min(min, nums[i]);
        }
        return result;
    }

    /**
     * 数组最大值与最小值的差值，不过最大值下标小于最小值下标
     */
    private static int maxBeforeMinDifferenceValue(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }

        int result = 0;
        int max = nums[0];
        for (int i = 1; i < nums.length; i++) {
            result = Math.max(max - nums[i], result);
            max = Math.max(max, nums[i]);
        }
        return result;
    }
}
