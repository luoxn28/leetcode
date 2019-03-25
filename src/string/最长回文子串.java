package string;

/**
 * 给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为 1000。
 * 输入: "babad" 输出: "bab"
 * 注意: "aba" 也是一个有效答案。
 *
 * 解法
 * 1 暴力枚举，以每个元素为中心点，同时从左右节点出发，时间复杂度O(n^2)。
 *   注意，回文数个数为奇数时中心点是一个点，如果为偶数中心点相当于是2个点
 */
public class 最长回文子串 {

    public static void main(String[] args) {
        System.out.println(longestPalindrome("aaaa"));
        System.out.println(longestPalindrome("aaa"));
    }

    static String longestPalindrome(String s) {
        String result = "";
        for (int i = 0; i < s.length(); i++) {
            String ps = palindrome(s, i, i);
            if (ps.length() > result.length()) {
                result = ps;
            }
            ps = palindrome(s, i, i + 1);
            if (ps.length() > result.length()) {
                result = ps;
            }
        }
        return result;
    }

    static String palindrome(String s, int left, int right) {
        if (left < 0 || right >= s.length()) {
            return "";
        }

        while (left >= 0 && right < s.length()) {
            if (s.charAt(left) == s.charAt(right)) {
                left--;
                right++;
            } else {
                break;
            }
        }

        return s.substring(left + 1, right);
    }
}
