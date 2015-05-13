package org.fhnw.dataanalyse.datamodell;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class ColumnVariableLoader implements IVariableLoader {
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

            for (int i = 0 ; i < variables.size(); i++){
                try {
                    variables.get(i).getData().add(in.nextFloat());

                }catch (Exception e){}
            }



        }
        in.close();
        return variables;
    }
}

