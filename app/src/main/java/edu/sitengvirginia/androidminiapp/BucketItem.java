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
        initialList.add(new BucketItem("first item", "whatever", "37.3", "38.4", "7/27/1997"));
        initialList.add(new BucketItem("second item", "whatever2", "37.33", "38.44", "7/27/1998"));
        return initialList;
    }
}
