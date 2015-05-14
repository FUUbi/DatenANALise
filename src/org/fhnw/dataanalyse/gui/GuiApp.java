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
 *
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
        GridBagConstraints contraints1;
        GridBagConstraints contraints2;
        Container surface = getContentPane();

        surface.setLayout(distributor);

        /*toolbar1 layout */
        contraints = new GridBagConstraints();
        contraints.gridx = 0;
        contraints.gridy = 0;
        contraints.gridwidth = width;
        contraints.gridheight = 10;
        contraints.fill = GridBagConstraints.HORIZONTAL;
        contraints.anchor = GridBagConstraints.FIRST_LINE_START;
        contraints.weightx =1;
        contraints.weighty =1;
        distributor.setConstraints(toolbar1, contraints);
        surface.add(toolbar1);
        toolbar1.setBackground(Color.blue);

        /*toolbar2 layout*/
        contraints1 = new GridBagConstraints();
        contraints1.gridx = 0;
        contraints1.gridy = 1;
        contraints1.gridwidth = width;
        contraints1.gridheight = 10;
        contraints1.fill = GridBagConstraints.HORIZONTAL;
        contraints1.anchor = GridBagConstraints.NORTH;
        distributor.setConstraints(toolbar2, contraints1);
        surface.add(toolbar2);
        toolbar2.setBackground(Color.darkGray);
        toolbar2.add(new Button());

        /*PlotingArea layout*/
        contraints2 = new GridBagConstraints();
        contraints2.gridx = 0;
        contraints2.gridy = 2;
        contraints2.gridwidth = width;
        contraints2.fill = GridBagConstraints.BOTH;
        contraints2.gridwidth = GridBagConstraints.REMAINDER;
        distributor.setConstraints(plotingArea, contraints2);
        surface.add(plotingArea);
        plotingArea.setBackground(Color.orange);

        plotingArea.add(new Button());


        setVisible(true);
    }

}
