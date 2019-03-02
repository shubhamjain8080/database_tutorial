package com.example.database_tutorial.models;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;

import java.text.SimpleDateFormat;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public class Receipts {

    @Id
    public ObjectId _id;

    public String receiptDate;

    public String orderDate;

    public ArrayList<Outlet> outlets;

    public String get_id() {
        return _id.toHexString();
    }
    public void set_id(ObjectId _id) {
        this._id = _id;
    }

    public String getDate(SimpleDateFormat formatter){
        String dateToBeParsed = getDateAsString();
        Date date = Date.from(Instant.parse(dateToBeParsed));
        return formatter.format(date);
    }

    public String getDateAsWeek(){
        String dateToBeParsed = getDateAsString();
        Date date = Date.from(Instant.parse(dateToBeParsed));
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        int week = calendar.get(Calendar.WEEK_OF_MONTH);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("MMM, yyyy");

        return (week + " week of " + getDate(simpleDateFormat));
    }

    private String getDateAsString() {
        return (receiptDate!=null && !receiptDate.equals("")) ? receiptDate : orderDate;
    }

}
