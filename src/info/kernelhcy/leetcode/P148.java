package info.kernelhcy.leetcode;

public class P148
{
    public static void main(String[] args)
    {
        System.out.println(new Solution().sortList(new ListNode(new int[]{4, 2, 1, 3})));
    }

    private static class Solution
    {
        public ListNode sortList(ListNode head)
        {
            int cnt = 0;
            ListNode next = head;
            while (next != null) {
                ++cnt;
                next = next.next;
            }

            return sortList(head, cnt);
        }

        private ListNode sortList(ListNode head, int len)
        {
            if (len <= 1) {
                if (head != null) {
                    head.next = null;
                }
                return head;
            }

            int p = len / 2;
            ListNode h1 = head, h2 = head;
            while (p-- > 0) h2 = h2.next;

            h1 = sortList(h1, len / 2);
            h2 = sortList(h2, len / 2 + (len & 1));

            if (h1.val < h2.val) {
                head = h1;
                h1 = h1.next;
            } else {
                head = h2;
                h2 = h2.next;
            }
            ListNode next = head;
            while (h1 != null && h2 != null) {
                if (h1.val < h2.val) {
                    next.next = h1;
                    h1 = h1.next;
                } else {
                    next.next = h2;
                    h2 = h2.next;
                }
                next = next.next;
            }

            while (h1 != null) {
                next.next = h1;
                h1 = h1.next;
                next = next.next;
            }

            while (h2 != null) {
                next.next = h2;
                h2 = h2.next;
                next = next.next;
            }
            next.next = null;
            return head;
        }
    }
}
