import java.util.*;

/**
 * 字母异位词分组
 *  熟练 api  Array.sort()  map --> values()
 */


public  class GroupAnagrams {
    public List<List<String>> groupAnagrams(String[] strs) {
        //熟练java的 api
        // 使用 Array.sort()  与 Map. values()  char[] --> String
        Map<String,List<String>> map = new HashMap<>();
        for (String str : strs) {
            char [] chs = str.toCharArray();
            Arrays.sort(chs);
            // 转为 String
            String key = String.valueOf(chs);
            if(!map.containsKey(key))
                // 先加一个链表
                map.put(key,new ArrayList<>());
            map.get(key).add(str);
        }
        return new ArrayList<>(map.values());
    }
}