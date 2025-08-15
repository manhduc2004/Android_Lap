package com.example.baithuchanh_14_2;


public class Item {
    private String ma;
    private String ten;
    private boolean like;

    public Item(String ma, String ten, boolean like) {
        this.ma = ma;
        this.ten = ten;
        this.like = like;
    }

    public String getMa() { return ma; }
    public String getTen() { return ten; }
    public boolean isLike() { return like; }

    public void setLike(boolean like) { this.like = like; }
}