package dev.enflowsoft.btech.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Customer {
    @SerializedName("CustomerId")
    @Expose
    private Integer customerId;
    @SerializedName("CustomerName")
    @Expose
    private String customerName;
    @SerializedName("CustomerAddress")
    @Expose
    private String customerAddress;
    @SerializedName("DeliveryAddress")
    @Expose
    private String deliveryAddress;
    @SerializedName("Phone")
    @Expose
    private Object phone;
    @SerializedName("GSTNo")
    @Expose
    private String gSTNo;
    @SerializedName("EmailID")
    @Expose
    private Object emailID;
    @SerializedName("UnitEmailID")
    @Expose
    private Object unitEmailID;
    @SerializedName("VendorCode")
    @Expose
    private Object vendorCode;

    public Integer getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Integer customerId) {
        this.customerId = customerId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getCustomerAddress() {
        return customerAddress;
    }

    public void setCustomerAddress(String customerAddress) {
        this.customerAddress = customerAddress;
    }

    public String getDeliveryAddress() {
        return deliveryAddress;
    }

    public void setDeliveryAddress(String deliveryAddress) {
        this.deliveryAddress = deliveryAddress;
    }

    public Object getPhone() {
        return phone;
    }

    public void setPhone(Object phone) {
        this.phone = phone;
    }

    public String getGSTNo() {
        return gSTNo;
    }

    public void setGSTNo(String gSTNo) {
        this.gSTNo = gSTNo;
    }

    public Object getEmailID() {
        return emailID;
    }

    public void setEmailID(Object emailID) {
        this.emailID = emailID;
    }

    public Object getUnitEmailID() {
        return unitEmailID;
    }

    public void setUnitEmailID(Object unitEmailID) {
        this.unitEmailID = unitEmailID;
    }

    public Object getVendorCode() {
        return vendorCode;
    }

    public void setVendorCode(Object vendorCode) {
        this.vendorCode = vendorCode;
    }
}
