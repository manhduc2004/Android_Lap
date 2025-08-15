package com.example.baithuchanh_13_customlayout;

public class Phone {
    private String namephone;
    private int imagephone;
    private String price;

    public Phone(String namephone, int imagephone, String price) {
        this.namephone = namephone;
        this.imagephone = imagephone;
        this.price = price;
    }

    public String getNamephone() {
        return namephone;
    }

    public void setNamephone(String namephone) {
        this.namephone = namephone;
    }

    public int getImagephone() {
        return imagephone;
    }

    public void setImagephone(int imagephone) {
        this.imagephone = imagephone;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }
}