package org.fhnw.dataanalyse.histogramdata;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * BinRanges contains setBinRanges() Method and getBinRanges()
 */

public class BinRanges {

    private int k;
    private int n;
    private ArrayList<Double> binRanges = new ArrayList<Double>();


    public void setBinRanges(ArrayList<Double> data){
        
        binRanges.clear();
        n = data.size();

        // set numbers of Bins k
        // Square-root choice if n < 30 otherwise Struges's formula
        if (n < 30) k = (int) Math.sqrt(n);
            else    k = (int) (1 + Math.log(n) / Math.log(2));
       
        double max = data.get(0);
        for (Double d : data) if (d.compareTo(max) == 1) max = d;

        double min = data.get(0);
        for (Double d : data) if (d.compareTo(min) == -1) min = d;

        double binWidth = (Math.abs(min) + Math.abs(max)) / k;

        for (int i = 0; i <= k; i++) {binRanges.add((min + i * binWidth));}
    }

    public List<Double> getBinRanges() {
        return binRanges;
    }

}
