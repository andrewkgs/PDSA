public class Shortestpath {
    public static void main(String[] args) {
        if (args.length > 0) {

            In in = new In(args[0]);
            int total_row = Integer.parseInt(in.readLine().split(" ")[1]);
            int total_col = Integer.parseInt(in.readLine().split(" ")[1]);

            String data;
            data = in.readLine()
            int[] start = new int[2];
            start[0] = Integer.parseInt(data.split(" ")[1].split(",")[0]) - 1;
            start[1] = Integer.parseInt(data.split(" ")[1].split(",")[1]) - 1;

            int[] goal = new int[2];
            goal[0] = Integer.parseInt(data.split(" ")[1].split(",")[0]) - 1;
            goal[1] = Integer.parseInt(data.split(" ")[1].split(",")[1]) - 1;

            in.readLine();

            int grid[][] = new int[total_row][total_col];
            while ((data=in.readLine()) != null) {

            }
        }
    }
}

}
