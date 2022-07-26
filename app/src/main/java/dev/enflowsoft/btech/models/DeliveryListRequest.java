package dev.enflowsoft.btech.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class DeliveryListRequest {

    @SerializedName("CompanyId")
    @Expose
    private Integer companyId;
    @SerializedName("FinyearId")
    @Expose
    private Integer finyearId;
    @SerializedName("UserId")
    @Expose
    private Integer userId;
    @SerializedName("pageno")
    @Expose
    private Integer pageno;

    public Integer getCompanyId() {
        return companyId;
    }

    public void setCompanyId(Integer companyId) {
        this.companyId = companyId;
    }

    public Integer getFinyearId() {
        return finyearId;
    }

    public void setFinyearId(Integer finyearId) {
        this.finyearId = finyearId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getPageno() {
        return pageno;
    }

    public void setPageno(Integer pageno) {
        this.pageno = pageno;
    }
}
