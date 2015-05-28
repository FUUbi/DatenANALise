package org.fhnw.dataanalyse.datamodell;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.io.File;

/**
 * FileChooser contains the getNewFile() method
 */
public class FileChooser {

    /**
     * getNewFile provides a Chooser which select the desired file
     * the file has to ended with .txt
     * @return the selected file
     */
    public File getNewFile(){

        JFileChooser chooser = new JFileChooser(System.getProperty("user.dir"));
        chooser.setAcceptAllFileFilterUsed(false);
        chooser.setFileFilter(new FileNameExtensionFilter("Textfile", "txt"));
        chooser.showOpenDialog(null);

        return chooser.getSelectedFile();

    }
}
