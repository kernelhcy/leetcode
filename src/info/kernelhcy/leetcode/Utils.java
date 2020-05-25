package info.kernelhcy.leetcode;

public class Utils
{
    public static void printMatrix(int[][] m)
    {
        System.out.println("[");
        for (int[] a : m) {
            for (int i : a) {
                System.out.print(i+ ",");
            }
            System.out.println("");
        }
        System.out.println("]");
    }
}
