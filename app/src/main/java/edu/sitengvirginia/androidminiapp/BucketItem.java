package edu.sitengvirginia.androidminiapp;

// date parsing idea from https://stackoverflow.com/questions/10774871/best-way-to-compare-dates-in-android

import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class BucketItem implements Serializable, Comparable<BucketItem>{
    private String mname;
    private String mdescription;
    private String mlatitude;
    private String mlongitude;
    private String mdate;
    private boolean mchecked;

    private BucketItem(String name, String description, String latitiude, String longitude, String date, boolean checked) {
        mname = name;
        mdescription = description;
        mlatitude = latitiude;
        mlongitude = longitude;
        mdate = date;
        mchecked = checked;
    }

    public static BucketItem createBucketItem(String name, String description, String latitude, String longitude, String date, boolean checked) {
        BucketItem b = new BucketItem(name, description, latitude, longitude, date, checked);
        return b;
    }

    public static BucketItem editBucketItem(BucketItem b, String name, String description, String latitude, String longitude, String date, boolean checked) {
        b = new BucketItem(name, description, latitude, longitude, date, checked);
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
    public void setMchecked(boolean val){this.mchecked=val; }

    public boolean getMchecked() {
        return mchecked;
    }

    public int compareTo(BucketItem b) {
        if(b.getMchecked() == true && this.getMchecked() == false) {
            return -1;
        }
        else if (b.getMchecked() == false && this.getMchecked() == true) {
            return 1;
        }
        else {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
            Date first = null;
            try {
                first = sdf.parse(b.getMdate());
            } catch (ParseException e) {
                e.printStackTrace();
            }
            Date second = null;
            try {
                second = sdf.parse(this.getMdate());
            } catch (ParseException e) {
                e.printStackTrace();
            }
            if (first.after(second)) {
                return -1;
            }
            else {
                return 1;
            }
        }
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
        initialList.add(new BucketItem("Last Year", "whatever", "37.3", "38.4", "2017/7/27", false));

        initialList.add(new BucketItem("Last Year2", "whatever", "37.3", "38.4", "2018/8/27", false));

        initialList.add(new BucketItem("Last Year3", "whatever", "37.3", "38.4", "2018/10/27", false));

        return initialList;
    }
}
