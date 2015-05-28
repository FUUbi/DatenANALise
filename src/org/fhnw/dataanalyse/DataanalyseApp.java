/**
 * Projekt: Dataanalyse, Programmieren II
 * $Header: $
 * Authors: F.Parrillo, S.Schneider, L.Vallat
 * Customers/Dozenten: R.Luethy, D.Brodbeck
 */

package org.fhnw.dataanalyse;

import org.fhnw.dataanalyse.datamodell.*;
import org.fhnw.dataanalyse.gui.GuiApp;
import org.fhnw.dataanalyse.gui.histogram.HistogramManager;
import org.fhnw.dataanalyse.gui.scatterplot.ScatterPlotPanel;
import java.io.File;

/**
 * DataanalyseApp contains the main Class
 */
public class DataanalyseApp {

    /**
     * the main Class provide a new File and the selected variables in it
     * Histogramm and ScatterPlot are created
     * the GUI is created and take all the necessary parameters created in the main
     */
    public static void main(String[] args){

        File file = new FileChooser().getNewFile();
        IVariableLoader loader = new VariableLoaderChooser(file).getLoader();
        DataModel dataModel =  loader.loadVariable(file);
        String  fileName = file.getName();

        HistogramManager histogramManager = new HistogramManager(dataModel);

        ScatterPlotPanel scatterPlotPanel = new ScatterPlotPanel(dataModel);

        new GuiApp(dataModel, histogramManager, scatterPlotPanel, fileName);
    }
}
