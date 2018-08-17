package com.example.ps.muggle.model.bean;

public class VersionBean {
    /**
     * id : 1
     * appName : 放克app
     * serverVersion : 1.0.1
     * serverFlag : 2
     * forceUpdate : 0
     * updateUrl : download\fankcool_v1.0.1.apk
     * uploadTime : 2017-09-12 17:26:35.0
     * updateDesc : 更新版本
     * fileName : fankcool
     * fileMD5 : null
     * state : 0
     * del : 0
     * remark : null
     */

    private int id;
    private String appName;
    private String serverVersion;
    private int serverFlag;
    private int forceUpdate;
    private String updateUrl;
    private String uploadTime;
    private String updateDesc;
    private String fileName;
    private String fileMD5;
    private int state;
    private int del;
    private Object remark;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAppName() {
        return appName;
    }

    public void setAppName(String appName) {
        this.appName = appName;
    }

    public String getServerVersion() {
        return serverVersion;
    }

    public void setServerVersion(String serverVersion) {
        this.serverVersion = serverVersion;
    }

    public int getServerFlag() {
        return serverFlag;
    }

    public void setServerFlag(int serverFlag) {
        this.serverFlag = serverFlag;
    }

    public int getForceUpdate() {
        return forceUpdate;
    }

    public void setForceUpdate(int forceUpdate) {
        this.forceUpdate = forceUpdate;
    }

    public String getUpdateUrl() {
        return updateUrl;
    }

    public void setUpdateUrl(String updateUrl) {
        this.updateUrl = updateUrl;
    }

    public String getUploadTime() {
        return uploadTime;
    }

    public void setUploadTime(String uploadTime) {
        this.uploadTime = uploadTime;
    }

    public String getUpdateDesc() {
        return updateDesc;
    }

    public void setUpdateDesc(String updateDesc) {
        this.updateDesc = updateDesc;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getFileMD5() {
        return fileMD5;
    }

    public void setFileMD5(String fileMD5) {
        this.fileMD5 = fileMD5;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public int getDel() {
        return del;
    }

    public void setDel(int del) {
        this.del = del;
    }

    public Object getRemark() {
        return remark;
    }

    public void setRemark(Object remark) {
        this.remark = remark;
    }

}
