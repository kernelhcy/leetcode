package info.kernelhcy.leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class P17
{
    public static void main(String[] args)
    {
        System.out.println(new Solution().letterCombinations("23"));
    }

    public static class Solution
    {
        public List<String> letterCombinations(String digits)
        {
            List<String> res = new ArrayList<>();
            if (digits.length() <= 0) {
                return res;
            }

            String s = MAPS[digits.charAt(0) - '0'];
            if (digits.length() == 1) {
                for (int i = 0; i < s.length(); ++i) {
                    res.add("" + s.charAt(i));
                }
                return res;
            }

            digits = digits.substring(1);
            List<String> tmp = letterCombinations(digits);
            if (s.length() <= 0) {
                return tmp;
            }

            for (int i = 0; i < s.length(); ++i) {
                char c = s.charAt(i);
                res.addAll(tmp.stream().map(ss -> c + ss).collect(Collectors.toList()));
            }
            return res;
        }

        private static final String[] MAPS = new String[]{
                "", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"
        };
    }
}
