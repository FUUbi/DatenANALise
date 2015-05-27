package org.fhnw.dataanalyse.histogramdata;

import java.awt.geom.FlatteningPathIterator;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Fabrizio on 21.05.2015.
 */
public class Bins {
    ArrayList<Integer> binAbsolteQuantity;

    public void setBinQuantity(ArrayList<Float> data, List<Float> binRanges){

        binAbsolteQuantity = new ArrayList<Integer>();
        for (float f: binRanges) binAbsolteQuantity.add(0);

            for (Float value : data) {
                boolean foundBin = false;

                int n = 0;
                while (!foundBin && n < binRanges.size()-1) {

                    if ((value.compareTo(binRanges.get(n)) == 0 || value.compareTo(binRanges.get(n)) == 1) &&
                            (value.compareTo(binRanges.get(n + 1)) == -1)) {
                        foundBin = true;
                    }

                    n++;

                }

                int tempQuantity = binAbsolteQuantity.get(n);
                tempQuantity++;

                binAbsolteQuantity.set(n, tempQuantity);
            }


    }

    public ArrayList<Integer> getBinAbsolteQuantity() {
        return binAbsolteQuantity;
    }
}
