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
public class VariableLoaderChooser {
    private IVariableLoader loader;

    
    public VariableLoaderChooser(File file){

        // Check the format of the file and get the right loader
        Scanner in = null;

        // Check if there is a document
        try {
            in = new Scanner(file);
        } catch (FileNotFoundException e) {
            //meldung
        }

        String lineOne = in.nextLine();

        // Check line one for Tab separated format
        int tabs = lineOne.length()-lineOne.replace("\t", "").length();
        if (tabs >= 1) {
            in.close();
            loader = new ColumnVariableLoader();
        }

        //         Check line one for an integer
        // (row formated files got an Integer on the first line)
        try{Integer.parseInt(lineOne);
            in.close();
            loader = new RowVariableLoader();
        }catch(Exception e){
            //meludng
        }


    }

    public IVariableLoader getLoader() {
        return loader;
    }
}
