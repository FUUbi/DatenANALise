package org.fhnw.dataanalyse.gui.toolbar;

import org.fhnw.dataanalyse.datamodell.DataModel;
import org.fhnw.dataanalyse.gui.GuiApp;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

/**
 * Created by Vallat on 19.05.2015.
 */
public class ScatterPlotToolbar extends JPanel {

    int dimensionData;
    boolean relativeSize = false;

    public ScatterPlotToolbar(DataModel dataModel, final GuiApp guiApp){
        //Dimension dimension =  Frame.getFrames()[0].getSize();
        //dimension.getWidth();

        setLayout(new BoxLayout(this, BoxLayout.LINE_AXIS));
        setBorder(BorderFactory.createTitledBorder("Scatter Plot"));


        JButton selectColor = new JButton("Change Color");
        selectColor.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Color color = JColorChooser.showDialog(
                        ScatterPlotToolbar.this,
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
                dimensionData = slider.getValue(); //<-- din wert G
                relativeSize = false;
                guiApp.getScatterPlotPanel().setDiameter(dimensionData,relativeSize);
                guiApp.getScatterPlotPanel().actionPerformedUpdate("sliderValue");

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

                dimensionData = relativSizeValuesComB.getSelectedIndex();
                if ((e.getStateChange() == ItemEvent.SELECTED)) {
                    relativeSize = true;
                    guiApp.getScatterPlotPanel().setSelectedVariableIndex3(dimensionData,relativeSize);
                    guiApp.getScatterPlotPanel().actionPerformedUpdate("cbx3Change");
                }
                revalidate();
                guiApp.repaint();
            }
        });

        final JCheckBox relSizeCB = new JCheckBox("Relativ Size");
        relSizeCB.setMnemonic(KeyEvent.VK_L);
        relSizeCB.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (relSizeCB.isSelected()){
                    slider.setEnabled(false);
                    relativSizeValuesComB.setEnabled(true);
                }

                else {
                    slider.setEnabled(true);
                    relativSizeValuesComB.setEnabled(false);
                }
                revalidate();
                guiApp.repaint();


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

