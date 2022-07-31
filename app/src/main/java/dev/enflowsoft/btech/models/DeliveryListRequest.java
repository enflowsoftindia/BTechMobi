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
    @SerializedName("fromDate")
    @Expose
    private String fromDate;
    @SerializedName("ToDate")
    @Expose
    private String toDate;
    @SerializedName("CustomerId")
    @Expose
    private Integer customerId;
    @SerializedName("ItemCode")
    @Expose
    private String itemCode;
    @SerializedName("pagesize")
    @Expose
    private String pagesize;

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

    public String getFromDate() {
        return fromDate;
    }

    public void setFromDate(String fromDate) {
        this.fromDate = fromDate;
    }

    public String getToDate() {
        return toDate;
    }

    public void setToDate(String toDate) {
        this.toDate = toDate;
    }

    public Integer getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Integer customerId) {
        this.customerId = customerId;
    }

    public String getItemCode() {
        return itemCode;
    }

    public void setItemCode(String itemCode) {
        this.itemCode = itemCode;
    }

    public String getPagesize() {
        return pagesize;
    }

    public void setPagesize(String pagesize) {
        this.pagesize = pagesize;
    }
}
