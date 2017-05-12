package com.grailsbrains.compare;

import com.grailsbrains.manage.Output;
import com.grailsbrains.persistence.DestinationAddress;

import java.util.Comparator;

/**
 * Created by Abhishek on 10-05-2017.
 */
public class ShipToComparator implements Comparator<Output> {
    @Override
    public int compare(Output o1, Output o2) {

        return o1.getShipto().compareToIgnoreCase(o2.getShipto());

    }
}