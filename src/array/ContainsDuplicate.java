package array;

import java.util.HashSet;
import java.util.Set;

/**
 * 给定一个整数数组，判断是否存在重复元素。
 * 如果任何值在数组中出现至少两次，函数返回 true。如果数组中每个元素都不相同，则返回 false。
 *
 * 解法
 * 1 用一个 HashSet, 不断往里面塞元素，如果发现有重复，说明存在重复。时间复杂度 O(n) ，空间复杂度 O(n)
 * 2 排序，然后从头到尾扫描，如果发现相邻两个元素相等，则存在重复。时间复杂度 O(nlogn) ，空间复杂度 O(1)
 */
public class ContainsDuplicate {

    public static void main(String[] args) {
        int[] nums = new int[] {1, 2, 3, 1};

        System.out.println(containsDuplicate(nums));
    }

    static boolean containsDuplicate(int[] nums) {
        Set<Integer> existed = new HashSet<>();
        for (int num : nums) {
            if (existed.contains(num)) {
                return true;
            }
            existed.add(num);
        }
        return false;
    }
}
