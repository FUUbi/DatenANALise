package org.fhnw.dataanalyse.datamodell;

import javax.swing.*;
import javax.swing.text.Segment;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class RowVariableLoader implements IVariableLoader {
    Scanner in;
    @Override
    public DataModel loadVariable(File rowFormatedFile) {


        ArrayList<Variable> variables = new ArrayList<Variable>();
        testNumberOfLines(rowFormatedFile);
        setIn(rowFormatedFile);

        int nVariable = Integer.parseInt(in.nextLine());

        // Creates an object Variable with each variable name
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

                int acctualValue = 0;
                for (String v: values){
                    try {
                        variables.get(n).getData().add(Double.parseDouble(v));
                        acctualValue++;
                    }catch (Exception e){
                        JOptionPane.showMessageDialog(null,
                                "Der "  + String.valueOf(acctualValue) +". Wert " + v + " der Variable" + String.valueOf(n) + "\n" +
                                        "kann nicht in eine Fliesskommazahl umgewandelt werden \n" +
                                        "es wird 0.0 eingefuegt ",
                                "Fehler",
                                JOptionPane.WARNING_MESSAGE);

                        variables.get(n).getData().add(0.d);
                    }
                }

            }

        }
        return new DataModel(variables);
    }

    public void setIn(File rowFormatedFile) {
        try {
            in = new Scanner(rowFormatedFile);
        } catch (FileNotFoundException e) {
            JOptionPane.showMessageDialog(null,
                    "Das Ausgew�hlte File kann nicht ge�ffnet werden",
                    "Fehler",
                    JOptionPane.ERROR_MESSAGE);
            System.exit(0);
        }
    }

    private void testNumberOfLines(File rowFormatedFile){
        setIn(rowFormatedFile);
        //First line of the file contains the information of the amount of variables
        int nVariable = Integer.parseInt(in.nextLine());

        int expectedLines = nVariable * 2 + 2;
        int lines = 1;
        int separatorLine = nVariable + 1;
        String separator = ";";
        while (in.hasNextLine()){
            String input=  in.nextLine();

            if(separatorLine == lines) {
                separator = input;
            }
            lines++;
        }

        if(expectedLines != lines){
            JOptionPane.showMessageDialog(null,
                    "Anzahl Variablen stimmt nicht mit Anzahl Zeilen �berein!",
                    "Fehler",
                    JOptionPane.ERROR_MESSAGE);
            System.exit(0);
        }

        if (separator.length() != 1){
            JOptionPane.showMessageDialog(null,
                    "Der Separator darf nur aus einem Zeichen bestehen!",
                    "Fehler",
                    JOptionPane.ERROR_MESSAGE);
            System.exit(0);
        }

        in.close();


    }
}

