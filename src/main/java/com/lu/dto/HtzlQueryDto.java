package com.lu.dto;

/**
 * Created by wuzhong on 16/2/22.
 */
public class HtzlQueryDto {

    private int pageNo;
    private int pageSize;
    private int cgjqWarnType;
    private long startJq;
    private long endJq;
    private Integer zjcs;
    private Boolean cywc;
    private String huhao;
    private String cght;

    public int getPageNo() {
        return pageNo;
    }

    public void setPageNo(int pageNo) {
        this.pageNo = pageNo;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getCgjqWarnType() {
        return cgjqWarnType;
    }

    public void setCgjqWarnType(int cgjqWarnType) {
        this.cgjqWarnType = cgjqWarnType;
    }

    public long getStartJq() {
        return startJq;
    }

    public void setStartJq(long startJq) {
        this.startJq = startJq;
    }

    public long getEndJq() {
        return endJq;
    }

    public void setEndJq(long endJq) {
        this.endJq = endJq;
    }

    public Integer getZjcs() {
        return zjcs;
    }

    public void setZjcs(Integer zjcs) {
        this.zjcs = zjcs;
    }

    public Boolean getCywc() {
        return cywc;
    }

    public void setCywc(Boolean cywc) {
        this.cywc = cywc;
    }

    public String getHuhao() {
        return huhao;
    }

    public void setHuhao(String huhao) {
        this.huhao = huhao;
    }

    public String getCght() {
        return cght;
    }

    public void setCght(String cght) {
        this.cght = cght;
    }
}
