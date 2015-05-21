package org.fhnw.dataanalyse.datamodell;

import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by Fabrizio on 20.05.2015.
 *
 */
public class VariableLoader {
    // IVariableLoader loader = null;
        File file;

    
    public  VariableLoader(File file){
        this.file = file;
    }


    public IVariableLoader loadVariables(){
        // java.lang.NullPointerException muss noch hinzugefügt werden



        return getLoader(file);

    }


    private IVariableLoader getLoader(File file){
        // Check the format of the file and get the right loader
        Scanner in = null;

        // Check if there is a document
        try {
            in = new Scanner(file);
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




}
