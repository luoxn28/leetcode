package string;

import java.util.Arrays;

/**
 * KMP算法
 */
public class KMP {

    public static void main(String[] args) {
        String str = "BBC ABCDAB ABCDABCDABDE";
        String pattern =  "ABCDABD";

        System.out.println(kmp(str, pattern));
    }

    static int kmp(String str, String pattern) {
        if (str.isEmpty() || pattern.isEmpty()) {
            return -1;
        }

        int i = 0, j = 0;
        int[] next = next(pattern);
        while (i < str.length() && j < pattern.length()) {
            if (j == -1 || str.charAt(i) == pattern.charAt(j)) {
                i++;
                j++;
            } else {
                j = next[j];
            }
        }

        return j == pattern.length() ? i - j : -1;
    }

    static int[] next(String pattern) {
        if (pattern.isEmpty()) {
            return new int[]{};
        }

        int[] next = new int[pattern.length()];
        int i = -1; // 对应前缀字符串
        int j = 0; // 对应后缀字符串

        next[0] = -1;
        while (j < pattern.length() - 1) {
            if (i == -1 || pattern.charAt(j) == pattern.charAt(i)) {
                next[++j] = ++i;
            } else {
                i = next[i];
            }
        }
        return next;
    }
}
