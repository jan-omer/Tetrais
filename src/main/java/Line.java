/**
 * Created by jan on 07/05/17.
 */
public class Line extends Shape {


    int left;
    int right;
    int up;
    int down;
    int [][] shape;
    Line next;
    Line previous;
    static Line base;



    static {
        int triangle1 [][]  = {{0,0,1,0},{0,0,1,0},{0,0,1,0},{0,0,1,0}};
        int triangle2 [][]  = {{0,0,0,0},{0,0,0,0},{1,1,1,1},{0,0,0,0}};

        Line t1 = new Line(2,1,0,0,triangle1,null,null);
        Line t2 = new Line(0,0,2,1,triangle2,t1,t1);
        t1.next = t2;
        base = t1;
    }

    public Line(int left, int right, int up, int down, int[][] shape, Line next, Line previous) {
        this.left = left;
        this.right = right;
        this.up = up;
        this.down = down;
        this.shape = shape;
        this.next = next;
        this.previous = previous;
    }

    @Override
    public int getLeft() {
        return left;
    }

    @Override
    public int getRight() {
        return right;
    }

    @Override
    public int getUp() {
        return up;
    }

    @Override
    public int getDown() {
        return down;
    }

    public int[][] getShape() {
        return shape;
    }

    public Shape getBase() {
        return base;
    }

    public Shape getNextShape() {
        return next;
    }
}
