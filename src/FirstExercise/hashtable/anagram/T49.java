package FirstExercise.hashtable.anagram;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * 49. 字母异位词分组
 * https://leetcode.cn/problems/group-anagrams/
 * 思路：
 * 将每个字符串取出后先进行排序，以排序后的字符串为 key，加入到 Map 中
 */
@SuppressWarnings({"all"})
public class T49 {
    public List<List<String>> groupAnagrams(String[] strs) {

        int len = strs.length;
        HashMap<String, List<String>> hashmap = new HashMap<>();

        for (int i = 0; i < len; i++) {
            char[] str = strs[i].toCharArray();
            Arrays.sort(str);
            String key = String.valueOf(str);

            if (!hashmap.containsKey(key)) {
                hashmap.put(key, new ArrayList<>());
            }
            hashmap.get(key).add(strs[i]);
        }
        return new ArrayList<>(hashmap.values());
    }
}
