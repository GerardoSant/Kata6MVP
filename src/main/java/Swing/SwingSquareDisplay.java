package Swing;

import View.SquareDisplay;

import javax.swing.*;
import java.awt.*;

public class SwingSquareDisplay  extends JPanel implements SquareDisplay {

    private int pos;
    private int squareSide;


    @Override
    public void displaySquare(int pos, int squareSide) {
        this.pos=pos;
        this.squareSide=squareSide;
        repaint();
    }

    public int getDisplayWidth() {
        return this.getWidth();
    }

    public void paintComponent(Graphics g){
        super.paintComponent(g);
        g.drawRect( pos, this.getHeight()/2-squareSide/2 , squareSide, squareSide);
    }
}
