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

        Point2D[] b = new Point2D[a.length];
        for (int i=0; i<a.length; i++) {
            b[i] = new Point2D(a[i].x(), a[i].y());
        }
        int min = min_Y(b);
        Point2D start = b[min];
        //StdOut.println(start);
        Arrays.sort(b, start.ATAN2_ORDER);
        convex_hull.push(b[0]);
        convex_hull.push(b[1]);

        for (int i = 2; i<a.length; i++) {
            Point2D q = convex_hull.pop();
            Point2D p = convex_hull.pop();
            Point2D r = b[i];
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

            for (int i = 0; i < N; i++) {
                String[] coordinate = br.readLine().split("\\s");
                double X_co = Double.parseDouble(coordinate[0]);
                double Y_co = Double.parseDouble(coordinate[1]);
                group[i] = new Point2D(X_co, Y_co);
            }

            int N_convexhull = 0;
            int unused_points_num = group.length;

            while (unused_points_num > 2) {
                boolean[] state = new boolean[group.length]; // Default is false
                int[] used_points = ConvexHullVertex(group);

                for (int i=0; i<used_points.length; i++){
                    state[used_points[i]] = true;
                }
                unused_points_num -= used_points.length;
                Point2D[] temp = new Point2D[unused_points_num];
                int count = 0;
                for (int i=0; i<state.length; i++) {
                    if (!state[i]) {
                        temp[count] = new Point2D(group[i].x(), group[i].y());
                        count++;
                    }
                }
                //for (int p=0; p<group.length; p++){
                //    System.out.println(group[p]);
                //}
                //StdOut.println("===");
                group = temp;
                N_convexhull++;
            }
            System.out.println(N_convexhull);
        }
    }
}