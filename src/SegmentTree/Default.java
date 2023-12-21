package SegmentTree;

public class Default {
    public static void main(String[] args) {
        int[] arr = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        TreeNode mode = new TreeNode(0, arr.length, arr);
        System.out.println();
    }

    public static class TreeNode {
        int lb;
        int rb;
        int[] arr;
        int max;
        TreeNode left;
        TreeNode right;

        TreeNode(int lb, int rb, int[] arr) {
            this.lb = lb;
            this.rb = rb;
            this.arr = arr;
            if (lb + 1 == rb) {
                this.max = arr[lb];
            } else {
                int mid = (lb + rb) / 2;
                this.left = new TreeNode(lb, mid, arr);
                this.right = new TreeNode(mid, rb, arr);
                this.max = Math.max(left.max, right.max);
            }
        }
    }
}
