package com.xf.jf;

import javax.swing.*;

public class QQMainJF extends JFrame {
    public void loadJF(){

        this.setVisible(true);//设置本窗体显示 true可见 false不可见
        this.setBounds(1000,20,350,900);//设置窗体的显示大小
        this.setResizable(true);//设置窗体是否拉伸

        //this.setLocationRelativeTo(null);//让窗体居中显示
        this.setTitle("盗版OICQ主界面");//添加标题
        this.setIconImage(new ImageIcon(this.getClass().getResource("../images/1.jpg")).getImage());//设置窗体logo
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//界面关闭之后，同步关闭程序进程
    }


}
