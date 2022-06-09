package com.xf.jf;



import java.awt.Point;

import javax.swing.*;

import javax.swing.border.LineBorder;

import com.xf.beans.UserInfo;
import com.xf.dao.UserDao;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.List;

/**
 * This code was edited or generated using CloudGarden's Jigloo
 * SWT/Swing GUI Builder, which is free for non-commercial
 * use. If Jigloo is being used commercially (ie, by a corporation,
 * company or business for any purpose whatever) then you
 * should purchase a license for each developer using Jigloo.
 * Please visit www.cloudgarden.com for details.
 * Use of Jigloo implies acceptance of these licensing terms.
 * A COMMERCIAL LICENSE HAS NOT BEEN PURCHASED FOR
 * THIS MACHINE, SO JIGLOO OR THIS CODE CANNOT BE USED
 * LEGALLY FOR ANY CORPORATE OR COMMERCIAL PURPOSE.
 */
public class QQMainJFrame extends javax.swing.JFrame implements WindowListener {

	private JPanel jPanel1;
	private JButton jButton1;
	private JPanel jPanel6;
	private JScrollPane jScrollPane1;
	private JPopupMenu jPopupMenu1;
	private JLabel jLabel2;
	private JLabel jLabel1;
	private JButton jButton3;
	private JButton jButton2;
	private JPanel jPanel5;
	private JPanel jPanel4;
	private JPanel jPanel3;
	private JTabbedPane jTabbedPane1;
	private JPanel jPanel2;
	//添加好友图标
	private JLabel jLabel3;
	//右键菜单
	JPopupMenu jPopupMenu;
	JMenuItem jMenuItem1;//删除好友
	JMenuItem jMenuItem2;//删除所有好友
		//当前登录用户对象
	private UserInfo userInfo ;
	UserDao userDao =new UserDao();
	/**
	 * Auto-generated main method to display this JFrame
	 */
	/*
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				QQMainJFrame inst = new QQMainJFrame(null);
				inst.setLocationRelativeTo(null);
				inst.setVisible(true);
			}
		});
	}*/

	public QQMainJFrame(UserInfo userInfo) {
		super();
		this.userInfo=userInfo;
		initGUI();
		this.setResizable(false);//窗口大小不变
		//当窗口关闭的时候，不操作
		this.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
		//this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//界面关闭之后，同步关闭程序进程
		//添加关闭窗体按钮监听
		this.addWindowListener(this);


	}

