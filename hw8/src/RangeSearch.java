public class RangeSearch {

    private Point2D ll, ur;
    private Node root;
    private MinPQ<Point2D> remain = new MinPQ<>();

    private class Node {
        private Point2D p;
        private int level; // 1 or 2 (2d-tree)
        private Node left, right;

        public Node(Point2D p, int level) {
            this.p = p;
            this.level = level;
        }
    }

    private void extend(Point2D p) {
        Node node = root;
        int level = 1; // level = 1 (x), level = 2 (y)
        while (true) {
            if (level == 1) {
                if (p.x() < node.p.x()) {
                    if (node.left == null) {
                        node.left = new Node(p, 3-level);
                        return;
                    }
                    node = node.left;
                }
                else {
                    if (node.right == null) {
                        node.right = new Node(p, 3-level);
                        return;
                    }
                    node = node.right;
                }
            }
            else { // level = 2
                if (p.y() < node.p.y()) {
                    if (node.left == null) {
                        node.left = new Node(p, 3-level);
                        return;
                    }
                    node = node.left;
                }
                else {
                    if (node.right == null) {
                        node.right = new Node(p, 3-level);
                        return;
                    }
                    node = node.right;
                }
            }
            level = 3 - level; // 1 <-> 2
        }
    }

    private void add(Point2D p) {
        if (root == null) {
            root = new Node(p, 1);
            return;
        }
        extend(p);
    }

    public void init(Point2D[] points){
        for (Point2D p:points) add(p);
    }

    private boolean inRectangle(Point2D p) {
        if (p.x() < ll.x()) return false;
        if (p.x() > ur.x()) return false;
        if (p.y() < ll.y()) return false;
        if (p.y() > ur.y()) return false;
        return true;
    }

    private void search(Node node) {
        if (node != null) {
            if (inRectangle(node.p)) remain.insert(node.p);
            if (node.level == 1) {
                if (node.p.x() >= ll.x()) search(node.left);
                if (node.p.x() <= ur.x()) search(node.right);
            }
            else if (node.level == 2) {
                if (node.p.y() >= ll.y()) search(node.left);
                if (node.p.y() <= ur.y()) search(node.right);
            }
        }
    }

    public Point2D[] query(Point2D ll, Point2D ur){
        this.ll = ll;
        this.ur = ur;
        search(root);

        int size = remain.size();
        Point2D[] result= new Point2D[size];
        for (int i=0; i<size; i++) result[i] = remain.delMin();
        return result;
    }
}