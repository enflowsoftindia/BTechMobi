package dev.enflowsoft.btech.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Item {

    @SerializedName("ItemId")
    @Expose
    private Integer itemId;
    @SerializedName("ItemName")
    @Expose
    private String itemName;
    @SerializedName("ItemCategoryId")
    @Expose
    private Integer itemCategoryId;
    @SerializedName("AlertStockQty")
    @Expose
    private Integer alertStockQty;
    @SerializedName("MaxStockQty")
    @Expose
    private Integer maxStockQty;
    @SerializedName("MinStockQty")
    @Expose
    private Integer minStockQty;
    @SerializedName("AlertRequired")
    @Expose
    private Boolean alertRequired;
    @SerializedName("HSNCode")
    @Expose
    private String hSNCode;
    @SerializedName("GSTPerc")
    @Expose
    private Double gSTPerc;
    @SerializedName("ScanCode")
    @Expose
    private String scanCode;
    @SerializedName("IsDeleted")
    @Expose
    private Boolean isDeleted;
    @SerializedName("IGSTPerc")
    @Expose
    private Double iGSTPerc;
    @SerializedName("UOMid")
    @Expose
    private Integer uOMid;
    @SerializedName("IsAssembly")
    @Expose
    private Boolean isAssembly;

    public Integer getItemId() {
        return itemId;
    }

    public void setItemId(Integer itemId) {
        this.itemId = itemId;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public Integer getItemCategoryId() {
        return itemCategoryId;
    }

    public void setItemCategoryId(Integer itemCategoryId) {
        this.itemCategoryId = itemCategoryId;
    }

    public Integer getAlertStockQty() {
        return alertStockQty;
    }

    public void setAlertStockQty(Integer alertStockQty) {
        this.alertStockQty = alertStockQty;
    }

    public Integer getMaxStockQty() {
        return maxStockQty;
    }

    public void setMaxStockQty(Integer maxStockQty) {
        this.maxStockQty = maxStockQty;
    }

    public Integer getMinStockQty() {
        return minStockQty;
    }

    public void setMinStockQty(Integer minStockQty) {
        this.minStockQty = minStockQty;
    }

    public Boolean getAlertRequired() {
        return alertRequired;
    }

    public void setAlertRequired(Boolean alertRequired) {
        this.alertRequired = alertRequired;
    }

    public String getHSNCode() {
        return hSNCode;
    }

    public void setHSNCode(String hSNCode) {
        this.hSNCode = hSNCode;
    }

    public Double getGSTPerc() {
        return gSTPerc;
    }

    public void setGSTPerc(Double gSTPerc) {
        this.gSTPerc = gSTPerc;
    }

    public String getScanCode() {
        return scanCode;
    }

    public void setScanCode(String scanCode) {
        this.scanCode = scanCode;
    }

    public Boolean getIsDeleted() {
        return isDeleted;
    }

    public void setIsDeleted(Boolean isDeleted) {
        this.isDeleted = isDeleted;
    }

    public Double getIGSTPerc() {
        return iGSTPerc;
    }

    public void setIGSTPerc(Double iGSTPerc) {
        this.iGSTPerc = iGSTPerc;
    }

    public Integer getUOMid() {
        return uOMid;
    }

    public void setUOMid(Integer uOMid) {
        this.uOMid = uOMid;
    }

    public Boolean getIsAssembly() {
        return isAssembly;
    }

    public void setIsAssembly(Boolean isAssembly) {
        this.isAssembly = isAssembly;
    }
}
