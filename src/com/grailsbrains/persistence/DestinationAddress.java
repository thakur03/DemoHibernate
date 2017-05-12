package com.grailsbrains.persistence;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import java.util.Date;

/**
 * entity class for deatination address inherit POAddress Class
 */
@Entity
@Table(name="destination_address")
@PrimaryKeyJoinColumn(name="ID")
public class DestinationAddress extends POAddress {
    @Column
    private String shipTo;
    @Column
    private Date deliveryStart;
    @Column
    private Date deliveryEnd;

    public String getShipTo() {
        return shipTo;
    }

    public void setShipTo(String shipTo) {
        this.shipTo = shipTo;
    }

    public Date getDeliveryStart() {
        return deliveryStart;
    }

    public void setDeliveryStart(Date deliveryStart) {
        this.deliveryStart = deliveryStart;
    }

    public Date getDeliveryEnd() {
        return deliveryEnd;
    }

    public void setDeliveryEnd(Date deliveryEnd) {
        this.deliveryEnd = deliveryEnd;
    }

    @Override
    public String toString() {
        return "DestinationAddress{" +
                "shipTo='" + shipTo + '\'' +
                ", deliveryStart=" + deliveryStart +
                ", deliveryEnd=" + deliveryEnd +
                '}';
    }
}
