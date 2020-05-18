package info.kernelhcy.leetcode;

public class P50
{
    public static void main(String[] args)
    {
        System.out.println(new Solution().myPow(2.0, 5));
        System.out.println(new Solution().myPow(2.0, -2));
        System.out.println(new Solution().myPow(2.0, 10));
        System.out.println(new Solution().myPow(2.0, -10));
        System.out.println(new Solution().myPow(1.0, 2147483647));
        System.out.println(new Solution().myPow(1.0, -2147483648));
    }

    public static class Solution
    {
        public double myPow(double x, int n)
        {
            if (n == 0) return 1.0;
            if (n == 1) return x;
            if (n == -2147483648) return 1.0 / (myPow(x, -(n + 2)) * myPow(x, 2));
            if (n < 0) return 1.0 / myPow(x, -n);

            double tmp = myPow(x, n / 2);
            return tmp * tmp * myPow(x, n % 2);
        }
    }
}
