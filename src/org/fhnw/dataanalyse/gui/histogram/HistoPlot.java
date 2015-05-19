package org.fhnw.dataanalyse.gui.histogram;

import org.fhnw.dataanalyse.datamodell.Variable;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

/**
 * Created by Fabrizio on 18.05.2015.
 */
public class HistoPlot extends JPanel{
    /* Number of Bins k */
    public Integer k;

    ArrayList<Float> intervals = new ArrayList<Float>();
    public   ArrayList<Float> relInterval = new ArrayList<Float>();
    ArrayList<Integer> absQuantaty = new ArrayList<Integer>();
    ArrayList<Float> relQuantity = new ArrayList<Float>();

    /* Numbers of values */
    Integer n;

    /* value Values: Index of selected Variable */
    Integer indexX = 1;

    /* values for value */
    ArrayList<Float> value;


    public HistoPlot(ArrayList<Variable> v){
        value = v.get(indexX).getData();

        n = value.size();

        k = (int) Math.sqrt(n);

        setIntervals();
        setQuantityPerInterval();

        System.out.println(intervals);
        System.out.println(relInterval);
        System.out.println(absQuantaty);
        System.out.println(relQuantity);

    }

    public void updateHistoData(ArrayList<Variable> v){
        value = v.get(indexX).getData();
        intervals.clear();
        relInterval.clear();
        absQuantaty.clear();
        relQuantity.clear();
        n = value.size();

        k = (int) Math.sqrt(n);
        setIntervals();
        setQuantityPerInterval();

        System.out.println(intervals);
        System.out.println(relInterval);
        System.out.println(absQuantaty);
        System.out.println(relQuantity);
    }

    @Override
    public void paintComponent(Graphics g) {

        int barWidth = getWidth() / k;
        for (int i = 0; i < k; i++) {

            int barHeight = (int) (relQuantity.get(i) * getHeight());

            int x = i * barWidth;
            int y = getHeight() - barHeight;

            g.setColor(Color.ORANGE);
            g.fillRect(x, y, barWidth, barHeight);
            g.setColor(Color.YELLOW);
            g.drawRect(x, y, barWidth, barHeight);
        }
    }

    private void setIntervals(){
        Float max = (float)0.0;
        for (Float f : value) if (f.compareTo(max) == 1) max = f;

        Float binWidth = max / k;
        for (int i = 0; i <= k; i++) intervals.add(i * binWidth);

        for (Float f : intervals) relInterval.add(f/intervals.get(intervals.size()-1));
    }

    private void setQuantityPerInterval(){
        for (int i = 0; i < k; i++){
            int counter = 0;
            for (Float aX : value) {
                if ((aX.compareTo(intervals.get(i)) == 0 &&  aX.compareTo(intervals.get(i)) == 1 ) ||
                        aX.compareTo(intervals.get(i+1)) == -1){
                    counter++;
                }
            }

            absQuantaty.add(counter);
        }

        for (Integer i : absQuantaty)   relQuantity.add((float)i / (float)n);
    }


    /* Diese Methoden nur falls mit DrawHisto

     */

    public int getNumbersOfBin(){
        return k;
    }

    public ArrayList<Float> getRelQuantity(){
        return relQuantity;
    }
}
