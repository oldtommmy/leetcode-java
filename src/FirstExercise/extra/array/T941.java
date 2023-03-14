package FirstExercise.extra.array;

public class T941 {
    public boolean validMountainArray(int[] arr) {
        int length = arr.length;
        if (length < 3) {
            return false;
        }

        int left = 0;
        int right = length - 1;
        while (left < length - 1 && arr[left + 1] > arr[left]) {
            left++;
        }
        while (right > 0 && arr[right - 1] > arr[right]) {
            right--;
        }

        if (left == right && left != 0 && right != length - 1){
            return true;
        }
        return false;
    }
}
