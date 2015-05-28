package org.fhnw.dataanalyse.datamodell;

import java.util.ArrayList;

/**
 * Created by Fabrizio on 13.05.2015.
 *
 */
public class Variable {
    /**
     * Variable:
     *  contains the name of the imported Variable
     *  and the values are stored in the Array data
     */
    private String name;
    private ArrayList<Double> data;

    public Variable(String name){
        this.name = name;
        this.data = new ArrayList<Double>();
    }

    public String getName(){
        return name;
    }

    public ArrayList<Double> getData(){
        return data;
    }
}

