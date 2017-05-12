package com.grailsbrains.compare;

import com.grailsbrains.manage.Output;
import com.grailsbrains.persistence.PurchaseOrder;

import java.util.Comparator;

/**
 * Created by Abhishek on 10-05-2017.
 */
public class NumberComparator implements Comparator<Output>{
    @Override
    public int compare(Output o1, Output o2) {

        if(o1.getPoNumber()==o2.getPoNumber())
            return 0;
        else if(o1.getPoNumber()>o2.getPoNumber())
            return 1;
        else
            return -1;

    }
}
