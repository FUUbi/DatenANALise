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
    ArrayList<Float> relQuantity;
    Color  color = Color.ORANGE;

    public DrawHisto(){

    }

    public DrawHisto(ArrayList<Float> binRelativQuantity) {
        this.k = binRelativQuantity.size();
        this.relQuantity = binRelativQuantity;

    }

    //vileich währe besser wenn set genant
    public void updateHistoValues(ArrayList<Float> binRelativQuantity) {
        this.k = binRelativQuantity.size();
        this.relQuantity = binRelativQuantity;
        repaint();

    }

    public void setColor(Color color){
        this.color = color;
        repaint();
    }


        @Override
    public void paintComponent(Graphics g) {

        int barWidth = getWidth() / k;
        for (int i = 0; i < k; i++) {

            int barHeight = (int) (relQuantity.get(i) * getHeight());

            int x = i * barWidth;
            int y = getHeight() - barHeight;

            g.setColor(color);
            g.fillRect(x, y, barWidth, barHeight);
            g.setColor(Color.YELLOW);
            g.drawRect(x, y, barWidth, barHeight);



        }
    }
}
