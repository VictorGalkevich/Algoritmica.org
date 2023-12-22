package binarysearch;

import java.util.Arrays;

public class AnswerBinarySearch {
    public static void main(String[] args) {
        int[] coords = new int[]{1, 7, 13, 18, 20, 26};
        System.out.println(placeCows(coords, 4));
    }

    public static int placeCows(int[] coords, int k) {
        Arrays.sort(coords);
        int l = 0, r = coords[coords.length - 1] - coords[0] + 1;
        while (r - l > 1) {
            int mid = (l + r) / 2;
            if (check(mid, coords, k)) {
                l = mid;
            } else {
                r = mid;
            }
        }
        return l;
    }

    public static boolean check(int x, int[] coords, int k) {
        int cows = 1;
        int lastCowCoordinate = coords[0];
        for (int coord : coords) {
            if (coord - lastCowCoordinate >= x) {
                cows++;
                lastCowCoordinate = coord;
            }
        }
        return cows >= k;
    }
}
