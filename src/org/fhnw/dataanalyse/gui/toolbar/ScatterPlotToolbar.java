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
 * ScatterPlotToolbar Class contains ScatterPlotToolbar Method which provides the content of toolbar2_left
 * @see GuiApp
 */

public class ScatterPlotToolbar extends JPanel {

    private int diameterSize;
    private boolean relativeSize = false;
    private Color bgColor = Color.white;


    /**
     * ScatterPlotToolbar provides all elements required on this toolbar and them ActionListeners
     * @param dataModel
     * @param guiApp
     */
    public ScatterPlotToolbar(DataModel dataModel, final GuiApp guiApp){

        setLayout(new BoxLayout(this, BoxLayout.LINE_AXIS));
        setBorder(BorderFactory.createTitledBorder("Scatter Plot"));


        /*Change Color*/
        JButton selectColor = new JButton("Change Color");
        selectColor.setBackground(bgColor);
        selectColor.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Color color = JColorChooser.showDialog(
                        ScatterPlotToolbar.this,
                        "Change Scatterplot Color",
                        Color.blue);
                guiApp.getScatterPlotPanel().changeColor(color);
                revalidate();
                guiApp.repaint();
            }
        });


        /*Slider */
        final Label accVal = new Label();
        accVal.setBackground(bgColor);

        final JSlider slider = new JSlider();
        slider.setBackground(bgColor);

        slider.setMinimum(0);
        slider.setMaximum(80);
        slider.setMinorTickSpacing(5);
        slider.setMajorTickSpacing(10);
        slider.setPaintTicks(true);
        slider.setPaintLabels(true);
        slider.setSnapToTicks(true);
        slider.setValue(10);

        slider.addChangeListener(new ChangeListener() {
            public void stateChanged(ChangeEvent event) {
                accVal.setText("actual Value : " + ((JSlider) event.getSource()).getValue());
                diameterSize = slider.getValue();
                relativeSize = false;
                guiApp.getScatterPlotPanel().setRelativeDiameter(diameterSize, relativeSize);
                guiApp.getScatterPlotPanel().actionPerformedUpdate("sliderValue");

                revalidate();
                guiApp.repaint();
            }
        });

        /* Plot data*/
        diameterSize = slider.getValue();
        relativeSize = false;
        guiApp.getScatterPlotPanel().setRelativeDiameter(diameterSize, relativeSize);
        guiApp.getScatterPlotPanel().actionPerformedUpdate("sliderValue");



        /* DropDownList containing variables for the ComboBox relativeSize */
        ArrayList<String> dropDownList = new ArrayList<String>();
        int n = dataModel.getVariableList().size();
        for (int i = 0; i < n; i++) {
            dropDownList.add(dataModel.getVariableList().get(i).getName());
        }

        final JComboBox relativeSizeValuesComb = new JComboBox();
        relativeSizeValuesComb.setBackground(bgColor);

        if (n == 0)  relativeSizeValuesComb.addItem("-");
        else for (String s : dropDownList)
            relativeSizeValuesComb.addItem(s);
        relativeSizeValuesComb.setEnabled(false);


        relativeSizeValuesComb.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {

                int index = relativeSizeValuesComb.getSelectedIndex();
                if ((e.getStateChange() == ItemEvent.SELECTED)) {
                    relativeSize = true;
                    guiApp.getScatterPlotPanel().setSelectedVariableIndex3(index, relativeSize);
                    guiApp.getScatterPlotPanel().actionPerformedUpdate("cbx3Change");


                }
                revalidate();
                guiApp.repaint();
            }
        });

        /*CheckBox Relative Size in Relation with the ComboBox relativeSizeValuesComb */
        final JCheckBox relSizeCB = new JCheckBox("Relative Size");
        relSizeCB.setBackground(bgColor);
        relSizeCB.setMnemonic(KeyEvent.VK_L);
        relSizeCB.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (relSizeCB.isSelected()){
                    slider.setEnabled(false);
                    relativeSizeValuesComb.setEnabled(true);
                    relativeSize = true;
                    guiApp.getScatterPlotPanel().setSelectedVariableIndex3(relativeSizeValuesComb.getSelectedIndex(),relativeSize);
                    guiApp.getScatterPlotPanel().actionPerformedUpdate("relativeValue");

                }

                else {
                    slider.setEnabled(true);
                    relativeSizeValuesComb.setEnabled(false);
                    relativeSize = false;
                    guiApp.getScatterPlotPanel().setSliderDiameter(relativeSize);
                    guiApp.getScatterPlotPanel().actionPerformedUpdate("sliderValue");

                }
                revalidate();
                guiApp.repaint();



            }
        });


        /*CheckBox Draw Line */
        final JCheckBox linieCB = new JCheckBox("Draw Line");
        linieCB.setBackground(bgColor);
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
        add(relativeSizeValuesComb);
        add(Box.createHorizontalGlue());
        add(linieCB);


    }

}

