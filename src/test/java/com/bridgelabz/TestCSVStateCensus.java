package com.bridgelabz;
import org.junit.jupiter.api.*;
import org.junit.Test;
import static org.junit.Assert.fail;

import java.util.ArrayList;

public class TestCSVStateCensus {
    static CSVStateCensus csvStateCensus;
    @Test
    public void testReadDataFromDestinationHappy(){
        csvStateCensus =  new CSVStateCensus();
        try{
            ArrayList<String> stateList = csvStateCensus.readDataFromSource("C:\\Day_29_Census_Analyzer\\src\\main\\java\\com\\bridgelabz\\State_census.csv");
            Assertions.assertEquals(stateList.size(), 199);
        } catch(Exception e){
            fail("Should not throw exception");
        }
    }

    // File name different
    @Test
    public void testReadDataFromDestinationSad1(){
        csvStateCensus =  new CSVStateCensus();
        try{
            ArrayList<String> stateList = csvStateCensus.readDataFromSource("C:\\Day_29_Census_Analyzer\\src\\main\\java\\com\\bridgelabz\\State.csv");
            fail("Should throw exception");
        } catch(Exception e){
            Assertions.assertNotNull(e.getMessage());
        }
    }

    // Incorrect file extension
    @Test
    public void testReadDataFromDestinationSad2(){
        csvStateCensus =  new CSVStateCensus();
        try{
            ArrayList<String> stateList = csvStateCensus.readDataFromSource("C:\\Day_29_Census_Analyzer\\src\\main\\java\\com\\bridgelabz\\State.txt");
            fail("Should throw exception");
        } catch(Exception e){
            Assertions.assertNotNull(e.getMessage());
        }
    }

}
