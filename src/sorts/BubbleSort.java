package sorts;

public class BubbleSort {
    public static void main(String[] args) {
        int[] arr = new int[]{1, 2, 3, 123, -12, -333, -123, 3223, 1 ,-231};
        sort(arr);
        for (int i : arr) {
            System.out.print(i + " ");
        }
    }

    public static void sort(int[] args) {
        for (int i = 0; i < args.length; i++) {
            for (int j = 0; j < args.length - 1; j++) {
                if (args[j] > args[j + 1]) {
                    int t = args[j];
                    args[j] = args[j + 1];
                    args[j + 1] = t;
                }
            }
        }
    }
}
