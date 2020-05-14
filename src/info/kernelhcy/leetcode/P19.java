package info.kernelhcy.leetcode;

public class P19
{

    public static void main(String[] args)
    {

    }

    public static class Solution
    {
        public ListNode removeNthFromEnd(ListNode head, int n)
        {
            ListNode re;
            int len = 0;
            ListNode next = head;
            while (next != null) {
                ++len;
                next = next.next;
            }

            int idx = len - n;
            if (idx == 0) {
                re = head.next;
                head.next = null;
                return re;
            }

            ListNode pre = head;
            next = head.next;
            while (--idx > 0) {
                pre = next;
                next = next.next;
            }

            pre.next = next.next;
            next.next = null;
            return head;
        }
    }
}
