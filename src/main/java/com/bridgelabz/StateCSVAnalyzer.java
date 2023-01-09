package com.bridgelabz;

import java.util.ArrayList;

public class StateCSVAnalyzer {
    public static void main(String[] args) {
         CSVStateCensus stateCensus = new CSVStateCensus();
         try{
             ArrayList<String> stateList = stateCensus.readDataFromSource();
             System.out.println(stateList.size());
         } catch(Exception e){
             System.out.println(e.getMessage());
         }
    }
}
