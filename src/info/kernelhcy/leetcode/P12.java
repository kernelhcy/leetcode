package info.kernelhcy.leetcode;

public class P12
{
    public static void main(String[] args)
    {
        System.out.println("3=" + new Solution().intToRoman(3));
        System.out.println("4=" + new Solution().intToRoman(4));
        System.out.println("9=" + new Solution().intToRoman(9));
        System.out.println("58=" + new Solution().intToRoman(58));
        System.out.println("1994=" + new Solution().intToRoman(1994));
    }

    public static class Solution
    {
        public String intToRoman(int num)
        {
            StringBuilder sb = new StringBuilder();
            while (num >= 1000) {
                sb.append('M');
                num -= 1000;
            }
            if (num >= 900) {
                sb.append("CM");
                num -= 900;
            }
            if (num >= 500) {
                sb.append('D');
                num -= 500;
            }
            if (num >= 400) {
                sb.append("DC");
                num -= 400;
            }
            while (num >= 100) {
                sb.append('C');
                num -= 100;
            }

            if (num >= 90) {
                sb.append("XC");
                num -= 90;
            }
            if (num >= 50) {
                sb.append('L');
                num -= 50;
            }
            if (num >= 40) {
                sb.append("XL");
                num -= 40;
            }
            while (num >= 10) {
                sb.append('X');
                num -= 10;
            }

            if (num >= 9) {
                sb.append("IX");
                num -= 9;
            }
            if (num >= 5) {
                sb.append('V');
                num -= 5;
            }
            if (num >= 4) {
                sb.append("IV");
                num -= 4;
            }
            while (num >= 1) {
                sb.append('I');
                num -= 1;
            }
            return sb.toString();
        }
    }
}
