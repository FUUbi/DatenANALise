package org.fhnw.dataanalyse.datamodell;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

   /**
    * Created by Fabrizio on 12.05.2015.
    *
    */

    public class VariableContainer {
    /**
     * VariableContainer:
     *  document: File chosen by the user
     *  variables: store for the imported variable
     *
     *  @return the Array variables with the imported varable
     */

       File document = null;
       ArrayList<Variable> variables = null;
       IVariableLoader loader = null;


       public void chooseFile(){

           JFileChooser chooser = new JFileChooser(System.getProperty("user.dir"));
           chooser.setAcceptAllFileFilterUsed(false);
           chooser.setFileFilter(new FileNameExtensionFilter("Textfile", "txt"));
           chooser.showOpenDialog(null);

           document = chooser.getSelectedFile();

       }

       public void loadVariables(){
        // java.lang.NullPointerException muss noch hinzugefügt werden

           loader = getLoader();
           variables  = loader.loadVariable(document);
       }





       public ArrayList<Variable> getVariables(){
        return variables;

    }


       private IVariableLoader getLoader(){
           // Check the format of the file and get the right loader
           Scanner in = null;

           // Check if there is a document
           try {
               in = new Scanner(document);
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
