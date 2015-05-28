package org.fhnw.dataanalyse.gui.histogram;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

/**
 * DrawHisto contains updateHistoValues Method which updates its content at each call
 * DrawHisto contains also paintComponent Method
 */
public class DrawHisto extends JPanel{

    private int k;
    private ArrayList<Integer> Quantity;


    public void updateHistoValues(ArrayList<Integer> binRelativQuantity) {
        this.k = binRelativQuantity.size();
        this.Quantity = binRelativQuantity;
        repaint();
    }

    @Override
    public void paintComponent(Graphics g) {

        int barWidth = getWidth() / k;
        int max = 0;

        for (Integer i : Quantity) if (i > max) max = i;

        for (int i = 0; i < k; i++) {

            int barHeight = (int) ((float)Quantity.get(i) / max * getHeight());

            int x = i * barWidth;
            int y = getHeight() - barHeight;

            g.setColor(Color.BLUE);
            g.fillRect(x, y, barWidth, barHeight);
            g.setColor(Color.YELLOW);
            g.drawRect(x, y, barWidth, barHeight);

        }
    }
}
