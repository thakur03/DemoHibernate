package com.grailsbrains.manage;

import com.grailsbrains.persistence.PurchaseOrder;

import java.util.Date;
import java.util.List;

/**
 * Created by Ajeet on 5/11/2017.
 */
public class Output {

    private int poNumber;
    private String supplier;
    private Date dueDate ;
    private String status;
    private String priority;
    private String shipfrom;
    private String shipto  ;
    private String transresp;

    public int getPoNumber() {
        return poNumber;
    }

    public void setPoNumber(int poNumber) {
        this.poNumber = poNumber;
    }

    public String getSupplier() {
        return supplier;
    }

    public void setSupplier(String supplier) {
        this.supplier = supplier;
    }

    public Date getDueDate() {
        return dueDate;
    }

    public void setDueDate(Date dueDate) {
        this.dueDate = dueDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getPriority() {
        return priority;
    }

    public void setPriority(String priority) {
        this.priority = priority;
    }

    public String getShipfrom() {
        return shipfrom;
    }

    public void setShipfrom(String shipfrom) {
        this.shipfrom = shipfrom;
    }

    public String getShipto() {
        return shipto;
    }

    public void setShipto(String shipto) {
        this.shipto = shipto;
    }

    public String getTransresp() {
        return transresp;
    }

    public void setTransresp(String transresp) {
        this.transresp = transresp;
    }

    @Override
    public String toString() {
        return "Output{" +
                "poNumber=" + poNumber +
                ", supplier='" + supplier + '\'' +
                ", dueDate=" + dueDate +
                ", status='" + status + '\'' +
                ", priority='" + priority + '\'' +
                ", shipfrom='" + shipfrom + '\'' +
                ", shipto='" + shipto + '\'' +
                ", transresp='" + transresp + '\'' +
                '}';
    }
}
