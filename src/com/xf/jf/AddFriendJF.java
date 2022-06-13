package com.xf.jf;

import com.xf.beans.Anam;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

public class AddFriendJF extends JFrame {
    public AddFriendJF(){
        AddFriendJF that=this;//把自己赋值
        //第一步给窗体添加组建容器
        JPanel bgJP =new JPanel();//容器创建
        bgJP.setBackground(Color.WHITE);
        //组建容器添加布局 绝对布局
        bgJP.setLayout(null);
        this.getContentPane().add(bgJP); //把容器放入窗体
        //好友搜索框
        JTextField serachJT =new JTextField();
        serachJT.setBounds(40,20,300,30);
        bgJP.add(serachJT);
        JButton searchBtn=new JButton("添加好友");
        searchBtn.setBounds(360,20,100,30);
        searchBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        bgJP.add(searchBtn);
    }

    public void loadJF(){
        this.setVisible(true);//设置本窗体显示 true可见 false不可见
        this.setSize(600,400);//设置窗体的显示大小
        this.setResizable(false);//设置窗体是否拉伸
        this.setLocationRelativeTo(null);//让窗体居中显示
        this.setTitle("添加好友");//添加标题
        this.setIconImage(new ImageIcon(this.getClass().getResource("../images/1.jpg")).getImage());//设置窗体logo
        //this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//界面关闭之后，同步关闭程序进程

        //文本框事件 内容只要发生变化 就会触发
        //失去焦点 触发



    }


}
