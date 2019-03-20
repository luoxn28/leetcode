package array;

/**
 * 老师想给孩子们分发糖果，有 N 个孩子站成了一条直线，老师会根据每个孩子的表现，预先给他们评分。
 * 你需要按照以下要求，帮助老师给这些孩子分发糖果：
 * 每个孩子至少分配到 1 个糖果。
 * 相邻的孩子中，评分高的孩子必须获得更多的糖果。
 */
public class Candy {

    public static void main(String[] args) {
        int[] ratings = new int[] {1,2,2};

        System.out.println(candy(ratings));
    }

    static int candy(int[] ratings) {
        int[] nums = new int[ratings.length];

        // 左右各扫描一遍
        for (int i = 1, inc = 1; i < ratings.length; i++) {
            if (ratings[i] > ratings[i-1]) {
                nums[i] = inc++;
            } else {
                inc = 1;
            }
        }
        for (int i = ratings.length - 2, inc = 1; i >= 0; i--) {
            if (ratings[i] > ratings[i+1]) {
                nums[i] = Math.max(inc++, nums[i]);
            } else {
                inc = 1;
            }
        }

        int sum = ratings.length;
        for (int num : nums) {
            sum += num;
        }
        return sum;
    }
}
