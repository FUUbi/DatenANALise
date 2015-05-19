package org;

import org.fhnw.dataanalyse.gui.histogram.HistoPlot;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

/**
 * Created by Fabrizio on 19.05.2015.
 *
 */
public class DrawHisto extends JPanel {

    int k;
    ArrayList<Float> relQuantity;

    public DrawHisto(HistoPlot histdata){

        this.k = histdata.k;
        this.relQuantity = histdata.relInterval;

/*
        this.k = histdata.getNumbersOfBin();
        this.relQuantity = histdata.getRelQuantity();
*/

    }

    public void updatehist(HistoPlot histdata) {
        this.k = histdata.k;
        this.relQuantity = histdata.relInterval;
    }

        @Override
    public void paintComponent(Graphics g) {

        int barWidth = getWidth() / k;
        for (int i = 0; i < k; i++) {

            int barHeight = (int) (relQuantity.get(i) * getHeight());

            int x = i * barWidth;
            int y = getHeight() - barHeight;

            g.setColor(Color.ORANGE);
            g.fillRect(x, y, barWidth, barHeight);
            g.setColor(Color.YELLOW);
            g.drawRect(x, y, barWidth, barHeight);
        }
    }
}
