package SegmentTree;

public class LazyPropagation {
    public static void main(String[] args) {
        int[] arr = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        LazyTreeNode mode = new LazyTreeNode(0, arr.length, arr);
        mode.addOnSegment(0, 10, 5);
        System.out.println(mode.sumOnSegment(0, 9));
    }

    public static class LazyTreeNode {
        int lb;
        int rb;
        int sum;
        int[] arr;
        int assign = Integer.MIN_VALUE;
        LazyTreeNode left;
        LazyTreeNode right;

        LazyTreeNode(int lb, int rb, int[] arr) {
            this.lb = lb;
            this.rb = rb;
            this.arr = arr;
            if (lb + 1 == rb) {
                this.sum = arr[lb];
            } else {
                int mid = (lb + rb) / 2;
                this.left = new LazyTreeNode(lb, mid, arr);
                this.right = new LazyTreeNode(mid, rb, arr);
                this.sum = left.sum + right.sum;
            }
        }

        void push() {
            if (assign != Integer.MIN_VALUE) {
                this.sum += assign * (rb - lb);
                if (left != null) {
                    this.left.assign += assign;
                    this.right.assign += assign;
                }
            }
        }

        void addOnSegment(int lq, int rq, int x) {
            push();
            if (lq <= lb && rb <= rq) {
                if (this.assign == Integer.MIN_VALUE) {
                    this.assign = 0;
                }
                this.assign += x;
            } else if (left != null && Math.max(lq, lb) < Math.min(rb, rq)) {
                this.left.addOnSegment(lq, rq, x);
                this.right.addOnSegment(lq, rq, x);
            }
        }

        int sumOnSegment(int lq, int rq) {
            push();
            if (lq <= lb && rb <= rq) {
                return this.sum;
            } else if (Math.max(lq, lb) >= Math.min(rb, rq)) {
                return 0;
            }

            return left.sumOnSegment(lq, rq) + right.sumOnSegment(lq, rq);
        }

    }

}