	private void initGUI() {
		try {
			//修改关闭方式为：关闭窗口，退出程序
			setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
			//固定窗口大小
			this.setResizable(false);
			//给窗口定位
			BorderLayout thisLayout = new BorderLayout();
			this.setLocation(new Point(800, 30));
			getContentPane().setLayout(thisLayout);
			{
				jPanel1 = new JPanel();
				getContentPane().add(jPanel1, BorderLayout.NORTH);
				jPanel1.setLayout(null);
				jPanel1.setPreferredSize(new java.awt.Dimension(394, 103));
				{
					jLabel1 = new JLabel();
					ImageIcon image1 = new ImageIcon(this.getClass().getResource("../images/QQfaces/LargeImage/"+this.userInfo.getFaceid()+".jpg"));
					//ImageIcon image1 = new ImageIcon("../images/1.jpg");
					image1.setImage(image1.getImage().getScaledInstance(69, 66, Image.SCALE_DEFAULT));
					jLabel1.setIcon(image1);
					jPanel1.add(jLabel1);
					jLabel1.setBounds(18, 22, 69, 66);
					//jLabel1.setBorder(new LineBorder(new java.awt.Color(255,0,128), 1, false));
				}
				{
					jLabel2 = new JLabel();
					jPanel1.add(jLabel2);
					jLabel2.setBounds(111, 31, 237, 49);


					jLabel2.setText(this.userInfo.getNickname());//当前用户昵称赋值
					jLabel2.setFont(new Font("微软雅黑", Font.BOLD, 20));
					jLabel2.setForeground(Color.BLACK);
				}

				{
					JLabel state = new JLabel();


					jPanel1.add(state);
					state.setBounds(111, 75, 237, 20);
					//根据用户选择状态显示不同用户状态
					if(this.userInfo.getStateid()==8){
						state.setText("写代码");
						state.setForeground(Color.red);
					}else if(this.userInfo.getStateid()==7){
						state.setText("忙碌");
						state.setForeground(Color.red);
					}
					else if(this.userInfo.getStateid()==6){
						state.setText("离开");
						state.setForeground(Color.LIGHT_GRAY);
					}
					else if(this.userInfo.getStateid()==5){
						state.setText("隐身");
						state.setForeground(Color.gray);
					}
					else if(this.userInfo.getStateid()==4){
						state.setText("Q我吧");
						state.setForeground(Color.ORANGE);
					}
					else if(this.userInfo.getStateid()==3){
						state.setText("工作中");
						state.setForeground(Color.red);
					}
					else if(this.userInfo.getStateid()==2){
						state.setText("在线");
						state.setForeground(Color.green);
					}
					else if(this.userInfo.getStateid()==1){
						state.setText("下线");
						state.setForeground(Color.gray);
					}




					//state.setFont(new Font("微软雅黑", Font.PLAIN, 20));

				}


			}
			{
				jPanel2 = new JPanel();
				getContentPane().add(jPanel2, BorderLayout.SOUTH);
				jPanel2.setLayout(null);
				jPanel2.setPreferredSize(new java.awt.Dimension(394, 40));
				jLabel3 = new JLabel(new ImageIcon("images/FormImage/Search.jpg"));
				//jLabel3 = new JLabel(new ImageIcon("../images/1.jpg"));
				//../images/1.jpg
				jPanel2.add(jLabel3);
				//设置图标的位置
				jLabel3.setBounds(12, 4, 28, 24);
			}
			{
				jTabbedPane1 = new JTabbedPane();
				getContentPane().add(jTabbedPane1, BorderLayout.CENTER);
				jTabbedPane1.setOpaque(true);
				{
					jPanel3 = new JPanel();
					BorderLayout jPanel3Layout = new BorderLayout();
					jTabbedPane1.addTab("好友", null, jPanel3, null);
					jPanel3.setLayout(jPanel3Layout);
					{
						jButton1 = new JButton();
						jPanel3.add(jButton1, BorderLayout.NORTH);
						jButton1.setText("\u597d\u53cb");
					}
					{
						jPanel5 = new JPanel();
						GridLayout jPanel5Layout = new GridLayout(2, 1);
						jPanel5Layout.setColumns(1);
						jPanel5Layout.setRows(2);
						jPanel3.add(jPanel5, BorderLayout.SOUTH);
						jPanel5.setLayout(jPanel5Layout);
						jPanel5.setPreferredSize(new java.awt.Dimension(389, 75));
						{
							jButton2 = new JButton();
							jPanel5.add(jButton2);
							jButton2.setText("\u964c\u751f\u4eba");
							jButton2.setPreferredSize(new java.awt.Dimension(389, 31));
						}
						{
							jButton3 = new JButton();
							jPanel5.add(jButton3);
							jButton3.setText("\u9ed1\u540d\u5355");
							jButton3.setPreferredSize(new java.awt.Dimension(389, 33));
						}
					}
					{
						jScrollPane1 = new JScrollPane();
						jPanel3.add(jScrollPane1, BorderLayout.CENTER);
						{
							jPanel6 = new JPanel();
							//new GridLayout(行数, 列数, 水平间距,垂直间距);
							GridLayout jPanel6Layout = new GridLayout(50, 1, 0,10);

							//循环创建50个好友
							JLabel[] jls = new JLabel[50];
							for(int i=0;i<jls.length;i++){
								//new JLabel(文本,图片地址,放的位置);
								jls[i] = new JLabel("好友"+(i+1), new ImageIcon("images/QQfaces/LargeImage/12.jpg"), JLabel.LEFT);
								jPanel6.add(jls[i]);
							}
							jPanel6.setLayout(jPanel6Layout);

							//把面板放到滚动面板里
							jScrollPane1.setViewportView(jPanel6);

							//创建右键菜单 ： 删除好友,删除所有好友
							jPopupMenu = new JPopupMenu();
							//创建2个右键菜单项目
							jMenuItem1 = new JMenuItem();
							jMenuItem1.setText("删除好友");

							jMenuItem2 = new JMenuItem();
							jMenuItem2.setText("删除所有好友");

							jPopupMenu.add(jMenuItem1);
							jPopupMenu.add(jMenuItem2);

							//把jPopupMenu放到jsp1里
							jScrollPane1.setComponentPopupMenu(jPopupMenu);
							//把jPopupMenu放到jphy2里
							jPanel6.setComponentPopupMenu(jPopupMenu);
						}
					}
				}
				{
					jPanel4 = new JPanel();
					jTabbedPane1.addTab("群组", null, jPanel4, null);
					jPanel4.setLayout(null);
				}
			}
			pack();
			setSize(400, 800);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void loadJF() {
	}


	@Override
	public void windowOpened(WindowEvent e) {

	}
	//点击关闭按钮时触发
	@Override
	public void windowClosing(WindowEvent e) {
		//提示是否关闭qq界面
		int i=JOptionPane.showConfirmDialog(QQMainJFrame.this,"您是否确定要关闭盗版OICQ","",JOptionPane.OK_CANCEL_OPTION);
		//根据选项关闭qq主界面，
		if(i==0){
			userDao.updateUserById(this.userInfo.getId()+"",1);//强制下线
			System.exit(0);//退出程序

		}
	}

	@Override
	public void windowClosed(WindowEvent e) {

	}

	@Override
	public void windowIconified(WindowEvent e) {

	}

	@Override
	public void windowDeiconified(WindowEvent e) {

	}

	@Override
	public void windowActivated(WindowEvent e) {

	}

	@Override
	public void windowDeactivated(WindowEvent e) {

	}
}
