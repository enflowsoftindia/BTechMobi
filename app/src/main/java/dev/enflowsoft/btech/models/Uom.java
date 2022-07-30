package dev.enflowsoft.btech.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Uom {

    @SerializedName("UOMId")
    @Expose
    private Integer uOMId;
    @SerializedName("UnitName")
    @Expose
    private String unitName;
    @SerializedName("UnitValue")
    @Expose
    private Object unitValue;
    @SerializedName("UnitCount")
    @Expose
    private Object unitCount;
    @SerializedName("IsActive")
    @Expose
    private Boolean isActive;

    public Integer getUOMId() {
        return uOMId;
    }

    public void setUOMId(Integer uOMId) {
        this.uOMId = uOMId;
    }

    public String getUnitName() {
        return unitName;
    }

    public void setUnitName(String unitName) {
        this.unitName = unitName;
    }

    public Object getUnitValue() {
        return unitValue;
    }

    public void setUnitValue(Object unitValue) {
        this.unitValue = unitValue;
    }

    public Object getUnitCount() {
        return unitCount;
    }

    public void setUnitCount(Object unitCount) {
        this.unitCount = unitCount;
    }

    public Boolean getIsActive() {
        return isActive;
    }

    public void setIsActive(Boolean isActive) {
        this.isActive = isActive;
    }
}
