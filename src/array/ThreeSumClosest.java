package array;

import java.util.Arrays;

/**
 * 给定一个包括 n 个整数的数组 nums 和 一个目标值 target。找出 nums 中的三个整数，使得它们的和与 target 最接近。
 * 返回这三个数的和。假定每组输入只存在唯一答案。
 * 例如，给定数组 nums = [-1，2，1，-4], 和 target = 1.
 * 与 target 最接近的三个数的和为 2. (-1 + 2 + 1 = 2).
 *
 * 解法：
 * 1. 对数组排序，遍历按照前后逼近策略进行查找，和Three Sum问题解法类似
 */
public class ThreeSumClosest {

    public static void main(String[] args) {
        int[] nums = new int[] {-1, 2, 1, -4};

        System.out.println(threeSumClosest(nums, 1));
    }

    static int threeSumClosest(int[] nums, int target) {
        int result = 0;
        int closest = Integer.MAX_VALUE;

        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            int j = i + 1;
            int k = nums.length - 1;
            while (j < k) {
                int sum = nums[i] + nums[j] + nums[k];
                int minGap = Math.abs(sum - target);
                if (minGap < closest) {
                    closest = minGap;
                    result = sum;
                }

                if (sum < target) {
                    j++;
                } else {
                    k--;
                }
            }
        }
        return result;
    }
}
