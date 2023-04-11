package hot100;

public class T4 {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {

        if (nums1.length > nums2.length) {
            int[] tmp = nums1;
            nums1 = nums2;
            nums2 = tmp;
        }
        int len1 = nums1.length;
        int len2 = nums2.length;

        //若为奇数个，则分割线左边为中位数
        //若为偶数个，则取分割线左边最大数，右边最小数之和的一半
        //分割线左边的个数
        int leftTotal = (len1 + len2 + 1) / 2;
        int left = 0, right = len1;
        while (left < right) {
            int i = left + (right - left) / 2;
            int j = leftTotal - i;
            if (nums1[i] < nums2[j - 1]) {
                left = i + 1;
            } else {
                right = i;
            }
        }

        int i = left;
        int j = leftTotal - i;
        int nums1LeftMax = i == 0 ? Integer.MIN_VALUE : nums1[i - 1];
        int nums1RightMin = i == len1 ? Integer.MAX_VALUE : nums1[i];
        int nums2LeftMax = j == 0 ? Integer.MIN_VALUE : nums2[j - 1];
        int nums2RightMin = j == len2 ? Integer.MAX_VALUE : nums2[j];
        if ((len1 + len2) % 2 == 0) {
            return (double) (Math.min(nums1RightMin, nums2RightMin) + Math.max(nums1LeftMax, nums2LeftMax)) / 2;
        }
        return Math.max(nums1LeftMax, nums2LeftMax);
    }

    /**
     *         int len1 = nums1.length;
     *         int len2 = nums2.length;
     *         int i = 0, j = 0, index = 0;
     *         int[] map = new int[len1 + len2];
     *         while (i < len1 && j < len2) {
     *             if (nums1[i] < nums2[j]) {
     *                 map[index++] = nums1[i];
     *                 i++;
     *             } else {
     *                 map[index++] = nums2[j];
     *                 j++;
     *             }
     *         }
     *         while (i != len1) {
     *             map[index++] = nums1[i++];
     *         }
     *         while (j != len2) {
     *             map[index++] = nums2[j++];
     *         }
     *         if ((len1 + len2) % 2 == 0) {
     *             return (double) (map[(len1 + len2) / 2 - 1] + map[(len1 + len2) / 2]) / 2;
     *         }
     *         return map[(len1 + len2) / 2];
     */
}
