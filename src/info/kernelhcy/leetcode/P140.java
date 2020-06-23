package info.kernelhcy.leetcode;

import java.util.*;

public class P140
{
    public static void main(String[] args)
    {
        System.out.println(new Solution().wordBreak("aaaaaaaa", Arrays.asList("aaaa","aaa","aa")));
    }

    public static class Solution {
        public List<String> wordBreak(String s, List<String> wordDict)
        {
            int[] memo = new int[s.length()];
            Arrays.fill(memo, -1);
            Set<String> res = new HashSet<>();
            wordBreak(s, 0, wordDict, "", res, memo);
            return new ArrayList<>(res);
        }

        private boolean wordBreak(String s, int idx, List<String> wordDict, String curr, Set<String> res, int[] memo)
        {
            if (idx >= s.length()) return true;
            if (memo[idx] == 0) return false;

            boolean re = false;
            for (int i = 0; i < wordDict.size(); ++i) {
                String w = wordDict.get(i);
                if (equals(s, idx, w)) {
                    if (idx + w.length() == s.length()) {
                        res.add(curr + w);
                    }

                    boolean r = wordBreak(s, idx + w.length(), wordDict, curr + w + " ", res, memo);
                    re |= r;
                }
            }
            memo[idx] = re ? 1 : 0;
            return re;
        }

        private boolean equals(String s, int idx, String w)
        {
            for (int i = 0; i < w.length(); ++i) {
                if (idx + i >= s.length() || s.charAt(idx + i) != w.charAt(i)) {
                    return false;
                }
            }
            return true;
        }
    }
}
