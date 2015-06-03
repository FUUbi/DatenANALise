package org.fhnw.dataanalyse.datamodell;

import javax.swing.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ColumnVariableLoader implements IVariableLoader {
    @Override
    public DataModel loadVariable(File lineFormatedFile) {

        Scanner in;
        try {
            in = new Scanner(lineFormatedFile);
        } catch (FileNotFoundException e) {

            JOptionPane.showMessageDialog(null,
                    "Das Ausgewählte File kann nicht geöffnet werden",
                    "Fehler",
                    JOptionPane.ERROR_MESSAGE);
            return null;
        }

        ArrayList<Variable> variables = new ArrayList<Variable>();

        // Creates an object Variable with each varaible name
        // The first line contains the variable names
        for (String str : in.nextLine().split("\t")){
            variables.add(new Variable(str));
        }

        // for every line of the document the values in  collumn 0 are added to the
        // data of the variable 0, and so on.
        Integer row = 0;
        while (in.hasNextLine()){

            List<Double> values = getValue(in.nextLine(),row);

            for (int i = 0; i < variables.size(); i++){

                try {
                    variables.get(i).getData().add(values.get(i));

                }catch (Exception e){

                    JOptionPane.showMessageDialog(null,
                            "In der Zeile " + row.toString() + " fehlt ein Wert\n" +
                            "es wird 0.0 eingefuegt ",
                            "Fehler",
                            JOptionPane.WARNING_MESSAGE);

                    variables.get(i).getData().add(null);
                }
            }
        }

        in.close();
        return new DataModel(variables);
    }


    private ArrayList<Double> getValue(String str, Integer row){
        /**
         * converts the values found in the acctual line and returns them as float
         * if a value can not be parsed to a Float, the User gets a message in
         * witch collumn and row and that the value 0 (null) has been imported
         */
        ArrayList<Double> values = new ArrayList<Double>();

        Integer coulum = 0;
        for (String v : str.split("\t")){
            coulum++;

            try {
                values.add(Double.parseDouble(v));
            }catch(Exception e){
                JOptionPane.showMessageDialog(null,
                        "Der Wert " + v + " in Zeile " + row.toString() + " Spalte " + coulum.toString() + "\n" +
                                "kann nicht in eine Fliesskommazahl umgewandelt werden \n" +
                                "es wird 0.0 eingefuegt ",
                        "Fehler",
                        JOptionPane.WARNING_MESSAGE);

                values.add(null);

            }
        }

        return values;

    }
}

