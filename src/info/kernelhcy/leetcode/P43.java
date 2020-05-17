package info.kernelhcy.leetcode;

import java.math.BigInteger;

public class P43
{
    public static void main(String[] args)
    {
        System.out.println(new Solution().add("2345455", "98765"));
        System.out.println(new Solution().multiply("2345455", '3', 1));
        System.out.println(new Solution().multiply("123", "456"));
    }

    public static class Solution
    {
        public String multiply(String num1, String num2)
        {
            if ("0".equals(num1) || "0".equals(num2)) return "0";
            String tmp = "";
            for (int i = num2.length() - 1; i >= 0; --i) {
                tmp = add(tmp, multiply(num1, num2.charAt(i), num2.length() - 1 - i));
            }
            return tmp;
        }

        public String add(String num1, String num2)
        {
            StringBuilder re = new StringBuilder();
            int in = 0;
            int len = Math.max(num1.length(), num2.length());
            int n1, n2;
            for (int i = 0; i < len; ++i) {
                n1 = num1.length() - 1 - i;
                n2 = num2.length() - 1 - i;
                int tmp = 0;
                if (n1 < 0 & n2 >= 0) {
                    tmp = (num2.charAt(n2) - '0') + in;
                } else if (n1 >= 0 && n2 < 0) {
                    tmp = (num1.charAt(n1) - '0') + in;
                } else {
                    tmp = (num1.charAt(n1) - '0') + (num2.charAt(n2) - '0') + in;
                }
                in = tmp / 10;
                tmp = tmp % 10;
                re.append((char)('0' + tmp));
            }
            if (in != 0) {
                re.append((char)('0' + in));
            }

            return re.reverse().toString();
        }

        public String multiply(String n, char c, int base)
        {
            StringBuilder re = new StringBuilder();
            int in = 0;
            int tmp = 0;
            for (int i = n.length() - 1; i >= 0; --i) {
                tmp = (c - '0') * (n.charAt(i) - '0') + in;
                in = tmp / 10;
                tmp = tmp % 10;
                re.append((char)('0' + tmp));
            }
            if (in != 0) {
                re.append((char)('0' + in));
            }

            String ts = re.reverse().toString();
            for (int i = 0; i < base; ++i) {
                ts += '0';
            }
            return ts;
        }
    }
}
