/**
 * Projekt: Dataanalyse, Programmieren II
 * $Header: $
 * Authors: F.Parrillo, S.Schneider, L.Vallat
 * Customers: R.Luethy, D.Brodbeck
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
     * Documentation of the main Class....ICH WART DO NO... =P
     * @param args pippo
     *
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
