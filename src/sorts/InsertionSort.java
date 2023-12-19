package sorts;

public class InsertionSort {
    public static void main(String[] args) {
        int[] arr = new int[]{1, 2, 3, 123, -12, -333, -123, 3223, 1, -231};
        sort(arr);
        for (int i : arr) {
            System.out.print(i + " ");
        }
    }

    public static void sort(int[] args) {
        for (int i = 1; i < args.length; i++) {
            for (int j = i; j > 0 && args[j - 1] > args[j]; j--) {
                int t = args[j - 1];
                args[j - 1] = args[j];
                args[j] = t;
            }
        }
    }
}
