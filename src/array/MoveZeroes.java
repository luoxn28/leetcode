package array;

import java.util.Arrays;

/**
 * 给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
 *
 * 解法
 * 1. 这题跟 "Remove Element" 思路一模一样，只是最后要把后半截设置为0
 */
public class MoveZeroes {

    public static void main(String[] args) {
        int[] nums = new int[] {0,1,0,3,12};

        moveZeroes(nums);
        System.out.println(Arrays.toString(nums));
    }

    static void moveZeroes(int[] nums) {
        int index = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                nums[index++] = nums[i];
            }
        }
        while (index < nums.length) {
            nums[index++] = 0;
        }
    }
}
