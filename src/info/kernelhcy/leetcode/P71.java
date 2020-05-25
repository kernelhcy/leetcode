package info.kernelhcy.leetcode;

import java.util.Stack;

public class P71
{
    public static void main(String[] args)
    {
        new Solution().simplifyPath("/");
        new Solution().simplifyPath("/.././../");
        new Solution().simplifyPath("/../");
        new Solution().simplifyPath("/home/hcy/../downloads/./hello");
        new Solution().simplifyPath("/.");
        new Solution().simplifyPath("/home/hcy/////hello/../.././");
        new Solution().simplifyPath("//////");
    }

    public static class Solution
    {
        public String simplifyPath(String path)
        {
            String[] parts = path.split("/");
            Stack<String> paths = new Stack<>();

            for (String p : parts) {
                if (p.length() <= 0 || p.equals(".")) continue;
                if (p.equals("..")) {
                    if (!paths.isEmpty()) {
                        paths.pop();
                    }
                } else {
                    paths.push(p);
                }
            }

            String re = "/";
            if (!paths.isEmpty()) {
                for (int i = 0; i < paths.size() - 1; ++i) {
                    re += paths.get(i);
                    re += "/";
                }
                re += paths.get(paths.size() - 1);
            }

//            System.out.println(path + " -> " + re);
            return re;
        }
    }
}
