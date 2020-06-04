package info.kernelhcy.leetcode;

public class P86
{
    public static void main(String[] args)
    {

    }

    public static class Solution
    {
        public ListNode partition(ListNode head, int x)
        {
            if (head == null) return head;

            ListNode smallHead = null, smallTail = null, geHead = null, geTail = null, next = head;
            while (next != null) {
                if (next.val < x) {
                    if (smallTail == null) {
                        smallHead = next;
                        smallTail = next;
                    } else {
                        smallTail.next = next;
                        smallTail = next;
                    }
                } else {
                    if (geTail == null) {
                        geHead = next;
                        geTail = next;
                    } else {
                        geTail.next = next;
                        geTail = next;
                    }
                }
                next = next.next;
            }

            if (geTail != null) geTail.next = null;

            if (smallTail == null) return geHead;
            smallTail.next = geHead;
            return smallHead;
        }
    }
}
