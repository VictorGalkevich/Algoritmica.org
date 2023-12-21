package binarysearch;

import java.util.Random;
import java.util.Scanner;

public class DefaultBinarySearch {
    public static void main(String[] args) {
        int[] arr = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        System.out.println(findElement(5, arr));
    }

    public static void startGuessGame() {
        int x = new Random().nextInt() + 1;
        int l = 1, r = 100;
        while (l < r) {
            int mid = (l + r) / 2;
            System.out.printf("Your number is bigger than %d?", mid);
            boolean approve = new Scanner(System.in).next().equalsIgnoreCase("yes");
            if (approve) {
                l = mid  +1;
            } else {
                r = mid;
            }
        }
        System.out.printf("Your number is %d", l);
    }

    public static int findElement(int x, int[] arr) {
        int l = 0, r = arr.length - 1;
        while (l < r) {
            int mid = (l + r) / 2;
            if (arr[mid] < x) {
                l = mid + 1;
            } else {
                r = mid;
            }
        }
        return arr[l] == x ? l : -1;
    }
}
