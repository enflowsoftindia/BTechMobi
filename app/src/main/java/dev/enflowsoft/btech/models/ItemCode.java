package dev.enflowsoft.btech.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ItemCode {

    @SerializedName("InvType")
    @Expose
    private String invType;
    @SerializedName("LastInvoice")
    @Expose
    private Object lastInvoice;

    public String getInvType() {
        return invType;
    }

    public void setInvType(String invType) {
        this.invType = invType;
    }

    public Object getLastInvoice() {
        return lastInvoice;
    }

    public void setLastInvoice(Object lastInvoice) {
        this.lastInvoice = lastInvoice;
    }

}
