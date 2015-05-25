package org.fhnw.dataanalyse.gui.toolbar;

import org.fhnw.dataanalyse.datamodell.DataModel;
import org.fhnw.dataanalyse.gui.GuiApp;
import org.fhnw.dataanalyse.gui.histogram.HistogramManager;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

/**
 * Created by Vallat on 20.05.2015.
 */

public class T2h_Configuration extends JPanel {
    JCheckBox hsito1CheckB = new JCheckBox();
    JCheckBox hsito2CheckB = new JCheckBox();
    DataModel dataModel;
    GuiApp guiApp;

    private int selectedVariableIndex1;
    private int selectedVariableIndex2;

    public T2h_Configuration(DataModel dataModel, final GuiApp guiApp) {

        setBorder(BorderFactory.createTitledBorder("Histogram"));


        this.dataModel = dataModel;
        this.guiApp = guiApp;

        hsito1CheckB.setMnemonic(KeyEvent.VK_L);
        hsito1CheckB.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                boolean checkBoxState =  hsito1CheckB.isSelected();
                guiApp.getHistogramManager().setHisto0State(checkBoxState);
                revalidate();
                guiApp.repaint();
            }
        });

        hsito2CheckB.setMnemonic(KeyEvent.VK_L);
        hsito2CheckB.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                boolean checkBoxState =  hsito2CheckB.isSelected();
                guiApp.getHistogramManager().setHisto1State(checkBoxState);
                revalidate();
                guiApp.repaint();
            }
        });

        add(hsito1CheckB);
        add(hsito2CheckB);

        setHisto1CheckBoxText();
        setHisto2CheckboxText();
        setVisible(true);


    }

    public void setHisto1CheckBoxText(){
        int index =   guiApp.getT1_configuration().getxAxisIndex();
        String histo1Text =  dataModel.getVariableList().get(index).getName();
        hsito1CheckB.setText(histo1Text);
    }

    public void setHisto2CheckboxText(){
        int index = guiApp.getT1_configuration().getyAxisIndex();
        String histo2Text =  dataModel.getVariableList().get(index).getName();
        hsito2CheckB.setText(histo2Text);
        System.out.println(histo2Text);
    }


    public JPanel getPanel(){
        return this;
    }

}
