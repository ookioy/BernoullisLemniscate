package Bernoullis_lemniscate;

import Bernoullis_lemniscate.panels_components.*;
import javax.swing.*;
import java.awt.*;

public class DrawingPanel extends JPanel {
    private final Lemniscate lemniscate;
    private final CoordinateSystem coordinateSystem;

    public DrawingPanel(double a, int step, int tickSize) {
        this.lemniscate = new Lemniscate(a);
        this.coordinateSystem = new CoordinateSystem(step, tickSize);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        lemniscate.draw((Graphics2D) g, getWidth(), getHeight());
        coordinateSystem.draw((Graphics2D) g, getWidth(), getHeight());
    }

    public Lemniscate getLemniscate() {return lemniscate;}
    public CoordinateSystem getCoordinate() {return coordinateSystem;}
}