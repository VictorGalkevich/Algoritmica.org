package sequences;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

//Coordinate compression helps us with
//moving elements from one set to elements
//of type [0,n)
public class CoordinatesCompression {
    public static void main(String[] args) {
        int[] arr = new int[]{1, 2, 3, 4 , 1, 2, 3, 4, 5};
        int[] brr = Arrays.copyOf(arr, arr.length);
        compressCoordinates(arr, brr);
        System.out.println();
    }
    public static void compressCoordinates(int[] arr, int[] brr) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            map.put(brr[i], i);
        }

        for (int i = 0; i < arr.length; i++) {
            arr[i] = map.get(arr[i]);
        }
    }
}
