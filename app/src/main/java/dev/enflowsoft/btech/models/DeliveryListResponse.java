package dev.enflowsoft.btech.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class DeliveryListResponse {

    @SerializedName("IssueId")
    @Expose
    private Integer issueId;
    @SerializedName("IssueNo")
    @Expose
    private String issueNo;
    @SerializedName("DCNumber")
    @Expose
    private String dCNumber;
    @SerializedName("IssueDate")
    @Expose
    private String issueDate;
    @SerializedName("PartyName")
    @Expose
    private String partyName;
    @SerializedName("listchildvm")
    @Expose
    private List<Listchildvm> listchildvm = null;

    public Integer getIssueId() {
        return issueId;
    }

    public void setIssueId(Integer issueId) {
        this.issueId = issueId;
    }

    public String getIssueNo() {
        return issueNo;
    }

    public void setIssueNo(String issueNo) {
        this.issueNo = issueNo;
    }

    public String getDCNumber() {
        return dCNumber;
    }

    public void setDCNumber(String dCNumber) {
        this.dCNumber = dCNumber;
    }

    public String getIssueDate() {
        return issueDate;
    }

    public void setIssueDate(String issueDate) {
        this.issueDate = issueDate;
    }

    public String getPartyName() {
        return partyName;
    }

    public void setPartyName(String partyName) {
        this.partyName = partyName;
    }

    public List<Listchildvm> getListchildvm() {
        return listchildvm;
    }

    public void setListchildvm(List<Listchildvm> listchildvm) {
        this.listchildvm = listchildvm;
    }
}
