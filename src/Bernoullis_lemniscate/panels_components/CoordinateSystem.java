package Bernoullis_lemniscate.panels_components;

import java.awt.*;

public class CoordinateSystem {
    private final Color color = Color.GRAY; // колір координатної системи
    private final Stroke stroke; // по суті об'єкт, що є сукупнністю доданих до нього об'єктів
    private int step; // відстань (у пікселях) між відмітками
    private int tickSize; // розмір відміток

    public CoordinateSystem(int step, int tickSize) {
        this.step = step;
        this.tickSize = tickSize;
        this.stroke = new BasicStroke(2); // ширина координат
    }

    public void draw(Graphics2D g, int width, int height) {
        g.setColor(color);
        g.setStroke(stroke);

        int centerX = width / 2;
        int centerY = height / 2;

        // Х координата
        g.drawLine(0, centerY, width, centerY);

        // Y координата
        g.drawLine(centerX, 0, centerX, height);

        // розмір стрілок
        int arrowSize = 6;
        // X стрілка
        g.drawLine(width - arrowSize, centerY - arrowSize, width, centerY);
        g.drawLine(width - arrowSize, centerY + arrowSize, width, centerY);

        // Y стрілка
        g.drawLine(centerX - arrowSize, arrowSize, centerX, 0);
        g.drawLine(centerX + arrowSize, arrowSize, centerX, 0);

        // додавання відміток
        drawTicks(g, centerX, centerY, width, height);
    }

    private void drawTicks(Graphics2D g, int centerX, int centerY, int width, int height) {
        // відмітки X координати
        for (int x = centerX + step; x < width; x += step) {
            g.drawLine(x, centerY - tickSize, x, centerY + tickSize);
        }
        for (int x = centerX - step; x > 0; x -= step) {
            g.drawLine(x, centerY - tickSize, x, centerY + tickSize);
        }

        // відмітки Y координати
        for (int y = centerY + step; y < height; y += step) {
            g.drawLine(centerX - tickSize, y, centerX + tickSize, y);
        }
        for (int y = centerY - step; y > 0; y -= step) {
            g.drawLine(centerX - tickSize, y, centerX + tickSize, y);
        }
    }

    public void setStep(int step) {
        this.step = step;
    }
    public void setTickSize(int tickSize) {
        this.tickSize = tickSize;
    }


}
