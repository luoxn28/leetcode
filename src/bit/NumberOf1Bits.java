package bit;

/**
 * 输入是一个无符号整数，返回其二进制表达式中数字位数为 ‘1’ 的个数。
 * 比如11（00000000000000000000000000001011）返回3
 * 注意，使用无符号右移计算
 *
 * 解法
 * 1. 按照无符号整数来处理，每次右移一位，如果最后一位为1则计数，整数每一位遍历完成得到计数值
 * 2. 执行n&(n-1)，会将n最后是1的那一位置为0，n&(n-1) != 0，能重复多少次，就说明n中有多少个1
 */
public class NumberOf1Bits {

    public static void main(String[] args) {
        System.out.println(hammingWeight(11));
        System.out.println(hammingWeightOptimize(11));

        System.out.println(hammingWeight2(11));
    }

    // 解法1
    static int hammingWeight(int num) {
        int cnt = 0;
        for (int i = 0; i < 32; i++) {
            cnt += num & 1;
            num >>>= 1;
        }
        return cnt;
    }
    // 解法1的改进版
    static int hammingWeightOptimize(int num) {
        int cnt = 0;
        while (num != 0) {
            cnt += num & 1;
            num >>>= 1;
        }
        return cnt;
    }

    // 解法2
    static int hammingWeight2(int num) {
        int cnt = 0;
        while (num != 0) {
            num &= num - 1;
            cnt++;
        }
        return cnt;
    }
}
