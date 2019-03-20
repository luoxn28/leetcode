package array;

import java.util.HashMap;
import java.util.Map;

/**
 * 给定一个排序数组，你需要在原地删除重复出现的元素，使得每个元素最多出现两次，返回移除后数组的新长度。
 * 不要使用额外的数组空间，你必须在原地修改输入数组并在使用 O(1) 额外空间的条件下完成。
 *
 * 扩展：
 * 1. 如果是非排序数组，需要map记录下元素出现次数
 */
public class RemoveDuplicatesfromSortedArrayII {

    public static void main(String[] args) {
        int[] nums = new int[]{1, 1, 1, 2, 2, 3};
        int[] nums2 = new int[]{1, 1, 1, 2, 2, 3};

        System.out.println(removeDuplicates(nums));
        System.out.println(removeDuplicatesNotSorted(nums2));
    }

    static int removeDuplicates(int[] nums) {
        if (nums.length <= 2) {
            return nums.length;
        }

        // tmp为O(1)空间
        int tmp = Integer.MIN_VALUE;
        int index = 2;
        for (int i = 2; i < nums.length; i++) {
            if (nums[i] != nums[i-2]) {
                if (tmp != Integer.MIN_VALUE) {
                    nums[index++] = tmp;
                }
                tmp = nums[i];
            }
        }
        if (tmp != Integer.MIN_VALUE) {
            nums[index++] = tmp;
        }

        return index;
    }

    /**
     * 非排序数组移除重复元素，最多重复2次
     */
    static int removeDuplicatesNotSorted(int[] nums) {
        if (nums.length <= 2) {
            return nums.length;
        }

        int index = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int cnt = map.getOrDefault(nums[i], 0);
            if (cnt < 2) {
                map.put(nums[i], cnt + 1);
                nums[index++] = nums[i];
            }
        }
        return index;
    }
}
