package com.example.myapplication_1.Fragments;

public class MessageDialog {

    public String uuid, message, order_uuid, driver_uuid, tag;
    public boolean ack;
    public long created_at_unix;

    public String getUuid(){
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public String getMessage(){
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getOrderUuid(){
        return order_uuid;
    }

    public void setOrderUuid(String order_uuid) {
        this.order_uuid = order_uuid;
    }

    public String getDriverUuid(){
        return driver_uuid;
    }

    public void setDriverUuid(String driver_uuid) {
        this.driver_uuid = driver_uuid;
    }

    public String getTag(){
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public boolean getAck(){
        return ack;
    }

    public void setAck(boolean ack) {
        this.ack = ack;
    }

    public long getCreatedAtUnix(){
        return created_at_unix;
    }

    public void setCreatedAtUnix(long created_at_unix) {
        this.created_at_unix = created_at_unix;
    }
}

