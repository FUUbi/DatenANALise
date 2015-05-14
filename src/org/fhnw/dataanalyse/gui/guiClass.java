package org.fhnw.dataanalyse.gui;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.CompoundBorder;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.util.concurrent.atomic.AtomicReference;
import static javax.swing.JPanel.*;
import java.awt.Color;
import java.awt.Container;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;

/**
 * Created by Vallat on 14.05.2015.
 */
public class GuiApp  extends JFrame{

    /*Get Dimension of the Desktop*/
    Toolkit toolkit =  Toolkit.getDefaultToolkit ();
    Dimension dim = toolkit.getScreenSize();

    JPanel toolbar1 = new JPanel();
    JPanel toolbar2 = new JPanel();
    JPanel plotingArea = new JPanel();


    public GuiApp() {

    /* Frame Initialisaton*/
        setTitle("Dataanalyse");
        int height = dim.height;
        int width = dim.width;
        setSize(width, height);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

    /*Layout*/
        GridBagLayout distributor = new GridBagLayout();
        GridBagConstraints contraints;
        Container surface = getContentPane();

        surface.setLayout(distributor);
        /*toolbar1 layout */
        contraints = new GridBagConstraints();
        contraints.gridx = 0;
        contraints.gridy = 0;
        contraints.gridwidth = width;
        contraints.gridheight = 1;
        contraints.fill = GridBagConstraints.HORIZONTAL;
        contraints.anchor = GridBagConstraints.FIRST_LINE_START;
        contraints.weightx =1;
        contraints.weighty =1;
        distributor.setConstraints(toolbar1, contraints);
        surface.add(toolbar1);
        toolbar1.setBackground(Color.blue);

        /*toolbar2 layout*/
        contraints = new GridBagConstraints();
        contraints.gridx = 0;
        contraints.gridy = 1;
        contraints.gridwidth = width;
        contraints.gridheight = 10;
        contraints.fill = GridBagConstraints.HORIZONTAL;
        contraints.anchor = GridBagConstraints.NORTH;
        distributor.setConstraints(toolbar2, contraints);
        surface.add(toolbar2);
        toolbar2.setBackground(Color.darkGray);

        /*PlotingArea layout*/
        contraints = new GridBagConstraints();
        contraints.gridx = 0;
        contraints.gridy = 2;
        contraints.gridwidth = width;
        contraints.fill = GridBagConstraints.BOTH;
        contraints.gridwidth = GridBagConstraints.REMAINDER;
        distributor.setConstraints(plotingArea, contraints);
        surface.add(plotingArea);
        plotingArea.setBackground(Color.orange);


        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new GuiApp().setVisible(true);
            }
        });
    }


}
