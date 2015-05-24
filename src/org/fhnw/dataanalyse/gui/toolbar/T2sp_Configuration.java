package org.fhnw.dataanalyse.gui.toolbar;

import javafx.scene.control.ColorPicker;
import org.fhnw.dataanalyse.datamodell.DataModel;
import org.fhnw.dataanalyse.gui.GuiApp;
import org.fhnw.dataanalyse.gui.scatterplot.ScatterPlotPanel;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

/**
 * Created by Vallat on 19.05.2015.
 */
public class T2sp_Configuration extends JPanel {

    JPanel panel2;
    JButton selectColor;
    JSlider slider;
    JLabel label;
    JCheckBox linieCB;


    public T2sp_Configuration(DataModel dataModel, final ScatterPlotPanel scatterPlotPanel){
        //Dimension dimension =  Frame.getFrames()[0].getSize();
        //dimension.getWidth();


        setLayout(new BoxLayout(this, BoxLayout.LINE_AXIS));

        label = new JLabel();
        linieCB = new JCheckBox("Linie");
        linieCB.setMnemonic(KeyEvent.VK_L);

        selectColor = new JButton("Select Color");
        slider = new JSlider();

        slider.setMinimum(0);
        slider.setMaximum(80);
        slider.setMinorTickSpacing(5);
        slider.setMajorTickSpacing(10);
        slider.setPaintTicks(true);
        slider.setPaintLabels(true);
        slider.setValue(0);

        add(selectColor);
        add(Box.createHorizontalGlue());
        add(slider);
        add(label);
        add(Box.createHorizontalGlue());
        add(linieCB);

       final JColorChooser colorChooser1 = new JColorChooser();
        colorChooser1.getColor();

        Color color;

        selectColor.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent
                                                e) {
            }
        });

        linieCB.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                boolean isSelected = linieCB.isSelected();

                if (isSelected){
                    linieCB.setSelected(true);
                    scatterPlotPanel.setLineDrawingChecked(linieCB.isSelected());
                    scatterPlotPanel.actionPerformedUpdate("drawChecked");
                }
                else{
                    linieCB.setSelected(false);
                    scatterPlotPanel.setLineDrawingChecked(linieCB.isSelected());
                    scatterPlotPanel.actionPerformedUpdate("drawUnChecked");
                }
            }
        });

        slider.addChangeListener(new ChangeListener() {
            public void stateChanged(ChangeEvent event) {
                label.setText("actual Value : " + ((JSlider) event.getSource()).getValue());
            }
        });




    }

    public JPanel getPanel2(){
        return panel2;
    }







}

