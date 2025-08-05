package CompetitiveCoding;

public class BlockSwapArray {
    public static void swap(int[] arr, int start1, int start2, int blockSize) {
        for (int i = 0; i < blockSize; i++) {
            int temp = arr[start1 + i];
            arr[start1 + i] = arr[start2 + i];
            arr[start2 + i] = temp;
        }
    }

    public static void leftRotate(int[] arr, int d, int n) {
        // Base cases
        if (d == 0 || d == n)
            return;

        if (d < n - d) {
            swap(arr, 0, n - d, d);
            leftRotate(arr, d, n - d);
        } else {
            swap(arr, 0, d, n - d);
            leftRotate(arr, n - d, d);
        }
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6};
        int d = 2;
        int n = arr.length;

        leftRotate(arr, d, n);

        for (int num : arr) {
            System.out.print(num + " ");
        }
    }
}
