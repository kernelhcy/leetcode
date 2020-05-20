package info.kernelhcy.leetcode;

import java.util.Stack;

/**
 * User: hcy
 * Date: 10/19/14
 * Time: 5:41 PM
 */
public class P150
{
    public int evalRPN(String[] tokens)
    {
        int op1, op2;
        Stack<Integer> stack = new Stack<Integer>();
        for (int i = 0; i < tokens.length; ++i) {
            if (tokens[i].equals("+")) {
                op2= stack.pop().intValue();
                op1= stack.pop().intValue();
                stack.push(op1 + op2);
            } else if (tokens[i].equals("-")) {
                op2= stack.pop().intValue();
                op1= stack.pop().intValue();
                stack.push(op1 - op2);
            } else if (tokens[i].equals("*")) {
                op2= stack.pop().intValue();
                op1= stack.pop().intValue();
                stack.push(op1 * op2);
            } else if (tokens[i].equals("/")) {
                op2= stack.pop().intValue();
                op1= stack.pop().intValue();
                stack.push(op1 / op2);
            } else {
                stack.push(Integer.valueOf(tokens[i]));
            }
        }
        return stack.pop().intValue();
    }

    public static void main(String[] argc)
    {
        P150 test = new P150();
        System.out.println(test.evalRPN(new String[]{"2", "1", "+", "3", "*"}));
        System.out.println(test.evalRPN(new String[]{"4", "13", "5", "/", "+"}));
    }
}
