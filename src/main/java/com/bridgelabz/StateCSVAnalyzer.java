package com.bridgelabz;

import java.util.ArrayList;

public class StateCSVAnalyzer {
    static String columnHeaderCensus = "State" + "\t" + "Population"+ "\t" + "AreaInSqKm" + "\t" + "DensityPerSqKm" + "\t";

    static String columnHeaderStateCode = "SrNo" + "\t" + "StateName" + "\t" + "TIN" + "\t" + "StateCode" + "\t";
    public static void main(String[] args) {

         System.out.println("State Census Data");
         System.out.println("_________________");
         CSVStateCensus stateCensus = new CSVStateCensus();
         try{
             ArrayList<String> stateList = stateCensus.readDataFromSource("C:\\Day_29_Census_Analyzer\\src\\main\\java\\com\\bridgelabz\\State_census.csv", columnHeaderCensus,4);
         } catch(Exception e){
             System.out.println(e.getMessage());
         }

        System.out.println("State Code Data");
        System.out.println("_________________");
        try{
            ArrayList<String> stateList = stateCensus.readDataFromSource("C:\\Day_29_Census_Analyzer\\src\\main\\java\\com\\bridgelabz\\stateCode.csv", columnHeaderStateCode,4);
            System.out.println(stateList.size());
        } catch(Exception e){
            System.out.println(e.getMessage());
        }
    }



}
