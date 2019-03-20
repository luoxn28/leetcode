package array;

import java.util.ArrayList;
import java.util.List;

/**
 * 数组中和为k的子数组
 */
public class SumK {

    public static void main(String[] args) {
        int[] nums = new int[] {0, 0, 1, 2, 3, 3, 4};

        sumK(nums, 0, 0, 6, new ArrayList<>());

        for (int i = 0; i < nums.length; i++) {
            sumK2(nums, i, 0, 6, new ArrayList<>());
        }
    }

    // 和为k的子数组，子数组不要求是连续的
    static void sumK(int[] nums, int start, int cur, int target, List<Integer> list) {
        if (start >= nums.length) {
            return;
        } else if (cur + nums[start] > target) {
            return;
        }

        cur += nums[start];
        list.add(nums[start]);
        if (cur == target) {
            System.out.println(list);
        }

        sumK(nums, start + 1, cur, target, list);
        list.remove(list.size() - 1);
        cur -= nums[start];

        int i = start + 1;
        while (i < nums.length && nums[i] == nums[start]) {
            i++;
        }
        sumK(nums, i, cur, target, list);
    }

    // 和为k的子数组，子数组必须是连续的
    static void sumK2(int[] nums, int start, int cur, int target, List<Integer> list) {
        if (start >= nums.length) {
            return;
        } else if (cur + nums[start] > target) {
            return;
        }

        cur += nums[start];
        list.add(nums[start]);
        if (cur == target) {
            System.out.println(list);

            int i = start + 1;
            while (i < nums.length && nums[i] == 0) {
                i++;
                list.add(0);
                System.out.println(list);
            }

            cur = 0;
            list.clear();
            return;
        }

        sumK2(nums, start + 1, cur, target, list);
    }
}
