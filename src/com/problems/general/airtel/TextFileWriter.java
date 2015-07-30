package com.problems.general.airtel;

import java.io.IOException;
import java.util.Map;
import java.util.TreeMap;

public class TextFileWriter {

    private static final String COMMA_DELIMITER = ",";
    private static final String NEW_LINE_SEPARATOR = "\n";

    //CSV file header
    private static final String FILE_HEADER = "SERIES,D_CIRCLE_NAME_MP,D_SH_CIRCLE_NAME_MP";

    public static void writeCsvFile(String fileName, TreeMap<String,AirtelMobileNumberInfo> data) {


        java.io.FileWriter fileWriter = null;

        try {
            fileWriter = new java.io.FileWriter(fileName);

            //Write the CSV file header
//            fileWriter.append(FILE_HEADER.toString());

            //Add a new line separator after the header
//            fileWriter.append(NEW_LINE_SEPARATOR);

            for (Map.Entry<String, AirtelMobileNumberInfo> entry : data.entrySet()) {
                String series = entry.getKey();
                AirtelMobileNumberInfo info = entry.getValue();
                fileWriter.append(series);
                fileWriter.append("= {");
                fileWriter.append(info.operatorName);
                fileWriter.append(COMMA_DELIMITER);
                fileWriter.append(info.dCircleName);
                fileWriter.append(COMMA_DELIMITER);
                fileWriter.append(info.dSHCircleName);
                fileWriter.append(" }");
                fileWriter.append(NEW_LINE_SEPARATOR);
            }

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
    }
}
