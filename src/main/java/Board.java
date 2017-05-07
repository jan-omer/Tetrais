import javax.swing.*;
import java.awt.*;
import java.util.*;
import java.util.List;
import java.util.jar.JarEntry;

/**
 * Created by jan on 03/05/17.
 */
public class Board extends JPanel {


    volatile int [][] cp;
    volatile Integer xCp;
    volatile Integer yCp;



   volatile List<Integer[]> board;

    public Board(java.util.List<Integer[]> board, int [][] cp,
                 Integer xCp, Integer yCp) {
        super();
        this.board = board;
        this.cp = cp;
        this.xCp = xCp;
        this.yCp = yCp;

    }


    int width = 30;
    int height = 30;
    @Override
    protected void paintComponent(Graphics g) {

        g.setColor(Color.lightGray);

        g.fillRect(0,0,400,800);
        g.setColor(Color.black);
        for(int i = 0 ; i  < cp.length ;i++){
            for(int j = 0; j < cp[0].length; j++){
                if(cp[j][i] == 1){
                    g.fillRect((xCp + i)*width, height*(yCp + j), width, height);
                }
            }
        }


        int x = 0;
        int y =0;
        for(Integer[] i : board) {
            for(int j : i) {

                switch (j) {
                    case 0:
                        g.setColor(Color.black);
                        g.drawRect(x, y, width, height);
                        break;
                    case 1:
                        g.setColor(Color.YELLOW);
                        g.fillRect(x, y, width, height);
                        break;
                }
                    x += width;

            }
            x = 0;
            y += height;
        }
    }

    public void pushUpdate(Integer yCp,Integer xCp,int [][] cp) {
        this.yCp = yCp;
        this.cp = cp;
        this.xCp = xCp;
    }
}
