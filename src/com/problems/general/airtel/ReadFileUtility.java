package com.problems.general.airtel;

import java.io.*;
import java.util.TreeMap;

/**
 * Created by raja on 10/07/15.
 */
public class ReadFileUtility {

    public static TreeMap<String, AirtelMobileNumberInfo> readUpdatedSeriesMasterFile(String filePath) {
        // Open the file
        FileInputStream fstream = null;
        try {
            fstream = new FileInputStream(filePath);
        } catch (FileNotFoundException e) {
            System.out.println("File not found Exception :" + e);
        }
        BufferedReader br = new BufferedReader(new InputStreamReader(fstream));

        TreeMap<String, AirtelMobileNumberInfo> map = new TreeMap<String, AirtelMobileNumberInfo>(new AirtelMobileNumberInfo());

        //Read File Line By Line
        try {
            String strLine = br.readLine();
            while ((strLine = br.readLine()) != null) {
                // Print the content on the console
                System.out.println(strLine);
                String[] value = strLine.split(",");
                String circle = value[0];
                String circleId = value[1];
                String series = value[2];

                AirtelMobileNumberInfo info = new AirtelMobileNumberInfo();
                info.seriesName = series.trim();
                info.operatorName = circle.trim();
                info.dCircleName = circleId.trim();
                info.dSHCircleName = circle.trim();

                map.put(series, info);

            }
        } catch (IOException e) {
            System.out.println("IOException :" + e);
        }

        //Close the input stream
        try {
            br.close();
        } catch (IOException e) {
            System.out.println("IOException :" + e);
        }

        return map;
    }

    public static TreeMap<String, AirtelMobileNumberInfo> readCircleListFile(String filePath) {
        // Open the file
        FileInputStream fstream = null;
        try {
            fstream = new FileInputStream(filePath);
        } catch (FileNotFoundException e) {
            System.out.println("File not found Exception :" + e);
        }
        BufferedReader br = new BufferedReader(new InputStreamReader(fstream));

        TreeMap<String, AirtelMobileNumberInfo> map = new TreeMap<String, AirtelMobileNumberInfo>(new AirtelMobileNumberInfo());
        String strLine;

        //Read File Line By Line
        try {
            while ((strLine = br.readLine()) != null) {
                // Print the content on the console
                System.out.println(strLine);

                String[] value = strLine.split("=");
                String series = value[0];
                String circle = value[1];

                String trimmedText = circle.replaceAll("\\{", "");
                trimmedText = trimmedText.replaceAll("\\}", "");
                String[] circles = trimmedText.split(",");

                AirtelMobileNumberInfo info = new AirtelMobileNumberInfo();
                info.seriesName = series;
                info.operatorName = circles[0].trim();
                info.dCircleName = circles[1].trim();
                info.dSHCircleName = circles[2].trim();

                map.put(series, info);

            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        //Close the input stream
        try {
            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return map;
    }
}
