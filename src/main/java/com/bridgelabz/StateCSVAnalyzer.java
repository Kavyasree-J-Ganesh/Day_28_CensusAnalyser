package com.bridgelabz;

import java.util.ArrayList;

public class StateCSVAnalyzer {
    static String columnHeaderCensus = "State" + "\t" + "Population"+ "\t" + "AreaInSqKm" + "\t" + "DensityPerSqKm" + "\t";
    public static void main(String[] args) {
         CSVStateCensus stateCensus = new CSVStateCensus();
         try{
             ArrayList<String> stateList = stateCensus.readDataFromSource("C:\\Day_29_Census_Analyzer\\src\\main\\java\\com\\bridgelabz\\State_census.csv", columnHeaderCensus,4);
             System.out.println(stateList.size());
         } catch(Exception e){
             System.out.println(e.getMessage());
         }
    }

}
