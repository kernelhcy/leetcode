package info.kernelhcy.leetcode;

/**
 *
 * Created by hcy on 05/10/2016.
 */
public class N6
{
    public static void main(String argv[])
    {
        //System.out.println("Result: " + new Solution().convert("", 1));
        System.out.println("Result: " + new Solution().convert("A", 1));
        System.out.println("Result: " + new Solution().convert("AB", 1));
        System.out.println("Result: " + new Solution().convert("PAYPALISHIRING", 3));
        System.out.println("Result: " + new Solution().convert("ABCDEFGHIJK", 3));
        System.out.println("Result: " + new Solution().convert("ABCDEFGHIJK", 2));
    }

    public static class Solution
    {
        public String convert(String s, int numRows)
        {
            if (numRows == 1) return s;
            StringBuilder res = new StringBuilder();
            int numCols = s.length() * 2 / numRows + 1;

            // first line
            for (int i = 0; i < numCols; ++i) {
                if ((2 * numRows - 2) * i >= 0 && (2 * numRows - 2) * i < s.length()) {
                    res.append(s.charAt((2 * numRows - 2) * i));
                }
            }


            for (int n = 1; n < numRows - 1; ++n) {
                for (int i = 0; i < s.length() * 2 / numRows + 1; ++i) {
                    if ((2 * numRows - 2) * i - n >= 0 && (2 * numRows - 2) * i - n < s.length())
                        res.append(s.charAt((2 * numRows - 2) * i - n));
                    if ((2 * numRows - 2) * i + n < s.length() )
                        res.append(s.charAt((2 * numRows - 2) * i + n));
                }
            }

            // last line
            for (int i = 0; i < numCols; ++i) {
                if ((2 * numRows - 2) * i + numRows - 1 >= 0 && (2 * numRows - 2) * i + numRows - 1 < s.length()) {
                    res.append(s.charAt((2 * numRows - 2) * i + numRows - 1));
                }
            }

            return res.toString();
        }
    }

}


