package Swing;

import Presenter.Presenter;
import View.ChangeSquareSizeDialog;
import View.MoveSquareDialog;
import View.SquareDisplay;
import javax.swing.*;
import java.awt.*;

public class SwingMainFrame extends JFrame {

    private SquareDisplay squareDisplay;
    private MoveSquareDialog moveSquareDialog;
    private ChangeSquareSizeDialog changeSquareSizeDialog;
    private Presenter presenter;


    public SwingMainFrame(SquareDisplay display, MoveSquareDialog moveDialog, ChangeSquareSizeDialog changeDialog) {
        squareDisplay=display;
        moveSquareDialog=moveDialog;
        changeSquareSizeDialog = changeDialog;
        createUI();
    }

    public void execute(){
        presenter.updateSquareDisplay();
        setVisible(true);
    }

    public void setPresenter(Presenter presenter) {
        this.presenter = presenter;
    }

    private void createUI() {
        add((Component) squareDisplay);
        add(buttonsPanel(),BorderLayout.SOUTH);
        ((SwingMoveSquareDialog) moveSquareDialog).setLocationRelativeTo(this);
        ((SwingChangeSquareSizeDialog) changeSquareSizeDialog).setLocationRelativeTo(this);
        setFrameSettings();
    }

    private JPanel buttonsPanel() {
        JPanel buttonsPanel = new JPanel();
        buttonsPanel.add(button("Reset"));
        buttonsPanel.add(button("Move"));
        buttonsPanel.add(button("Change"));
        return buttonsPanel;
    }

    private JButton button(String buttonName) {
        JButton button = new JButton(buttonName);
        button.addActionListener(e->{
            switch (buttonName){
                case "Reset":
                    presenter.resetPosition();
                    break;
                case "Move":
                    presenter.movePosition();
                    break;
                case "Change":
                    presenter.changeSquareSize();
                    break;
            }
        });
        return button;
    }

    private void setFrameSettings() {
        setSize(800, 300);
        setTitle("Block displayer");
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

}
