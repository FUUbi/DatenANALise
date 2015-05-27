package org.fhnw.dataanalyse.histogramdata;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Fabrizio on 21.05.2015.
 *
 */
public class BinRanges {
    int k;
    int n;
    ArrayList<Float> binRanges = new ArrayList<Float>();


    public void setbinRanges(ArrayList<Float> data){
        binRanges.clear();

        n = data.size();
        k = (int) Math.sqrt(n);

        float max = 0.f;
        for (Float f : data) if (f.compareTo(max) == 1) max = f;

        float min = 0.f;
        for (Float f : data) if (f.compareTo(min) == -1) min = f;


        float binWidth = (Math.abs(min) + Math.abs(max)) / k;

        for (int i = 0; i <= k; i++) {
            binRanges.add((min + i * binWidth));
        }

    }


    public List<Float> getBinRanges() {
        return binRanges;
    }

}
