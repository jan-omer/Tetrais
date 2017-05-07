import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.*;

/**
 * Created by jan on 03/05/17.
 */
public class MFrame extends JFrame {
    final Board boardPanel;
    final GameEngine ge;

    MFrame(GameEngine gameEngine, final java.util.List<Integer[]>  board, int [][] cp, Integer x, Integer y){
        boardPanel = new Board(board,cp,x,y);
        ge = gameEngine;
        add(boardPanel);
        this.setVisible(true);
        this.setSize(new Dimension(400,800));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        SwingWorker<Void,Void> sw = new SwingWorker<Void, Void>() {
            @Override
            protected Void doInBackground() throws Exception {
                while (true) {
                    boardPanel.revalidate();
                   boardPanel.repaint();

                    Thread.sleep(10);
                }

            }
        };
        sw.execute();

        addKeyListener(new KeyListener() {
            public void keyTyped(KeyEvent e) {

            }

            public void keyPressed(KeyEvent e) {

            }

            public void keyReleased(KeyEvent e) {

                if(e.getKeyCode() == KeyEvent.VK_UP) {
                    System.out.println("RRRR");
                    ge.applyMovement(GameEngine.MovementType.UP);
                }

                if(e.getKeyCode() == KeyEvent.VK_LEFT) {
                    System.out.println("RRRR");
                    ge.applyMovement(GameEngine.MovementType.LEFT);
                }
                if(e.getKeyCode() == KeyEvent.VK_RIGHT) {
                    System.out.println("RRRR");
                    ge.applyMovement(GameEngine.MovementType.RIGHT);
                }

                if(e.getKeyCode() == KeyEvent.VK_DOWN) {
                    System.out.println("RRRR");
                    ge.applyMovement(GameEngine.MovementType.DOWN);
                }
            }
        });

    }


    public void pushUpdate(Integer yCp,Integer xCp,int [][] cp) {
        boardPanel.pushUpdate(yCp,xCp,cp);
    }
}
