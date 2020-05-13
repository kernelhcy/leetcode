package info.kernelhcy.leetcode;

/**
 *
 * Created by hcy on 05/10/2016.
 */
public class N8
{
    public static void main(String argv[])
    {
        System.out.println("Result: " + new Solution().myAtoi(""));
        System.out.println("Result: " + new Solution().myAtoi("-2147483647"));
        System.out.println("Result: " + new Solution().myAtoi("2147483648"));
        System.out.println("Result: " + new Solution().myAtoi("123ab"));
        System.out.println("Result: " + new Solution().myAtoi("a23"));
        System.out.println("Result: " + new Solution().myAtoi("123"));
        System.out.println("Result: " + new Solution().myAtoi("-123"));
        System.out.println("Result: " + new Solution().myAtoi("+123"));
        System.out.println("Result: " + new Solution().myAtoi("  -0012a42"));
        System.out.println("Result: " + new Solution().myAtoi("+-2"));
    }

    public static class Solution
    {
        public int myAtoi(String str)
        {
            if (str.length() <= 0) return 0;
            str = str.trim();
            long re = 0;
            boolean isPositive = false;
            boolean isNegative = false;

            for (int i = 0; i < str.length(); ++i) {
                switch (str.charAt(i))
                {
                    case '-':
                        if (isPositive || isNegative) return 0;
                        isNegative = true;
                        break;
                    case '+':
                        if (isNegative || isPositive) return 0;
                        isPositive = true;
                        break;
                    case '0':
                    case '1':
                    case '2':
                    case '3':
                    case '4':
                    case '5':
                    case '6':
                    case '7':
                    case '8':
                    case '9':
                        re *= 10;
                        re += str.charAt(i) - '0';
                        if (isNegative) {
                            if (-re <= Integer.MIN_VALUE) return Integer.MIN_VALUE;
                        } else {
                            if (re >= Integer.MAX_VALUE) return Integer.MAX_VALUE;
                        }
                        break;
                    default:
                        return (int) (isNegative ? -re : re);
                }
            }
            return (int) (isNegative ? -re : re);

        }
    }
}
