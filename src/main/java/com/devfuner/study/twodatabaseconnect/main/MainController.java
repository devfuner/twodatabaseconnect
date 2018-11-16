package com.devfuner.study.twodatabaseconnect.main;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class MainController {

    @Autowired
    MainMapper mainMapper;

    @GetMapping("main")
    public List<MainVo> list() {
        return mainMapper.list();
    }
}
