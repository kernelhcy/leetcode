package info.kernelhcy.leetcode;

import java.util.Stack;

public class P32
{
    public static void main(String[] args)
    {
        System.out.println(new Solution().longestValidParentheses("(()"));
        System.out.println(new Solution().longestValidParentheses("())"));
        System.out.println(new Solution().longestValidParentheses(")()())"));
    }

    public static class Solution
    {
        public int longestValidParentheses(String s)
        {
            Stack<Pair> stack = new Stack<>();
            for (int i = 0; i < s.length(); ++i) {
                char c = s.charAt(i);
                if (c == '(') {
                    stack.push(new Pair(i, c));
                } else if (c == ')') {
                    if (!stack.isEmpty() && stack.peek().c == '(') {
                        stack.pop();
                    } else {
                        stack.push(new Pair(i, c));
                    }
                }
            }
            if (stack.isEmpty()) {
                return s.length();
            }

            Pair p1 = stack.pop(), p2;
            int max = s.length() - p1.idx - 1;
            while (!stack.isEmpty()) {
                 p2 = stack.pop();
                 if (p1.idx - p2.idx - 1 > max) {
                     max = p1.idx - p2.idx - 1;
                 }
                 p1 = p2;
            }

            if (p1.idx > max) {
                max = p1.idx;
            }

            return max;
        }

        private static class Pair
        {
            public Pair(int idx, char c)
            {
                this.idx = idx;
                this.c = c;
            }

            int idx;
            char c;
        }
    }
}
