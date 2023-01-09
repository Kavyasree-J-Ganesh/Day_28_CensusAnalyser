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


    public ArrayList<String> readDataFromSource(String path, String expectedColumnHeader, int expectedColumnCount) throws Exception {
        ArrayList<String> stateList = new ArrayList<>();
        try{
            FileReader filereader = new FileReader(path);
            int count = 0;
            CSVReader csvReader = new CSVReader(filereader);
            String[] nextRecord;
            while ((nextRecord = csvReader.readNext()) != null) {
                int columCount = 0;
                String entry = "";
                for (String addressBookDetails : nextRecord) {
                    entry = entry + addressBookDetails + "\t";
                    columCount++;
                }
                if( count==0 && columCount != expectedColumnCount){
                    throw new FileReadException("Error in Reading file");
                }

                if(count ==0 && !entry.equals(expectedColumnHeader)) {
                    System.out.println(entry);
                    System.out.println(expectedColumnHeader);
                    throw new FileReadException("Error in Reading file");
                }
                stateList.add(entry);
                System.out.println(entry);
                count++;
            }
        } catch (Exception e){
            throw new FileReadException("Error in Reading file");
        }

        return stateList;
    }
}
