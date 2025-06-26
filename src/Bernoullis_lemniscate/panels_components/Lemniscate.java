package Bernoullis_lemniscate.panels_components;

import java.awt.*;

public class Lemniscate {
    private double a; // параметр, що визначає розмір і форму кривої.
    private final Color color = Color.BLACK; // колір

    public Lemniscate(double a) {
        this.a = a;
    }
    public void draw(Graphics2D g, int width, int height) {
        g.setColor(color);

        int centerX = width / 2;
        int centerY = height / 2;

        for (double t = 0; t <= 2 * Math.PI; t += 0.01) {
            double sin = Math.sin(t);
            double denominator = 1 + sin * sin;

            double x = a * Math.cos(t) / denominator;
            double y = a * Math.cos(t) * sin / denominator;

            int screenX = (int) (centerX + x);
            int screenY = (int) (centerY - y);

            g.fillRect(screenX, screenY, 2, 2);
        }
    }
    public void setA(double a) {
        this.a = a;
    }
}
