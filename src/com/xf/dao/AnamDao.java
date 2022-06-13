package com.xf.dao;

import com.xf.beans.Anam;
import com.xf.utils.DBManager;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class AnamDao {
    QueryRunner qr=new QueryRunner();
    public List<Anam> getQAllAnams(){//查询所有记住输入的账号
       Connection conn= DBManager.getConn();
        try {
            return qr.query(conn,"select * from anam order by updateTime desc ",new BeanListHandler<>(Anam.class));
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
    //记住密码存储用户信息，qq，owd，isRemember
    public void addAnam(int qq,String pwd,int isRemember){

            Connection conn= DBManager.getConn();
            try {
                qr.execute(conn, "insert into anam values (null,?,?,?,now())", qq, pwd, isRemember);
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

    public Anam getAnamById(int id){
        Connection conn = DBManager.getConn();
        try {
            return qr.query(conn,"select * from Anam where qq=?",new BeanHandler<>(Anam.class),id);
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            try {
                conn.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        return null;
    }
    //通过用户账号修改用户状态
    public void updateAnamById(int id,int i) {
        Connection conn= DBManager.getConn();
        try {
            qr.execute(conn, "update anam set staid=?,updateTime=now() where qq=?",i,id );
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
}
