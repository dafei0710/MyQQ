package com.xf.jf;

import com.xf.beans.UserInfo;
import com.xf.dao.UserDao;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class QQMainJF extends JFrame {//找回密码
    UserDao userDao=new UserDao();
    QQMainJF that=this;
    public void loadJF(){
        JPanel bgJP =new JPanel();//容器创建
        bgJP.setBackground(Color.WHITE);
        //loginBtn.addActionListener(new ActionListener()




        //组建容器添加布局 绝对布局
        bgJP.setLayout(null);
        this.add(bgJP);



        //用户标签
        JLabel unameJl =new JLabel("用户名：");
        unameJl.setBounds(95,170,100,26);
        unameJl.setFont(new Font("微软雅黑",Font.BOLD,14));//调整字体大小
        bgJP.add(unameJl);

        //用户名输入框
        JTextField unameJT=new JTextField("1");
        unameJT.setBounds(150,170,150,26);
        unameJT.setFont(new Font("微软雅黑",Font.PLAIN,12));//调整字体大小
        bgJP.add(unameJT);

        //昵称标签
        JLabel nickNameJl =new JLabel("昵称：");
        nickNameJl.setBounds(95,220,100,26);
        nickNameJl.setFont(new Font("微软雅黑",Font.BOLD,14));//调整字体大小
        bgJP.add(nickNameJl);

        //用户名输入框
        JTextField nickNameJT=new JTextField("1");
        nickNameJT.setBounds(150,220,150,26);
        nickNameJT.setFont(new Font("微软雅黑",Font.PLAIN,12));//调整字体大小
        bgJP.add(nickNameJT);

        //提交按钮
        JButton tjBtn = new JButton("提  交"); //登录按钮
        tjBtn.setBounds(150,255,150,32);
        tjBtn.setFont(new Font("微软雅黑",Font.PLAIN,14));//调整字体大小
        bgJP.add(tjBtn);
        tjBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nickName=nickNameJT.getText();
                String id=unameJT.getText();

                //System.out.println(Integer.parseInt(id)+"    "+nickName);

                if((id.trim().equals("")||nickName.trim().equals(""))||(id.trim().equals("")&&nickName.trim().equals(""))){
                    JOptionPane.showMessageDialog(QQMainJF.this,"昵称和用户名不能为空！");
                }
                else{
                    UserInfo userInfo=userDao.getUserByNickName(Integer.parseInt(id),nickName);
                    if(userInfo!=null){
                        JOptionPane.showMessageDialog(QQMainJF.this,"您的密码是："+userInfo.getLoginpwd());
                        that.dispose();

                    }
                    else{
                        JOptionPane.showMessageDialog(QQMainJF.this,"请确认您输入的信息是否有误！");
                    }
                }
            }
        });



        this.setVisible(true);//设置本窗体显示 true可见 false不可见
        this.setBounds(0,0,500,500);//设置窗体的显示大小
        this.setResizable(true);//设置窗体是否拉伸
        this.setLocationRelativeTo(null);

        //this.setLocationRelativeTo(null);//让窗体居中显示
        this.setTitle("找回密码");//添加标题
        this.setIconImage(new ImageIcon(this.getClass().getResource("../images/1.jpg")).getImage());//设置窗体logo
        //this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//界面关闭之后，同步关闭程序进程
    }

    public static void main(String[] args) {
        QQMainJF qqMainJF=new QQMainJF();//创建窗体时使用
        qqMainJF.loadJF();
    }

}
