package com.devfuner.study.twodatabaseconnect.sub;

import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface SubMapper {

    List<SubVo> list();
}
