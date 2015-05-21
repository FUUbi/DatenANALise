package org.fhnw.dataanalyse.gui.toolbar;

import org.fhnw.dataanalyse.datamodell.FileChooser;
import org.fhnw.dataanalyse.datamodell.IVariableLoader;
import org.fhnw.dataanalyse.datamodell.DataModel;
import org.fhnw.dataanalyse.datamodell.VariableLoader;
import org.fhnw.dataanalyse.gui.histogram.HistoPlot;
import org.fhnw.dataanalyse.gui.scatterplot.ScatterPlotPanel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

/**
 * Created by Fabrizio on 19.05.2015.
 */
public class ActionLoadFile  implements ActionListener{
    private final ScatterPlotPanel splot;
    private DataModel dataModel;
    private HistoPlot  histoPlot;


    public ActionLoadFile(DataModel dataModel, HistoPlot histoPlot, ScatterPlotPanel splot){
        this.dataModel = dataModel;
        this.histoPlot = histoPlot;
        this.splot = splot;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        //dataModel.setVariableList(new VariableLoader(new FileChooser().getNewFile()).loadVariables());
        File file = new FileChooser().getNewFile();
        IVariableLoader loader = new VariableLoader(file).loadVariables();
        dataModel =  loader.loadVariable(file);


        histoPlot.updateHistoData(dataModel.getVariableList());
        splot.updateScatterPlot(dataModel.getVariableList());

    }
}
