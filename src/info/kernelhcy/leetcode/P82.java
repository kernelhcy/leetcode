package info.kernelhcy.leetcode;

public class P82
{
    public static void main(String[] args)
    {
        System.out.println(new Solution().deleteDuplicates(new ListNode(new int[]{1,2,3,3,4,4,5})));
        System.out.println(new Solution().deleteDuplicates(new ListNode(new int[]{1,1,1,3,4,4,5})));
        System.out.println(new Solution().deleteDuplicates(new ListNode(new int[]{1,1,1,3,4,5,5})));
        System.out.println(new Solution().deleteDuplicates(new ListNode(new int[]{1,1,1,5,5})));
        System.out.println(new Solution().deleteDuplicates(new ListNode(new int[]{1,1,1})));
    }

    public static class Solution
    {
        public ListNode deleteDuplicates(ListNode head)
        {
            if (head == null || head.next == null) return head;

            ListNode pre = null;
            ListNode next = head, pnext;
            int currVal = next.val;
            while (next != null) {
                pnext = next;
                while (next != null && next.val == currVal) {
                    next = next.next;
                }

                if (next != null) currVal = next.val;

                if (pnext.next == next) {
                    // no duplicates
                    pre = pnext;
                } else {
                    if (pre == null) {
                        head = next;
                    } else {
                        pre.next = next;
                    }
                }
            }
            return head;
        }
    }
}
