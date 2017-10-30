import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;


public class Onion {
    public static int[] ConvexHullVertex(Point2D[] a) {
        // return the index set of the ConvexHullVertex,
        // the index is the same as the index in array a:0, 1, 2, 3, 4, ....a.length-1
        ArrayList<Point2D> points = new ArrayList<>();
        for (Point2D p:a) {
            points.add(p);
        }

        Stack<Point2D> convex_hull = new Stack<>();

        int min = min_Y(a);
        //StdOut.println(min);
        Point2D start = a[min];
        Arrays.sort(a, start.ATAN2_ORDER);
        //for (int j = 0; j < a.length; j++) {
        //    System.out.println(a[j]);
        //}
        convex_hull.push(a[0]);
        convex_hull.push(a[1]);

        for (int i = 2; i < a.length; i++) {
            Point2D q = convex_hull.pop();
            Point2D p = convex_hull.pop();
            Point2D r = a[i];
            while (Point2D.ccw(p, q, r) != 1) {
                q = p;
                p = convex_hull.pop();
            }
            convex_hull.push(p);
            convex_hull.push(q);
            convex_hull.push(r);
        }

        int[] convex_index = new int[convex_hull.size()];
        int count = 0;
        while (!convex_hull.isEmpty()) {
            Point2D tmp = convex_hull.pop();
            int i = points.indexOf(tmp);
            convex_index[count++] = i;
        }
        return convex_index;
    }

    private static int min_Y (Point2D[] a) {
        int min_index = 0;
        for (int i=0; i<a.length; i++) {
            if (Point2D.Y_ORDER.compare(a[min_index], a[i]) == 1) {
                min_index = i;
            }
        }
        return min_index;
    }

    public static void main(String[] args) throws Exception{
        // 1. read in the file containing N 2-dimensional points
        // 2. recursively find the convexhull of the resting points
        // 3. count the number of convexhulls and print it
        try (BufferedReader br = new BufferedReader(new FileReader(args[0]))) {
            int N = Integer.parseInt(br.readLine());
            Point2D[] group = new Point2D[N];

            for (int i=0; i<N; i++) {
                String[] coordinate = br.readLine().split("\\s");
                double X_co = Double.parseDouble(coordinate[0]);
                double Y_co = Double.parseDouble(coordinate[1]);
                group[i] = new Point2D(X_co, Y_co);
            }

            int N_convexhull = 0;
            int[] root = new int[N];

            System.out.println(ConvexHullVertex(group)[1]);

        }
    }
}