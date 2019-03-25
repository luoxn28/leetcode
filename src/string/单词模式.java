package string;

import java.util.HashMap;
import java.util.Map;

/**
 * 单词模式
 * 给定一种 pattern(模式) 和一个字符串 str ，判断 str 是否遵循相同的模式。
 *
 * 解法
 * 1 通过map结构记录模式和字符串的匹配关系，
 */
public class 单词模式 {

    public static void main(String[] args) {
        System.out.println(wordPattern("北京 杭州 杭州 北京", "abba"));
        System.out.println(wordPattern(" 北京 杭州 杭州 北京", "abba"));
        System.out.println(wordPattern("北京 杭州 杭州 北京", "aabb"));
        System.out.println(wordPattern("北京 杭州 杭州 北京", "baab"));
    }

    static boolean wordPattern(String str, String pattern) {
        if (str == null || pattern == null) {
            return false;
        }

        String[] strs = str.trim().split("\\s+");
        if (pattern.length() != strs.length) {
            return false;
        }

//        Map<Character, String> charString = new HashMap<>();
        Map<String, Character> stringChar = new HashMap<>();
        for (int i = 0; i < pattern.length(); i++) {
            Character c = stringChar.get(strs[i]);
            if (c == null) {
                stringChar.put(strs[i], pattern.charAt(i));
            } else if (!c.equals(pattern.charAt(i))) {
                return false;
            }

//            String s = charString.get(pattern.charAt(i));
//            if (s == null) {
//                charString.put(pattern.charAt(i), strs[i]);
//            } else if (!s.equals(strs[i])) {
//                return false;
//            }
        }

        return true;
    }
}
