package com.devfuner.study.twodatabaseconnect.main;

public class MainVo {
    private Long id;
    private String mainName;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMainName() {
        return mainName;
    }

    public void setMainName(String mainName) {
        this.mainName = mainName;
    }

    @Override
    public String toString() {
        return "MainVo{" +
                "id=" + id +
                ", mainName='" + mainName + '\'' +
                '}';
    }
}
