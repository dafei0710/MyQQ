package com.xf.jf;
import com.xf.beans.StateInfo;
import com.xf.beans.UserInfo;
import com.xf.dao.StateDao;
import com.xf.dao.UserDao;

import javax.swing.*;
import javax.swing.event.AncestorListener;
import java.awt.*;
import java.awt.event.*;
import java.util.List;
import java.util.Vector;

public class LoginJF extends JFrame { //加载界面方法 frame窗体
    //背景图429 156
    //构造方法
    LoginJF that =this;//把自己复制
    int w=429,h=350;//设置宽度高度
    UserDao userDao =new UserDao();//用户持久层对象
    StateDao stateDao =new StateDao();//状态持久层对象
    public LoginJF(){
        //第一步给窗体添加组建容器
        JPanel bgJP =new JPanel();//容器创建
        bgJP.setBackground(Color.WHITE);
//loginBtn.addActionListener(new ActionListener()




        //组建容器添加布局 绝对布局
        bgJP.setLayout(null);
        this.getContentPane().add(bgJP); //把容器放入窗体




        //登陆组件
        //用户标签
        JLabel unameJl =new JLabel("用户名：");
        unameJl.setBounds(95,170,100,26);
        unameJl.setFont(new Font("微软雅黑",Font.BOLD,14));//调整字体大小
        bgJP.add(unameJl);

        //用户名输入框
        JTextField unameJT=new JTextField();
        unameJT.setBounds(150,170,150,26);
        unameJT.setFont(new Font("微软雅黑",Font.PLAIN,12));//调整字体大小
        bgJP.add(unameJT);


        //用户选择登录状态
        JComboBox stateJC =new JComboBox();
        //登录状态添加监听事件
        stateJC.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                if(e.getStateChange()==1){
                    System.out.println("hello");
                }
            }
        });

        //下拉框加载数据

        //添加数据库源
        Vector v =new Vector<>();
        List<StateInfo> stateInfos = stateDao.getStates();
        //把数据集合中的用户状态名称放入数据源
        for (StateInfo stateInfo:stateInfos    ) {
            v.add(stateInfo.getState());
        }
        DefaultComboBoxModel aMoudel =new DefaultComboBoxModel<>(v);//创建模型
        stateJC.setModel(aMoudel);
        stateJC.setBounds(300,170,100,26);//

        bgJP.add(stateJC);



        //添加背景图片
        JLabel bgImg=new JLabel("hello");
        //设置背景图的位置以及大小
        bgImg.setBounds(0,0,w,156);//xy轴坐标,宽高
        bgImg.setIcon(new ImageIcon(this.getClass().getResource("../images/QQ.png")));//设置背景图
        bgJP.add(bgImg);

        //密码标签
        JLabel pwdJl =new JLabel("密   码：");
        pwdJl.setBounds(95,210,100,26);
        pwdJl.setFont(new Font("微软雅黑",Font.BOLD,14));//调整字体大小
        bgJP.add(pwdJl);
        JPasswordField pwdJT=new JPasswordField();//密码输入框
        pwdJT.setBounds(150,210,150,26);
        pwdJT.setFont(new Font("微软雅黑",Font.PLAIN,12));//调整字体大小
        bgJP.add(pwdJT);
        //登录按钮
        JButton loginBtn = new JButton("登   陆"); //登录按钮
        loginBtn.setBounds(150,250,150,32);
        loginBtn.setFont(new Font("微软雅黑",Font.PLAIN,14));//调整字体大小

        //添加点击事件
        loginBtn.addActionListener(new ActionListener() {
            //监听按钮
            @Override
            public void actionPerformed(ActionEvent e) {
                //弹窗效果
                //JOptionPane.showMessageDialog(LoginJF.this,"登录成功");
                //获取用户输入到用户名和密码
               String username= unameJT.getText();
               String password =pwdJT.getText();
               //JOptionPane.showMessageDialog(LoginJF.this,"您输入的用户名为："+ username + ",密码为"+password);


            //判断用户名和密码为空的情况
            if(username.trim().length()==0||password.trim().length()==0){
                JOptionPane.showMessageDialog(LoginJF.this,"用户名或密码不能为空");
                return;
            }
          // /* 判断密码复杂度，方便测试暂不写
            if(password.trim().length()<6){
                JOptionPane.showMessageDialog(LoginJF.this,"密码不能小于6位数");
                return;
            }
           // */

                UserInfo userInfo =userDao.login(username,password);//通过userdao对象调用它的登陆验证方法
            //判断用户是否登录成功
                if(userInfo==null){
                    JOptionPane.showMessageDialog(LoginJF.this,"用户名或密码错误");
                }
                else{
                    JOptionPane.showMessageDialog(LoginJF.this,"登录成功！");

                    /*
                    QQMainJF qqMainJF =new QQMainJF();
                    qqMainJF.loadJF();
                    that.setVisible(false);
                    */
                    //qq主界面,当我们登陆成功跳转到主界面到时候把当前用户信息传递给主界面
                    QQMainJFrame qqMainJFrame =new QQMainJFrame(userInfo);
                    qqMainJFrame.setVisible(true);
                    that.setVisible(false);

                }


            }
        });
        bgJP.add(loginBtn);


        //注册账号
        //JLabel registerJL =new JLabel("注册账号");//识别网页标签
        JLabel registerJL =new JLabel("注册账号");
        registerJL.setBounds(10,288,100,26);
        registerJL.setForeground(Color.GRAY);
        registerJL.setFont(new Font("微软雅黑",Font.PLAIN,14));//调整字体大小
        //添加注册账号监听，监听是否划过或者点击
        registerJL.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                RegisterJF registerJF =new RegisterJF();
                registerJF.loadJF();
                registerJL.setForeground(Color.blue);
                //that.loadJF();
            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {//
                registerJL.setForeground(Color.darkGray);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                registerJL.setForeground(Color.GRAY);
            }

        });



        bgJP.add(registerJL);
    }

    public void loadJF(){

        this.setVisible(true);//设置本窗体显示 true可见 false不可见
        this.setSize(w,h);//设置窗体的显示大小
        this.setResizable(true);//设置窗体是否拉伸
        this.setLocationRelativeTo(null);//让窗体居中显示
        this.setTitle("盗版OICQ");//添加标题
        this.setIconImage(new ImageIcon(this.getClass().getResource("../images/1.jpg")).getImage());//设置窗体logo
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//界面关闭之后，同步关闭程序进程

    }
    public void btnclick(){

    }

    public static void main(String[] args){//程序入口
        LoginJF loginJF=new LoginJF();//创建窗体时使用
        loginJF.loadJF();

    }


}
