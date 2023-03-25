package secondExercise.hash;

import java.util.HashMap;

public class T454 {
    public int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {

        HashMap<Integer, Integer> map1 = new HashMap<>();
        int ans = 0;

        for (int i : nums1) {
            for (int j : nums2) {
                map1.put(i + j, map1.getOrDefault(i + j, 0) + 1);
            }
        }
        for (int i : nums3) {
            for (int j : nums4) {
                if (map1.containsKey(-(i + j))) {
                    ans += map1.get(-(i + j));
                    map1.remove(-(i + j));
                }
            }
        }
        return ans;
    }
}
