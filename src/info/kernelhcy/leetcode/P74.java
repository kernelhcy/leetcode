package info.kernelhcy.leetcode;

public class P74
{
    public static void main(String[] args)
    {
        int[][] m = new int[][]{
                new int[]{1,   3,  5,  7},
                new int[]{10, 11, 16, 20},
                new int[]{23, 30, 34, 50},
        };
        System.out.println(new Solution().searchMatrix(m, 1));
        System.out.println(new Solution().searchMatrix(m, 3));
        System.out.println(new Solution().searchMatrix(m, 11));
        System.out.println(new Solution().searchMatrix(m, 50));
        System.out.println(new Solution().searchMatrix(m, 510));
    }

    public static class Solution
    {
        public boolean searchMatrix(int[][] matrix, int target)
        {
            if (matrix.length <= 0) return false;
            if (matrix[0].length <= 0) return false;

            int col = matrix.length - 1;
            for (int i = 0; i < matrix.length; ++i) {
                if (matrix[i][0] > target) {
                    col = i - 1;
                    break;
                }
            }
            if (col < 0) return false;

            int[] m = matrix[col];
            int start = 0, end = m.length - 1;
            while (start <= end) {
                int mid = (start + end) / 2;
                if (m[mid] == target) return true;
                if (start == end) return m[start] == target;
                if (end - start == 1) {
                    return m[start] == target || m[end] == target;
                }
                if (m[mid] > target) {
                    end = mid;
                } else {
                    start = mid;
                }
            }
            return false;
        }
    }
}
