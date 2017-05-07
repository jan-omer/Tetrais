/**
 * Created by jan on 06/05/17.
 */
public class Triangle extends Shape{


    int left;
    int right;
    int up;
    int down;
    int [][] shape;
    Triangle next;
    Triangle previous;
    static Triangle base;



    static {
          int triangle1 [][]  = {{0,0,0},{0,1,0},{1,1,1}};
            int triangle2 [][]  = {{0,0,1},{0,1,1},{0,0,1}};
          int triangle3 [][]  = {{1,1,1},{0,1,0},{0,0,0}};
        int triangle4 [][]  = {{1,0,0},{1,1,0},{1,0,0}};
        Triangle t1 = new Triangle(0,0,1,0,triangle1,null,null);


        Triangle t4 = new Triangle(0,1,0,0,triangle4,t1,null);
        Triangle t3 = new Triangle(0,0,0,1,triangle3,t4,null);
        Triangle t2 = new Triangle(1,0,1,0,triangle2,t3,null);
        t1.next = t2;
        base = t1;
    }

    public Triangle(int left, int right, int up, int down, int[][] shape, Triangle next, Triangle previous) {
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
