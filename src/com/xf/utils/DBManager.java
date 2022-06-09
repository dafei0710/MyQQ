package com.xf.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

//对数据库进行连接
public class DBManager {
    private static final String DRIVER = "com.mysql.cj.jdbc.Driver";
    //所连接的数据库地址
    private static final String URL="jdbc:mysql://localhost:3306/qq?serverTimezone=GMT&useSSL=false";
    //用户名密码
    private static final String USERNAME="root";
    private static final String PASSWORD="admin123";


    //加载驱动
    static {
        try {
            Class.forName(DRIVER);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    //获取连接的方法
    public static Connection getConn(){
        //尝试获取连接
        try {
            //connection
            Connection connection = DriverManager.getConnection(URL,USERNAME,PASSWORD);
            System.out.println(connection);
            return connection;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void main(String[] args) {
        getConn();
    }
}
