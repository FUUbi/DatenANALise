package org.fhnw.dataanalyse.datamodell;

import java.util.ArrayList;

/**
 * DataModel contains variableList and getVariableList
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
