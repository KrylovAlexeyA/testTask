package com.testTask;

import com.testTask.repository.EntityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

@SpringBootApplication
public class TestTaskApplication {


	private EntityRepository entityRepository;

	public static void main(String[] args) throws Exception {
		SpringApplication.run(TestTaskApplication.class, args);
		String csvFilename = "/Users/a17065355/Desktop/source.csv";
		CSVParser csvParser = new CSVParser();
		List list = csvParser.parse(csvFilename);

	}

}
