package org.fhnw.dataanalyse.datamodell;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Fabrizio on 20.05.2015.
 */
public class DataModel {
    ArrayList<Variable> variableList;

    public DataModel(ArrayList<Variable> variableList){
        this.variableList = variableList;
    }

    public ArrayList<Variable> getVariableList() {
        return variableList;
    }


}
