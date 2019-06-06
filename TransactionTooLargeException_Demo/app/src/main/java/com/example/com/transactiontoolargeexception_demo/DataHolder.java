package com.example.com.transactiontoolargeexception_demo;

public class DataHolder {
    private int[] data;
    public int[] getData() {
        return data;
    }

    public void setData(int[] data) {
        this.data = data;
    }

    private final static DataHolder holder = new DataHolder();

    public static DataHolder getInstance() {
        return holder;
    }

}
