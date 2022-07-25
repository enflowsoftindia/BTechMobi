package dev.enflowsoft.btech.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class SalesListResponse {

    @SerializedName("TransId")
    @Expose
    private Integer transId;
    @SerializedName("TransDate")
    @Expose
    private String transDate;
    @SerializedName("TransNo")
    @Expose
    private String transNo;
    @SerializedName("PartyName")
    @Expose
    private String partyName;
    @SerializedName("PartyAddress")
    @Expose
    private Object partyAddress;
    @SerializedName("Icon1")
    @Expose
    private Object icon1;
    @SerializedName("IsAdvancePaid")
    @Expose
    private Boolean isAdvancePaid;
    @SerializedName("IsEstimate")
    @Expose
    private Boolean isEstimate;
    @SerializedName("listchildvm")
    @Expose
    private List<Listchildvm> listchildvm = null;

    public Integer getTransId() {
        return transId;
    }

    public void setTransId(Integer transId) {
        this.transId = transId;
    }

    public String getTransDate() {
        return transDate;
    }

    public void setTransDate(String transDate) {
        this.transDate = transDate;
    }

    public String getTransNo() {
        return transNo;
    }

    public void setTransNo(String transNo) {
        this.transNo = transNo;
    }

    public String getPartyName() {
        return partyName;
    }

    public void setPartyName(String partyName) {
        this.partyName = partyName;
    }

    public Object getPartyAddress() {
        return partyAddress;
    }

    public void setPartyAddress(Object partyAddress) {
        this.partyAddress = partyAddress;
    }

    public Object getIcon1() {
        return icon1;
    }

    public void setIcon1(Object icon1) {
        this.icon1 = icon1;
    }

    public Boolean getIsAdvancePaid() {
        return isAdvancePaid;
    }

    public void setIsAdvancePaid(Boolean isAdvancePaid) {
        this.isAdvancePaid = isAdvancePaid;
    }

    public Boolean getIsEstimate() {
        return isEstimate;
    }

    public void setIsEstimate(Boolean isEstimate) {
        this.isEstimate = isEstimate;
    }

    public List<Listchildvm> getListchildvm() {
        return listchildvm;
    }

    public void setListchildvm(List<Listchildvm> listchildvm) {
        this.listchildvm = listchildvm;
    }
}
