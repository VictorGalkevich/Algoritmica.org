package sorts;

public class HeapSort {
    public static void main(String[] args) {
        int[] arr = new int[]{1, 2, 3, 123, -12, -333, -123, 3223, 1, -231};
        sort(arr);
        for (int i : arr) {
            System.out.print(i + " ");
        }
    }

    public static void sort(int[] args) {
        Node node = new Node(0, args.length, args);
        for (int i = 0; i < args.length; i++) {
            Pair min = node.findMin(i, args.length);
            int t = args[i];
            args[i] = args[min.index];
            args[min.index] = t;
        }
    }

    public static class Node {
        Pair min;
        int minIndex;
        int lb;
        int rb;
        int[] arr;
        Node left;
        Node right;

        public Node(int lb, int rb, int[] arr) {
            this.min = new Pair();
            this.arr = arr;
            this.lb = lb;
            this.rb = rb;
            if (lb + 1 == rb) {
                min = new Pair(lb, arr[lb]);
            } else {
                int mb = (lb + rb) / 2;
                this.left = new Node(lb, mb, arr);
                this.right = new Node(mb, rb, arr);
                this.min.value = Math.min(left.min.value, right.min.value);
                this.min.index = min.value == left.min.value ? left.minIndex : right.minIndex;
            }
        }

        public Pair findMin(int lq, int rq) {
            if (lb == lq && rq == rb) {
                return min;
            } else if (Math.max(lq, lb) >= Math.min(rq, rb)) {
                return new Pair(-1, Integer.MAX_VALUE);
            } else if (lb + 1 == rb) {
                return min;
            }
            Pair r1 = left.findMin(lq, rq);
            Pair r2 = right.findMin(lq, rq);
            return r1.value < r2.value ? r1 : r2;
        }
    }

    public static class Pair {
        int index;
        int value;

        public Pair(int index, int value) {
            this.index = index;
            this.value = value;
        }

        public Pair() {
        }
    }

}
