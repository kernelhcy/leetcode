package info.kernelhcy.leetcode;

import java.util.Objects;

public class P10
{
    public static void main(String[] args)
    {
        System.out.println(new Solution().isMatch("aa", "a"));
        System.out.println(new Solution().isMatch("aa", "a*"));
        System.out.println(new Solution().isMatch("ab", ".*"));
        System.out.println(new Solution().isMatch("aab", "c*a*b"));
        System.out.println(new Solution().isMatch("mississippi", "mis*is*p*."));
        System.out.println(new Solution().isMatch("aaa", "a*a"));
        System.out.println(new Solution().isMatch("ab", ".*c"));
        System.out.println(new Solution().isMatch("a", "ab*"));
        System.out.println(new Solution().isMatch("a", "a.*a"));
        System.out.println(new Solution().isMatch("", "c*c*"));
    }

    public static class Solution
    {
        public boolean isMatch(String s, String p)
        {
            if (Objects.isNull(s) && Objects.isNull(p)) return true;
            if (s.length() <= 0 && p.length() <= 0) return true;
            if (s.length() > 0 && p.length() <= 0) return false;
            if (s.length() <= 0 && p.length() == 2 && p.endsWith("*")) return true;

            int j = 0;
            for (int i = 0; i < p.length(); ++i) {
                if (j > s.length()) return false;

                if (i < p.length() - 1 && p.charAt(i + 1) == '*') {
                    boolean re = isMatch(s.substring(j), p.substring(i + 2));
                    if (re) return re;
                    while (j < s.length() && ( p.charAt(i) == '.' || p.charAt(i) == s.charAt(j))) {
                        re |= isMatch(s.substring(j + 1), p.substring(i + 2));
                        if (re) return re;
                        ++j;
                        if (j >= s.length()) break;
                    }
                } else {
                    if (j < s.length() && ( p.charAt(i) == '.' || p.charAt(i) == s.charAt(j))) {
                        j += 1;
                    } else {
                        return false;
                    }
                }
            }

            return j == s.length();
        }
    }
}
