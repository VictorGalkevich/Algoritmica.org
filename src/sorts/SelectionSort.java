package sorts;

public class SelectionSort {
    public static void main(String[] args) {
        int[] arr = new int[]{1, 2, 3, 123, -12, -333, -123, 3223, 1 ,-231};
        sort(arr);
        for (int i : arr) {
            System.out.print(i + " ");
        }
    }

    public static void sort(int[] args) {
        for (int i = 0; i < args.length; i++) {
            for (int j = i + 1; j < args.length; j++) {
                if (args[i] > args[j]) {
                    int t = args[i];
                    args[i] = args[j];
                    args[j] = t;
                }
            }
        }
    }
}
