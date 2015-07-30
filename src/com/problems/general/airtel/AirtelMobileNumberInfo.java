package com.problems.general.airtel;

import java.util.Comparator;

/**
 * Created by raja on 10/07/15.
 */
public class AirtelMobileNumberInfo implements Comparator{

    public String seriesName;
    public String operatorName;
    public String dCircleName;
    public String dSHCircleName;


    @Override
    public int compare(Object o1, Object o2) {
        String obj1 = (String) o1;
        String obj2 = (String) o2;

        Integer i1 = new Integer(obj1);
        Integer i2 = new Integer(obj2);
        return i1.compareTo(i2);
    }

    @Override
    public boolean equals(Object obj) {
        AirtelMobileNumberInfo o = (AirtelMobileNumberInfo) obj;

        if(o==null){
            return false;
        }
        if(seriesName ==null && o.seriesName!=null){
            return false;
        }

        if(dSHCircleName ==null && o.dSHCircleName!=null){
            return false;
        }


        if (seriesName!=null && o.seriesName!=null && seriesName.equals(o.seriesName) &&
                (dSHCircleName!=null && o.dSHCircleName!=null && (dSHCircleName.equals("D_SH_CIRCLE_NAME_" + o.dSHCircleName) || o.dSHCircleName.equals("D_SH_CIRCLE_NAME_" + dSHCircleName)))) {
            return true;
        }
        return false;

    }
}
