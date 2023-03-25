package secondExercise.hash;

import java.util.ArrayList;

public class T349 {
    public int[] intersection(int[] nums1, int[] nums2) {
        int[] hash = new int[1001];
        ArrayList<Integer> ans = new ArrayList<>();
        for (int i : nums1) {
            hash[i]++;
        }
        for (int i : nums2) {
            if (hash[i] != 0) {
                ans.add(i);
                hash[i] = 0;
            }
        }
        int[] res = new int[ans.size()];
        for (int i = 0; i < ans.size(); i++) {
            res[i] = ans.get(i);
        }
        return res;
    }
}
