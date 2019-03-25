package string;

/**
 * 实现strStr()
 * 给定一个 haystack 字符串和一个 needle 字符串，在 haystack 字符串中找出 needle 字符串出现的第一个位置 (从0开始)。
 * 如果不存在，则返回  -1。
 *
 * 解法
 * 1 暴力，遍历查找
 * 2 KMP算法
 */
public class 实现strStr {

    public static void main(String[] args) {
        System.out.println(strStr("hello", "ll"));
        System.out.println(strStr("mississippi", "a"));
    }

    static int strStr(String haystack, String needle) {
        if (needle.isEmpty()) {
            return 0;
        }

        int length = haystack.length() - needle.length() + 1;
        for (int i = 0; i < length; i++) {
            int j = i, k = 0;
            while (k < needle.length() && haystack.charAt(j) == needle.charAt(k)) {
                j++;
                k++;
            }
            if (k == needle.length()) {
                return i;
            }
        }
        return -1;
    }
}
