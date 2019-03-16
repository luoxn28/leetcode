package bit;

/**
 * 给定一个字符串数组 words，找到 length(word[i]) * length(word[j]) 的最大值，并且这两个单词不含有公共字母。
 * 你可以认为每个单词只包含小写字母。如果不存在这样的两个单词，返回 0。
 * 输入: ["abcw","baz","foo","bar","xtfn","abcdef"]
 * 输出: 16
 * 解释: 这两个单词为 "abcw", "xtfn"。
 */
public class MaximumProductOfWordLengths {

    public static void main(String[] args) {
        String[] words = new String[] {"abcw", "baz", "foo", "bar", "xtfn", "abcdef"};

        System.out.println(maxProduct(words));
    }

    // 将单词编码成int型数据，通过两个int型数据比较是否有共同元素
    static int maxProduct(String[] words) {
        int n = words.length;
        int[] hashset = new int[n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < words[i].length(); j++) {
                hashset[i] |= 1 << (words[i].charAt(j) - 'a');
            }
        }

        int result = 0;
        for (int i = 0; i < n ; i++) {
            for (int j = i + 1; j < n; j++) {
                int tmp = words[i].length() * words[j].length();
                if ((hashset[i] & hashset[j]) == 0 && tmp > result) {
                    result = tmp;
                }
            }
        }
        return result;
    }
}
