package com.tourism.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Table(name="log")
public class Log extends BaseEntity  {
    //名称
    @Column(name= "name")
    private String name;

    //说明
    @Column(name= "info")
    private String info;

    //次数
    @Column(name= "num")
    private String num;

    //日期
    @Column(name= "create_time")
    private Date createTime;

    public String getName() {
        return name;
    }

    public String getInfo() {
        return info;
    }

    public String getNum() {
        return num;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public void setNum(String num) {
        this.num = num;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }


}
