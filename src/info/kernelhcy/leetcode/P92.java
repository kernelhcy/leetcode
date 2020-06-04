package info.kernelhcy.leetcode;

public class P92
{
    public static void main(String[] args)
    {
        System.out.println(new Solution().reverseBetween(new ListNode(new int[]{1,2,3,4,5}), 2, 4));
        System.out.println(new Solution().reverseBetween(new ListNode(new int[]{1,2,3,4,5}), 1, 4));
        System.out.println(new Solution().reverseBetween(new ListNode(new int[]{1,2,3,4,5}), 2, 5));
        System.out.println(new Solution().reverseBetween(new ListNode(new int[]{1,2,3,4,5}), 1, 5));
    }

    public static  class Solution
    {
        public ListNode reverseBetween(ListNode head, int m, int n)
        {
            int cnt = n - m + 1;
            ListNode next = head, preNext = head;
            int i = 1;
            while (i < m) {
                preNext = next;
                next = next.next;
                ++i;
            }

            ListNode rHead = next, rTail = next, tmp;
            while (--cnt >= 0) {
                tmp = next.next;
                next.next = rHead;
                rHead = next;
                next = tmp;
            }

            if (rTail != null) rTail.next = next;

            if (m == 1) {
                return rHead;
            }

            if (preNext != null) preNext.next = rHead;
            return head;
        }
    }
}
