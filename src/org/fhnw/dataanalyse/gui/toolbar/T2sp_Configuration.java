package org.fhnw.dataanalyse.gui.toolbar;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

/**
 * Created by Vallat on 19.05.2015.
 */
public class T2sp_Configuration {

    JPanel panel2;
    JButton pipapu;
    JSlider slider;
    JLabel label;
    JCheckBox linieCB;

    public T2sp_Configuration()

    {
        panel2 = new JPanel();
        panel2.setLayout(new BoxLayout(panel2, BoxLayout.LINE_AXIS));
        label = new JLabel();
        linieCB = new JCheckBox("Linie");
        linieCB.setMnemonic(KeyEvent.VK_V);


        pipapu = new JButton("Pipau");
        slider = new JSlider();

        slider.setMinimum(0);
        slider.setMaximum(80);
        slider.setMinorTickSpacing(1);
        slider.setMajorTickSpacing(5);
        slider.setPaintTicks(true);
        slider.setPaintLabels(true);
        slider.setValue(0);


        panel2.add(pipapu);
       // panel2.add(Box.createHorizontalGlue());
        panel2.add(slider);

/*        pipapu.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("pipapu");
            }
        });

        slider.addChangeListener(new ChangeListener() {
            public void stateChanged(ChangeEvent event) {
                label.setText("actual Value : " + ((JSlider) event.getSource()).getValue());
            }
        });
*/

    }

    public JPanel getPanel2(){
        return panel2;
    }


}

