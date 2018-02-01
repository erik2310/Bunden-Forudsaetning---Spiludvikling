package GameExample;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * @author Niels on 29-01-2018.
 */
public class MapTileMaker extends JPanel {
    int x, y;

    public MapTileMaker(final int x, final int y){
        this.x = x;
        this.y = y;

        addMouseListener(new MouseAdapter(){
            public void mousePressed(MouseEvent e) {
                if(e.getButton() == MouseEvent.BUTTON1){
                    setBackground(Color.WHITE);
                    MazeMapMaker.map[x][y] = 1;
                }
                if(e.getButton() == MouseEvent.BUTTON3){
                    setBackground(Color.GRAY);
                    MazeMapMaker.map[x][y] = 0;
                }
            }
        });
    }
}