public class Prize {
    private static NewBST<Integer,String> myBST;
    public static void main(String[] args) {
        In in=new In(args[0]);
    }
}

class NewBST<Key extends Comparable<Key>, Value> extends BST{
    public Value predecessor(Key key, int m){
    }
    public Value successor(Key key, int m){
    }
}