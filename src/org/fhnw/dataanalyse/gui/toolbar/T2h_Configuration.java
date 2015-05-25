package org.fhnw.dataanalyse.gui.toolbar;

import org.fhnw.dataanalyse.datamodell.DataModel;
import org.fhnw.dataanalyse.gui.histogram.HistogramManager;
import org.fhnw.dataanalyse.gui.scatterplot.ScatterPlotPanel;

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

public class T2h_Configuration extends JPanel {
    JCheckBox hsito1CheckB = new JCheckBox();
    JCheckBox hsito2CheckB = new JCheckBox();
    DataModel dataModel;

    private int selectedVariableIndex1;
    private int selectedVariableIndex2;

    public T2h_Configuration(DataModel dataModel, final HistogramManager histogramManager) {
        setBorder(BorderFactory.createTitledBorder("Histogram"));


        this.dataModel = dataModel;


        hsito1CheckB.setMnemonic(KeyEvent.VK_L);
        hsito1CheckB.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                hsito1CheckB.isSelected();
            }
        });

        hsito2CheckB.setMnemonic(KeyEvent.VK_L);
        hsito2CheckB.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                hsito2CheckB.isSelected();
            }
        });

        add(hsito2CheckB);
        add(hsito1CheckB);

        updateHisto1(0);
        updateHisto2(0);

        setVisible(true);


    }

    public void updateHisto1(int selectedVariableIndex1){
        String histo1Text =  dataModel.getVariableList().get(selectedVariableIndex1).getName();
        hsito1CheckB.setText(histo1Text);
    }

    public void updateHisto2(int selectedVariableIndex2){
        String histo2Text =  dataModel.getVariableList().get(selectedVariableIndex2).getName();
        hsito2CheckB.setText(histo2Text);
    }


    public JPanel getPanel(){
        return this;
    }

}
