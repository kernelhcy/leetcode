package info.kernelhcy.leetcode;

import java.util.LinkedList;
import java.util.List;

public class P131
{
    public static void main(String[] args)
    {
        System.out.println(new Solution().partition("aab"));
        System.out.println(new Solution().partition("aabb"));
    }

    private static class Solution
    {
        public List<List<String>> partition(String s)
        {
            List<List<String>> res = new LinkedList<>();
            if (s.length() <= 0) return res;
            find(s, 0, new LinkedList<>(), res);
            return res;
        }

        private void find(String s, int idx, List<String> curr, List<List<String>> res)
        {
            if (idx >= s.length()) {
                res.add(new LinkedList<>(curr));
                return;
            }

            for (int i = idx; i < s.length(); ++i) {
                if (isPalindrome(s, idx, i)) {
                    String tmp = s.substring(idx, i + 1);
                    List<String> tc = new LinkedList<>(curr);
                    tc.add(tmp);
                    find(s, i + 1, tc, res);
                }
            }
        }

        private boolean isPalindrome(String s, int start, int end)
        {
            while (start <= end) {
                if (s.charAt(start) != s.charAt(end)) return false;
                ++start;
                --end;
            }
            return true;
        }
    }
}
