import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

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
                    setBackground(Color.BLACK);
                    MazeMapMaker.map[x][y] = 0;
                }
            }
        });
    }
}