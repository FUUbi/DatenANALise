package org.fhnw.dataanalyse.datamodell;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class RowVariableLoader implements IVariableLoader {
    @Override
    public DataModel loadVariable(File rowFormatedFile) {

        Scanner in = null;
        try {
            in = new Scanner(rowFormatedFile);
        } catch (FileNotFoundException e) {
            return null;
        }

        ArrayList<Variable> variables = new ArrayList<Variable>();

        //First line of the file contains the information of the amount of variables
        int nVariable = Integer.parseInt(in.nextLine());

        // Creates an object Variable with each varaible name
        for (int n = nVariable; n > 0; n--){
            variables.add(new Variable(in.nextLine()));
        }

        // The next line contains the character who separates the values
        String separator = in.nextLine();

        // Import all the values and add them to the variable created before
        // in the Array data
        while (in.hasNextLine()){
            for (int n = 0; n < nVariable; n++){
                String variableValues = in.nextLine();

                String[] values = variableValues.split(separator);

                for (String v: values){
                  variables.get(n).getData().add(Float.parseFloat(v));
                }

            }

        }
        return new DataModel(variables);
    }
}

