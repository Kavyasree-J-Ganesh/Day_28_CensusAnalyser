package com.bridgelabz;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class CSVStateCensus {


    public ArrayList<String> readDataFromSource(String path) throws Exception {
        ArrayList<String> stateList = new ArrayList<>();
        try{
            FileReader filereader = new FileReader(path);

            CSVReader csvReader = new CSVReader(filereader);
            String[] nextRecord;

            while ((nextRecord = csvReader.readNext()) != null) {
                String entry = "";
                for (String addressBookDetails : nextRecord) {
                    entry = entry + addressBookDetails + "\t";
                }
                stateList.add(entry);
                System.out.println(entry);
            }
        } catch (CsvValidationException e){
            throw new FileReadException("Error in Reading file");
        }

        return stateList;
    }
}
