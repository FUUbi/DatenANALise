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
    ArrayList<Float> relativBins = new ArrayList<Float>();  // muss noch engtfernt werden wertlos für die app


    public BinRanges(){
    }

    public BinRanges(ArrayList<Float> data){
        n = data.size();
        k = (int) Math.sqrt(n);


        float max = (float)0.0;
        for (Float f : data) if (f.compareTo(max) == 1) max = f;

        float binWidth = max / k;

        for (int i = 0; i <= k; i++) binRanges.add(i * binWidth);

        for (Float f : binRanges) relativBins.add(f/max);

    }


    public void setbinRanges(ArrayList<Float> data){
        n = data.size();
        k = (int) Math.sqrt(n);

        binRanges.clear();

        float max = (float)0.0;
        for (Float f : data) if (f.compareTo(max) == 1) max = f;

        float binWidth = max / k;

        for (int i = 0; i <= k; i++) binRanges.add(i * binWidth);

        for (Float f : binRanges) relativBins.add(f/max);

    }


    public List<Float> getBinRanges() {
        return binRanges;
    }

}
