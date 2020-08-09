package info.kernelhcy.leetcode;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;
import java.util.stream.Collectors;

public class P224
{
    public static void main(String[] args)
    {
        System.out.println(new Solution().calculate(" 2-1 + 2 "));
        System.out.println(new Solution().calculate("(1+(4+5+2)-3)+(6+8)"));
        System.out.println(new Solution().calculate("2147483647"));
        System.out.println(new Solution().calculate("(6)-(8)-(7)+(1+(6))"));
    }

    public static class Solution
    {
        public int calculate(String s)
        {
            List<Op> postfixExps = new LinkedList<>();
            Stack<Op> ops = new Stack<>();

            for (int i = 0; i < s.length(); ++i) {
                char c = s.charAt(i);

                if (c == ' ') continue;
                if (c >= '0' && c <='9') {
                    String tmp = "" + c;
                    ++i;
                    while (i < s.length() && s.charAt(i) >= '0' && s.charAt(i) <= '9') {
                        tmp += s.charAt(i);
                        ++i;
                    }
                    --i;
                    postfixExps.add(new Op(Integer.parseInt(tmp)));
                    continue;
                }

                if (c == '-') {
                    while (!ops.isEmpty() && ops.peek().isOp()&& ops.peek().op != '(') {
                        postfixExps.add(ops.pop());
                    }
                    ops.push(new Op(c));
                    continue;
                }

                if (c == '+') {
                    while (!ops.isEmpty() && ops.peek().isOp()&& ops.peek().op != '(') {
                        postfixExps.add(ops.pop());
                    }
                    ops.push(new Op(c));
                    continue;
                }


                if (c == '(') {
                    ops.push(new Op(c));
                    continue;
                }

                if (c == ')') {
                    while (!ops.isEmpty() && ops.peek().isOp() && ops.peek().op != '(') postfixExps.add(ops.pop());
                    if (!ops.isEmpty()) ops.pop();
                }
            }

            while (!ops.isEmpty()) postfixExps.add(ops.pop());

            System.out.println(postfixExps.stream().map(Op::toString).collect(Collectors.joining()));

            Stack<Long> re = new Stack<>();
            for (Op op : postfixExps) {
                if (!op.isOp()) {
                    re.push((long) op.value);
                    continue;
                }
                long n1 = re.pop();
                long n2 = re.pop();

                if (op.op == '+') {
                    re.push(n1 + n2);
                } else if (op.op == '-') {
                    re.push(n2 - n1);
                }
            }

            return re.pop().intValue();
        }

        private static class Op
        {
            int value = -1;
            char op;

            public Op(int value)
            {
                this.value = value;
            }

            public Op(char op)
            {
                this.op = op;
            }

            public boolean isOp()
            {
                return value < 0;
            }

            @Override
            public String toString()
            {
                if (isOp()) {
                    return String.valueOf(op);
                } else {
                    return String.valueOf(value);
                }
            }
        }
    }
}

