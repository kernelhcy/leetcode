package info.kernelhcy.leetcode;

/**
 * User: hcy
 * Date: 10/19/14
 * Time: 4:45 PM
 */
public class P153
{
    /*
     * 0 1 2 3 4 5 6 7
     * 1 2 3 4 5 6 7 0
     * 2 3 4 5 6 7 0 1
     * 3 4 5 6 7 0 1 2
     * 4 5 6 7 0 1 2 3
     * 5 6 7 0 1 2 3 4
     * 6 7 0 1 2 3 4 5
     *
     */
    public int findMin(int[] num)
    {
        if (num[0] < num[num.length - 1]) return num[0];
        return findMinHelper(num, 0, num.length - 1);
    }

    private int findMinHelper(int[] num, int start, int end)
    {
        int pivot = (start + end) / 2;
        if (pivot == start) return num[end];
        if (num[start] > num[pivot]) return findMinHelper(num, start, pivot);
        return findMinHelper(num, pivot, end);
    }

    public static void main(String[] argc)
    {
        FindMinimuminRotatedSortedArray test = new FindMinimuminRotatedSortedArray();
        System.out.println(test.findMin(new int[]{0, 1, 2, 3, 4, 5, 6, 7}));
        System.out.println(test.findMin(new int[]{1, 2, 3, 4, 5, 6, 7, 0}));
        System.out.println(test.findMin(new int[]{2, 3, 4, 5, 6, 7, 0, 1}));
        System.out.println(test.findMin(new int[]{5, 6, 7, 0, 1, 2, 3, 4}));
        System.out.println(test.findMin(new int[]{6, 7, 0, 1, 2, 3, 4, 5}));
    }
}
