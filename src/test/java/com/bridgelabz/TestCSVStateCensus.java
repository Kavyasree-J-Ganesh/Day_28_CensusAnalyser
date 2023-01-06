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
            ArrayList<String> stateList = csvStateCensus.readDataFromSource();
            Assertions.assertEquals(stateList.size(), 199);
        } catch(Exception e){
            fail("Should not throw exception");
        }
    }

}
