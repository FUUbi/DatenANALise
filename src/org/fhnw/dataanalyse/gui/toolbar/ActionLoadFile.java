package org.fhnw.dataanalyse.gui.toolbar;

import org.fhnw.dataanalyse.datamodell.VariableContainer;
import org.fhnw.dataanalyse.gui.histogram.HistoPlot;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Fabrizio on 19.05.2015.
 */
public class ActionLoadFile  implements ActionListener{
    private VariableContainer variableContainer;
    private HistoPlot  histoPlot;

    public ActionLoadFile(VariableContainer variableContainer, HistoPlot histoPlot){
        this.variableContainer = variableContainer;
        this.histoPlot = histoPlot;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        variableContainer.chooseFile();
        variableContainer.loadVariables();
        histoPlot.updateHistoData(variableContainer.getVariables());
    }
}
