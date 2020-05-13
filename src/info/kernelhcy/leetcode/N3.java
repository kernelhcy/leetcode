package info.kernelhcy.leetcode;

/**
 * Created by hcy on 06/10/2016.
 */
public class N3
{
    public static void main(String argv[])
    {
        System.out.println("Result: " + new Solution().lengthOfLongestSubstring("aab"));
        System.out.println("Result: " + new Solution().lengthOfLongestSubstring("pwwkew"));
        System.out.println("Result: " + new Solution().lengthOfLongestSubstring("abcabcbb"));
        System.out.println("Result: " + new Solution().lengthOfLongestSubstring("bbbb"));
        System.out.println("Result: " + new Solution().lengthOfLongestSubstring("b"));
        System.out.println("Result: " + new Solution().lengthOfLongestSubstring(""));
    }

    public static class Solution
    {
        public int lengthOfLongestSubstring(String s)
        {
            if (s == null || s.length() <= 0) return 0;
            if (s.length() == 1) return 1;
            if (s.length() == 2) {
                if (s.charAt(0) != s.charAt(1)) return 2;
                return 1;
            }

            int length = 0;
            int[] recoders = new int[256];
            for (int i = 0; i < s.length(); ++i) {
                resetRecorders(recoders);
                recoders[s.charAt(i)] = 1;
                for (int j = i + 1; j < s.length(); ++j) {
                    if (recoders[s.charAt(j)] != 0) {
                        if (length < j - i) length = j - i;
                        break;
                    }
                    recoders[s.charAt(j)] = j;

                    if (j == s.length() - 1) {
                        if (length < j - i + 1) length = j - i + 1;
                    }
                }
            }

            return length;
        }

        private void resetRecorders(int[] r)
        {
            for (int i = 0; i < r.length; ++i) {
                r[i] = 0;
            }
        }
    }
}
