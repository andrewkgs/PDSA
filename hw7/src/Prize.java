import java.util.Arrays;

public class Prize {
    private static NewBST<Integer, String> myBST = new NewBST<>();
    public static void main(String[] args) {
        if (args.length > 0) {
            In in = new In(args[0]);
            String[] line = in.readLine().split(" ");
            int N = Integer.parseInt(line[0]); // N people (without people who fail)
            int M = Integer.parseInt(line[1]); // 2M people win second prize
            int W = Integer.parseInt(line[2]); // W is the winning number

            String tmp, name;
            int X, count=0;
            while ((tmp = in.readLine()) != null) {
                line = tmp.split(" ");
                name = line[0];
                X = Integer.parseInt(line[1]);
                if (myBST.contains(X)) StdOut.println(name + " fail");
                else {
                    myBST.put(X, name);
                    count++;
                    if (count == N) break;
                }
            }

            StdOut.println(myBST.get(W));
            String[] second_prize = new String[M * 2];
            int index = 0;
            while (index < M * 2) {
                second_prize[index] = myBST.predecessor(W, (index / 2) + 1);
                index++;
                second_prize[index] = myBST.successor(W, (index / 2) + 1);
                index++;
            }
            Arrays.sort(second_prize); // sort by name alphabetically
            for (String n : second_prize) {
                StdOut.println(n);
            }
        }
    }
}

class NewBST<Key extends Comparable<Key>, Value> extends BST{
    public Value predecessor(Key key, int m){
        if (!contains(key)) return null;
        if (m < 0) return successor(key, (-1)*m);
        int r = rank(key);
        int s = size();
        while (r < m) r += s;
        return (Value)get(select(r - m));
    }
    public Value successor(Key key, int m){
        if (!contains(key)) return null;
        if (m < 0) return predecessor(key, (-1)*m);
        int r = rank(key);
        int s = size();
        while (r > s-1-m) r -= s;
        return (Value)get(select(r + m));
    }
}