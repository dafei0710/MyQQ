package com.xf.jf;

import com.xf.beans.Anam;
import com.xf.beans.FriendsInfo;
import com.xf.beans.UserInfo;
import com.xf.dao.FriendsDao;
import com.xf.dao.UserDao;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

public class AddFriendJF extends JFrame {
    //创建一个数据库执行对象
    FriendsDao friendsDao=new FriendsDao();
    UserDao userDao =new UserDao();

    public AddFriendJF(int hostid){
        AddFriendJF that=this;//把自己赋值
        //第一步给窗体添加组建容器
        JPanel bgJP =new JPanel();//容器创建
        bgJP.setBackground(Color.WHITE);
        //组建容器添加布局 绝对布局
        bgJP.setLayout(null);
        this.getContentPane().add(bgJP); //把容器放入窗体
        //好友搜索框
        JTextField serachJT =new JTextField();
        serachJT.setBounds(40,60,400,50);
        bgJP.add(serachJT);
        JButton searchBtn=new JButton("添加好友");
        searchBtn.setBounds(450,60,100,50);
        searchBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {


                //获取到好友到的账户
                int friendid= Integer.parseInt(serachJT.getText());

                //第一种情况 添加到好友不存在，或者自己添加自己为好友
                UserInfo user =userDao.getUserById(friendid);//通过输入账户 查询用户对象，如果存在则可以进行添加测试 如果不存在则不能添加
                if(user==user){//自己不能添加自己为好友
                    JOptionPane.showMessageDialog(AddFriendJF.this,"自己不能添加自己为好友！");
                    return;
                }
                if(user==null){
                    JOptionPane.showMessageDialog(AddFriendJF.this,"当前用户不存在，无法添加好友！");
                    return;
                }

                //第二种情况 添加的好友以及是好友
               FriendsInfo friendsInfo =friendsDao.getUserByHostIdAndFriendId(hostid,friendid);
                //判断如果userinfo不为空，说明已经是好友了。不用再添加
                if(friendsInfo!=null){
                    JOptionPane.showMessageDialog(AddFriendJF.this,"当前用户已是好友，无需再添加！");
                    return;
                }
                //第三种情况 好友存在，且不是好友，添加好友成功
                //添加好友应该有两个账户 当前登陆用户 好友的用户
                //流程已经完成，好友是相互的，当前账户的好友添加 //那么当前好友也是对方好友的好友
                friendsDao.addFriend(hostid,friendid);
                friendsDao.addFriend(friendid,hostid);
                JOptionPane.showMessageDialog(AddFriendJF.this,"好友添加成功！");
                serachJT.setText("");


            }
        });
        bgJP.add(searchBtn);

        //组件容器添加背景色
        bgJP.setBackground(new Color(235,242,249));
        JLabel bgImg1 =new JLabel();
        bgImg1.setBounds(0,0,1024,58);
        bgImg1.setIcon(new ImageIcon(this.getClass().getResource("../images/a.png")));
        bgJP.add(bgImg1);

        JLabel bgImg2 =new JLabel();
        bgImg2.setBounds(0,128,1024,500);
        bgImg2.setIcon(new ImageIcon(this.getClass().getResource("../images/b.png")));
        bgJP.add(bgImg2);
    }

    public void loadJF(){
        this.setVisible(true);//设置本窗体显示 true可见 false不可见
        this.setSize(1024,600);//设置窗体的显示大小
        this.setResizable(false);//设置窗体是否拉伸
        this.setLocationRelativeTo(null);//让窗体居中显示
        this.setTitle("添加好友");//添加标题
        this.setIconImage(new ImageIcon(this.getClass().getResource("../images/1.jpg")).getImage());//设置窗体logo
        //this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//界面关闭之后，同步关闭程序进程

        //文本框事件 内容只要发生变化 就会触发
        //失去焦点 触发



    }


}
