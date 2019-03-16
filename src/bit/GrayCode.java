package bit;

import java.util.ArrayList;
import java.util.List;

/**
 * 格雷编码是一个二进制数字系统，在该系统中，两个连续的数值仅有一个位数的差异。
 * 给定一个代表编码总位数的非负整数 n，打印其格雷编码序列。格雷编码序列必须以 0 开头。
 *   输入: 2
     输出: [0,1,3,2]
     解释:
     00 - 0
     01 - 1
     11 - 3
     10 - 2

 * 解法
 * 1. 数学公式，时间复杂度O(2^n)，空间复杂度O(1)
 */
public class GrayCode {

    public static void main(String[] args) {
        System.out.println(grayCode(2));
    }

    static List<Integer> grayCode(int n) {
        int size = 1 << n; // 2^n
        List<Integer> result = new ArrayList<>(size);

        for (int i = 0; i < size; i++) {
            result.add(binary2Gray(i));
        }
        return result;
    }
    static int binary2Gray(int n) {
        return n ^ (n >> 1);
    }
}
