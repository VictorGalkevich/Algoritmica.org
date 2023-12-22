package decomposition.scanline;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class LengthOfSegmentsMerge {
    public static void main(String[] args) {
        List<Segment> segments = new ArrayList<>(List.of(
                new Segment(1, 3),
                new Segment(2, 6)
        ));
        System.out.println(scan(segments));
    }

    public static int scan(List<Segment> segments) {
        List<Point> points = new ArrayList<>();
        for (Segment segment : segments) {
            points.add(new Point(segment.l, 1));
            points.add(new Point(segment.r, -1));
        }
        Collections.sort(points);
        int cnt = 0, res = 0, prev = Integer.MIN_VALUE;

        for (Point e : points) {
            if (prev != Integer.MIN_VALUE && cnt > 0) {
                res += e.x - prev; // весь отрезок [prev, e.x] покрыт cnt отрезками
            }
            cnt += e.type;
            prev = e.x;
        }
        return res;
    }

    public static class Segment {
        int l;
        int r;

        public Segment(int l, int r) {
            this.l = l;
            this.r = r;
        }
    }

    public static class Point implements Comparable<Point> {
        int x;
        int type;

        public Point(int x, int type) {
            this.x = x;
            this.type = type;
        }

        @Override
        public int compareTo(Point point) {
            if (point.x == this.x) {
                return this.type - point.type;
            }
            return this.x - point.x;
        }
    }
}
