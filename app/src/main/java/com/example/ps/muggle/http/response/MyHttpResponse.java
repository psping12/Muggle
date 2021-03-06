package com.example.ps.muggle.http.response;

public class MyHttpResponse<T> {

    /**
     * ok : false
     * code : 500
     * msg : 版本获取失败
     * data : null
     * page : false
     * curPage : 0
     * totalRecord : 0
     * totalPage : 0
     * curRecord : 0
     * beginRow : 0
     * endRow : 0
     * prePageSize : 0
     * errors : null
     */
    private boolean ok;
    private int code;
    private String msg;
    private T  data;
    private boolean page;
    private int curPage;
    private int totalRecord;
    private int totalPage;
    private int curRecord;
    private int beginRow;
    private int endRow;
    private int prePageSize;
    private Object errors;

    public boolean isOk() {
        return ok;
    }

    public void setOk(boolean ok) {
        this.ok = ok;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public boolean isPage() {
        return page;
    }

    public void setPage(boolean page) {
        this.page = page;
    }

    public int getCurPage() {
        return curPage;
    }

    public void setCurPage(int curPage) {
        this.curPage = curPage;
    }

    public int getTotalRecord() {
        return totalRecord;
    }

    public void setTotalRecord(int totalRecord) {
        this.totalRecord = totalRecord;
    }

    public int getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(int totalPage) {
        this.totalPage = totalPage;
    }

    public int getCurRecord() {
        return curRecord;
    }

    public void setCurRecord(int curRecord) {
        this.curRecord = curRecord;
    }

    public int getBeginRow() {
        return beginRow;
    }

    public void setBeginRow(int beginRow) {
        this.beginRow = beginRow;
    }

    public int getEndRow() {
        return endRow;
    }

    public void setEndRow(int endRow) {
        this.endRow = endRow;
    }

    public int getPrePageSize() {
        return prePageSize;
    }

    public void setPrePageSize(int prePageSize) {
        this.prePageSize = prePageSize;
    }

    public Object getErrors() {
        return errors;
    }

    public void setErrors(Object errors) {
        this.errors = errors;
    }
}
