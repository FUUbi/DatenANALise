package org.fhnw.dataanalyse.datamodell;

import javax.swing.*;

/**
 *
 * Created by Fabrizio on 17.05.2015.
 */
public class ValueError {
    public void ValueError() {
        System.out.println("ksdfklsfk");

        JOptionPane.showMessageDialog(null,
                "Sie haben 3x convertiert \n" +
                        "Starten sie die App neu",
                "Fehler",
                JOptionPane.WARNING_MESSAGE);
    }


}
