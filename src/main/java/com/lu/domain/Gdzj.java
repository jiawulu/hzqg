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

    private long jdkdsj;
    private String jdkdqk;
    private long zjhksj;
    private String hzkdqk;
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

    public long getJdkdsj() {
        return jdkdsj;
    }

    public void setJdkdsj(long jdkdsj) {
        this.jdkdsj = jdkdsj;
    }

    public String getJdkdqk() {
        return jdkdqk;
    }

    public void setJdkdqk(String jdkdqk) {
        this.jdkdqk = jdkdqk;
    }

    public long getZjhksj() {
        return zjhksj;
    }

    public void setZjhksj(long zjhksj) {
        this.zjhksj = zjhksj;
    }

    public String getHzkdqk() {
        return hzkdqk;
    }

    public void setHzkdqk(String hzkdqk) {
        this.hzkdqk = hzkdqk;
    }

    public String getZgcs() {
        return zgcs;
    }

    public void setZgcs(String zgcs) {
        this.zgcs = zgcs;
    }
}
