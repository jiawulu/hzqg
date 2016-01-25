package com.lu.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;

/**
 * Created by wuzhong on 16/1/25.
 * <p/>
 * 合同资料
 */
@Entity
public class Htzl implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String kh;
    private String kfddh;
    private long wxjq;
    private String ddczy;
    private String wxh;
    private String cgjq;
    private String kehao;
    private String gchh;
    private long xdrq;
    private String cght;
    private String gc;
    private String cpms;
    private double zxl;
    private String bzsm;
    private double wxj;
    private double cgj;
    private long sl;
    private String jgtk;
    private int htxj;
    private double wxzj;
    private double nxzj;
    private double mll;
    private double bmmll;
    private String jyyq;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getKh() {
        return kh;
    }

    public void setKh(String kh) {
        this.kh = kh;
    }

    public String getKfddh() {
        return kfddh;
    }

    public void setKfddh(String kfddh) {
        this.kfddh = kfddh;
    }

    public long getWxjq() {
        return wxjq;
    }

    public void setWxjq(long wxjq) {
        this.wxjq = wxjq;
    }

    public String getDdczy() {
        return ddczy;
    }

    public void setDdczy(String ddczy) {
        this.ddczy = ddczy;
    }

    public String getWxh() {
        return wxh;
    }

    public void setWxh(String wxh) {
        this.wxh = wxh;
    }

    public String getCgjq() {
        return cgjq;
    }

    public void setCgjq(String cgjq) {
        this.cgjq = cgjq;
    }

    public String getKehao() {
        return kehao;
    }

    public void setKehao(String kehao) {
        this.kehao = kehao;
    }

    public String getGchh() {
        return gchh;
    }

    public void setGchh(String gchh) {
        this.gchh = gchh;
    }

    public long getXdrq() {
        return xdrq;
    }

    public void setXdrq(long xdrq) {
        this.xdrq = xdrq;
    }

    public String getCght() {
        return cght;
    }

    public void setCght(String cght) {
        this.cght = cght;
    }

    public String getGc() {
        return gc;
    }

    public void setGc(String gc) {
        this.gc = gc;
    }

    public String getCpms() {
        return cpms;
    }

    public void setCpms(String cpms) {
        this.cpms = cpms;
    }

    public double getZxl() {
        return zxl;
    }

    public void setZxl(double zxl) {
        this.zxl = zxl;
    }

    public String getBzsm() {
        return bzsm;
    }

    public void setBzsm(String bzsm) {
        this.bzsm = bzsm;
    }

    public double getWxj() {
        return wxj;
    }

    public void setWxj(double wxj) {
        this.wxj = wxj;
    }

    public double getCgj() {
        return cgj;
    }

    public void setCgj(double cgj) {
        this.cgj = cgj;
    }

    public long getSl() {
        return sl;
    }

    public void setSl(long sl) {
        this.sl = sl;
    }

    public String getJgtk() {
        return jgtk;
    }

    public void setJgtk(String jgtk) {
        this.jgtk = jgtk;
    }

    public int getHtxj() {
        return htxj;
    }

    public void setHtxj(int htxj) {
        this.htxj = htxj;
    }

    public double getWxzj() {
        return wxzj;
    }

    public void setWxzj(double wxzj) {
        this.wxzj = wxzj;
    }

    public double getNxzj() {
        return nxzj;
    }

    public void setNxzj(double nxzj) {
        this.nxzj = nxzj;
    }

    public double getMll() {
        return mll;
    }

    public void setMll(double mll) {
        this.mll = mll;
    }

    public double getBmmll() {
        return bmmll;
    }

    public void setBmmll(double bmmll) {
        this.bmmll = bmmll;
    }

    public String getJyyq() {
        return jyyq;
    }

    public void setJyyq(String jyyq) {
        this.jyyq = jyyq;
    }
}
