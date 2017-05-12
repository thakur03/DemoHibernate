package com.grailsbrains.persistence;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import java.util.Date;

/**
 * Entity class for Origin Address inherit POAddress Class
 */
@Entity
@Table(name="origin_address")
@PrimaryKeyJoinColumn(name="ID")
public class OriginAddress extends POAddress {


    @Column
    private String shipFrom;
    @Column
    private Date pickupStart;
    @Column
    private Date pickupEnd;

    public String getShipFrom() { return shipFrom; }

    public void setShipFrom(String shipFrom) { this.shipFrom = shipFrom; }

    public Date getPickupStart() {
        return pickupStart;
    }

    public void setPickupStart(Date pickupStart) {
        this.pickupStart = pickupStart;
    }

    public Date getPickupEnd() {
        return pickupEnd;
    }

    public void setPickupEnd(Date pickupEnd) {
        this.pickupEnd = pickupEnd;
    }

    @Override
    public String toString() {
        return "OriginAddress{" +
                "shipFrom='" + shipFrom + '\'' +
                ", pickupStart=" + pickupStart +
                ", pickupEnd=" + pickupEnd +
                '}';
    }
}
