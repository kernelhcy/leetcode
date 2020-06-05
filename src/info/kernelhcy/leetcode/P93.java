package info.kernelhcy.leetcode;

import java.util.LinkedList;
import java.util.List;

public class P93
{
    public static void main(String[] args)
    {
        System.out.println(new Solution().restoreIpAddresses("00000"));
        System.out.println(new Solution().restoreIpAddresses("25525511135"));
        System.out.println(new Solution().restoreIpAddresses("0000"));
        System.out.println(new Solution().restoreIpAddresses("010010"));
    }

    public static class Solution
    {
        public List<String> restoreIpAddresses(String s)
        {
            List<String> result = new LinkedList<>();
            restore(s, result, 0, 1, "");
            return result;
        }

        private void restore(String s, List<String> result, int idx, int seg, String curr)
        {
            if (idx >= s.length()) return;

            if (seg == 4) {
                String tmp = s.substring(idx);
                if (tmp.length() <= 0) return;
                if (tmp.length() > 3) return;
                int v = Integer.parseInt(tmp);

                if (tmp.length() == 3 && v >= 100 && v < 256) {
                    result.add(curr + tmp);
                } else if (tmp.length() == 2 && v >= 10 && v < 100) {
                    result.add(curr + tmp);
                } else if (tmp.length() == 1 && v >= 0 && v < 10) {
                    result.add(curr + tmp);
                }
                return;
            }

            if (s.charAt(idx) == '0') {
                restore(s, result, idx + 1, seg + 1, curr + "0.");
                return;
            }

            for (int i = 1; i <= 3 && idx + i < s.length(); ++i) {
                String tmp = s.substring(idx, idx + i);
                int v = Integer.parseInt(tmp);
                if (v >= 0 && v < 256) {
                    restore(s, result, idx + i, seg + 1, curr + tmp + ".");
                }
            }
        }
    }
}
