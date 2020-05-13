package info.kernelhcy.leetcode;

/**
 *
 * Created by hcy on 05/10/2016.
 */
public class N7
{
    public static void main(String argv[])
    {
        System.out.println("Result: " + new Solution().reverse(1534236469));
        System.out.println("Result: " + new Solution().reverse(123));
        System.out.println("Result: " + new Solution().reverse(-321));
        System.out.println("Result: " + new Solution().reverse(1));
        System.out.println("Result: " + new Solution().reverse(0));
    }

    public static class Solution
    {
        public int reverse(int x)
        {
            int re = 0;
            int v = Math.abs(x);
            while (v > 0) {
                int tmp = v % 10;
                v /= 10;
                int pre = re;
                re *= 10;
                if (re / 10 != pre) return 0;
                re += tmp;
            }
            if (x < 0) re = -re;
            return re;
        }
    }
}
