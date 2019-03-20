package array;

/**
 * 假设你正在爬楼梯。需要 n 阶你才能到达楼顶。
 * 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
 * 设 f(n) 表示爬 n 阶楼梯的不同方法数，为了爬到第 n 阶楼梯，有两个选择：
 *   从第 n-1 阶前进1步；
 *   从第 n-1 阶前进2步；
 * f(n) = f(n-1) + f(n-2)
 *
 * 解法
 * 1. 递归
 * 2. 遍历
 */
public class ClimbingStairs {

    public static void main(String[] args) {
        System.out.println(climbStairs(3));
        System.out.println(climbStairs(4));
    }

    // 解法2
    static int climbStairs(int n) {
        int pre = 0;
        int cur = 1;

        for (int i  = 1; i <= n; i++) {
            int tmp = cur;
            cur += pre;
            pre = tmp;
        }
        return cur;
    }
}
