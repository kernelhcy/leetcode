package info.kernelhcy.leetcode;

import java.util.Stack;

public class P227
{
    public static void main(String[] args)
    {
        System.out.println(new Solution().calculate("14/3*2"));
        System.out.println(new Solution().calculate("3+2*2"));
        System.out.println(new Solution().calculate(" 3/2 "));
        System.out.println(new Solution().calculate(" 3+5 / 2 "));
        System.out.println(new Solution().calculate("0-2147483647"));
    }

    public static class Solution
    {
        public int calculate(String s)
        {
            Stack<Long> nums = new Stack<>();
            Stack<Character> ops = new Stack<>();

            char currOp = '.';
            for (int i = 0; i < s.length(); ++i) {
                char c = s.charAt(i);
                if (c == ' ') continue;
                if (c >= '0' && c <= '9') {
                    String tmp = "";
                    while (c >= '0' && c <= '9') {
                        tmp += c;
                        ++i;
                        if (i >= s.length()) break;
                        c = s.charAt(i);
                    }
                    --i;

                    if (currOp == '.') {
                        nums.push(Long.valueOf(tmp));
                    } else {
                        if (currOp == '+' || currOp == '-') {
                            ops.push(currOp);
                            nums.push(Long.valueOf(tmp));
                        } else {
                            // * /
                            long n = nums.pop();
                            if (currOp == '*') {
                                nums.push(n * Long.parseLong(tmp));
                            } else if (currOp == '/') {
                                nums.push(n / Long.parseLong(tmp));
                            }
                            currOp = '.';
                        }
                    }
                    continue;
                }

                currOp = c;
            }

            Stack<Long> ns = new Stack<>();
            Stack<Character> os = new Stack<>();
            while (!nums.isEmpty()) ns.push(nums.pop());
            while (!ops.isEmpty()) os.push(ops.pop());

            while (!os.isEmpty()) {
                currOp = os.pop();
                long n1 = ns.pop();
                long n2 = ns.pop();
                if (currOp == '+') {
                    ns.push(n1 + n2);
                } else if (currOp == '-') {
                    ns.push(n1 - n2);
                }
            }

            return ns.pop().intValue();
        }
    }
}
