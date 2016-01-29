package com.lu.domain;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by wuzhong on 16/1/29.
 * <p/>
 * 出运检验
 * <p/>
 * 合同号	文本
 * 工厂	文本
 * 客号	文本
 * 检验要求	文本
 * 检验时间	通过，不通过
 * 检验结果
 * 内容备注
 * 整改内容	文本
 */
@Entity
public class Cyjy implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(nullable = false)
    private Integer htId;
    /**
     * 检验时间
     */
    private long jysj;
    /**
     * 检验结果
     */
    private String jyjg;
    /**
     * 内容备注
     */
    private String nrbz;
    /**
     * 整改内容	文本
     */
    private String zgnrwb;

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

    public long getJysj() {
        return jysj;
    }

    public void setJysj(long jysj) {
        this.jysj = jysj;
    }

    public String getJyjg() {
        return jyjg;
    }

    public void setJyjg(String jyjg) {
        this.jyjg = jyjg;
    }

    public String getNrbz() {
        return nrbz;
    }

    public void setNrbz(String nrbz) {
        this.nrbz = nrbz;
    }

    public String getZgnrwb() {
        return zgnrwb;
    }

    public void setZgnrwb(String zgnrwb) {
        this.zgnrwb = zgnrwb;
    }
}
