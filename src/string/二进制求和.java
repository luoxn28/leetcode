package string;

/**
 * 二进制求和
 */
public class 二进制求和 {

    public static void main(String[] args) {
        System.out.println(addBinary("11", "1"));
    }

    static String addBinary(String a, String b) {
        int i = a.length() - 1, j = b.length() - 1;
        int carry = 0;

        StringBuilder builder = new StringBuilder();
        while (i >= 0 || j >= 0 || carry > 0) {
            int ia = i >= 0 ? a.charAt(i--) - '0' : 0;
            int ib = j >= 0 ? b.charAt(j--) - '0' : 0;

            int sum = carry + ia + ib;
            builder.append(sum % 2);
            carry = sum / 2;
        }
        return builder.reverse().toString();
    }
}
