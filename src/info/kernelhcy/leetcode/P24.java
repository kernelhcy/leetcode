package info.kernelhcy.leetcode;

import java.util.ArrayList;

public class P24
{
    public static void main(String[] args)
    {

    }

    public static class Solution
    {
        public ListNode swapPairs(ListNode head)
        {
            ArrayList<ListNode> array = new ArrayList<>();
            ListNode next = head;
            while (next != null) {
                array.add(next);
                next = next.next;
            }

            if (array.size() < 2) {
                return head;
            }

            for (int i = 0; i < array.size() - 1; i += 2) {
                ListNode tmp = array.get(i);
                array.set(i, array.get(i + 1));
                array.set(i + 1, tmp);
            }

            array.get(array.size() -1).next = null;
            head = array.get(0);
            next = head;
            for (int i = 1; i < array.size(); ++i) {
                next.next = array.get(i);
                next = next.next;
            }

            return head;
        }
    }
}
