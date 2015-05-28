package org.fhnw.dataanalyse.histogramdata;

import java.util.ArrayList;
import java.util.List;

/**
 * Bins contains setBinQuantity()  Method and getBinAbsoluteQuantity() Method
 * the BinQuantity is set relative to binRanges and match with the Size dedicated to the Histogram on the GUI
 * @see BinRanges
 */

public class Bins {

    private ArrayList<Integer> binAbsoluteQuantity;

    public void setBinQuantity(ArrayList<Double> data, List<Double> binRanges){

        binAbsoluteQuantity = new ArrayList<Integer>();

        for (double f : binRanges) binAbsoluteQuantity.add(0);

        for (Double value : data) {

            boolean foundBin = false;
            int n = 0;

            while (!foundBin && n < binRanges.size()-1) {

                if ((value.compareTo(binRanges.get(n)) == 0 || value.compareTo(binRanges.get(n)) == 1) &&
                        (value.compareTo(binRanges.get(n + 1)) == -1)) {
                    foundBin = true;
                }

                n++;
            }

            int tempQuantity = binAbsoluteQuantity.get(n);
            tempQuantity++;

            binAbsoluteQuantity.set(n, tempQuantity);
        }
    }

    public ArrayList<Integer> getBinAbsoluteQuantity() {
        return binAbsoluteQuantity;
    }
}
