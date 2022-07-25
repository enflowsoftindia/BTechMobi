package dev.enflowsoft.btech.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Listchildvm {
    @SerializedName("Itemname")
    @Expose
    private String itemname;
    @SerializedName("Qty")
    @Expose
    private String qty;
    @SerializedName("Amount")
    @Expose
    private String amount;
    @SerializedName("Rate")
    @Expose
    private String rate;
    @SerializedName("TaxAmount")
    @Expose
    private String taxAmount;
    @SerializedName("Tranport")
    @Expose
    private String tranport;

    public String getItemname() {
        return itemname;
    }

    public void setItemname(String itemname) {
        this.itemname = itemname;
    }

    public String getQty() {
        return qty;
    }

    public void setQty(String qty) {
        this.qty = qty;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public String getRate() {
        return rate;
    }

    public void setRate(String rate) {
        this.rate = rate;
    }

    public String getTaxAmount() {
        return taxAmount;
    }

    public void setTaxAmount(String taxAmount) {
        this.taxAmount = taxAmount;
    }

    public String getTranport() {
        return tranport;
    }

    public void setTranport(String tranport) {
        this.tranport = tranport;
    }
}
