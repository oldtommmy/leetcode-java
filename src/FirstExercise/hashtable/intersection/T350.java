package FirstExercise.hashtable.intersection;

import java.util.ArrayList;

/**
 *  350. 两个数组的交集 II
 *  https://leetcode.cn/problems/intersection-of-two-arrays-ii/
 */
@SuppressWarnings({"all"})
public class T350 {
    public int[] intersect(int[] nums1, int[] nums2) {

        ArrayList<Integer> ans = new ArrayList<>();
        int[] cnt = new int[1001];

        for (int i = 0; i < nums1.length; i++) {
            cnt[nums1[i]]++;
        }
        for (int i = 0; i < nums2.length; i++) {
            if (cnt[nums2[i]] > 0) {
                ans.add(nums2[i]);
                cnt[nums2[i]]--;
            }
        }

        int[] answer = new int[ans.size()];
        for (int i = 0; i < answer.length; i++) {
            answer[i] = ans.get(i);
        }

        return answer;
    }
}
