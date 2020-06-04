package info.kernelhcy.leetcode;

import java.util.LinkedList;
import java.util.List;

public class P89
{
    public static void main(String[] args)
    {
        System.out.println(new Solution().grayCode(2));
        System.out.println(new Solution().grayCode(3));
        System.out.println(new Solution().grayCode(4));
    }

    public static class Solution
    {
        /*

        [0,1,3,2,6,7,5,4]
        00
        01

        11
        10

        [0,1,3,2,6,7,5,4,12,13,15,14,10,11,9,8]
        000
        001
        011
        010

        110
        111
        101
        100

         */



        public List<Integer> grayCode(int n)
        {
            List<Integer> re = new LinkedList<>();
            if (n <= 0) {
                re.add(0);
                return re;
            }

            List<Integer> nre = grayCode(n - 1);
            re.addAll(nre);
            int mask = 1 << (n - 1);
            for (int i = nre.size() - 1; i >= 0; --i) {
                re.add(nre.get(i) | mask);
            }

            return re;
        }


    }
}
