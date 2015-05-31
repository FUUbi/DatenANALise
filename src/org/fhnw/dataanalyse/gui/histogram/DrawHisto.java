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
    private int border = 50;
    private Color bgColor = Color.white;


    public void updateHistoValues(ArrayList<Integer> binRelativQuantity) {
        this.k = binRelativQuantity.size();
        this.Quantity = binRelativQuantity;
        setBackground(bgColor);
        repaint();
    }

    @Override
    public void paintComponent(Graphics g) {

        int barWidth = (getWidth() - 2 * border) / k;
        int max = 0;

        for (Integer i : Quantity) if (i > max) max = i;

        // y-Axis
        g.setColor(Color.GRAY);
        g.drawLine(border, border/2, border, getHeight() - border);

        //x
        for(int i = 0; i <= 9; i++) {

            int y = i*(getHeight() - 2 * border)/10 + border;
            g.drawLine(border, y , getWidth() - border, y);
        }


        for (int i = 0; i < k; i++) {

            int barHeight = (int) ((float)Quantity.get(i) / max * (getHeight() - 2 * border));

            int x = i * barWidth + border;
            int y = getHeight() - barHeight - border;

            g.setColor(Color.BLUE);
            g.fillRect(x, y, barWidth, barHeight);
            g.setColor(Color.WHITE);
            g.drawRect(x, y, barWidth, barHeight);
        }

        //x-Axis
        int y = getHeight() - border;
        g.setColor(Color.GRAY);
        g.drawLine(border, y , getWidth() - border /2, y);


    }
}
