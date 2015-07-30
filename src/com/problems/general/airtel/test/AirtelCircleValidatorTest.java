package com.problems.general.airtel.test;

import com.problems.general.airtel.AirtelCircleValidator;

/**
 * Created by raja on 10/07/15.
 */
public class AirtelCircleValidatorTest {

    public static void main(String[] args) {

        // test 1 : five digit series number exists in five Digit property file and circle is same as is in master file

        AirtelCircleValidator.validateSeries("src/com/problems/general/airtel/test/properties/test1/g_circle_list4col.properties", "src/com/problems/general/airtel/test/properties/test1/g_circle_list5col.properties", "src/com/problems/general/airtel/test/properties/test1/Updated_Series_Master.csv","src/com/problems/general/airtel/test/properties/test1/UpdatedRecordsData.csv","src/com/problems/general/airtel/test/properties/test1/g_circle_list4col_updated.properties","src/com/problems/general/airtel/test/properties/test1/g_circle_list5col_updated.properties");

        // test 2 : five digit series number exists in five Digit property file and circle is different
        // after updating the properties file, checking if there are less than 10 unique numbers in this series
        // then no need to take any action

        AirtelCircleValidator.validateSeries("src/com/problems/general/airtel/test/properties/test2/g_circle_list4col.properties", "src/com/problems/general/airtel/test/properties/test2/g_circle_list5col.properties", "src/com/problems/general/airtel/test/properties/test2/Updated_Series_Master.csv","src/com/problems/general/airtel/test/properties/test2/UpdatedRecordsData.csv","src/com/problems/general/airtel/test/properties/test2/g_circle_list4col_updated.properties","src/com/problems/general/airtel/test/properties/test2/g_circle_list5col_updated.properties");

        // test 3 : five digit series number exists in five Digit property file and circle is different
        // after updating the properties file, checking if there are exactly 10 numbers(test3a) in this series
        // then remove all numbers for this series from five Digit property file and insert one record in four Digit property file
        // for this series otherwise (test3b)no need to take any action

        AirtelCircleValidator.validateSeries("src/com/problems/general/airtel/test/properties/test3a/g_circle_list4col.properties", "src/com/problems/general/airtel/test/properties/test3a/g_circle_list5col.properties", "src/com/problems/general/airtel/test/properties/test3a/Updated_Series_Master.csv","src/com/problems/general/airtel/test/properties/test3a/UpdatedRecordsData.csv","src/com/problems/general/airtel/test/properties/test3a/g_circle_list4col_updated.properties","src/com/problems/general/airtel/test/properties/test3a/g_circle_list5col_updated.properties");
        AirtelCircleValidator.validateSeries("src/com/problems/general/airtel/test/properties/test3b/g_circle_list4col.properties", "src/com/problems/general/airtel/test/properties/test3b/g_circle_list5col.properties", "src/com/problems/general/airtel/test/properties/test3b/Updated_Series_Master.csv","src/com/problems/general/airtel/test/properties/test3b/UpdatedRecordsData.csv" ,"src/com/problems/general/airtel/test/properties/test3b/g_circle_list4col_updated.properties","src/com/problems/general/airtel/test/properties/test3b/g_circle_list5col_updated.properties");

        // test 4 : five digit series number doesn't exist in five Digit property file
        //  but first four digits exists in Four digit property file and circle is same as is in master file

        AirtelCircleValidator.validateSeries("src/com/problems/general/airtel/test/properties/test4/g_circle_list4col.properties", "src/com/problems/general/airtel/test/properties/test4/g_circle_list5col.properties", "src/com/problems/general/airtel/test/properties/test4/Updated_Series_Master.csv","src/com/problems/general/airtel/test/properties/test4/UpdatedRecordsData.csv","src/com/problems/general/airtel/test/properties/test4/g_circle_list4col_updated.properties","src/com/problems/general/airtel/test/properties/test4/g_circle_list5col_updated.properties");

        // test 5 : five digit series number doesn't exist in five Digit property file
        //  but first four digits exists in Four digit property file and circle is different
        // then create new 9 new records in five Digit property file for this series for previous circle and
        // 1 new entry for newly added circle for the same series.
        // Note : remove entry from 4 digit property file.

        AirtelCircleValidator.validateSeries("src/com/problems/general/airtel/test/properties/test5/g_circle_list4col.properties", "src/com/problems/general/airtel/test/properties/test5/g_circle_list5col.properties", "src/com/problems/general/airtel/test/properties/test5/Updated_Series_Master.csv","src/com/problems/general/airtel/test/properties/test5/UpdatedRecordsData.csv","src/com/problems/general/airtel/test/properties/test5/g_circle_list4col_updated.properties","src/com/problems/general/airtel/test/properties/test5/g_circle_list5col_updated.properties");

        // test 6 : five digit series number doesn't exist in five Digit property file and
        // five digit series number doesn't exist in four Digit property file
        // then create a new record in five digit property file
        // after updating the properties file, checking if there are less than 10(unique) numbers in this series
        // then no need to take any action

        AirtelCircleValidator.validateSeries("src/com/problems/general/airtel/test/properties/test6/g_circle_list4col.properties", "src/com/problems/general/airtel/test/properties/test6/g_circle_list5col.properties", "src/com/problems/general/airtel/test/properties/test6/Updated_Series_Master.csv","src/com/problems/general/airtel/test/properties/test6/UpdatedRecordsData.csv","src/com/problems/general/airtel/test/properties/test6/g_circle_list4col_updated.properties","src/com/problems/general/airtel/test/properties/test6/g_circle_list5col_updated.properties");

        // test 7 : five digit series number doesn't exist in five Digit property file and
        // five digit series number doesn't exist in four Digit property file
        // then create a new record in five digit property file
        // after updating the property file, checking if there are exactly 10 numbers(test7a) in this series
        // then remove all numbers for this series from five Digit property file and insert one record in four Digit property file
        // for this series otherwise (test7b)no need to take any action

        AirtelCircleValidator.validateSeries("src/com/problems/general/airtel/test/properties/test7a/g_circle_list4col.properties", "src/com/problems/general/airtel/test/properties/test7a/g_circle_list5col.properties", "src/com/problems/general/airtel/test/properties/test7a/Updated_Series_Master.csv","src/com/problems/general/airtel/test/properties/test7a/UpdatedRecordsData.csv","src/com/problems/general/airtel/test/properties/test7a/g_circle_list4col_updated.properties","src/com/problems/general/airtel/test/properties/test7a/g_circle_list5col_updated.properties");
        AirtelCircleValidator.validateSeries("src/com/problems/general/airtel/test/properties/test7b/g_circle_list4col.properties", "src/com/problems/general/airtel/test/properties/test7b/g_circle_list5col.properties", "src/com/problems/general/airtel/test/properties/test7b/Updated_Series_Master.csv","src/com/problems/general/airtel/test/properties/test7b/UpdatedRecordsData.csv","src/com/problems/general/airtel/test/properties/test7b/g_circle_list4col_updated.properties","src/com/problems/general/airtel/test/properties/test7b/g_circle_list5col_updated.properties");
    }
}
