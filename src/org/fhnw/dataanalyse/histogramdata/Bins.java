package org.fhnw.dataanalyse.histogramdata;

import java.awt.geom.FlatteningPathIterator;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Fabrizio on 21.05.2015.
 */
public class Bins {
    ArrayList<Integer> binAbsolteQuantity = new ArrayList<Integer>();
    ArrayList<Float> binRelativQuantity = new ArrayList<Float>();

    public Bins (){
    }

    public void setBinQuantity(ArrayList<Float> data, List<Float> binRanges){
        binAbsolteQuantity.clear();
        binRelativQuantity.clear();

        for (int i = 0; i < binRanges.size()-1; i++){
            int counter = 0;
            for (Float aX : data) {
                if ((aX.compareTo(binRanges.get(i)) == 0 &&  aX.compareTo(binRanges.get(i)) == 1 ) ||
                        aX.compareTo(binRanges.get(i+1)) == -1){
                    counter++;
                }
            }

            binAbsolteQuantity.add(counter);
        }

        for (int i : binAbsolteQuantity)   binRelativQuantity.add((float)i / (float)data.size());

    }

    public ArrayList<Float> getBinRelativQuantity() {
        return binRelativQuantity;
    }

    public ArrayList<Integer> getBinAbsolteQuantity() {
        return binAbsolteQuantity;
    }
}

