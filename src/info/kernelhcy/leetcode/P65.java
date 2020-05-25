package info.kernelhcy.leetcode;

public class P65
{
    public static void main(String[] args)
    {
        System.out.println(new Solution().isNumber("-.0959440.94e+098"));
        System.out.println(new Solution().isNumber("-.0959440e+098"));
        System.out.println(new Solution().isNumber("-0959440.e+098"));
        System.out.println(new Solution().isNumber("959440.94f"));
        System.out.println(new Solution().isNumber("0"));
        System.out.println(new Solution().isNumber("3."));
        System.out.println(new Solution().isNumber("."));
        System.out.println(new Solution().isNumber(" 0.1"));
        System.out.println(new Solution().isNumber("abc"));
        System.out.println(new Solution().isNumber("1 a"));
        System.out.println(new Solution().isNumber("2e10"));
        System.out.println(new Solution().isNumber(" -90e3"));
        System.out.println(new Solution().isNumber(" 1e"));
        System.out.println(new Solution().isNumber("e3"));
        System.out.println(new Solution().isNumber(" 6e-1"));
        System.out.println(new Solution().isNumber("99e2.5"));
        System.out.println(new Solution().isNumber("53.5e93"));
        System.out.println(new Solution().isNumber(" --6"));
        System.out.println(new Solution().isNumber("-+3"));
        System.out.println(new Solution().isNumber("3+3"));
        System.out.println(new Solution().isNumber("95a54e3"));
    }

    public static class Solution
    {
        public boolean isNumber(String s)
        {
            // -.0873e+083
            System.out.print(s + " => ");
            s = s.trim();
            if (s.length() <= 0) return false;

            int signIdx = -1;
            int eIdx = -1;
            int eSignIdx = -1;
            boolean hasNum = false;
            boolean hasPoint = false;

            for (int i = 0; i < s.length(); ++i) {
                char c = s.charAt(i);
                if (isNum(c)) {
                    hasNum = true;
                    continue;
                }
                if (c == '-' || c == '+') {
                    if (eIdx > 0) {
                        if (eSignIdx >= 0) return false;
                        eSignIdx = i;
                        if (eIdx + 1 != eSignIdx) return false;
                        if (eSignIdx == s.length() - 1) return false;
                    } else {
                        if (signIdx >= 0) return false;
                        signIdx = i;
                        if (signIdx == s.length() - 1) return false;
                        if (signIdx != 0) return false;
                    }
                    continue;
                }
                if (!isValidChar(c)) return false;

                if (c == 'e' && eIdx >= 0) return false;
                if (c == 'e' && (i <= 0 || i >= s.length() - 1)) return false;
                if (c == 'e' && !hasNum) return false;
                if (c == 'e') {
                    eIdx = i;
                    continue;
                }
                if (eIdx > 0 && c == '.') return false;

                if (hasPoint && c == '.') return false;
                if (c == '.') {
                    hasPoint = true;
                    if (!((i > 0 && isNum(s.charAt(i - 1)) || (i < s.length() - 1 && isNum(s.charAt(i + 1)))))) {
                        return false;
                    }
                }
            }
            return true;
        }

        private boolean isValidChar(char c)
        {
            return isNum(c) || c == 'e' || c == '-' || c == '+' || c == '.';
        }
        private boolean isNum(char c)
        {
            return c >= '0' && c <= '9';
        }
    }
}
