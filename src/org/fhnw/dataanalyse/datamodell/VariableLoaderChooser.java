package org.fhnw.dataanalyse.datamodell;

import javax.swing.*;
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
        } catch (FileNotFoundException e) {
            JOptionPane.showMessageDialog(null,
                    "Das Ausgewählte File kann nicht geöffnet werden",
                    "Fehler",
                    JOptionPane.ERROR_MESSAGE);
        }

        String lineOne = null;
        if (in != null) {
            lineOne = in.nextLine();
        }

        /* Check line one for Tab separated format */
        int tabs = 0;
        if (lineOne != null) {
            tabs = lineOne.length()-lineOne.replace("\t", "").length();
        }

        if (tabs >= 1) {
            if (in != null) {
                in.close();
            }

            loader = new ColumnVariableLoader();
        }

        else {
        /*  Check line one for an integer */
            try {
                Integer.parseInt(lineOne);
                in.close();
                loader = new RowVariableLoader();
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null,
                        "Das Format wird nicht unterstuezt",
                        "Format Fehler",
                        JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    /**
     * getLoader Method get the appropriate Loader for the variables
     * @return loader of Interface IVariableLoader Type
     */
    public IVariableLoader getLoader() {
        return loader;
    }
}
