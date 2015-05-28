package org.fhnw.dataanalyse.datamodell;

import java.util.ArrayList;

/**
 *
 */

public class DataModel {

    private ArrayList<Variable> variableList;

    public DataModel(ArrayList<Variable> variableList){
        this.variableList = variableList;
    }

    public ArrayList<Variable> getVariableList() {
        return variableList;
    }
}
