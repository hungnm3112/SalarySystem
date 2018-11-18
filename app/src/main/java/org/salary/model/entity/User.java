package org.salary.model.entity;

import android.graphics.Bitmap;

public class User {

    private int id;
    private String name;
    private String code;
    private byte[] img;
    private int idResImg;

    public User(int id, String name, String code, int idResImg) {
        this.id = id;
        this.name = name;
        this.code = code;
        this.idResImg = idResImg;
    }

    public User() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public byte[] getImg() {
        return img;
    }

    public void setImg(byte[] img) {
        this.img = img;
    }

    public int getIdResImg() {
        return idResImg;
    }

    public void setIdResImg(int idResImg) {
        this.idResImg = idResImg;
    }

}
