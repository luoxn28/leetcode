package bit;

/**
 * 给定一个unsigned int型数据，将其二进制位反转。
 * 比如 43261596 (represented in binary as 00000010100101000001111010011100 )，其二进制
 * 反转964176192 (represented in binary as 00111001011110000010100101000000 )
 *
 * 解法：
 * 1. 使用临时int变量result，遍历int数据二进制位，如果
 * 2. 将int数据转换成二进制位数组，相当于反转数据。需要额外数组空间对应位为1，则将result反转对应位置1，否则置0。使用额外int变量
 * 3. 前后同时遍历int数据二进制位，如果前后遍历对应位的二进制数据不一样，则直接在原int数据上交换。无需使用额外变量
 */
public class ReverseBits {

    public static void main(String[] args) {
        System.out.println(Integer.toBinaryString(43261596));

        System.out.println(Integer.toBinaryString(reverseBits(43261596)));
        System.out.println(Integer.toBinaryString(reverseBitsDirect(43261596)));
    }

    // 解法2
    static int reverseBits(int num) {
        int result = 0;
        for (int i = 0; i < 32; i++) {
            result = (result << 1) + ((num >> i) & 1);
        }
        return result;
    }

    // 解法3
    static int reverseBitsDirect(int num) {
        int i = 0;
        int j = 31;
        while (i < j) {
            // 如果i,j对应位不一致，则进行反转
            if (((num >> i) & 1) != ((num >> j) & 1)) {
                num ^= ((1 << i) | (1 << j));
            }

            i++;
            j--;
        }
        return num;
    }
}
