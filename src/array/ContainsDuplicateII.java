package array;

import java.util.HashMap;
import java.util.Map;

/**
 * 给定一个整数数组和一个整数 k，判断数组中是否存在两个不同的索引 i 和 j，使得 nums [i] = nums [j]，并且 i 和 j 的差的绝对值最大为 k。
 *
 * 解法
 * 1 使用map，key为num，value为对应下标，数组遍历过程中，如果map已存在，则判断下标间隔是否小于k
 */
public class ContainsDuplicateII {

    public static void main(String[] args) {
        int[] nums = new int[] {1,2,3,1};

        System.out.println(containsNearbyDuplicate(nums, 3));
    }

    static boolean containsNearbyDuplicate(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) {
                if (i - map.get(nums[i]) <= k) {
                    return true;
                }
            }
            map.put(nums[i], i);
        }
        return false;
    }
}
