package com.testTask;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class Controler {

    @Autowired
    private Service service;


    @GetMapping("/getInfo")
    public String getInfo(){
        return "все ок";
    }


    @GetMapping("/get")
    public List getEntities(){
        return service.getEntities();
    }

    @GetMapping("/save")
    public void readFileAndSaveToDB() throws Exception {
        service.readAndSave();
    }
}
