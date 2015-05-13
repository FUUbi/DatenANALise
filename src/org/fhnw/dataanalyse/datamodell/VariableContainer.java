package org.fhnw.dataanalyse.datamodell;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

/**
    * Created by Fabrizio on 12.05.2015.
            *
            */
    public class VariableContainer {
    File document;
    ArrayList<Variable> variables = null;
    IVariableLoader loader = null;
    public VariableContainer(){
        document = new File("Spalten-Orientiert.txt");
    }

    public void loadVariables(){
        // java.lang.NullPointerException muss noch hinzugefügt werden
        loader = getLoader();
        variables  = loader.loadVariable(document);
    }

    private IVariableLoader getLoader(){
        Scanner in = null;

        try {
            in = new Scanner(document);
        } catch (FileNotFoundException e) {
            return null;
        }
        String lineOne = in.nextLine();

        int tabs = lineOne.length()-lineOne.replace("\t", "").length();
        if (tabs >= 1) {
            in.close();
            return new ColumnVariableLoader();
        }

        try{Integer.parseInt(lineOne);
            in.close();
            return new ColumnVariableLoader();
        }catch(Exception e){}

        return null;
    }

    public ArrayList<Variable> getVariables(){
        return variables;

    }


}
