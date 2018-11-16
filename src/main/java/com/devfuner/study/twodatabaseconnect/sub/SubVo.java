package com.devfuner.study.twodatabaseconnect.sub;

public class SubVo {
    private Long id;
    private String subName;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSubName() {
        return subName;
    }

    public void setSubName(String subName) {
        this.subName = subName;
    }

    @Override
    public String toString() {
        return "SubVo{" +
                "id=" + id +
                ", subName='" + subName + '\'' +
                '}';
    }
}
