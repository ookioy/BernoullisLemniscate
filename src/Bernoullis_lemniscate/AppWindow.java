package Bernoullis_lemniscate;

import javax.swing.*;

public class AppWindow extends JFrame {
    public AppWindow() {
        this.setTitle("Bernoulli's Lemniscate");
        this.setSize(800, 600);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
        DrawingPanel drawingPanel = new DrawingPanel(50, 20, 2);
        MainMenuBar mainMenuBar = new MainMenuBar(drawingPanel);
        this.add(drawingPanel);
        this.setJMenuBar(mainMenuBar);

        setVisible(true);
    }
}
