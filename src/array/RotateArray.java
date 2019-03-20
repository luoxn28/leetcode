package array;

import java.util.Arrays;

/**
 * 给定一个数组，将数组中的元素向右移动 k 个位置，其中 k 是非负数。
 *
 * 解法：
 * 1. 创建新的数组，将原数组数据按照次序放到新数组中
 * 2. 直接在原数组右移，将所有元素右移1次，直到要求次数为止
 * 3. 将数组分成2个子数组，分别对子数组进行整体反转，然后再对整个数组进行整体反转
 */
public class RotateArray {

    public static void main(String[] args) {
        int[] nums = new int[] {1,2,3,4,5,6,7};

        rotate(nums, 3);
        System.out.println(Arrays.toString(nums));
    }

    // 方法3
    static void rotate(int[] nums, int k) {
        k %= nums.length;

        reverse(nums, 0, nums.length - k);
        reverse(nums, nums.length - k, nums.length);
        reverse(nums, 0, nums.length);
    }
    static void reverse(int[] nums, int begin, int end) {
        end--;
        while (begin < end) {
            int tmp = nums[begin];
            nums[begin] = nums[end];
            nums[end] = tmp;
            begin++;
            end--;
        }
    }
}
