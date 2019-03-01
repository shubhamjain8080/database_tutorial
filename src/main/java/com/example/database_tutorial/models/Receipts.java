package com.example.database_tutorial.models;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;

public class Receipts {

    @Id
    public ObjectId _id;

    public String customerOrderId;

    public Receipts() {}

    public Receipts(ObjectId _id, String customerOrderId) {
        this._id = _id;
        this.customerOrderId = customerOrderId;
    }

    public String getCustomerOrderId() {
        return customerOrderId;
    }

    public void setCustomerOrderId(String customerOrderId) {
        this.customerOrderId = customerOrderId;
    }

    public ObjectId get_id() {
        return _id;
    }

    public void set_id(ObjectId _id) {
        this._id = _id;
    }
}
