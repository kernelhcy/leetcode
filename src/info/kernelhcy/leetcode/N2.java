package info.kernelhcy.leetcode;

/**
 * Created by hcy on 05/10/2016.
 */
public class N2
{
    public static void main(String argv[])
    {
        ListNode l1 = new ListNode(5);
//        l1.next = new ListNode(4);
//        l1.next.next = new ListNode(3);

        ListNode l2 = new ListNode(5);
//        l2.next = new ListNode(6);
//        l2.next.next = new ListNode(4);

        System.out.println("Result: " + new Solution().addTwoNumbers(l1, l2));
    }

    public static class ListNode
    {
        int val;
        ListNode next;

        ListNode(int x)
        {
            val = x;
        }
    }

    public static class Solution
    {
        public ListNode addTwoNumbers(ListNode l1, ListNode l2)
        {
            if (l1 == null) return l2;
            if (l2 == null) return l1;

            int len1 = listLength(l1);
            int len2 = listLength(l2);

            ListNode re = len1 > len2 ? l1 : l2;
            ListNode tmp = len1 > len2 ? l2 : l1;
            
            ListNode id1 = re, id2 = tmp;
            while (id2 != null) {
                id1.val += id2.val;
                id1 = id1.next;
                id2 = id2.next;
            }

            int tmpv = 0;
            id1 = re;
            while (id1 != null) {
                id1.val += tmpv;
                tmpv = id1.val / 10;
                id1.val %= 10;
                if (id1.next == null) {
                    if (tmpv != 0) {
                        id1.next = new ListNode(tmpv);
                        tmpv = 0;
                    }
                }
                id1 = id1.next;
            }



            return re;
        }

        private int listLength(ListNode l) {
            int len = 0;
            while (l != null) {
                ++len;
                l = l.next;
            }
            return len;
        }
    }
}
