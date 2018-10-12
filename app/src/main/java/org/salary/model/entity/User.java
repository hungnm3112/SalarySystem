package org.salary.model.entity;

public class User {
    private String name;
    private String code;
    private int idResImg;

    public User(String name, String code, int idResImg) {
        this.name = name;
        this.code = code;
        this.idResImg = idResImg;
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

    public int getIdResImg() {
        return idResImg;
    }

    public void setIdResImg(int idResImg) {
        this.idResImg = idResImg;
    }

}
