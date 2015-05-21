package org.fhnw.dataanalyse.gui.toolbar;

import org.fhnw.dataanalyse.datamodell.FileChooser;
import org.fhnw.dataanalyse.datamodell.IVariableLoader;
import org.fhnw.dataanalyse.datamodell.DataModel;
import org.fhnw.dataanalyse.datamodell.VariableLoader;
import org.fhnw.dataanalyse.gui.scatterplot.ScatterPlotPanel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

/**
 * Created by Fabrizio on 19.05.2015.
 */
public class ActionLoadFile  implements ActionListener{
    final ScatterPlotPanel splot;
    DataModel dataModel;

    public ActionLoadFile(DataModel dataModel,  ScatterPlotPanel splot){
        this.dataModel = dataModel;
        this.splot = splot;

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        //dataModel.setVariableList(new VariableLoader(new FileChooser().getNewFile()).loadVariables());
        File file = new FileChooser().getNewFile();
        IVariableLoader loader = new VariableLoader(file).loadVariables();
        dataModel =  loader.loadVariable(file);



        splot.updateScatterPlot(dataModel.getVariableList());

    }
}
