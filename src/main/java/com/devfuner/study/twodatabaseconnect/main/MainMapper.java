package com.devfuner.study.twodatabaseconnect.main;

import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface MainMapper {

    List<MainVo> list();
}
