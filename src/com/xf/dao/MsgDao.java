package com.xf.dao;

import com.xf.beans.Messagesinfo;
import com.xf.utils.DBManager;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

/**
 *
 */
public class MsgDao {

    QueryRunner qr=new QueryRunner();

    /**
     *查询两个人对聊天记录
     * @param id 自己
     * @param friendId 对方
     * @return
     */
    public List<Messagesinfo> getMsg(int id, String friendId) {
        Connection conn = DBManager.getConn();
        try {

          return   qr.query(conn,"select * from messagesinfo where fromuserid=? and touserid=? or fromuserid=? and touserid=?",new BeanListHandler<>(Messagesinfo.class),id,friendId,friendId,id);

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

    /**
     * 添加聊天记录
     * @param id 发消息的人
     * @param friendId 收消息的人
     * @param msg 发送的消息
     */
    public void addMsg(int id, String friendId, String msg) {
        Connection conn = DBManager.getConn();
        try {

       qr.execute(conn,"insert into messagesinfo values(null,?,?,?,1,0,now())",id,friendId,msg);

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
