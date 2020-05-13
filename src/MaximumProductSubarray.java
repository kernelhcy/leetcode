import java.util.ArrayList;

/**
 * User: hcy
 * Date: 10/19/14
 * Time: 5:03 PM
 */
public class MaximumProductSubarray
{
    public int maxProduct(int[] A)
    {
        ArrayList<Integer> aa = new ArrayList<Integer>();
        for (int i = 0; i < A.length; ++i) {
            if (A[i] == 1) continue;
            if (A[i] == -1 && aa.size() > 0 && aa.get(aa.size() - 1) == -1) {
                aa.remove(aa.size() - 1);
                continue;
            }
            aa.add(A[i]);
        }
        A = new int[aa.size()];
        for (int i = 0; i < A.length; ++i) {
            A[i] = aa.get(i).intValue();
        }

        int largest = Integer.MIN_VALUE;
        for (int j = 0; j < A.length; ++j) {
            int product = 1;
            for (int i = j; i < A.length; ++i) {
                if (A[i] == 0) {
                    product = 1;
                    continue;
                }
                product *= A[i];
                if (product > largest) largest = product;
            }
        }
        if (largest == Integer.MIN_VALUE) return 0;
        return largest;
    }

    public static void main(String[] argc)
    {
        MaximumProductSubarray test = new MaximumProductSubarray();
        System.out.println(test.maxProduct(new int[]{2,3,-2,4}));
        System.out.println(test.maxProduct(new int[]{2}));
        System.out.println(test.maxProduct(new int[]{-1}));
        System.out.println(test.maxProduct(new int[]{-1, 1}));
        System.out.println(test.maxProduct(new int[]{0}));
        System.out.println(test.maxProduct(new int[]{-4,-3}));
    }
}
