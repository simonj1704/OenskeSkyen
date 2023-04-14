package com.example.oenskeskyen.model;


public class Wish {

    private int id;
    private String wish_name;
    private String wish_link;
    private double wish_price;
    private boolean reserved;

    public Wish(int id, String wish_name, int wish_price, String wish_link, boolean reserved) {
        this.id = id;
        this.wish_name = wish_name;
        this.wish_price = wish_price;
        this.wish_link = wish_link;
        this.reserved = reserved;
    }

    public Wish(){
    }
    public double getWish_price() {
        return wish_price;
    }

    public void setWish_price(double wish_price) {
        this.wish_price = wish_price;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getWish_name() {
        return wish_name;
    }

    public void setWish_name(String wish_name) {
        this.wish_name = wish_name;
    }

    public String getWish_link() {
        return wish_link;
    }

    public void setWish_link(String wish_link) {
        this.wish_link = wish_link;
    }

    public boolean isReserved() {
        return reserved;
    }

    public void setReserved(boolean reserved) {
        this.reserved = reserved;
    }
}
