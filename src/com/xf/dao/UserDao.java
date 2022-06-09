package com.xf.dao;

import com.xf.beans.UserInfo;
import com.xf.utils.DBManager;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import java.sql.Connection;
import java.sql.SQLException;

//对用户进行CRUD操作，增删改查
public class UserDao {

    QueryRunner qr = new QueryRunner();//进行crud操作

    //登陆实现：通过用户输入对用户名与密码，对数据库数据进行查询，如果次用户名与密码查询到用户代表登陆成功，如果没有查询到用户，代表登陆失败
    //登陆功能,返回用户对象
    public UserInfo login(String username,String password){
        //通过工具类去获取数据库连接
        Connection conn = DBManager.getConn();
        //qr执行查询连接 sql语句
        try {
          return  qr.query(conn,"select * from userinfo where id=? and loginpwd=?",new BeanHandler<>(UserInfo.class),username,password);
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

    //注册功能,昵称，密码
    public int register(String nickName,String password){
        Connection conn = DBManager.getConn();
        //第一种做法 数据库随机函数 random
        //第二种做法，使用Java随机数
        try {
            int count = qr.execute(conn,"insert into userinfo (nickname,loginpwd,faceid,age) values (?,?,?,?)",nickName,password,(int)(Math.random()*100)+" ",18);
            return count;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }
    //获取最后注册到到用户信息
    public UserInfo getRegisterUser(){
        //通过工具类去获取数据库连接
        Connection conn = DBManager.getConn();
        //qr执行查询连接 sql语句
        try {
            return  qr.query(conn,"select * from userinfo order by id desc LIMIT 1 ",new BeanHandler<>(UserInfo.class));
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
    //通过用户账户修改状态，id用户账户，state修改状态值
    public void updateUserById(String id,int state){
        //
       Connection conn= DBManager.getConn();
        try {
         qr.execute(conn,"update userinfo set stateid=? where id =?",state,id);
         //System.out.println(state);
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

    public static void main(String[] args) {
       // UserDao userDao =new UserDao();
        //System.out.println(userDao.login("10001","520520"));
      //  userDao.register("小甜甜","111111");


    }
}
