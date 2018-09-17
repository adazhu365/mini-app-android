package edu.sitengvirginia.androidminiapp;

// date parsing idea from https://stackoverflow.com/questions/10774871/best-way-to-compare-dates-in-android

import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class BucketItem implements Serializable{
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

    public static BucketItem createBucketItem(String name, String description, String latitude, String longitude, String date) {
        BucketItem b = new BucketItem(name, description, latitude, longitude, date);
        return b;
    }

    public static BucketItem editBucketItem(BucketItem b, String name, String description, String latitude, String longitude, String date) {
        b = new BucketItem(name, description, latitude, longitude, date);
        return b;
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



    public static int compareTo(String firstDate, String secondDate) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
        Date first = sdf.parse(firstDate);
        Date second = sdf.parse(secondDate);
        if (first.after(second)) {
            return 0;
        }
        return 1;

    }

    public static ArrayList<BucketItem> createInitialBucketList() {
        ArrayList<BucketItem> initialList = new ArrayList<BucketItem>();
        initialList.add(new BucketItem("Last Year", "whatever", "37.3", "38.4", "2017/7/27"));
        return initialList;
    }
}
