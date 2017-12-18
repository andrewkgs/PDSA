public class main {
    public static void main(String[] args) {
        RangeSearch rs = new RangeSearch();
        if (args.length > 0) {
            In in = new In(args[0]);
            int N = 20;
            Point2D[] group = new Point2D[N];

            for (int i = 0; i < N; i++) {
                String[] coordinate = in.readLine().split("\\s");
                double X_co = Double.parseDouble(coordinate[0]);
                double Y_co = Double.parseDouble(coordinate[1]);
                group[i] = new Point2D(X_co, Y_co);
            }
            rs.init(group);
            Point2D LL = new Point2D(0.2, 0.3);
            Point2D UR = new Point2D(0.7, 0.8);
            Point2D[] a = rs.query(LL, UR);
            //StdOut.println(a[0]);
        }
    }
}
