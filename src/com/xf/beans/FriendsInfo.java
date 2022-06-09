package com.xf.beans;

public class FriendsInfo {
    private int id;
    private int hostid;
    private int friendid;

    @Override
    public String toString() {
        return "FriendsInfo{" +
                "id=" + id +
                ", hostid=" + hostid +
                ", friendid=" + friendid +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getHostid() {
        return hostid;
    }

    public void setHostid(int hostid) {
        this.hostid = hostid;
    }

    public int getFriendid() {
        return friendid;
    }

    public void setFriendid(int friendid) {
        this.friendid = friendid;
    }
}
