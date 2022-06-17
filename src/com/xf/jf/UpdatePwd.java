package com.xf.jf;

import com.xf.beans.UserInfo;
import com.xf.dao.UserDao;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static java.lang.System.exit;

public class UpdatePwd extends JFrame {//找回密码
    UserDao userDao=new UserDao();
    UpdatePwd that=this;
    UserInfo userInfo;
    int Id;

    public UpdatePwd(int id) {
       this.Id=id;
        System.out.println(Id);
    }


    public void loadJF(){
        JPanel bgJP =new JPanel();//容器创建
        bgJP.setBackground(Color.WHITE);
        //loginBtn.addActionListener(new ActionListener()




        //组建容器添加布局 绝对布局
        bgJP.setLayout(null);
        this.add(bgJP);
        //id标签
        JLabel idJl =new JLabel("用户名");
        idJl.setBounds(72,120,100,26);
        idJl.setFont(new Font("微软雅黑",Font.BOLD,14));//调整字体大小
        bgJP.add(idJl);

        //id输入框
        System.out.println(Id);
        JTextField idJT=new JTextField();
        idJT.setText(Id+"");
        System.out.println(Id);
        idJT.setEditable(false);
        idJT.setBounds(150,120,150,26);
        idJT.setFont(new Font("微软雅黑",Font.PLAIN,12));//调整字体大小
        bgJP.add(idJT);


        //密码标签
        JLabel updata11pwdJl =new JLabel("输入新密码");
        updata11pwdJl.setBounds(72,170,100,26);
        updata11pwdJl.setFont(new Font("微软雅黑",Font.BOLD,14));//调整字体大小
        bgJP.add(updata11pwdJl);

        //密码输入框
        JTextField updata1pwdJT=new JTextField("");
        updata1pwdJT.setBounds(150,170,150,26);
        updata1pwdJT.setFont(new Font("微软雅黑",Font.PLAIN,12));//调整字体大小
        bgJP.add(updata1pwdJT);

        //密码标签
        JLabel updata22pwdJl =new JLabel("确认新密码");
        updata22pwdJl.setBounds(72,220,100,26);
        updata22pwdJl.setFont(new Font("微软雅黑",Font.BOLD,14));//调整字体大小
        bgJP.add(updata22pwdJl);

        //密码输入框
        JTextField updata2pwdJT=new JTextField("");
        updata2pwdJT.setBounds(150,220,150,26);
        updata2pwdJT.setFont(new Font("微软雅黑",Font.PLAIN,12));//调整字体大小
        bgJP.add(updata2pwdJT);

        //提交按钮
        JButton tjBtn = new JButton("修改密码"); //登录按钮
        tjBtn.setBounds(150,255,150,32);
        tjBtn.setFont(new Font("微软雅黑",Font.PLAIN,14));//调整字体大小
        bgJP.add(tjBtn);
        tjBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int id=Integer.parseInt(idJT.getText());
                String Update1Pwd=updata1pwdJT.getText();
                String Update2Pwd=updata2pwdJT.getText();
                //System.out.println(Integer.parseInt(id)+"    "+nickName);
                //UserInfo userInfo =new UserDao();
                System.out.println(id);
                System.out.println(Update1Pwd);
                System.out.println(Update2Pwd);
                if((Update1Pwd.equals(Update2Pwd))){//如果输入的新密码和确认的新密码一致，则进行修改修改
                    UserInfo user =userDao.updatePwd((Id),Update2Pwd);
                    userDao.updatePwd(Id,Update2Pwd);
                    JOptionPane.showMessageDialog(UpdatePwd.this,"密码修改成功,请退出重新登陆!");
                    idJT.setText("");
                    updata1pwdJT.setText("");
                    updata2pwdJT.setText("");
                    that.dispose();
                    exit(0);
//                    LoginJF loginJF =new LoginJF();
//                    loginJF.loadJF();
                }
                else{
                    JOptionPane.showMessageDialog(UpdatePwd.this,"请确认两次输入密码是否一致");
                }

            }
        });



        this.setVisible(true);//设置本窗体显示 true可见 false不可见
        this.setBounds(0,0,500,500);//设置窗体的显示大小
        this.setResizable(true);//设置窗体是否拉伸
        this.setLocationRelativeTo(null);

        //this.setLocationRelativeTo(null);//让窗体居中显示
        this.setTitle("修改密码");//添加标题
        this.setIconImage(new ImageIcon(this.getClass().getResource("../images/1.jpg")).getImage());//设置窗体logo
        //this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//界面关闭之后，同步关闭程序进程
    }

    public static void main(String[] args) {
        QQMainJF qqMainJF=new QQMainJF();//创建窗体时使用
        qqMainJF.loadJF();
    }

}

