package info.kernelhcy.leetcode;

import java.util.*;

public class P30
{
    public static void main(String[] args)
    {
        System.out.println(new Solution().findSubstring("barfoothefoobarman", new String[]{"foo", "bar"}));
        System.out.println(new Solution().findSubstring("barfoofoobarthefoobarman", new String[]{"foo", "bar", "the"}));
        System.out.println(new Solution().findSubstring("wordgoodgoodgoodbestword", new String[]{"word","good","best","good"}));
    }

    public static class Solution
    {
        public List<Integer> findSubstring(String s, String[] words)
        {
            List<Integer> res = new LinkedList<>();
            if (s.length() <= 0 || words.length <= 0) {
                return res;
            }

            int wl = words[0].length();
            int wsl = words[0].length() * words.length;

            Map<String, Integer> wordsMap = new HashMap<>();
            for (String word : words) {
                wordsMap.put(word, wordsMap.getOrDefault(word, 0) + 1);
            }

            for (int i = 0; i < s.length(); ++i) {
                Map<String, Integer> actual = new HashMap<>();
                for (int j = i; j <= s.length() - wl; j += wl) {
                    String tmp = s.substring(j, j + wl);
                    if (wordsMap.containsKey(tmp)) {
                        actual.put(tmp, actual.getOrDefault(tmp, 0) + 1);
                        if (actual.get(tmp) > wordsMap.get(tmp)) {
                            break;
                        }

                        if (j - i == wsl - wl) {
                            res.add(i);
                            break;
                        }
                    } else {
                        break;
                    }
                }
            }

            return res;
        }


        public int divide(int dividend, int divisor)
        {
            boolean neg = false;
            if (dividend < 0 && divisor > 0) neg = true;
            if (dividend > 0 && divisor < 0) neg = true;

            if (dividend == -2147483648 && divisor == 1) {
                return dividend;
            }

            if (dividend == -2147483648 && divisor == -1) {
                return 2147483647;
            }

            long re = 0;
            long dd = Math.abs((long) dividend);
            long dr = Math.abs((long) divisor);
            long[] map = new long[32];
            for (int i = 0; i < 32; ++i) {
                map[i] = dr << i;
            }
            for (int i = 31; i >= 0; --i) {
                if (dd > map[i]) {
                    dd -= map[i];
                    re += (1 << i);
                }
            }

            return (int)(neg ? -re : re);
        }
    }
}
