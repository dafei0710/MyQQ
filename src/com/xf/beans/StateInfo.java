package com.xf.beans;

public class StateInfo {
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    //状态编号
    private int id;
    //状态名称
    private String state;

    @Override
    public String toString() {//
        return "StateInfo{" +
                "id=" + id +
                ", state='" + state + '\'' +
                '}';
    }
}
