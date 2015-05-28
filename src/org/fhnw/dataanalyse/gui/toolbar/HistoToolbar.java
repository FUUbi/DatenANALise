package org.fhnw.dataanalyse.gui.toolbar;

import org.fhnw.dataanalyse.datamodell.DataModel;
import org.fhnw.dataanalyse.gui.GuiApp;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

/**
 * HistoToolbar Class contains the Method HistoToolbar which provides the content of toolbar2_right
 * @see GuiApp
 * HistoToolbar Class also contains setHisto1CheckBoxText(), setHisto2CheckboxText() and getPanel()
 */
public class HistoToolbar extends JPanel {

    private JCheckBox histo1CheckB = new JCheckBox();
    private JCheckBox histo2CheckB = new JCheckBox();
    private DataModel dataModel;
    private GuiApp guiApp;


    /**
     * HistoToolbar provides all elements required on this toolbar and them ActionListeners
     * @param dataModel
     * @param guiApp
     */
    public HistoToolbar(DataModel dataModel, final GuiApp guiApp) {

        this.dataModel = dataModel;
        this.guiApp = guiApp;

        setBorder(BorderFactory.createTitledBorder("Histogram"));
        /* CheckBox 1*/
        histo1CheckB.setMnemonic(KeyEvent.VK_L);
        histo1CheckB.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                boolean checkBoxState = histo1CheckB.isSelected();
                guiApp.getHistogramManager().setHisto0State(checkBoxState);
                revalidate();
                guiApp.repaint();
            }
        });

        /* CheckBox 2*/
        histo2CheckB.setMnemonic(KeyEvent.VK_L);
        histo2CheckB.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                boolean checkBoxState = histo2CheckB.isSelected();
                guiApp.getHistogramManager().setHisto1State(checkBoxState);
                revalidate();
                guiApp.repaint();
            }
        });

        add(histo1CheckB);
        add(histo2CheckB);

        setHisto1CheckBoxText();
        setHisto2CheckboxText();
        setVisible(true);
    }

    public void setHisto1CheckBoxText(){
        int index =   guiApp.getMenuToolbar().getxAxisIndex();
        String histo1Text =  dataModel.getVariableList().get(index).getName();
        histo1CheckB.setText(histo1Text);
    }

    public void setHisto2CheckboxText(){
        int index = guiApp.getMenuToolbar().getyAxisIndex();
        String histo2Text =  dataModel.getVariableList().get(index).getName();
        histo2CheckB.setText(histo2Text);
        System.out.println(histo2Text);
    }

    public JPanel getPanel(){
        return this;
    }

}
