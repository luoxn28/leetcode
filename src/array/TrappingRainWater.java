package array;

import java.util.Arrays;

/**
 * 给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水
 *
 * 解法:
 * 对于每个柱子，找到其左右两边最高的柱子，该柱子能容纳的面积就是 min(max_left, max_right) - height 。
 */
public class TrappingRainWater {

    public static void main(String[] args) {
        int[] height = new int[] {0,1,0,2,1,0,1,3,2,1,2,1};

        System.out.println(trap(height));
    }

    static int trap(int[] height) {

        int[] leftPeek = new int[height.length];
        int[] rightPeek = new int[height.length];

        // 向右遍历，找到当前index左边最高柱子高度
        for (int i = 1; i < height.length; i++) {
            leftPeek[i] = Math.max(leftPeek[i-1], height[i-1]);
        }

        // 向左遍历，找到当前index右边最高柱子高度
        for (int i = height.length - 2; i >= 0; i--) {
            rightPeek[i] = Math.max(rightPeek[i+1], height[i+1]);
        }

        int result = 0;
        for (int i =  1; i < height.length - 1; i++) {
            int h = Math.min(leftPeek[i], rightPeek[i]);
            if (h > height[i]) {
                result += h- height[i];
            }
        }
        return result;
    }
}
