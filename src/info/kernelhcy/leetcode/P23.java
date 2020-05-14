package info.kernelhcy.leetcode;

public class P23
{
    public static void main(String[] args)
    {

    }

    public static class Solution
    {
        public ListNode mergeKLists(ListNode[] lists)
        {
            ListNode head, next;
            int curr = Integer.MAX_VALUE;
            int idx = -1;
            for (int i = 0; i < lists.length; ++i) {
                if (lists[i] != null && lists[i].val < curr) {
                    curr = lists[i].val;
                    idx = i;
                }
            }
            if (idx < 0) {
                return null;
            }

            head = lists[idx];
            next = head;
            lists[idx] = lists[idx].next;

            while (true) {
                idx = -1;
                curr = Integer.MAX_VALUE;
                for (int i = 0; i < lists.length; ++i) {
                    if (lists[i] != null && lists[i].val < curr) {
                        curr = lists[i].val;
                        idx = i;
                    }
                }
                if (idx < 0) {
                    break;
                }

                next.next = lists[idx];
                next = next.next;
                lists[idx] = lists[idx].next;
            }
            return head;
        }
    }
}
