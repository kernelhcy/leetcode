package info.kernelhcy.leetcode;

public class P61
{
    public static void main(String[] args)
    {

    }

    public static class Solution
    {
        public ListNode rotateRight(ListNode head, int k)
        {
            int len = 0;
            ListNode next = head;
            while (next != null) {
                ++len;
                next = next.next;
            }

            if (len == 0) return head;
            k = k % len;
            if (k == 0) return head;

            int startIdx = len - k;
            ListNode originHead = head;
            while (startIdx > 0) {
                head = head.next;
                --startIdx;
            }

            next = head;
            for (int i = 0; i < len; ++i) {
                if (next.next == null) {
                    next.next = originHead;
                } else {
                    next = next.next;
                }
            }
            next.next = null;
            return head;
        }
    }
}
