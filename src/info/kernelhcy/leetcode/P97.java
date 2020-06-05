package info.kernelhcy.leetcode;

import java.util.HashMap;

public class P97
{
    public static void main(String[] args)
    {
        System.out.println(new Solution().isInterleave3("aabcc", "dbbca", "aadbbcbcac"));
        System.out.println(new Solution().isInterleave3("aabcc", "dbbca", "aadbbbaccc"));
    }

    public static class Solution
    {

        public boolean isInterleave(String s1, String s2, String s3)
        {
            boolean[][][] dp = new boolean[s1.length() + 1][s2.length() + 1][s3.length() + 1];
            for (int i = 0; i <= s2.length(); ++i) {
                for (int j = 0; j <= s3.length(); ++j) {
                    dp[s1.length()][i][j] = s2.substring(i).equals(s3.substring(j));
                }
            }

            for (int i = 0; i <= s1.length(); ++i) {
                for (int j = 0; j <= s3.length(); ++j) {
                    dp[i][s2.length()][j] = s1.substring(i).equals(s3.substring(j));
                }
            }

            for (int k = s3.length() - 1; k >= 0; --k) {
                for (int i = s1.length() - 1; i >= 0; --i) {
                    for (int j = s2.length() - 1; j >= 0; --j) {
                        char c1 = s1.charAt(i);
                        char c2 = s2.charAt(j);
                        char c3 = s3.charAt(k);

                        boolean b1 = false;
                        if (c3 == c1) {
                            b1 = dp[i + 1][j][k + 1];
                        }

                        boolean b2 = false;
                        if (c3 == c2) {
                            b2 = dp[i][j + 1][k + 1];
                        }
                        dp[i][j][k] = b1 || b2;
                    }
                }
            }
            return dp[0][0][0];
        }


        private final HashMap<String, Boolean> memo = new HashMap<>();
        public boolean isInterleave2(String s1, String s2, String s3)
        {
            if (s3.length() == 0 && s2.length() == 0 && s1.length() == 0) return true;
            if (s3.length() == 0) return false;

            if (s1.length() == 0) return s2.equals(s3);
            if (s2.length() == 0) return s1.equals(s3);

            String key = s1 + "|" + s2 + "|" + s3;
            if (memo.containsKey(key)) return memo.get(key);

            char c1 = s1.charAt(0);
            char c2 = s2.charAt(0);
            char c3 = s3.charAt(0);

            boolean b1 = false;
            if (c3 == c1) {
                b1 = isInterleave(s1.substring(1), s2, s3.substring(1));
            }

            boolean b2 = false;
            if (c3 == c2) {
                b2 = isInterleave(s1, s2.substring(1), s3.substring(1));
            }

            boolean re = b1 || b2;
            memo.put(key, re);
            return re;
        }

        public boolean isInterleave3(String s1, String s2, String s3)
        {
            return isInterleave3(s1, 0, s2, 0, s3, 0);
        }
        private boolean isInterleave3(String s1, int idx1,  String s2, int idx2,  String s3, int idx3)
        {
            if (idx3 >= s3.length() && idx2 >= s2.length() && idx1 >= s1.length()) return true;
            if (idx3 >= s3.length()) return false;

            if (idx1 >= s1.length()) return s2.equals(s3);
            if (idx2 >= s2.length()) return s1.equals(s3);

//            String key = s1 + "|" + s2 + "|" + s3;
//            if (memo.containsKey(key)) return memo.get(key);

            char c1 = s1.charAt(idx1);
            char c2 = s2.charAt(idx2);
            char c3 = s3.charAt(idx3);

            boolean b1 = false;
            if (c3 == c1) {
                b1 = isInterleave3(s1, idx1 + 1, s2, idx2, s3, idx3 + 1);
            }

            boolean b2 = false;
            if (c3 == c2) {
                b2 = isInterleave3(s1, idx1, s2, idx2 + 1, s3, idx3 + 1);
            }

            boolean re = b1 || b2;
//            memo.put(key, re);
            return re;
        }
    }
}
