package info.kernelhcy.leetcode;

import java.util.*;
import java.util.stream.Collectors;

public class P49
{
    public static void main(String[] args)
    {

    }

    public static class Solution
    {
        public List<List<String>> groupAnagrams(String[] strs)
        {
            List<List<String>> re = new LinkedList<>();
            if (strs.length <= 0) return re;

            Map<String, List<String>> map = new HashMap<>();
            for (String s : strs) {
                byte[] bytes = Arrays.copyOf(s.getBytes(), s.length());
                Arrays.sort(bytes);
                String tmp = new String(bytes);
                if (map.containsKey(tmp)) {
                    map.get(tmp).add(s);
                } else {
                    List<String> tl = new LinkedList<>();
                    tl.add(s);
                    map.put(tmp, tl);
                }
            }

            return new ArrayList<>(map.values());
        }
    }
}
