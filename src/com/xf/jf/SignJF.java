package com.xf.jf;

import javax.swing.*;
import java.awt.*;

public class SignJF extends JFrame {
    public static void main(String[] args) {
        SignJF signJF =new SignJF();
        signJF.loadJF();
    }
    public SignJF(){

            //第一步给窗体添加组建容器
            SignJF that=this;
            JPanel bgJP =new JPanel();//容器创建
            bgJP.setBackground(Color.WHITE);
            //loginBtn.addActionListener(new ActionListener()

            //组建容器添加布局 绝对布局
            bgJP.setLayout(null);
            this.getContentPane().add(bgJP); //把容器放入窗体
            JTextField signJT =new JTextField();
            signJT.setBounds(10,10,400,30);
            bgJP.add(signJT);

    }
    public void loadJF(){

        this.setVisible(true);//设置本窗体显示 true可见 false不可见
        this.setSize(420,110);//设置窗体的显示大小
        this.setResizable(true);//设置窗体是否拉伸
        this.setLocationRelativeTo(null);//让窗体居中显示
        this.setTitle("个性签名");//添加标题
        this.setIconImage(new ImageIcon(this.getClass().getResource("../images/1.jpg")).getImage());//设置窗体logo
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//界面关闭之后，同步关闭程序进程

    }

}
