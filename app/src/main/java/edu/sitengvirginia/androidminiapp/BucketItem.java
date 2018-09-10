package edu.sitengvirginia.androidminiapp;

import java.util.ArrayList;

public class BucketItem {
    private String mname;
    private String mdescription;
    private String mlatitude;
    private String mlongitude;
    private String mdate;

    private BucketItem(String name, String description, String latitiude, String longitude, String date) {
        mname = name;
        mdescription = description;
        mlatitude = latitiude;
        mlongitude = longitude;
        mdate = date;

    }

    public String getMname() {
        return mname;
    }
    public String getMdescription() {
        return mdescription;
    }
    public String getMlatitude() {
        return mlatitude;
    }
    public String getMlongitude() {
        return mlongitude;
    }
    public String getMdate() {
        return mdate;
    }



    public int compareTo(String firstDate, String secondDate) {
        return firstDate.compareTo(secondDate);
    }

    public static ArrayList<BucketItem> createInitialBucketList() {
        ArrayList<BucketItem> initialList = new ArrayList<BucketItem>();
        initialList.add(new BucketItem("Last Year", "whatever", "37.3", "38.4", "2017/7/27"));
        initialList.add(new BucketItem("This Year", "whatever2", "37.33", "38.44", "2018/7/28"));
        return initialList;
    }
}
