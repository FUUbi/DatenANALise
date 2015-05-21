package org.fhnw.dataanalyse.gui.toolbar;

import org.fhnw.dataanalyse.gui.histogram.HistogramManager;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.util.Random;

/**
 * Created by Vallat on 20.05.2015.
 */

public class T2h_Configuration extends JPanel{

    public T2h_Configuration(final HistogramManager histogramManager){
        Button changeColorBtn = new Button("drück mich");

        add(changeColorBtn);
        setVisible(true);

        changeColorBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Random rand = new Random();
                int r = rand.nextInt(255);
                int g = rand.nextInt(255);
                int b = rand.nextInt(255);
                Color randomColor = new Color(r, g, b);

                histogramManager.colorChanged(randomColor);
            }
        });

    }


}

