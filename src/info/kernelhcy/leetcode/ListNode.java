package info.kernelhcy.leetcode;

public class ListNode
{
    int val;
    ListNode next;

    ListNode()
    {
    }

    ListNode(int val)
    {
        this.val = val;
    }

    ListNode(int val, ListNode next)
    {
        this.val = val;
        this.next = next;
    }

    public String toString()
    {
        StringBuilder sb = new StringBuilder("[");
        ListNode n = this;
        while (n != null) {
            sb.append(n.val).append(',');
            n = n.next;
        }
        sb.replace(sb.length() - 1, sb.length(), "]");
        return sb.toString();
    }
}
