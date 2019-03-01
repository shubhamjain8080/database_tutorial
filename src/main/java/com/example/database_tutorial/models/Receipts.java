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

    public ArrayList<Outlet> outlets;

    public String get_id() {
        return _id.toHexString();
    }
    public void set_id(ObjectId _id) {
        this._id = _id;
    }

    public String getDate(SimpleDateFormat formatter){
        Date date = Date.from(Instant.parse(receiptDate));
        return formatter.format(date);
    }

    public String getDateInWeekFormat(){
        Date date = Date.from(Instant.parse(receiptDate));
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        int week = calendar.get(Calendar.WEEK_OF_MONTH);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("MMM, yyyy");

        return (week + " week of " + getDate(simpleDateFormat));

    }

}
