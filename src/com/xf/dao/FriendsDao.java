package com.xf.dao;

import com.xf.beans.FriendsInfo;
import com.xf.utils.DBManager;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class FriendsDao {
    QueryRunner qr=new QueryRunner();
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
}
