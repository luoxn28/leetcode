package array;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。
 * 你可以假设每种输入只会对应一个答案。但是，你不能重复利用这个数组中同样的元素。
 * 给定 nums = [2, 7, 11, 15], target = 9
 * 因为 nums[0] + nums[1] = 2 + 7 = 9
 * 所以返回 [0, 1]
 *
 * 解法：
 * 1. 暴力法，直接两次循环遍历，看两数之和是否等于target，时间复杂度O(n^2)
 * 2. hash。用一个哈希表，存储每个数对应的下标，复杂度 O(n)
 * 3. 先排序，然后左右夹逼，排序O(n log n)，左右夹逼 O(n) ，最终O(n log n)。但是注意，这题需要
 *   返回的是下标，而不是数字本身，因此这个方法行不通。
 */
public class TwoSum {

    public static void main(String[] args) {
        int[] nums = new int[] {2, 7, 11, 15};

        System.out.println(Arrays.toString(twoSum(nums, 9)));
    }

    // 方法2
    static int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
        }
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(target - nums[i])) {
                return new int[]{i, map.get(target - nums[i])};
            }
        }
        return new int[]{};
    }
}
