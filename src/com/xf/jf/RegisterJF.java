package com.xf.jf;

import com.xf.beans.UserInfo;
import com.xf.dao.UserDao;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class RegisterJF extends JFrame {

    RegisterJF that = this;
    UserDao userDao =new UserDao();
    //构造方法 添加组建
    public RegisterJF(){
        JPanel bgJP =new JPanel();//容器创建
        bgJP.setBackground(Color.WHITE);

        //组建容器添加布局 绝对布局
        bgJP.setLayout(null);
        this.getContentPane().add(bgJP); //把容器放入窗体
        //内容标题
        JLabel title1 =new JLabel("欢迎注册盗版QQ");
        title1.setFont(new Font("微软雅黑",Font.PLAIN,50));
        title1.setBounds(600,90,500,50);
        bgJP.add(title1);
        JLabel title2 =new JLabel("每一天乐在沟通");
        title2.setFont(new Font("微软雅黑",Font.PLAIN,40));
        title2.setBounds(600,160,400,40);
        bgJP.add(title2);

        //昵称
        JTextField nickJT =new JTextField("  昵称");
        nickJT.setBounds(600,240,350,50);
        nickJT.setFont(new Font("宋体",Font.BOLD,22));
        nickJT.setForeground(Color.darkGray);
        //获取焦点失去焦点的事件
        nickJT.addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent e) {
                //获取焦点
                //当用户没有输入的时候 文本框获取到焦点清空文本输入框
                if(nickJT.getText().trim().equals("昵称")){
                    nickJT.setText("");//清空文本框内容
                    nickJT.setForeground(Color.black);//设置文字颜色
                }
            }
            @Override
            public void focusLost(FocusEvent e) {
                //失去焦点
                //文本框为空，文本框失去焦点复原文本输入框
                if(nickJT.getText().trim().equals("")){
                    nickJT.setText(" 昵称");//复原文本框内容
                    nickJT.setForeground(Color.darkGray);//设置文字颜色
                }

            }
        });

        bgJP.add(nickJT);

        //密码
        JPasswordField pwdJT =new JPasswordField("  密码");
        pwdJT.setEchoChar((char)0);//设置铭明文显示
        pwdJT.setBounds(600,320,350,50);
        pwdJT.setFont(new Font("宋体",Font.BOLD,22));
        pwdJT.setForeground(Color.darkGray);


        JLabel eyeIs =new JLabel();
        eyeIs.setIcon(new ImageIcon(this.getClass().getResource("../images/eye.png")));//设置背景图
        eyeIs.setBounds(965,333,39,24);
        JLabel eyeIsClose =new JLabel();
        eyeIsClose.setIcon(new ImageIcon(this.getClass().getResource("../images/eyeclose.png")));//设置背景图
        eyeIsClose.setBounds(965,333,39,24);
        eyeIs.setVisible(false);
        eyeIs.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
//                super.mouseClicked(e);
                eyeIsClose.setVisible(true);
                eyeIs.setVisible(false);
                
                pwdJT.setEchoChar('*');

            }
        }
        );

        eyeIsClose.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
//                super.mouseClicked(e);
                eyeIsClose.setVisible(false);
                eyeIs.setVisible(true);
                pwdJT.setEchoChar((char)0);//设置铭明文显示


            }
        });
//        eyeIsClose.setVisible(true);
        bgJP.add(eyeIs);
        bgJP.add(eyeIsClose);
        pwdJT.addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent e) {
                //获取焦点
                //当用户没有输入的时候 文本框获取到焦点清空文本输入框
                if(pwdJT.getText().trim().equals("密码")){
                    pwdJT.setEchoChar('*');
                    pwdJT.setText("");//清空文本框内容
                    pwdJT.setForeground(Color.black);//设置文字颜色
                }
            }
            @Override
            public void focusLost(FocusEvent e) {
                //失去焦点
                //文本框为空，文本框失去焦点复原文本输入框
                if(pwdJT.getText().trim().equals("")){
                    pwdJT.setEchoChar((char)0);
                    pwdJT.setText("  密码");//复原文本框内容

                    pwdJT.setForeground(Color.darkGray);//设置文字颜色
                }

            }
        });

        bgJP.add(pwdJT);

        //同意协议
        JCheckBox isOk =new JCheckBox("我以阅读并同意相关服务条款和隐私政策");
        //isOk.setFont(new Font("微软雅黑",Font.PLAIN,14));
        isOk.setForeground(Color.gray);
        isOk.setBounds(600,460,50,50);
        isOk.setBackground(Color.GRAY);
        bgJP.add(isOk);
        //立即注册
        JButton registerBtn =new JButton("  立即注册");
        registerBtn.setBounds(600,400,350,50);
        registerBtn.setFont(new Font("微软雅黑",Font.BOLD,22));
        registerBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //获取注册的昵称和密码
                String nickName=nickJT.getText();
                String password =pwdJT.getText();


                if(isOk.isSelected()){//判断是否同意协议
                    //判断昵称和密码是否为空
                    if(nickName.trim().length()==0 || password.trim().length()==0){
                        JOptionPane.showMessageDialog(RegisterJF.this,"昵称和密码不能为空！");
                        return ;
                    }
                    //判断有无修改默认值
                    if(nickName.trim().equals("昵称")||password.trim().equals("密码")){
                        JOptionPane.showMessageDialog(RegisterJF.this,"昵称和密码不能为默认！");
                        return ;
                    }

                    //判断密码大于等于6位,自己写
                    if(password.trim().length()<6){
                        JOptionPane.showMessageDialog(RegisterJF.this,"密码不能小于6位数");
                        return;
                    }
                    int count = userDao.register(nickName,password);
                    //判断是否注册成功，如果成功提示注册用户到账号，如果失败，提示注册失败
                    if(count==1){
                        //获取到注册到用户
                        UserInfo userInfo =  userDao.getRegisterUser();
                        JOptionPane.showMessageDialog(RegisterJF.this,"盗版QQ注册成功！您到账号为："+userInfo.getId()+"不要弄丢账号哦！");
                        that.dispose();
                    }
                    else{
                        JOptionPane.showMessageDialog(RegisterJF.this,"注册失败");
                    }
                }else {
                    JOptionPane.showMessageDialog(RegisterJF.this,"请先选择服务条款");
                }
            }
        });
        bgJP.add(registerBtn);






        //
        JLabel isOkStr =new JLabel("我以阅读并同意相关服务条款和隐私政策");
        isOk.setBounds(600,480,400,50);
        registerBtn.setFont(new Font("微软雅黑",Font.PLAIN,14));
        isOkStr.setForeground(Color.darkGray);
        bgJP.add(isOkStr);
        //




        JLabel bgImg=new JLabel();
        //设置背景图的位置以及大小
        bgImg.setBounds(-50,-40,560,800);//xy轴坐标,宽高481,931
        bgImg.setIcon(new ImageIcon(this.getClass().getResource("../images/1.gif")));//设置背景图

        bgJP.add(bgImg);


    }

    public void loadJF(){

        this.setVisible(true);//设置本窗体显示 true可见 false不可见
        this.setSize(1100,800);//设置窗体的显示大小1200,1000


        this.setLocationRelativeTo(null);//让窗体居中显示
        this.setTitle("盗版QQ注册界面");//添加标题
        this.setIconImage(new ImageIcon(this.getClass().getResource("../images/1.jpg")).getImage());//设置窗体logo
        this.setResizable(true);//设置窗体是否拉伸





    }
}
