/**
 *
 * Created by hcy on 05/10/2016.
 */
public class N9
{
    public static void main(String argv[])
    {
        System.out.println("Result: " + new Solution().isPalindrome(12321));
        System.out.println("Result: " + new Solution().isPalindrome(1221));
        System.out.println("Result: " + new Solution().isPalindrome(1223));
        System.out.println("Result: " + new Solution().isPalindrome(Integer.MAX_VALUE));
        System.out.println("Result: " + new Solution().isPalindrome(Integer.MIN_VALUE));
    }

    public static class Solution
    {
        public boolean isPalindrome(int x)
        {
            if (x == Integer.MAX_VALUE || x == Integer.MIN_VALUE || x  < 0) return false;

            int length = 0;
            int tmp = x;
            while (tmp > 0) {
                ++length;
                tmp /= 10;
            }

            int i = 0;
            while(true) {
                if (i > length / 2 - 1) break;
                if (intAt(x, i) != intAt(x, length - i - 1)) return false;
                ++i;
            }

            return true;
        }

        private int intAt(int x, int pos)
        {
            while(pos > 0) {
                x /= 10;
                --pos;
            }
            return x % 10;
        }
    }
}
