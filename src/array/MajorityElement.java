package array;

/**
 * 给定一个大小为 n 的数组，找到其中的众数。众数是指在数组中出现次数大于 ⌊ n/2 ⌋ 的元素。
 * 你可以假设数组是非空的，并且给定的数组总是存在众数。
 *
 * 解法：
 * 1. 数组排序，然后取[n/2]位置元素即可 时间复杂度O(nlogn)
 * 2. 可以用相抵消的思想，凡是和最多元素不相等的，就抵消，最后剩下的一定就是最多的那个元素。
 */
public class MajorityElement {

    public static void main(String[] args) {
        int[] nums = new int[] {3,2,3};

        System.out.println(majorityElement(nums));
    }

    // 解法2
    static int majorityElement(int[] nums) {
        int result = 0;

        for (int i = 0, cnt = 0; i < nums.length; i++) {
            if (cnt == 0) {
                result = nums[i];
                cnt = 1;
            } if (nums[i] == result) {
                cnt++;
            } else {
                cnt--;
            }
        }
        return result;
    }
}
