/*
 * Copyright © 2015 Packt Publishing  - All Rights Reserved
 * Unauthorized copying of this file, via any medium is strictly prohibited
 */
package com.packtpub.rest.ch2.jackson;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.packtpub.rest.ch2.model.Employee;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * This class demonstrates object model(binding API) writer APIs in Jackson
 *
 * @author Jobinesh
 */
public class JacksonJsonObjModelWriterExample {

    private static final Logger logger = Logger.getLogger(JacksonJsonObjModelWriterExample.class.getName());

    public static void main(String[] args) throws IOException {
        logger.setLevel(Level.INFO);
        String fileName = "emp-array-modified.json";
        new JacksonJsonObjModelWriterExample().writeEmployeeList(fileName);
    }

    /**
     * This method illustrates the use of Jackson binding writer API for
     * converting List<Employee> in to JSON
     *
     * @param fileName
     * @throws IOException
     */
    public void writeEmployeeList(String fileName) throws IOException {
        List<Employee> employees = getEmployeesList();
        ObjectMapper mapper = new ObjectMapper();
        //write the list of employees to file
        OutputStream outputStream = new FileOutputStream(fileName);
        mapper.writeValue(outputStream, employees);
        outputStream.close();
    }

    /**
     * Gets List<Employee> from a JSON file
     *
     * @return
     * @throws IOException
     */
    private List<Employee> getEmployeesList() throws IOException {
        String jsonFileName = "/emp-array.json";
        List<Employee> employeeList = new JacksonJsonStreamingParserExample().buildEmployeeList(jsonFileName);
        return employeeList;
    }
}
