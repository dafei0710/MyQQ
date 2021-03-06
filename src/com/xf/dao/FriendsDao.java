package com.xf.dao;

import com.xf.beans.FriendsInfo;
import com.xf.beans.UserInfo;
import com.xf.utils.DBManager;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class FriendsDao {//做好友增删改查
    QueryRunner qr=new QueryRunner();

    public UserInfo getFrendsByHostId(int hostId){
        Connection conn = DBManager.getConn();
        try {
            return (UserInfo) qr.query(conn,"select * from friendsinfo where  hostid= ?",new BeanListHandler<>(FriendsInfo.class),hostId);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    //通过用户账户查询好友账户，hostid当前用户，返回好友账户集合
    public List<FriendsInfo> getFriends(int hostId){
        Connection conn = DBManager.getConn();
        try {
          return  qr.query(conn,"select * from friendsinfo where  hostid= ?",new BeanListHandler<>(FriendsInfo.class),hostId);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }
//添加好友
    public void addFriend(int hostid, int friendid) {
        Connection conn= DBManager.getConn();
        try {
            qr.execute(conn, "insert into friendsinfo values(null,?,?)",hostid,friendid);
            //qr.execute(conn, "insert into friendsinfo values(null,?,?)",friendid,hostid);
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
    /**
     * 通过当前好友账户查询好友是否存在
     * @param hostid
     * @param friendid
     * @return
     */
    public FriendsInfo getUserByHostIdAndFriendId(int hostid, int friendid) {
        Connection conn = DBManager.getConn();
        try {
            //return  qr.query(conn,"select * from friendsinfo where  hostid=? and friendid= ?",new BeanListHandler<>(FriendsInfo.class),hostid,friendid);
            return qr.query(conn,"select * from friendsinfo where hostid=? and friendid =?",new BeanHandler<>(FriendsInfo.class),hostid,friendid);
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return null;
    }





}

/*
 Connection conn = DBManager.getConn();
        try {
            //return  qr.query(conn,"select * from friendsinfo where  hostid=? and friendid= ?",new BeanListHandler<>(FriendsInfo.class),hostid,friendid);
            return qr.query(conn,"select * from friendsinfo where hostid=? and friendid =?",new BeanHandler<>(FriendsInfo.class),hostid,friendid);
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return null;
 */