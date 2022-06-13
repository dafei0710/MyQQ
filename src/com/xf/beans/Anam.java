package com.xf.beans;

public class Anam {
    private int id;
    private int qq;
    private String pwd;
    private int staid;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getQq() {
        return qq;
    }

    public void setQq(int qq) {
        this.qq = qq;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public int getStaid() {
        return staid;
    }

    public void setStaid(int staid) {
        this.staid = staid;
    }



    @Override
    public String toString() {
        return "Anam{" +
                "id=" + id +
                ", qq=" + qq +
                ", pwd='" + pwd + '\'' +
                ", staid=" + staid +
                '}';
    }
}
