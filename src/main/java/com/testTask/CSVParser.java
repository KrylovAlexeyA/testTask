package com.testTask;


import java.io.FileReader;
import java.util.List;

import au.com.bytecode.opencsv.CSVReader;
import au.com.bytecode.opencsv.bean.ColumnPositionMappingStrategy;
import au.com.bytecode.opencsv.bean.CsvToBean;

public class CSVParser {

    @SuppressWarnings({"rawtypes", "unchecked"})
    public List parse(String csvFilename) throws Exception {
        CsvToBean csv = new CsvToBean();
        //String csvFilename = "/Users/a17065355/Desktop/source.csv";
        CSVReader csvReader = new CSVReader(new FileReader(csvFilename));
        //Set column mapping strategy
        List list = csv.parse(setColumMapping(), csvReader);
        for (Object object : list) {
            Entity entity = (Entity) object;
            System.out.println(entity);
        }
        return list;
    }

    @SuppressWarnings({"rawtypes", "unchecked"})
    private static ColumnPositionMappingStrategy setColumMapping() {
        ColumnPositionMappingStrategy strategy = new ColumnPositionMappingStrategy();
        strategy.setType(Entity.class);
        String[] columns = new String[]{"id", "name", "value"};
        strategy.setColumnMapping(columns);
        return strategy;
    }

}