package dev.enflowsoft.btech.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class MenuSetting {

    @SerializedName("MenuKey")
    @Expose
    private String menuKey;
    @SerializedName("MenuVal")
    @Expose
    private String menuVal;

    public String getMenuKey() {
        return menuKey;
    }

    public void setMenuKey(String menuKey) {
        this.menuKey = menuKey;
    }

    public String getMenuVal() {
        return menuVal;
    }

    public void setMenuVal(String menuVal) {
        this.menuVal = menuVal;
    }
}
