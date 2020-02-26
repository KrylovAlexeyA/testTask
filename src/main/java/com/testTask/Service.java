package com.testTask;


import com.testTask.repository.EntityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.util.Collections;
import java.util.List;

@org.springframework.stereotype.Service
public class Service {

    @Autowired
    private EntityRepository repository;

    public List getEntities(){
        return Collections.singletonList(repository.findAll());
    }

    public void readAndSave() throws Exception {
        String csvFilename = "/Users/a17065355/Desktop/source.csv";
        CSVParser csvParser = new CSVParser();
        List list = csvParser.parse(csvFilename);
        repository.saveAll(list);
    }


    public void testPrint() throws IOException {
        ClassLoader classLoader = getClass().getClassLoader();
        URL resource = classLoader.getResource("input/source.csv");
        try (FileReader reader = new FileReader(resource.getFile());
             BufferedReader br = new BufferedReader(reader)) {
            String line;
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }
        }
    }
}
