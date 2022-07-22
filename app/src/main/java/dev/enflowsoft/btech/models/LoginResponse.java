package dev.enflowsoft.btech.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class LoginResponse {
    @SerializedName("UserId")
    @Expose
    private Integer userId;
    @SerializedName("CompanyId")
    @Expose
    private Integer companyId;
    @SerializedName("CompanyUnitId")
    @Expose
    private Integer companyUnitId;
    @SerializedName("CompanyUnitName")
    @Expose
    private String companyUnitName;
    @SerializedName("FinyearId")
    @Expose
    private Integer finyearId;
    @SerializedName("FinyearName")
    @Expose
    private String finyearName;
    @SerializedName("IsDefault")
    @Expose
    private Boolean isDefault;
    @SerializedName("MenuSettings")
    @Expose
    private List<MenuSetting> menuSettings = null;
    @SerializedName("statuscode")
    @Expose
    private Integer statuscode;
    @SerializedName("errormessage")
    @Expose
    private String errormessage;

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getCompanyId() {
        return companyId;
    }

    public void setCompanyId(Integer companyId) {
        this.companyId = companyId;
    }

    public Integer getCompanyUnitId() {
        return companyUnitId;
    }

    public void setCompanyUnitId(Integer companyUnitId) {
        this.companyUnitId = companyUnitId;
    }

    public String getCompanyUnitName() {
        return companyUnitName;
    }

    public void setCompanyUnitName(String companyUnitName) {
        this.companyUnitName = companyUnitName;
    }

    public Integer getFinyearId() {
        return finyearId;
    }

    public void setFinyearId(Integer finyearId) {
        this.finyearId = finyearId;
    }

    public String getFinyearName() {
        return finyearName;
    }

    public void setFinyearName(String finyearName) {
        this.finyearName = finyearName;
    }

    public Boolean getIsDefault() {
        return isDefault;
    }

    public void setIsDefault(Boolean isDefault) {
        this.isDefault = isDefault;
    }

    public List<MenuSetting> getMenuSettings() {
        return menuSettings;
    }

    public void setMenuSettings(List<MenuSetting> menuSettings) {
        this.menuSettings = menuSettings;
    }

    public Integer getStatuscode() {
        return statuscode;
    }

    public void setStatuscode(Integer statuscode) {
        this.statuscode = statuscode;
    }

    public String getErrormessage() {
        return errormessage;
    }

    public void setErrormessage(String errormessage) {
        this.errormessage = errormessage;
    }
}
