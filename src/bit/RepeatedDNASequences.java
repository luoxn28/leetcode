package bit;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 所有 DNA 由一系列缩写为 A，C，G 和 T 的核苷酸组成，例如：“ACGAATTCCG”。在研究 DNA 时，识别 DNA 中的重复序列有时会对研究非常有帮助。
 * 编写一个函数来查找 DNA 分子中所有出现超多一次的10个字母长的序列（子串）。
 * 示例:
 * 输入: s = "AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT"
 * 输出: ["AAAAACCCCC", "CCCCCAAAAA"]
 *
 * 解法
 * 1. [暴力] 按照10个字母长度遍历，将其塞到map中，value为计数值，便利完成之后，获取map中计数值大于1的数据
 *      时间复杂度O(n) 空间复杂度O(10)
 * 2. ACGT只有4种，只有10字符长度，理论上可以将10字符串长度的ACGT子串编码成int数据，流程和方法一一样，只不过此时
 *   时间复杂度O(n)  空间复杂度O(n)
 */
public class RepeatedDNASequences {

    public static void main(String[] args) {
        String s = "AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT";

        System.out.println(findRepeatedDnaSequences(s));
        System.out.println(findRepeatedDnaSequencesLessSpace(s));
    }

    // 解法1
    static List<String> findRepeatedDnaSequences(String s) {
        List<String> result = new ArrayList<>();
        if (s.length() < 10) {
            return result;
        }

        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length() - 9; i++) {
            String key = s.substring(i, i + 10);
            int cnt = map.getOrDefault(key, 0);
            map.put(key, cnt + 1);
        }

        map.forEach((k, v) -> {
            if (v > 1) {
                result.add(k);
            }
        });
        return result;
    }

    // 解法2
    static List<String> findRepeatedDnaSequencesLessSpace(String s) {
        List<String> result = new ArrayList<>();
        if (s.length() < 10) {
            return result;
        }

        Map<Character, Integer> encodeMap = new HashMap<>();
        encodeMap.put('A', 0);
        encodeMap.put('C', 1);
        encodeMap.put('G', 2);
        encodeMap.put('T', 3);

        Map<Integer, Character> decodeMap = new HashMap<>();
        encodeMap.forEach((k, v) -> decodeMap.put(v, k));

        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length() - 9; i++) {
            Integer key = encode(s.substring(i, i + 10), encodeMap);
            int cnt = map.getOrDefault(key, 0);
            map.put(key, cnt + 1);
        }

        map.forEach((k, v) -> {
            if (v > 1) {
                result.add(decode(k, decodeMap));
            }
        });
        return result;
    }
    // 字符串与int数据的编解码
    static int encode(String s, Map<Character, Integer> encodeMap) {
        assert s.length() == 10;

        int result = 0;
        for (int i = 0; i < 10; i++) {
            result = (result << 2) + encodeMap.get(s.charAt(i));
        }
        return result;
    }
    static String decode(int num, Map<Integer, Character> decodeMap) {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < 10; i++) {
            builder.append(decodeMap.get(num & 3));
            num >>= 2;
        }
        return builder.reverse().toString();
    }
}
