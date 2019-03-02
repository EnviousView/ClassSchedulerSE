package com.system.model;

import java.io.Serializable;
import java.util.*;
/**
 *
 * @author CalvinGabriel
 */
public class yearIDSet implements Serializable{
    private static final long serialVersionUID = 1L;
    private Set yrSet;
    public Set yearIDSet(String yearId)
    {
        yrSet = new TreeSet(new yearSetAsc());
        yrSet.add(yearId);
        return yrSet;
    }        
}
class yearSetAsc implements Comparator<String>
{
    @Override
    public int compare(String yearID1,String yearID2)
    {
        int val = yearID1.compareTo(yearID2);
            
        if(val == 0)
            return 0;
        else if(val < 0)
            return -1;
        else
            return 1;
    }        
}

