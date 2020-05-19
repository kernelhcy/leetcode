package info.kernelhcy.leetcode;

/**
 * User: hcy
 * Date: 10/14/14
 * Time: 10:48 PM
 */
public class P151
{
    public String reverseWords(String s)
    {
        StringBuilder re = new StringBuilder();
        String[] ss = s .split(" ");
        for (int i = ss.length - 1; i >=0 ; --i) {
            if (ss[i].length() <= 0) continue;
            re.append(ss[i].trim());
            if (i != 0) re.append(" ");
        }
        return re.toString().trim();
    }

    public static void main(String[] args)
    {
        String s = new ReverseWordsInString().reverseWords(" a");
        System.out.println("#" + s + "#");
    }
}
