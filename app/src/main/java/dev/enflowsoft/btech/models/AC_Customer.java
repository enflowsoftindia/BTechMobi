package dev.enflowsoft.btech.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class AC_Customer {
    @SerializedName("CustomerName")
    @Expose
    private String CustomerName;
    public String getCustomerName() {
        return CustomerName;
    }

    public void setCustomerName(String ProductName) {
        this.CustomerName = CustomerName;
    }
}
