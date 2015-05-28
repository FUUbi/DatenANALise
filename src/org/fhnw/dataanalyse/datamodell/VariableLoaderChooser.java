package org.fhnw.dataanalyse.datamodell;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * VariableLoaderChooser contains the VariableLoaderChooser Method and the getLoader Method
 */
public class VariableLoaderChooser {

    private IVariableLoader loader;

    /**
     * VariableLoaderChooser checks the format of the selected file and provides the right loader to select variables
     * the loader is not know yet, that is why it has the Interface Type IVariableLoader
     * @param file of File Type
     * @see   public Class File
     */
    public VariableLoaderChooser(File file){

        Scanner in = null;

        /* Check if there is a document */
        try {
            in = new Scanner(file);
        } catch (FileNotFoundException e) {/*Notification*/}

        String lineOne = in.nextLine();

        /* Check line one for Tab separated format */
        int tabs = lineOne.length()-lineOne.replace("\t", "").length();
        if (tabs >= 1) {
            in.close();
            loader = new ColumnVariableLoader();
        }

        /*  Check line one for an integer */
        /* (row formated files got an Integer on the first line) */
        try{Integer.parseInt(lineOne);
            in.close();
            loader = new RowVariableLoader();
        }catch(Exception e){/*Notification*/}
    }

    /**
     * getLoader Method get the appropriate Loader for the variables
     * @return loader of Interface IVariableLoader Type
     */
    public IVariableLoader getLoader() {
        return loader;
    }
}
