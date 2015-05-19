package org.fhnw.dataanalyse.gui.toolbar;

import org.fhnw.dataanalyse.datamodell.VariableContainer;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Fabrizio on 19.05.2015.
 */
public class ActionLoadFile extends VariableContainer implements ActionListener {

    @Override
    public void actionPerformed(ActionEvent test) {
        chooseFile();

    }
}
