import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by jan on 03/05/17.
 */
public class GameEngine {

    volatile  List<Integer[]> board =  new ArrayList<Integer[]>();
    Shape currentShape;

    {
        for(int i = 0; i < 20; i++){
            Integer[] temp = new Integer[10];
            Arrays.fill(temp,0);
            board.add(temp);

        }

      //  board[2][2] =1;
    }






    int currentRotation = 0;

    MFrame mFrame;
    volatile Integer xCp = 0; volatile Integer yCp =0;

    GameEngine() throws InterruptedException {
        currentShape = Line.base;
        mFrame = new MFrame(this,board, currentShape.getShape(), xCp, yCp);

        while (true) {

            mFrame.pushUpdate(yCp,xCp, currentShape.getShape());
            Thread.sleep(500);

               if (isEndPoint()) {
                applyNew();
                checkLinesFilled();
            }
        }
    }

    private void checkLinesFilled() {

       List<Integer> rows = new ArrayList<Integer>();
       int rowNumber = 0;
        for(Integer [] row :board){
            boolean isCurrentFull = true;

            for(int i : row){
                if(i == 0){
                    isCurrentFull = false;
                }
            }

            if(isCurrentFull){
                rows.add(rowNumber);
            }
            rowNumber++;
        }


        for(Integer i : rows){
            Integer[] temp = new Integer[10];
            Arrays.fill(temp,0);
            board.remove(board.get(i));
            board.add(0,temp);
        }

    }

    private void applyNew() {
        applyCpToBoard();
    }


    public static void main(String args[]) throws InterruptedException {
        new GameEngine();
    }

    public boolean isEndPoint() {

        int yCp= this.yCp + 1;
        int[][] shape = this.currentShape.getShape();
        System.out.println("ee" + yCp + " " + yCp + (shape.length - this.currentShape.getDown()) +  " " + board.size());
        if(yCp + (shape.length - this.currentShape.getDown()) >= board.size()){

            this.yCp++;
            return true;
        }
        for(int i = 0 ; i < shape.length ;i++){
            for(int j = 0; j < shape[0].length; j++){
                if(shape[i][j] != 0 &&(
                        board.get(yCp+ i+1)[xCp +j] == shape[i][j])){
                    this.yCp++;
                    return true;
                }
            }
        }
        this.yCp++;


        return false;
    }

    private void applyCpToBoard() {
        int[][] shape = this.currentShape.getShape();
        System.out.println("apb ycp " + yCp);
        for(int i = currentShape.getUp() ; i < shape.length - currentShape.getDown() ;i++){
            for(int j = 0; j < shape[0].length; j++){
                if(shape[i][j] != 0)
                board.get(yCp+ i)[xCp +j] =
                        shape[i][j]  ;
            }
        }
        yCp =0;
    }

    void applyMovement(MovementType movementType){
        switch (movementType){
            case UP:
                currentShape = currentShape.getNextShape();

                break;
            case LEFT:

                System.out.println(xCp + " " + currentShape.getLeft());
                if(xCp    + currentShape.getLeft()  > 0)
                xCp--;

                break;
            case RIGHT:


                int i = xCp + currentShape.getShape()[0].length - currentShape.getRight() -1;
                if(((xCp   + currentShape.getShape()[0].length - currentShape.getRight())
                        < board.get(0).length) && (i <  20 && board.get(yCp)[i + 1] == 0)) {
                    xCp++;
                }
                break;
            case DOWN:


                if (isEndPoint()) {
                    applyNew();
                }
                yCp = yCp == board.size()  ? board.size() : yCp;
                break;
        }
        mFrame.pushUpdate(yCp,xCp, currentShape.getShape());
    }

    enum MovementType{
        LEFT,RIGHT,UP,DOWN
    }
}
