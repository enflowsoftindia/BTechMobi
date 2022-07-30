package dev.enflowsoft.btech.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Transport {

    @SerializedName("TransId")
    @Expose
    private Integer transId;
    @SerializedName("TransName")
    @Expose
    private String transName;
    @SerializedName("TNnum")
    @Expose
    private String tNnum;

    public Integer getTransId() {
        return transId;
    }

    public void setTransId(Integer transId) {
        this.transId = transId;
    }

    public String getTransName() {
        return transName;
    }

    public void setTransName(String transName) {
        this.transName = transName;
    }

    public String getTNnum() {
        return tNnum;
    }

    public void setTNnum(String tNnum) {
        this.tNnum = tNnum;
    }
}
