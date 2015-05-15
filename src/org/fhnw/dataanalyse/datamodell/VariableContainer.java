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
    /**
     * VariableContainer:
     *  document: File chosen by the user
     *  variables: store for the imported variable
     *
     *  @return the Array variables with the imported varable
     */

    File document;
    ArrayList<Variable> variables = null;
    IVariableLoader loader = null;

    public VariableContainer(){
        document = new File("Zeilen-Orientiert.txt");
    }

    public void loadVariables(){
        // java.lang.NullPointerException muss noch hinzugefügt werden

        loader = getLoader();
        variables  = loader.loadVariable(document);
    }

    private IVariableLoader getLoader(){
        // Check the format of the file and get the right loader
        Scanner in = null;

        // Check if there is a document
        try {
            in = new Scanner(document);
        } catch (FileNotFoundException e) {
            return null;
        }

        String lineOne = in.nextLine();

        // Check line one for Tab separated format
        int tabs = lineOne.length()-lineOne.replace("\t", "").length();
        if (tabs >= 1) {
            in.close();
            return new ColumnVariableLoader();
        }

        // Check line one for an integer
        // (row formated files got an Integer on the first line)
        try{Integer.parseInt(lineOne);
            in.close();
            return new RowVariableLoader();
        }catch(Exception e){}

        return null;
    }

    public ArrayList<Variable> getVariables(){
        return variables;

    }


}
