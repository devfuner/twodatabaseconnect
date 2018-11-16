package com.devfuner.study.twodatabaseconnect.sub;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class SubController {

    @Autowired
    SubMapper subMapper;

    @GetMapping("sub")
    public List<SubVo> list() {
        return subMapper.list();
    }
}
