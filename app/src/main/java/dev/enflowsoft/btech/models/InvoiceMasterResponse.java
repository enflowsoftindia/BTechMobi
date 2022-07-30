package dev.enflowsoft.btech.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class InvoiceMasterResponse {
    @SerializedName("customerlist")
    @Expose
    private List<Customer> customerlist = null;
    @SerializedName("customerUnitlist")
    @Expose
    private List<Customer> customerUnitlist = null;
    @SerializedName("itemslist")
    @Expose
    private List<Item> itemslist = null;
    @SerializedName("uomlist")
    @Expose
    private List<Uom> uomlist = null;
    @SerializedName("vehiclelist")
    @Expose
    private List<Transport> vehiclelist = null;
    @SerializedName("invoicetypelist")
    @Expose
    private List<ItemCode> invoicetypelist = null;

    public List<Customer> getCustomerlist() {
        return customerlist;
    }

    public void setCustomerlist(List<Customer> customerlist) {
        this.customerlist = customerlist;
    }

    public List<Customer> getcustomerUnitlist() {
        return customerUnitlist;
    }

    public void setcustomerUnitlist(List<Customer> customerUnitlist) {
        this.customerUnitlist = customerUnitlist;
    }

    public List<Item> getitemslist() {
        return itemslist;
    }

    public void setitemslist(List<Item> itemslist) {
        this.itemslist = itemslist;
    }

    public List<Uom> getuomlist() {
        return uomlist;
    }

    public void setuomlist(List<Uom> uomlist) {
        this.uomlist = uomlist;
    }

    public List<Transport> getvehiclelist() {
        return vehiclelist;
    }

    public void setvehiclelist(List<Transport> vehiclelist) {
        this.vehiclelist = vehiclelist;
    }

    public List<ItemCode> getinvoicetypelist() {
        return invoicetypelist;
    }

    public void setinvoicetypelist(List<ItemCode> invoicetypelist) {
        this.invoicetypelist = invoicetypelist;
    }

}
