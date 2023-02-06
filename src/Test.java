

public class Test {
    public static void main(String[] args) {
        int N = 5;
        int[] arr = {3, 4, 6, 2, 1, 5};
        if(arr.length <= 1) {
            return;
        }

        int i = 0;
        while(i < arr.length) {
            if(arr[i] - 1 != i) {

                int x = arr[i];
                arr[i] = arr[arr[i] - 1];
                arr[arr[i] - 1] = x;
            } else {
                i++;
            }
        }

        for(i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }

    }
}
