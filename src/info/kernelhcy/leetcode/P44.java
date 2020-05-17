package info.kernelhcy.leetcode;

import java.util.HashMap;
import java.util.Map;

public class P44
{
    public static void main(String[] args)
    {
        System.out.println(new Solution().isMatch2("aaa", "**a"));
        System.out.println(new Solution().isMatch2("asd", "a*"));
        System.out.println(new Solution().isMatch2("mississippi", "m??*ss*?i*pi"));
        System.out.println(new Solution().isMatch2("adceb", "*a*b"));
        System.out.println(new Solution().isMatch("babbbaabbaaaaabbababaaaabbbbbbbbbbabbaaaabbababbabaa", "*a*a*b*ab*a*bab"));
        System.out.println(new Solution().isMatch("babbbaabbaaaaabbababaaaabbbbbbbbbbabbaaaabbababbabaa", "**a****a**b***ab***a*bab"));
        System.out.println(new Solution().isMatch("abbabaaabbabbaababbabbbbbabbbabbbabaaaaababababbbabababaabbababaabbbbbbaaaabababbbaabbbbaabbbbababababbaabbaababaabbbababababbbbaaabbbbbabaaaabbababbbbaababaabbababbbbbababbbabaaaaaaaabbbbbaabaaababaaaabb",
                "*aa*ba*a*bb*aa*ab*a*aaaaaa*a*aaaa*bbabb*b*b*aaaaaaaaa*a*ba*bbb*a*ba*bb*bb*a*b*bb"));
        System.out.println(new Solution().isMatch("abbabaaabbabbaababbabbbbbabbbabbbabaaaaababababbbabababaabbababaabbbbbbaaaabababbbaabbbbaabbbbababababbaabbaababaabbbababababbbbaaabbbbbabaaaabbababbbbaababaabbababbbbbababbbabaaaaaaaabbbbbaabaaababaaaabb",
                "**aa*****ba*a*bb**aa*ab****a*aaaaaa***a*aaaa**bbabb*b*b**aaaaaaaaa*a********ba*bbb***a*ba*bb*bb**a*b*bb"));
    }

    public static class Solution
    {
        public boolean isMatch(String s, String p)
        {
            byte[] sa = s.getBytes();
            byte[] pa = p.getBytes();

            int si = 0, lastSi = -1;
            int pi = 0, lastPi = -1;
            while (si < sa.length) {
                if (pi < pa.length && pa[pi] == '*') {
                    ++pi;
                    lastPi = pi;
                    lastSi = si;
                } else if (pi < pa.length && (pa[pi] == '?' || pa[pi] == sa[si])) {
                    ++si;
                    ++pi;
                } else if (lastSi >= 0){
                    ++lastSi;
                    si = lastSi;
                    pi = lastPi;
                } else {
                    return false;
                }
            }

            while (pi < pa.length && pa[pi] == '*') ++pi;
            return pi >= pa.length;
        }

        public boolean isMatch2(String s, String p)
        {
            String key = s + "|" + p;
            if (res.containsKey(key)) {
                return res.get(key);
            }

            if (p.equals("*")) return true;
            if (s.length() <= 0 && p.length() <= 0) return true;
            if (s.length() > 0 && p.length() <= 0) return false;
            if (s.length() <= 0) return false;

            int i = 0, j = 0;
            for (; i < s.length(); ++i, ++j) {
                if (j >= p.length()) {
                    res.put(key, false);
                    return false;
                }

                if (p.charAt(j) == '*') {
                    while (j < p.length() - 1 && p.charAt(j + 1) == '*') ++j;

                    String np = p.substring(j + 1);
                    for (int k = i; k <= s.length(); ++k) {
                        if (isMatch2(s.substring(k), np)) {
                            res.put(key, true);
                            return true;
                        }
                    }
                } else if (p.charAt(j) == '?' || p.charAt(j) == s.charAt(i)) {
                    continue;
                } else {
                    res.put(key, false);
                    return false;
                }
            }

            while (j < p.length() && p.charAt(j) == '*') ++j;
            return j >= p.length();
        }

        private Map<String, Boolean> res = new HashMap<>();
    }
}
