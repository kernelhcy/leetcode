package info.kernelhcy.leetcode;

/**
 * Created by hcy on 06/10/2016.
 */
public class N5
{
    public static void main(String argv[])
    {
        System.out.println("Result: " + new Solution().longestPalindrome("11abcba22"));
        System.out.println("Result: " + new Solution().longestPalindrome("11abba2"));
    }

    public  static class Solution
    {
        public String longestPalindrome(String s)
        {
            if (s == null || s.length() <= 1) return s;

            int maxIdx = 0, maxLen = 0;
            boolean flag = false;

            int expLen = s.length() * 2 - 1;
            for (int i = 0; i < expLen; ++i) {
                int idx = i / 2;
                int len = 1;
                if (i % 2 == 0) {
                    while (idx - len >= 0 && idx + len < s.length() && s.charAt(idx - len) == s.charAt(idx + len)) {
                        ++len;
                    }
                    --len;
                    if (len * 2 + 1 > maxLen) {
                        maxIdx = idx;
                        maxLen = len * 2 + 1;
                        flag = false;
                    }
                } else {
                    while (idx - len + 1 >= 0 && idx + len < s.length() && s.charAt(idx - len + 1) == s.charAt(idx + len)) {
                        ++len;
                    }
                    --len;
                    if (len * 2 > maxLen) {
                        maxIdx = idx;
                        maxLen = len * 2;
                        flag = true;
                    }
                }
            }

            int start = flag ? maxIdx - maxLen / 2 + 1 : maxIdx - maxLen / 2;
            return s.substring(start, start + maxLen);
        }

    }
}
