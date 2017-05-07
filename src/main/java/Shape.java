/**
 * Created by jan on 06/05/17.
 */
public abstract class Shape {



    int getEmptySpace(Direction d){
        switch (d){
            case RIGHT:
                return getRight();
            case UP:
                return getUp();
            case DOWN:
                return getDown();
            case LEFT:
                return getLeft();
                default:
                    throw new IllegalArgumentException("No Direction");
        }
    }

    public abstract  int getRight();

    public abstract int getUp() ;


    public abstract  int getLeft();

    public abstract int getDown() ;

    public abstract  int[][] getShape();

    public abstract Shape getBase();

    public abstract Shape getNextShape();

    enum Direction {
        LEFT,RIGHT,UP,DOWN
    }
}
