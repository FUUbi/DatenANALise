package org.fhnw.dataanalyse.gui.histogram;

import org.fhnw.dataanalyse.datamodell.FileChooser;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

/**
 * Created by Fabrizio on 21.05.2015.
 *
 */
public class DrawHisto extends JPanel{
    int k;
    ArrayList<Integer> Quantity;
    boolean state = true;

    public DrawHisto(){

    }

    public DrawHisto(ArrayList<Integer> binQuantity) {
        this.k = binQuantity.size();
        this.Quantity = binQuantity;

    }

    //vileich währe besser wenn set genant
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
