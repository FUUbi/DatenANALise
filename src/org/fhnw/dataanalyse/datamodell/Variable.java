package org.fhnw.dataanalyse.datamodell;

import java.util.ArrayList;

/**
 * Created by Fabrizio on 13.05.2015.
 *
 */
public class Variable {
    private String name;
    private ArrayList<Float> data;

    public Variable(String name){
        this.name = name;
        this.data = new ArrayList<Float>();
    }

    public String getName(){
        return name;
    }

    public ArrayList<Float> getData(){
        return data;
    }
}

