package com.xf.dao;

import com.xf.beans.StateInfo;
import com.xf.beans.UserInfo;
import com.xf.utils.DBManager;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class StateDao {
    QueryRunner qr =new QueryRunner();
    public List<StateInfo> getStates(){
        //通过工具类去获取数据库连接
        Connection conn = DBManager.getConn();
        //qr执行查询连接 sql语句
        try {
            return  qr.query(conn,"select * from stateinfo",new BeanListHandler<>(StateInfo.class));//返回的类型为集合类型，集合类存放的数据为StateInfo
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
