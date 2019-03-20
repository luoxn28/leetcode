package array;

import java.util.Arrays;

/**
 * 实现获取下一个排列的函数，算法需要将给定数字序列重新排列成字典序中下一个更大的排列。
 * 如果不存在下一个更大的排列，则将数字重新排列成最小的排列（即升序排列）。
 * 必须原地修改，只允许使用额外常数空间。
 以下是一些例子，输入位于左侧列，其相应输出位于右侧列。
 1,2,3 → 1,3,2
 3,2,1 → 1,2,3
 1,1,5 → 1,5,1
 *
 * 解法：
 * 从右向左遍历，找到第一个小于其右边元素的元素，其下标为p。如果未找到则反正该数组即可；
 * 再次从右向左遍历，找到第一个大于nums[p]元素的元素，旗下表为q，p和q交换位置，然后从p+1位置开始，
 * 将数据中后续元素反转即可
 */
public class NextPermutation {

    public static void main(String[] args) {
        int[] nums = new int[] {1, 2, 3};
        nextPermutation(nums );
        System.out.println(Arrays.toString(nums));

        nums = new int[] {3,2,1};
        nextPermutation(nums);
        System.out.println(Arrays.toString(nums));

        nums = new int[] {1,1,5};
        nextPermutation(nums);
        System.out.println(Arrays.toString(nums));
    }

    static void nextPermutation(int[] nums) {
        int end = nums.length - 1;
        int p = end - 1;
        while (p >= 0 && nums[p] >= nums[p+1]) {
            p--;
        }
        if (p == -1) {
            reverse(nums, 0, nums.length - 1);
            return;
        }

        int q = end;
        while (q >= 0 && nums[q] <= nums[p]) {
            q--;
        }
        swap(nums, p, q);
        reverse(nums, p + 1, end);
    }

    static void swap(int[] nums, int i, int j) {
        int num = nums[i];
        nums[i] = nums[j];
        nums[j] = num;
    }
    static void reverse(int[] nums, int start, int end) {
        while (start < end) {
            swap(nums, start++, end--);
        }
    }
}
