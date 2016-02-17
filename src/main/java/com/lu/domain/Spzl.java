package com.lu.domain;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by wuzhong on 16/2/17.
 */
@Entity
@org.hibernate.annotations.Entity(dynamicUpdate = true)
public class Spzl implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    /**
     * 索赔编号	文本
     **/
    private String spbh;
    /**
     * 记账客户	文本
     **/
    private String jzkh;
    /**
     * 外销合同号	文本
     **/
    private String wxhth;
    /**
     * 货号	文本 (和htzl表关联)
     **/
    private String huohao;
    /**
     * 客号	文本
     **/
    private String kehao;
    /**
     * 责任客服	文本
     **/
    private String zrkf;
    /**
     * 实际赔付USD	数值
     **/
    private double sjpfusd;
    /**
     * 索赔日期	日期
     **/
    private long sprq;
    /**
     * 索赔原因	文本
     **/
    @Column(length = 1024)
    private String spyy;
    /**
     * 录入日期	日期
     **/
    private long lrrq;
    /**
     * 品名	文本
     **/
    private String pm;
    /**
     * 录入人	文本
     **/
    private String lrr;
    /**
     * 部门	文本
     **/
    private String bm;
    /**
     * 部门承担USD	数值
     **/
    private double bmcdusd;
    /**
     * 索赔责任人	文本
     **/
    private String spzrr;
    /**
     * 处理人	文本
     **/
    private String clr;
    /**
     * 原因分析	文本
     **/
    private String yyfx;
    /**
     * 预防措施	文本
     **/
    private String fycs;
    /**
     * 涉及工厂	文本
     **/
    private String sjgc;
    /**
     * 应赔付金额	数值
     **/
    private double ypfje;
    /**
     * 工厂赔付确认	文本
     **/
    private String gcpfqr;
    /**
     * 工厂实际赔付	数值
     **/
    private double gcsjpf;
    /**
     * 工厂赔付日期	日期
     **/
    private long gcpfrq;
    /**
     * 内销合同号	文本
     **/
    private String nxhth;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSpbh() {
        return spbh;
    }

    public void setSpbh(String spbh) {
        this.spbh = spbh;
    }

    public String getJzkh() {
        return jzkh;
    }

    public void setJzkh(String jzkh) {
        this.jzkh = jzkh;
    }

    public String getWxhth() {
        return wxhth;
    }

    public void setWxhth(String wxhth) {
        this.wxhth = wxhth;
    }

    public String getHuohao() {
        return huohao;
    }

    public void setHuohao(String huohao) {
        this.huohao = huohao;
    }

    public String getKehao() {
        return kehao;
    }

    public void setKehao(String kehao) {
        this.kehao = kehao;
    }

    public String getZrkf() {
        return zrkf;
    }

    public void setZrkf(String zrkf) {
        this.zrkf = zrkf;
    }

    public double getSjpfusd() {
        return sjpfusd;
    }

    public void setSjpfusd(double sjpfusd) {
        this.sjpfusd = sjpfusd;
    }

    public long getSprq() {
        return sprq;
    }

    public void setSprq(long sprq) {
        this.sprq = sprq;
    }

    public String getSpyy() {
        return spyy;
    }

    public void setSpyy(String spyy) {
        this.spyy = spyy;
    }

    public long getLrrq() {
        return lrrq;
    }

    public void setLrrq(long lrrq) {
        this.lrrq = lrrq;
    }

    public String getPm() {
        return pm;
    }

    public void setPm(String pm) {
        this.pm = pm;
    }

    public String getLrr() {
        return lrr;
    }

    public void setLrr(String lrr) {
        this.lrr = lrr;
    }

    public String getBm() {
        return bm;
    }

    public void setBm(String bm) {
        this.bm = bm;
    }

    public double getBmcdusd() {
        return bmcdusd;
    }

    public void setBmcdusd(double bmcdusd) {
        this.bmcdusd = bmcdusd;
    }

    public String getSpzrr() {
        return spzrr;
    }

    public void setSpzrr(String spzrr) {
        this.spzrr = spzrr;
    }

    public String getClr() {
        return clr;
    }

    public void setClr(String clr) {
        this.clr = clr;
    }

    public String getYyfx() {
        return yyfx;
    }

    public void setYyfx(String yyfx) {
        this.yyfx = yyfx;
    }

    public String getFycs() {
        return fycs;
    }

    public void setFycs(String fycs) {
        this.fycs = fycs;
    }

    public String getSjgc() {
        return sjgc;
    }

    public void setSjgc(String sjgc) {
        this.sjgc = sjgc;
    }

    public double getYpfje() {
        return ypfje;
    }

    public void setYpfje(double ypfje) {
        this.ypfje = ypfje;
    }

    public String getGcpfqr() {
        return gcpfqr;
    }

    public void setGcpfqr(String gcpfqr) {
        this.gcpfqr = gcpfqr;
    }

    public double getGcsjpf() {
        return gcsjpf;
    }

    public void setGcsjpf(double gcsjpf) {
        this.gcsjpf = gcsjpf;
    }

    public long getGcpfrq() {
        return gcpfrq;
    }

    public void setGcpfrq(long gcpfrq) {
        this.gcpfrq = gcpfrq;
    }

    public String getNxhth() {
        return nxhth;
    }

    public void setNxhth(String nxhth) {
        this.nxhth = nxhth;
    }
}
