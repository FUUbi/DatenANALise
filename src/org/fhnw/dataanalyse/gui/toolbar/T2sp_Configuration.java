package org.fhnw.dataanalyse.gui.toolbar;

import org.fhnw.dataanalyse.datamodell.VariableContainer;
import org.fhnw.dataanalyse.gui.histogram.HistoPlot;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Vallat on 19.05.2015.
 */
public class T2sp_Configuration {

    public JPanel T2sp_Configuration(/*chunt no das Scatterplot vo Sven..?)*/)

    {

        JPanel t2spContent = new JPanel();

        t2spContent.setLayout(new BoxLayout(t2spContent, BoxLayout.LINE_AXIS));
        JButton pipapu = new JButton("pipapu");
        JButton houla = new JButton("Houla");

        t2spContent.add(pipapu);
        t2spContent.add(Box.createHorizontalGlue());
        t2spContent.add(houla);




        pipapu.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                System.out.println("PipapuButton");
            }
        });

        houla.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                System.out.println("houlaButton");
            }
        });


        return t2spContent;


    }



}
