package com.problems.general.airtel;

import java.io.*;
import java.util.Map;
import java.util.TreeMap;

/**
 * Created by raja on 10/07/15.
 */
public class AirtelCircleValidator {

    private static final String COMMA_DELIMITER = ",";
    private static final String NEW_LINE_SEPARATOR = "\n";
    private static final String FILE_HEADER = "CIRCLE,CIRCLE_ID,SERIES,COMMENTS";
    public static final String D_SH_CIRCLE_NAME = "D_SH_CIRCLE_NAME_";
    public static final String D_CIRCLE_NAME = "D_CIRCLE_NAME_";
    public static final String D_OPERATOR_NAME_AT = "D_OPERATOR_NAME_AT";

    public static void main(String[] args) {
        validateSeries("/Users/raja/Downloads/airtel_circle/g_circle_list4col.properties", "/Users/raja/Downloads/airtel_circle/g_circle_list5col.properties", "/Users/raja/Downloads/airtel_circle/Updated_Series_Master.csv", "/Users/raja/Downloads/airtel_circle/data.csv", "/Users/raja/Downloads/airtel_circle/g_circle_list4col_updated.properties", "/Users/raja/Downloads/airtel_circle/g_circle_list5col_updated.properties");
    }

    public static void validateSeries(String circleListFilePathFourDigit, String circleListFilePathFiveDigit, String updatedSeriesMasterFilePath, String outputFile, String writeCsvFileForFourDigitsOnPath, String writeCsvFileForFiveDigitsOnPath) {
        TreeMap<String, AirtelMobileNumberInfo> circleListOfFourDigits = ReadFileUtility.readCircleListFile(circleListFilePathFourDigit);
        TreeMap<String, AirtelMobileNumberInfo> circleListOfFiveDigits = ReadFileUtility.readCircleListFile(circleListFilePathFiveDigit);

        Map<String, AirtelMobileNumberInfo> updatedSeriesMasterFile = ReadFileUtility.readUpdatedSeriesMasterFile(updatedSeriesMasterFilePath);

        FileWriter fileWriter = null;

        try {
            fileWriter = new FileWriter(outputFile);

            //Write the CSV file header
            fileWriter.append(FILE_HEADER.toString());

            //Add a new line separator after the header
            fileWriter.append(NEW_LINE_SEPARATOR);


            for (Map.Entry<String, AirtelMobileNumberInfo> entry : updatedSeriesMasterFile.entrySet()) {
                String series = entry.getKey();
                AirtelMobileNumberInfo info = entry.getValue();
                if (circleListOfFiveDigits.containsKey(series)) {
                    ProcessCircleListForFiveDigits(circleListOfFourDigits, circleListOfFiveDigits, fileWriter, series, info);
                } else if (circleListOfFourDigits.containsKey(series.substring(0, series.length() - 1))) {
                    processCircleListForFourDigit(circleListOfFourDigits, circleListOfFiveDigits, fileWriter, series, info);
                } else {
                    // record not found, then add a new record
                    processCircleListWhenSeriesNotFound(circleListOfFourDigits, circleListOfFiveDigits, series, info, fileWriter);
                }
            }
            System.out.println("file was created successfully on the location : " + outputFile + "for those records which need to be updated/created!!!");
        } catch (Exception e) {
            System.out.println("Error in CsvFileWriter !!!");
            e.printStackTrace();
        } finally {

            try {
                fileWriter.flush();
                fileWriter.close();
            } catch (IOException e) {
                System.out.println("Error while flushing/closing fileWriter !!!");
                e.printStackTrace();
            }

        }

        // Update properties file

        TextFileWriter.writeCsvFile(writeCsvFileForFourDigitsOnPath, circleListOfFourDigits);
        TextFileWriter.writeCsvFile(writeCsvFileForFiveDigitsOnPath, circleListOfFiveDigits);

    }

