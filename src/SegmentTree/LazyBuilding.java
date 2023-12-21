package SegmentTree;

public class LazyBuilding {
    public static void main(String[] args) {
        int[] arr = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        Default.TreeNode mode = new Default.TreeNode(0, arr.length, arr);
        System.out.println();
    }
    public static class LazyBuildTreeNode {
        int lb;
        int rb;
        int sum;
        int[] arr;
        LazyBuildTreeNode left;
        LazyBuildTreeNode right;

        public LazyBuildTreeNode(int lb, int rb, int[] arr) {
            this.lb = lb;
            this.rb = rb;
            this.arr = arr;
        }

        public void build(){
            if (left == null && lb + 1 < rb) {
                int mid = (lb + rb) / 2;
                left = new LazyBuildTreeNode(lb, mid, arr);
                right = new LazyBuildTreeNode(mid, rb, arr);
            }
        }

    }
}
