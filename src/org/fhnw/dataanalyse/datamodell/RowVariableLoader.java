package org.fhnw.dataanalyse.datamodell;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class RowVariableLoader implements IVariableLoader {
    @Override
    public ArrayList<Variable> loadVariable(File lineFormatedFile) {

        Scanner in = null;
        try {
            in = new Scanner(lineFormatedFile);
        } catch (FileNotFoundException e) {
            return null;
        }

         ArrayList<Variable> variables = new ArrayList<Variable>();
        for (String str : in.nextLine().split("\t")){
            variables.add(new Variable(str));
        }

        while (in.hasNextLine()){
            for (int i = variables.size(); i == 0; i--){
                System.out.println(i);
            }
            String lineN = in.nextLine();
            for (Variable v: variables){

            }
        }
        return variables;
    }
}

