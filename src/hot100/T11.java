package hot100;

public class T11 {
    public int maxArea(int[] height) {

        int left = 0, right = height.length - 1;
        int ans = 0;
        while (left < right) {
            if (height[left] < height[right]) {
                int area = height[left] * (right - left);
                ans = Math.max(ans, area);
                left++;
            } else {
                int area = height[right] * (right - left);
                ans = Math.max(ans, area);
                right--;
            }
        }
        return ans;
    }
}
