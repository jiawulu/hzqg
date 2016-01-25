package com.lu.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;

/**
 * Created by wuzhong on 16/1/25.
 * <p/>
 * 跟单数据
 */
@Entity
public class Gdsj implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private Integer htId;

    private long ypqrsj;
    private long psdqysj;
    private int csyq;
    private long cswcsj;
    private String cyqk;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getHtId() {
        return htId;
    }

    public void setHtId(Integer htId) {
        this.htId = htId;
    }

    public long getYpqrsj() {
        return ypqrsj;
    }

    public void setYpqrsj(long ypqrsj) {
        this.ypqrsj = ypqrsj;
    }

    public long getPsdqysj() {
        return psdqysj;
    }

    public void setPsdqysj(long psdqysj) {
        this.psdqysj = psdqysj;
    }

    public int getCsyq() {
        return csyq;
    }

    public void setCsyq(int csyq) {
        this.csyq = csyq;
    }

    public long getCswcsj() {
        return cswcsj;
    }

    public void setCswcsj(long cswcsj) {
        this.cswcsj = cswcsj;
    }

    public String getCyqk() {
        return cyqk;
    }

    public void setCyqk(String cyqk) {
        this.cyqk = cyqk;
    }
}
