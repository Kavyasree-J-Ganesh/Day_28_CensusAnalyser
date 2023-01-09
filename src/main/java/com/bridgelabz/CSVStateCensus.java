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
    static String FILE_PATH = "C:\\Day_29_Census_Analyzer\\src\\main\\java\\com\\bridgelabz\\State_census.csv";

    public ArrayList<String> readDataFromSource() throws IOException {
        ArrayList<String> stateList = new ArrayList<>();
        try{
            FileReader filereader = new FileReader(FILE_PATH);

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
           
        }

        return stateList;
    }
}
