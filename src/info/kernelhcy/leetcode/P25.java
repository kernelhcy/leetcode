package info.kernelhcy.leetcode;

public class P25
{
    public static void main(String[] args)
    {
        ListNode head = new ListNode(1);
        ListNode next = head;

        next.next = new ListNode(2);
        next = next.next;

        next.next = new ListNode(3);
        next = next.next;
        next.next = new ListNode(4);
        next = next.next;
        next.next = new ListNode(5);


        System.out.println(head.toString() + " ==> " + new Solution().reverseKGroup(head, 2));

        head = new ListNode(1);
        next = head;
        next.next = new ListNode(2);
        System.out.println(head.toString() + " ==> " + new Solution().reverseKGroup(head, 2));
    }

    public static class Solution
    {
        public ListNode reverseKGroup(ListNode head, int k)
        {
            if (k <= 0) {
                return head;
            }

            int len = 0;
            ListNode next = head;
            while (next != null) {
                next = next.next;
                ++len;
            }

            int idx = 0;
            ListNode[] nodes = new ListNode[len + 1];
            next = head;
            while (next != null) {
                nodes[idx] = next;
                next = next.next;
                ++idx;
            }

            for (int i = 0; i <= len - k; i += k) {
                reverse(nodes, i, i + k - 1);
            }

            head = nodes[0];
            next = head;
            nodes[len - 1].next = null;
            for (int i = 1; i < len; ++i) {
                next.next = nodes[i];
                next = next.next;
            }

            return head;
        }

        private void reverse(ListNode[] nodes, int start, int end)
        {
            if (start == end) {
                return;
            }

            ListNode tmp;
            while (start <= end) {
                tmp = nodes[start];
                nodes[start] = nodes[end];
                nodes[end] = tmp;
                ++start;
                --end;
            }
        }
    }
}
