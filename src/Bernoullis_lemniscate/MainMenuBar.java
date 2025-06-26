package Bernoullis_lemniscate;

import javax.swing.*;

public class MainMenuBar extends JMenuBar {
    public MainMenuBar(DrawingPanel drawingPanel) {
        JMenu fileMenu = new JMenu("Файл");

        // задаємо об'єкти меню
        JMenuItem exitItem = new JMenuItem("Вихід");
        exitItem.addActionListener(_ -> System.exit(0));
        JMenuItem editParamA = getEditParamA(drawingPanel);
        JMenuItem editParamStep = getEditParamStep(drawingPanel);
        JMenuItem editParamTickSize = getEditParamTickSize(drawingPanel);

        // додаємо їх
        fileMenu.add(exitItem);
        fileMenu.add(editParamA);
        fileMenu.add(editParamStep);
        fileMenu.add(editParamTickSize);

        add(fileMenu);
    }

    private JMenuItem getEditParamStep(DrawingPanel drawingPanel) {
        JMenuItem editParamStep = new JMenuItem("Змінити відстань між відмітками");
        editParamStep.addActionListener(_ -> {
            String input = JOptionPane.showInputDialog(this, "Введіть значення параметра step:", "Зміна параметра a", JOptionPane.PLAIN_MESSAGE);
            if (input != null) {
                try {
                    int step = Integer.parseInt(input);
                    drawingPanel.getCoordinate().setStep(step);
                    drawingPanel.repaint();
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(this, "Будь ласка, введіть коректне число.", "Помилка", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        return editParamStep;
    }

    private JMenuItem getEditParamA(DrawingPanel drawingPanel) {
        JMenuItem editParamA = new JMenuItem("Змінити a");
        editParamA.addActionListener(_ -> {
            String input = JOptionPane.showInputDialog(this, "Введіть значення параметра a:", "Зміна параметра a", JOptionPane.PLAIN_MESSAGE);
            if (input != null) {
                try {
                    double a = Double.parseDouble(input);
                    drawingPanel.getLemniscate().setA(a);
                    drawingPanel.repaint();
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(this, "Будь ласка, введіть коректне число.", "Помилка", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        return editParamA;
    }

    private JMenuItem getEditParamTickSize(DrawingPanel drawingPanel) {
        JMenuItem editParamTickSize = new JMenuItem("Змінити розмір відміток");
        editParamTickSize.addActionListener(_ -> {
            String input = JOptionPane.showInputDialog(this, "Введіть значення параметра tickSize:", "Зміна параметра a", JOptionPane.PLAIN_MESSAGE);
            if (input != null) {
                try {
                    int tickSize = Integer.parseInt(input);
                    drawingPanel.getCoordinate().setTickSize(tickSize);
                    drawingPanel.repaint();
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(this, "Будь ласка, введіть коректне число.", "Помилка", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        return editParamTickSize;
    }
}

