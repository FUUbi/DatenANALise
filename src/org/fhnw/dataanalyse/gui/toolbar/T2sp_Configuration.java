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

    public T2sp_Configuration(DataModel dataModel, final ScatterPlotPanel scatterPlotPanel){
        //Dimension dimension =  Frame.getFrames()[0].getSize();
        //dimension.getWidth();

        setLayout(new BoxLayout(this, BoxLayout.LINE_AXIS));
        setBorder(BorderFactory.createTitledBorder("Scatter Plot"));


        JButton selectColor = new JButton("Change Color");
        selectColor.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Color color = JColorChooser.showDialog(
                        T2sp_Configuration.this,
                        "Change Scatterplot Color",
                        Color.blue);

                scatterPlotPanel.colorChanged(color);

            }
        });


        final Label accVal = new Label();
        final JSlider slider = new JSlider();

        slider.setMinimum(0);
        slider.setMaximum(80);
        slider.setMinorTickSpacing(5);
        slider.setMajorTickSpacing(10);
        slider.setPaintTicks(true);
        slider.setPaintLabels(true);
        slider.setSnapToTicks(true);
        slider.setValue(0);

        slider.addChangeListener(new ChangeListener() {
            public void stateChanged(ChangeEvent event) {
                accVal.setText("actual Value : " + ((JSlider) event.getSource()).getValue());
                slider.getValue(); //<-- din wert G
            }
        });


        final JCheckBox linieCB = new JCheckBox("Draw Linie");
        linieCB.setMnemonic(KeyEvent.VK_L);
        linieCB.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                linieCB.isSelected(); // git true / false <-- G methonde
            }
        });



        final JCheckBox relSizeCB = new JCheckBox("Relativ Size");
        relSizeCB.setMnemonic(KeyEvent.VK_L);
        relSizeCB.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               if (relSizeCB.isSelected()) slider.setEnabled(false);
                else slider.setEnabled(true);

                // dini methode G
            }
        });


        add(selectColor);
        add(Box.createHorizontalGlue());
        add(slider);
        add(relSizeCB);
        add(Box.createHorizontalGlue());
        add(linieCB);

    }








}

