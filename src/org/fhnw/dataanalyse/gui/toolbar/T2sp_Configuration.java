package org.fhnw.dataanalyse.gui.toolbar;

import javafx.scene.control.ColorPicker;
import org.fhnw.dataanalyse.datamodell.DataModel;
import org.fhnw.dataanalyse.gui.GuiApp;
import org.fhnw.dataanalyse.gui.scatterplot.ScatterPlotPanel;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

/**
 * Created by Vallat on 19.05.2015.
 */
public class T2sp_Configuration extends JPanel {

    public T2sp_Configuration(DataModel dataModel, final GuiApp guiApp){
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
                guiApp.getScatterPlotPanel().colorChanged(color);
                revalidate();
                guiApp.repaint();
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

                revalidate();
                guiApp.repaint();
            }
        });

        ArrayList<String> dropDownList = new ArrayList<String>();
        int n = dataModel.getVariableList().size();
        for (int i = 0; i < n; i++) {
            dropDownList.add(dataModel.getVariableList().get(i).getName());
        }

        final JComboBox relativSizeValuesComB = new JComboBox();
        if (n == 0)  relativSizeValuesComB.addItem("-");

        else for (String s : dropDownList)
            relativSizeValuesComB.addItem(s);

        relativSizeValuesComB.setEnabled(false);

        relativSizeValuesComB.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                if ((e.getStateChange() == ItemEvent.SELECTED)) {
                    // dini methode G
                }
            }
        });

        final JCheckBox relSizeCB = new JCheckBox("Relativ Size");
        relSizeCB.setMnemonic(KeyEvent.VK_L);
        relSizeCB.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (relSizeCB.isSelected()){
                    slider.setEnabled(false);
                    relativSizeValuesComB.setEnabled(true);}

                else {
                    slider.setEnabled(true);
                    relativSizeValuesComB.setEnabled(false);
                }

                // dini methode G
            }
        });


        final JCheckBox linieCB = new JCheckBox("Draw Linie");
        linieCB.setMnemonic(KeyEvent.VK_L);
        linieCB.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                boolean isSelected = linieCB.isSelected();

                if (isSelected){
                    linieCB.setSelected(true);

                    guiApp.getScatterPlotPanel().setLineDrawingChecked(linieCB.isSelected());
                    guiApp.getScatterPlotPanel().actionPerformedUpdate("drawChecked");
                }
                else{
                    linieCB.setSelected(false);
                    guiApp.getScatterPlotPanel().setLineDrawingChecked(linieCB.isSelected());
                    guiApp.getScatterPlotPanel().actionPerformedUpdate("drawUnChecked");
                }

                revalidate();
                guiApp.repaint();
            }
        });


        add(selectColor);
        add(Box.createHorizontalGlue());
        add(slider);
        add(relSizeCB);
        add(relativSizeValuesComB);
        add(Box.createHorizontalGlue());
        add(linieCB);

    }








}

