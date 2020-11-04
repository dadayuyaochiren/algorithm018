import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/**
 * 有效的 字母异同位次
 *  考点  map ~
 *  特点:桶思想来 来优化 map
 */
public class IsAnagram {

    public boolean isAnagram(String s, String t) {
        // 效率较低
        // if(s.length() != t.length()){
        //     return false;
        // }
        // // 利用map +1 -1 操作
        // Map<Character,Integer> map = new HashMap<>();
        // for (int i = 0 ; i < s.length(); i++) {
        //     if (s.charAt(i) ==t.charAt(i))
        //         continue;
        //     map.put(s.charAt(i),map.getOrDefault(s.charAt(i),0)+1);
        //     map.put(t.charAt(i),map.getOrDefault(t.charAt(i),0)-1);
        // }
        // for (Map.Entry<Character,Integer> entry : map.entrySet()){
        //     if (entry.getValue() != 0) return false;
        // }
        // return true;

        if (s.length() != t.length()) {
            return false;
        }
        // a-z 26
        int[] map = new int[26];
        for (int i =0; i < s.length(); i ++) {
            map[s.charAt(i) - 'a'] ++;
            map[t.charAt(i) - 'a'] --;
        }
        // 减少了 遍历
        for(int i =0; i < t.length(); i ++) {
            if (map[t.charAt(i) - 'a'] < 0) {
                return false;
            }
        }
        return true;
    }




}
