package com.lu.domain;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by wuzhong on 16/1/25.
 * <p/>
 * 跟单中检
 */
@Entity
public class Gdzj implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(nullable = false)
    private Integer htId;

    private long jdhdsj;
    private String jdhdqk;
    private long zjhdsj;
    private String zjhdqk;
    private String zgcs;

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

    public long getJdhdsj() {
        return jdhdsj;
    }

    public void setJdhdsj(long jdhdsj) {
        this.jdhdsj = jdhdsj;
    }

    public String getJdhdqk() {
        return jdhdqk;
    }

    public void setJdhdqk(String jdhdqk) {
        this.jdhdqk = jdhdqk;
    }

    public long getZjhdsj() {
        return zjhdsj;
    }

    public void setZjhdsj(long zjhdsj) {
        this.zjhdsj = zjhdsj;
    }

    public String getZjhdqk() {
        return zjhdqk;
    }

    public void setZjhdqk(String zjhdqk) {
        this.zjhdqk = zjhdqk;
    }

    public String getZgcs() {
        return zgcs;
    }

    public void setZgcs(String zgcs) {
        this.zgcs = zgcs;
    }
}
