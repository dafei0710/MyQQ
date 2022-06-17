package com.xf.jf;
import com.xf.beans.Anam;
import com.xf.beans.StateInfo;
import com.xf.beans.UserInfo;
import com.xf.dao.AnamDao;
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
    AnamDao anamDao =new AnamDao();
    static List<Anam> anams;


    JCheckBox remJC;
     int state =1;
     static JComboBox unameJT ;
     static JPasswordField pwdJT;
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
        unameJT=new JComboBox();
        unameJT.setBounds(150,170,150,26);
        unameJT.setFont(new Font("微软雅黑",Font.PLAIN,12));//调整字体大小
        unameJT.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                super.keyTyped(e);
                if(e.getKeyChar()==KeyEvent.VK_ENTER){
                    loginEnter();
                }
            }
        });
        //设置下拉列表可以输入内容
        unameJT.setEditable(true);//设置可以编辑
        //把数据查询出来
        Vector v1 =new Vector<>();
        anams= anamDao.getQAllAnams();//查询所有登陆的用户账号
        //转化为集合数据
        for (Anam anam:anams) {
            v1.add(anam.getQq());
        }
        //放入下拉框的数据源中
        DefaultComboBoxModel model =new DefaultComboBoxModel<>(v1);
        //列表加载
        unameJT.setModel(model);
        //添加监听
        unameJT.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {

                //
                if(e.getStateChange()==1){
                  //判断用户是否勾选记住密码
                    int index=unameJT.getSelectedIndex();//可能对值为-1
                    if(index>=0){
                        Anam anam=anams.get(unameJT.getSelectedIndex());
                        //System.out.println(anam);
                        if(anam.getStaid()==1){

                            pwdJT.setText(anam.getPwd());
                            remJC.setSelected(true);

                        }
                        else if(anam.getStaid()==0){
                            pwdJT.setText("");
                            remJC.setSelected(false);
                        }
                    }


                }
            }
        });

        bgJP.add(unameJT);



        //用户选择登录状态
        JComboBox stateJC =new JComboBox();
        //登录状态添加监听事件

        //存储用户状态

        stateJC.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                //当下拉框值发生改变的时候触发
                if(e.getStateChange()==1){
                    //System.out.println(stateJC.getSelectedIndex()+1);
                    //System.out.println(stateJC.getSelectedItem());

                    state=stateJC.getSelectedIndex()+1; //把改变的状态编号放入用户装填


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
        stateJC.setSelectedIndex(1);
        stateJC.setBounds(300,170,100,26);//

        //stateJC.setEditable(true);//设置可以编辑
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
        //JPasswordField pwdJT=new JPasswordField();//密码输入框
        pwdJT=new JPasswordField();//密码输入框
        pwdJT.setBounds(150,210,150,26);
        pwdJT.setFont(new Font("微软雅黑",Font.PLAIN,12));//调整字体大小
        pwdJT.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {//监听回车事件，回车登陆
                super.keyTyped(e);
                if(e.getKeyChar()==KeyEvent.VK_ENTER){
                    loginEnter();
                }
            }
        });

        bgJP.add(pwdJT);

        JLabel findPwdJT =new JLabel("找回密码");
        findPwdJT.setBounds(310,210,100,26);
        findPwdJT.setFont(new Font("微软雅黑",Font.PLAIN,14));//调整字体大小
        findPwdJT.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
