package com.lu.domain;

import java.io.Serializable;
import java.util.List;

/**
 * Created by wuzhong on 16/2/10.
 */
public class HtzlDto implements Serializable {

    private Integer id;
    /**
     * 样品确认时间
     */
    private long ypqrsj;
    /**
     * 评审单签样时间
     */
    private long psdqysj;
    /**
     * 测试要求	判断	列表选择  ：是  ： 或者  ：否：
     */
    private int csyq;
    /**
     * 测试完成时间
     */
    private long cswcsj;

    private List<Gdzj> zjs;

    private List<Cyjy> cjs;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public List<Gdzj> getZjs() {
        return zjs;
    }

    public void setZjs(List<Gdzj> zjs) {
        this.zjs = zjs;
    }

    public List<Cyjy> getCjs() {
        return cjs;
    }

    public void setCjs(List<Cyjy> cjs) {
        this.cjs = cjs;
    }
}
