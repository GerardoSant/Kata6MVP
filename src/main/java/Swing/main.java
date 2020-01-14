package Swing;
import Model.Square;
import Presenter.Presenter;
import View.ChangeSquareSizeDialog;
import View.MoveSquareDialog;
import View.SquareDisplay;

import javax.swing.*;


public class main {

    public static void main(String[] args) {
        //Model
        Square square = new Square(100,50);
        //View
        SquareDisplay display= new SwingSquareDisplay();
        MoveSquareDialog moveDialog = new SwingMoveSquareDialog();
        ChangeSquareSizeDialog changeDialog= new SwingChangeSquareSizeDialog();
        //Presenter
        Presenter presenter = new Presenter(square, display, moveDialog, changeDialog);
        //Implementation
        SwingMainFrame swingMainFrame = new SwingMainFrame(display,moveDialog,changeDialog);
        swingMainFrame.setPresenter(presenter);
        swingMainFrame.execute();
    }
}