//                super.mouseClicked(e);
                QQMainJF qqMainJF =new QQMainJF();
                qqMainJF.loadJF();
            }
        });
        bgJP.add(findPwdJT);
        //记住密码复选框
        remJC=new JCheckBox("记住密码");
        remJC.setBounds(150,230,80,32);
        remJC.setFont(new Font("微软雅黑",Font.PLAIN,10));//调整字体大小
        remJC.setForeground(Color.gray);
        bgJP.add(remJC);


        //登录按钮
        JButton loginBtn = new JButton("登   陆"); //登录按钮
        loginBtn.setBounds(150,255,150,32);
        loginBtn.setFont(new Font("微软雅黑",Font.PLAIN,14));//调整字体大小

        //添加点击事件
        loginBtn.addActionListener(new ActionListener() {
            //监听按钮
            @Override
            public void actionPerformed(ActionEvent e) {
               loginEnter();

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

    public void loginEnter() {
        //弹窗效果
        //JOptionPane.showMessageDialog(LoginJF.this,"登录成功");
        //获取用户输入到用户名和密码
        String username = unameJT.getSelectedItem().toString();//使用下拉框获取用户账号
        String password = pwdJT.getText();
        //JOptionPane.showMessageDialog(LoginJF.this,"您输入的用户名为："+ username + ",密码为"+password);


        //判断用户名和密码为空的情况
        if (username.trim().length() == 0 || password.trim().length() == 0) {
            JOptionPane.showMessageDialog(LoginJF.this, "用户名或密码不能为空");
            return;
        }
        // /* 判断密码复杂度，方便测试暂不写
        if (password.trim().length() < 6) {
            JOptionPane.showMessageDialog(LoginJF.this, "密码不能小于6位数");
            return;
        }
        // */

        UserInfo userInfo = userDao.login(username, password);//通过userdao对象调用它的登陆验证方法

        //判断用户是否登录成功
        if(state==1){//下线状态不能登陆
            JOptionPane.showMessageDialog(LoginJF.this,"下线状态不能登陆");
            return;
        }

        if (userInfo == null) {
            JOptionPane.showMessageDialog(LoginJF.this, "用户名或密码错误");
        } else {
            //JOptionPane.showMessageDialog(LoginJF.this,"登录成功！");
            //JOptionPane.showConfirmDialog(LoginJF.this,"登录成功！");
                    /*
                    QQMainJF qqMainJF =new QQMainJF();
                    qqMainJF.loadJF();
                    that.setVisible(false);
                    */
            userInfo.setStateid(state);//当前登陆用户的状态
            //把数据库中用户状态进行改变  通过用户的账户修改他在数据库中的状态
            userDao.updateUserById(userInfo.getId() + "", state);



            //Anam anam=anams.get(unameJT.getSelectedIndex());
            Anam anam =anamDao.getAnamById(Integer.parseInt(username));
            //登陆成功之后判断是否勾选记住密码
            //if(anamDao.getAnamById(anam.getQq())==null){
            if(anam==null){
                //当勾选记住密码
                if(remJC.isSelected()==true) {
                    anamDao.addAnam(Integer.parseInt(username), password, 1);
                }else{//未勾选记住密码
                    anamDao.addAnam(Integer.parseInt(username), password, 0);
                }
            }
            else{
                //如果存在 根据选择师傅记住密码 修改用户状态
                if(remJC.isSelected()==true){
                    //如果表中存在数据，再次登陆勾选记住密码 只修改记住密码状态
                    anamDao.updateAnamById(Integer.parseInt(username),1);
                   //System.out.println(anam.getPwd());

                }else{
                    anamDao.updateAnamById(Integer.parseInt(username),0);
                }


            }





            //qq主界面,当我们登陆成功跳转到主界面到时候把当前用户信息传递给主界面
            QQMainJFrame qqMainJFrame = new QQMainJFrame(userInfo);
            qqMainJFrame.setVisible(true);
            that.setVisible(false);
        }
    }




    public void loadJF(){

        this.setVisible(true);//设置本窗体显示 true可见 false不可见
        this.setSize(w,h);//设置窗体的显示大小
        this.setResizable(false);//设置窗体是否拉伸
        this.setLocationRelativeTo(null);//让窗体居中显示
        this.setTitle("盗版QQ");//添加标题
        this.setIconImage(new ImageIcon(this.getClass().getResource("../images/1.jpg")).getImage());//设置窗体logo
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//界面关闭之后，同步关闭程序进程
        //初始化数据
        //获取到默认账户
        if(anams.size()>0){//账号数量大于0报错问题
            Anam anam = anams.get(0);
            //对默认账户进行判断，如果默认账户记住密码直接赋值，如果没有记住密码，就不写
            if(anam.getStaid()==1){
                pwdJT.setText(anam.getPwd());
                remJC.setSelected(true);
            }

        }
        //下拉框触发事件 内容只要发生变化 就会触发
        //失去焦点 触发
        unameJT.getEditor().getEditorComponent().addKeyListener(new KeyListener() {//JComboBox下拉文本框触发事件
            @Override
            public void keyTyped(KeyEvent e) {
               // System.out.println("111");
            }

            @Override
            public void keyPressed(KeyEvent e) {

            }

            @Override
            public void keyReleased(KeyEvent e) {
                //判断输入字符的长度
                String id=unameJT.getEditor().getItem().toString();
                //System.out.println(id);
                //如果第一个字符 如果是记住密码 把密码框直接清空，如果密码长度符合账户长度，检测这个还在那个户是否记住密码的功能
                //if(id.length()==1||id.length()==0){
                if(id.length()<=1){//1位或者0位清空
                    pwdJT.setText("");
                    remJC.setSelected(false);
                }else if(id.length()>=4){
                    //单纯集合对象

                    //定义一个变量判断是否输入记住密码的账户
                    boolean isHave=false;
                    Anam anam1 = null;


                    for (Anam anam: anams) {
                        //当我们把集合中所有的记住密码的账户跟你输入的账户做对比 如果对比存在 说明你输入的账户是记住密码的 所以我们要直接记住登陆
                        if(anam.getQq()==Integer.parseInt(id)){
                           isHave=true;
                           anam1=anam;
                            break;//终止当前循环
                        }

                    }
                    if(isHave==true){
                        //判断输入账户记住密码是否勾选
                        if(anam1.getStaid()==1){
                            pwdJT.setText(anam1.getPwd());
                            remJC.setSelected(true);
                        }else{
                            pwdJT.setText("");
                            remJC.setSelected(false);
                        }
                    }
                    else{
                        pwdJT.setText("");
                        remJC.setSelected(false);
                    }
                }

            }
        });






    }




    public static void main(String[] args){//程序入口
        LoginJF loginJF=new LoginJF();//创建窗体时使用
        loginJF.loadJF();



    }


}
