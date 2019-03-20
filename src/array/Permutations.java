package array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 给定一个没有重复数字的序列，返回其所有可能的全排列。
 *
 * 解法：
 * 1. 递归方案，依次确定某一位，然后将该位置后数据进行全排列。当start为数组大小时，递归结束
 */
public class Permutations {

    public static void main(String[] args) {
        int[] nums = new int[] {1, 2, 3};

        System.out.println(permute(nums));
    }

    static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        permuteInternal(nums, 0, result);
        return result;
    }

    static void permuteInternal(int[] nums, int start, List<List<Integer>> result) {
        if (start >= nums.length) {
            List<Integer> list = new ArrayList<>(nums.length);
            Arrays.stream(nums).forEach(list::add);
            result.add(list);
            return;
        }

        for (int i = start; i < nums.length; i++) {
            swap(nums, start, i);
            permuteInternal(nums, start + 1, result);
            swap(nums, start, i);
        }
    }

    static void swap(int[] nums, int i, int j) {
        int num = nums[i];
        nums[i] = nums[j];
        nums[j] = num;
    }
}
