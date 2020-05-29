package info.kernelhcy.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class P76
{
    public static void main(String[] args)
    {
        System.out.println(new Solution().minWindow("aa", "aa"));
        System.out.println(new Solution().minWindow("ADOBECODEBANC", "ABC"));
    }

    public static class Solution
    {
//        public String minWindow(String s, String t)
//        {
//            Map<Character, Integer> tMap = new HashMap<>();
//            for (int i = 0; i < t.length(); ++i) {
//                tMap.put(t.charAt(i), tMap.getOrDefault(t.charAt(i), 0) + 1);
//            }
//
//            for (int i = 0; i < s.length(); ++i) {
//                if (! tMap.containsKey(s.charAt(i))) continue;
//
//                char c = s.charAt(i);
//                for (int j = i; j < s.length(); ++j) {
//
//                }
//            }
//        }

        public String minWindow(String s, String t)
        {
            if (s.length() <= 0 || t.length() <= 0) return "";
            int[][] map = new int[s.length()][t.length()];

            for (int i = 0; i < s.length(); ++i) {
                for (int j = 0; j < t.length(); ++j) {
                    map[i][j] = s.charAt(i) == t.charAt(j) ? 1 : 0;
                }
            }

            List<Integer> idxs = new ArrayList<>(s.length());
            for (int i = 0; i < s.length(); ++i) {
                boolean all0 = true;
                for (int j = 0; j < t.length(); ++j) {
                    if (map[i][j] != 0) {
                        all0 = false;
                        break;
                    }
                }
                if (!all0) {
                    idxs.add(i);
                }
            }
            int[][] nmap = new int[idxs.size()][t.length()];
            for (int i = 0; i < idxs.size(); ++i) {
                for (int j = 0; j < t.length(); ++j) {
                    nmap[i][j] = map[idxs.get(i)][j];
                }
            }

            if (nmap.length < t.length()) return "";

            int min = Integer.MAX_VALUE;
            int start = 0, end = 0;
            for (int i = 0; i <= nmap.length - t.length(); ++i) {
                if (check(nmap, i, t.length())) {
                    if (idxs.get(i + t.length() - 1) - idxs.get(i) < min) {
                        min = idxs.get(i + t.length() - 1) - idxs.get(i);
                        start = idxs.get(i);
                        end = idxs.get(i + t.length() - 1);
                    }
                }
            }
            if (min < Integer.MAX_VALUE) {
                return s.substring(start, end + 1);
            }
            return "";
        }

        private boolean check(int[][] map, int start, int len)
        {
            for (int i = start; i < start + len; ++i) {
                int sum = 0;
                for (int j = 0; j < len; ++j) {
                    sum += map[i][j];
                }
                if (sum != 1) return false;
            }

            for (int i = 0; i < len; ++i) {
                int sum = 0;
                for (int j = start; j < start + len; ++j) {
                    sum += map[j][i];
                }
                if (sum != 1) return false;
            }

            return true;
        }
    }
}