    private static void processCircleListWhenSeriesNotFound(TreeMap<String, AirtelMobileNumberInfo> circleListOfFourDigits, TreeMap<String, AirtelMobileNumberInfo> circleListOfFiveDigits, String series, AirtelMobileNumberInfo info, FileWriter fileWriter) {
        AirtelMobileNumberInfo newInfo = new AirtelMobileNumberInfo();
        newInfo.seriesName = series;
        newInfo.dSHCircleName = D_SH_CIRCLE_NAME + info.dSHCircleName;
        newInfo.dCircleName = D_CIRCLE_NAME + info.dSHCircleName;
        newInfo.operatorName = D_OPERATOR_NAME_AT;
        circleListOfFiveDigits.put(series, newInfo);

        int count = 0;
        // check if all circles are of same region then increment the count
        for (int i = 0; i < 10; i++) {
            if (circleListOfFiveDigits.containsKey(series.substring(0, series.length() - 1) + i) &&
                    circleListOfFiveDigits.get(series.substring(0, series.length() - 1) + i).dSHCircleName.equals(D_SH_CIRCLE_NAME + info.dSHCircleName)) {
                count++;
            } else {
                break;
            }
        }

        // if count is 10 ... it means all series are from same circle , thus remove the property from five digit
        // property file and create a new entry in four digit property file.
        if (count == 10) {
            AirtelMobileNumberInfo newInfo1 = new AirtelMobileNumberInfo();
            newInfo1.seriesName = series.substring(0, series.length() - 1);
            newInfo1.dSHCircleName = D_SH_CIRCLE_NAME + info.dSHCircleName;
            newInfo1.dCircleName = D_CIRCLE_NAME + info.dSHCircleName;
            newInfo1.operatorName = D_OPERATOR_NAME_AT;
            circleListOfFourDigits.put(series.substring(0, series.length() - 1), newInfo1);
            for (int i = 0; i < 10; i++) {
                circleListOfFiveDigits.remove(series.substring(0, series.length() - 1) + i);
            }
        }

        try {
            fileWriter.append(info.dSHCircleName);
            fileWriter.append(COMMA_DELIMITER);
            fileWriter.append(info.dCircleName);
            fileWriter.append(COMMA_DELIMITER);
            fileWriter.append(series);
            fileWriter.append(COMMA_DELIMITER);
            fileWriter.append("Five and Four Digit doesn't match");
            fileWriter.append(NEW_LINE_SEPARATOR);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void processCircleListForFourDigit(TreeMap<String, AirtelMobileNumberInfo> circleListOfFourDigits, TreeMap<String, AirtelMobileNumberInfo> circleListOfFiveDigits, FileWriter fileWriter, String series, AirtelMobileNumberInfo info) throws IOException {
        if (circleListOfFourDigits.get(series.substring(0, series.length() - 1)).dSHCircleName.equals(D_SH_CIRCLE_NAME + info.dSHCircleName)) {
            // record found -- Do nothing
        } else {

            for (int i = 0; i <= 9; i++) {
                AirtelMobileNumberInfo newNumber = new AirtelMobileNumberInfo();
                newNumber.seriesName = series.substring(0, series.length() - 1) + i;
                newNumber.dSHCircleName = circleListOfFourDigits.get(series.substring(0, series.length() - 1)).dSHCircleName;
                newNumber.dCircleName = circleListOfFourDigits.get(series.substring(0, series.length() - 1)).dCircleName;
                newNumber.operatorName = circleListOfFourDigits.get(series.substring(0, series.length() - 1)).operatorName;
                circleListOfFiveDigits.put(series.substring(0, series.length() - 1) + i, newNumber);
            }
            circleListOfFiveDigits.get(series).dSHCircleName = D_SH_CIRCLE_NAME + info.dSHCircleName;
            circleListOfFiveDigits.get(series).dCircleName = D_CIRCLE_NAME + info.dSHCircleName;
            circleListOfFourDigits.remove(series.substring(0, series.length() - 1));
            fileWriter.append(info.dSHCircleName);
            fileWriter.append(COMMA_DELIMITER);
            fileWriter.append(info.dCircleName);
            fileWriter.append(COMMA_DELIMITER);
            fileWriter.append(series);
            fileWriter.append(COMMA_DELIMITER);
            fileWriter.append("Four Digit matches but circle doesn't match");
            fileWriter.append(NEW_LINE_SEPARATOR);
        }
    }

    private static void ProcessCircleListForFiveDigits(TreeMap<String, AirtelMobileNumberInfo> circleListOfFourDigits, TreeMap<String, AirtelMobileNumberInfo> circleListOfFiveDigits, FileWriter fileWriter, String series, AirtelMobileNumberInfo info) throws IOException {
        if (circleListOfFiveDigits.get(series).equals(info)) {
            // record found
        } else {
            circleListOfFiveDigits.get(series).dSHCircleName = D_SH_CIRCLE_NAME + info.dSHCircleName;
            circleListOfFiveDigits.get(series).dCircleName = D_CIRCLE_NAME + info.dSHCircleName;
            // check if all circles are of same region then increment the count
            int count = 0;
            for (int i = 0; i < 10; i++) {
                if (circleListOfFiveDigits.containsKey(series.substring(0, series.length() - 1) + i) &&
                        circleListOfFiveDigits.get(series.substring(0, series.length() - 1) + i).equals(info)) {
                    count++;
                } else {
                    break;
                }
            }
            // if count is 10 ... it means all series are from same circle , thus remove the property from five digit
            // property file and create a new entry in four digit property file.
            if (count == 10) {
                AirtelMobileNumberInfo newInfo = new AirtelMobileNumberInfo();
                newInfo.seriesName = series.substring(0, series.length() - 1);
                newInfo.dSHCircleName = D_SH_CIRCLE_NAME + info.dSHCircleName;
                newInfo.dCircleName = D_CIRCLE_NAME + info.dSHCircleName;
                newInfo.operatorName = D_OPERATOR_NAME_AT;
                circleListOfFourDigits.put(series.substring(0, series.length() - 1), newInfo);
                for (int i = 0; i < 10; i++) {
                    circleListOfFiveDigits.remove(series.substring(0, series.length() - 1) + i);
                }
            }
            fileWriter.append(info.dSHCircleName);
            fileWriter.append(COMMA_DELIMITER);
            fileWriter.append(info.dCircleName);
            fileWriter.append(COMMA_DELIMITER);
            fileWriter.append(series);
            fileWriter.append(COMMA_DELIMITER);
            fileWriter.append("Five Digit matches but circle doesn't match");
            fileWriter.append(NEW_LINE_SEPARATOR);
        }
    }

}
