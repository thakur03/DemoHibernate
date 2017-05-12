package com.grailsbrains.compare;

import com.grailsbrains.manage.Output;
import com.grailsbrains.persistence.OriginAddress;
import com.grailsbrains.persistence.PurchaseOrder;

import java.util.Comparator;

/**
 * Created by Abhishek on 10-05-2017.
 */
public class ShipFromComparator implements Comparator<Output> {
    @Override
    public int compare(Output o1, Output o2) {

        return o1.getShipfrom().compareToIgnoreCase(o2.getShipfrom());

    }
}