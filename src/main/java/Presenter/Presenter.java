package Presenter;

import Model.Square;
import View.ChangeSquareSizeDialog;
import View.MoveSquareDialog;
import View.SquareDisplay;

public class Presenter {
    private Square square;
    private SquareDisplay display;
    private MoveSquareDialog moveDialog;
    private ChangeSquareSizeDialog changeDialog;

    public Presenter(Square square, SquareDisplay display, MoveSquareDialog moveDialog, ChangeSquareSizeDialog changeDialog) {
        this.square = square;
        this.display = display;
        this.moveDialog = moveDialog;
        this.changeDialog = changeDialog;
    }

    public void resetPosition() {
        square.setPosition(display.getDisplayWidth()/2-square.getSide()/2);
        updateSquareDisplay();
    }

    public void movePosition() {
        square.setPosition(square.getPosition()+moveDialog.getSquarePositionChange());
        updateSquareDisplay();
    }

    public void changeSquareSize() {
        square.setSide(changeDialog.getNewSquareSize());
        updateSquareDisplay();
    }

    public void updateSquareDisplay(){
        display.displaySquare(square.getPosition(),square.getSide());
    }
}
