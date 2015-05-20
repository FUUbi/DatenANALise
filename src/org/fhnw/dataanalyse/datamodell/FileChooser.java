package org.fhnw.dataanalyse.datamodell;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.io.File;

/**
 * Created by Fabrizio on 20.05.2015.
 */
public class FileChooser {

    public File getNewFile(){

        JFileChooser chooser = new JFileChooser(System.getProperty("user.dir"));
        chooser.setAcceptAllFileFilterUsed(false);
        chooser.setFileFilter(new FileNameExtensionFilter("Textfile", "txt"));
        chooser.showOpenDialog(null);

        return chooser.getSelectedFile();

    }

}
