package com.testTask;


import com.testTask.repository.EntityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

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
}
