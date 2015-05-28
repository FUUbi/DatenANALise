package org.fhnw.dataanalyse.histogramdata;

import java.util.ArrayList;
import java.util.List;

/**
 * BinRanges contains setBinRanges() Method and getBinRanges()
 */

public class BinRanges {

    private int k;
    private int n;
    private ArrayList<Double> binRanges = new ArrayList<>();


    public void setBinRanges(ArrayList<Double> data){
        
        binRanges.clear();
        n = data.size();
        k = (int) Math.sqrt(n);

        double max = data.get(0);
        for (Double f : data) if (f.compareTo(max) == 1) max = f;

        double min = data.get(0);
        for (Double f : data) if (f.compareTo(min) == -1) min = f;

        double binWidth = (Math.abs(min) + Math.abs(max)) / k;

        for (int i = 0; i <= k; i++) {binRanges.add((min + i * binWidth));}
    }

    public List<Double> getBinRanges() {
        return binRanges;
    }

}
