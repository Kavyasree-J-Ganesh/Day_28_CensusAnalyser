package com.bridgelabz;
import org.junit.jupiter.api.*;
import org.junit.Test;
import static org.junit.Assert.fail;

import java.util.ArrayList;

public class TestCSVStateCensus {
    static CSVStateCensus csvStateCensus;
    static String columnHeaderCensus = "State" + "\t" + "Population"+ "\t" + "AreaInSqKm" + "\t" + "DensityPerSqKm" + "\t";

    static String columnHeaderStateCode = "SrNo" + "\t" + "StateName" + "\t" + "TIN" + "\t" + "StateCode" + "\t";
    @Test
    public void testReadDataFromDestinationHappy(){
        csvStateCensus =  new CSVStateCensus();
        try{
            ArrayList<String> stateList = csvStateCensus.readDataFromSource("C:\\Day_29_Census_Analyzer\\src\\main\\java\\com\\bridgelabz\\State_census.csv", columnHeaderCensus,4);
            Assertions.assertEquals(stateList.size(), 30);
        } catch(Exception e){
            fail("Should not throw exception");
        }

        try{
            ArrayList<String> stateCodes = csvStateCensus.readDataFromSource("C:\\Day_29_Census_Analyzer\\src\\main\\java\\com\\bridgelabz\\stateCode.csv", columnHeaderStateCode,4);
            Assertions.assertEquals(stateCodes.size(), 38);
        } catch(Exception e){
            fail("Should not throw exception");
        }


    }

    // File name different
    @Test
    public void testReadDataFromDestinationSadWrongFile(){
        csvStateCensus =  new CSVStateCensus();
        try{
            ArrayList<String> stateList = csvStateCensus.readDataFromSource("C:\\Day_29_Census_Analyzer\\src\\main\\java\\com\\bridgelabz\\State.csv", columnHeaderCensus,4);
            fail("Should throw exception");
        } catch(Exception e){
            Assertions.assertNotNull(e.getMessage());
        }

        try{
            ArrayList<String> stateCodes = csvStateCensus.readDataFromSource("C:\\Day_29_Census_Analyzer\\src\\main\\java\\com\\bridgelabz\\State.csv", columnHeaderStateCode,4);
            fail("Should throw exception");
        } catch(Exception e){
            Assertions.assertNotNull(e.getMessage());
        }


    }

    // Incorrect file extension
    @Test
    public void testReadDataFromDestinationSadWrongFormat(){
        csvStateCensus =  new CSVStateCensus();
        try{
            ArrayList<String> stateList = csvStateCensus.readDataFromSource("C:\\Day_29_Census_Analyzer\\src\\main\\java\\com\\bridgelabz\\State.txt", columnHeaderCensus,4);
            fail("Should throw exception");
        } catch(Exception e){
            Assertions.assertEquals(e.getMessage(),"Error in Reading file");
        }

        try{
            ArrayList<String> stateCodes = csvStateCensus.readDataFromSource("C:\\Day_29_Census_Analyzer\\src\\main\\java\\com\\bridgelabz\\State.txt", columnHeaderStateCode,4);
            fail("Should throw exception");
        } catch(Exception e){
            Assertions.assertEquals(e.getMessage(),"Error in Reading file");
        }
    }

    // Incorrect delimiter
    @Test
    public void testReadDataFromDestinationSadWrongDelimiter(){
        csvStateCensus =  new CSVStateCensus();
        try{
            ArrayList<String> stateList = csvStateCensus.readDataFromSource("C:\\Day_29_Census_Analyzer\\src\\main\\java\\com\\bridgelabz\\State_census_wrong_delimiter.csv", columnHeaderCensus, 4);
            fail("Should throw exception");
        } catch(Exception e){
            Assertions.assertEquals(e.getMessage(), "Error in Reading file");
        }

        try{
            ArrayList<String> stateCodes = csvStateCensus.readDataFromSource("C:\\Day_29_Census_Analyzer\\src\\main\\java\\com\\bridgelabz\\stateCode_wrong_delimiter.csv", columnHeaderStateCode,4);
            fail("Should throw exception");
        } catch(Exception e){
            Assertions.assertEquals(e.getMessage(), "Error in Reading file");
        }
    }

    @Test
    public void testReadDataFromDestinationSadWrongHeader(){
        csvStateCensus =  new CSVStateCensus();
        try{
            ArrayList<String> stateList = csvStateCensus.readDataFromSource("C:\\Day_29_Census_Analyzer\\src\\main\\java\\com\\bridgelabz\\State_census_wrong_header.csv", columnHeaderCensus , 4);
            fail("Should throw exception");
        } catch(Exception e){
            Assertions.assertEquals(e.getMessage(), "Error in Reading file");
        }

        try{
            ArrayList<String> stateList = csvStateCensus.readDataFromSource("C:\\Day_29_Census_Analyzer\\src\\main\\java\\com\\bridgelabz\\State_census_wrong_header.csv", columnHeaderStateCode , 4);
            fail("Should throw exception");
        } catch(Exception e){
            Assertions.assertEquals(e.getMessage(), "Error in Reading file");
        }
    }

}
