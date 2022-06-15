package com.xf.jf;



import java.awt.Point;

import javax.swing.*;

import javax.swing.border.LineBorder;
import javax.swing.event.AncestorEvent;
import javax.swing.event.AncestorListener;

import com.xf.beans.FriendsInfo;
import com.xf.beans.UserInfo;
import com.xf.dao.FriendsDao;
import com.xf.dao.UserDao;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.*;
import java.io.Flushable;
import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

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
public class QQMainJFrame extends javax.swing.JFrame implements WindowListener, MouseListener,Runnable{

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
	static JLabel state;
	UserDao userDao =new UserDao();
	FriendsDao friendsDao =new FriendsDao();

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
		this.setResizable(false);//窗口大小
		//当窗口关闭的时候，不操作
		this.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
		//this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//界面关闭之后，同步关闭程序进程
		this.setIconImage(new ImageIcon(this.getClass().getResource("../images/1.jpg")).getImage());//设置窗体logo
		//添加关闭窗体按钮监听
		this.addWindowListener(this);
		this.setTitle("盗版QQ");//添加标题


	}

	private void initGUI() {
		QQMainJFrame that=this;//复制给自己
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
					ImageIcon image1 = new ImageIcon(this.getClass().getResource("../images/QQfaces/LargeImage/"+this.userInfo.getFaceid()+".png"));
					//ImageIcon image1 = new ImageIcon("../images/1.jpg");
					image1.setImage(image1.getImage().getScaledInstance(69, 66, Image.SCALE_DEFAULT));
					jLabel1.setIcon(image1);
					jPanel1.add(jLabel1);
					jLabel1.setBounds(18, 15, 69, 66);//22
					//jLabel1.setBorder(new LineBorder(new java.awt.Color(255,0,128), 1, false));
				}
				{
					jLabel2 = new JLabel();
					jPanel1.add(jLabel2);
					jLabel2.setBounds(111, 13, 200, 75);//111,13,237,48,28

					jLabel2.setText(this.userInfo.getNickname());//当前用户昵称赋值

					//System.out.println(this.userInfo.getNickname()+"www");
					jLabel2.setFont(new Font("微软雅黑", Font.BOLD, 20));
					jLabel2.setForeground(Color.red);






					/*
					JLabel unameJl =new JLabel("生日快乐");
					unameJl.setBounds(164,23,100,28);
					unameJl.setFont(new Font("微软雅黑",Font.BOLD,18));//调整字体大小
					unameJl.setForeground(Color.red);
					jLabel2.add(unameJl);
					*/
				}


				{
				
					
					state = new JLabel();

					jPanel1.add(state);
					state.setBounds(111, 68, 50, 20);//111，60，237，20
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
					
					state.setFont(new Font("微软雅黑", Font.PLAIN, 12));

				}

				
				{
					//让默认焦点不在文本输入框中,设置在组建容器中
					jPanel1.setFocusable(true);
					JTextField sign =new JTextField(this.userInfo.getSign());//个性签名
					//sign.setBounds(144,23,100,28);
					//sign.setBounds(30,55,237,20);//可以正常
					sign.setOpaque(false);//设置组件透明
					sign.setBounds(38,55,237,22);
					sign.setBackground(new Color(0,0,0,0));//MacOs 设置java JtextFiled文本框为透明色
					//MatteBorder mb =new MatteBorder(0, 0, 0, 0,Color.cyan);
					sign.setFont(new Font("微软雅黑",Font.PLAIN,12));//调整字体大小
					//sign.setFocusable(false);

					sign.addFocusListener(new FocusListener() {
						//得到焦点
						@Override
						public void focusGained(FocusEvent e) {
							sign.setOpaque(true);
							sign.setBackground(Color.white);
							//sign.setBackground(new Color(0,0,0,0));//MacOs 设置java JtextFiled文本框为透明色
						}
						//失去焦点
						@Override
						public void focusLost(FocusEvent e) {
							sign.setOpaque(false);
							sign.setBackground(new Color(0,0,0,0));//MacOs 设置java JtextFiled文本框为透明色
							userDao.updateUserSignById(that.userInfo.getId()+"",sign.getText());//修改签名的功能
						}
					});




					sign.setForeground(Color.CYAN);
					jLabel2.add(sign);

				}


				{
					JLabel bg = new JLabel();//头部背景，迪士尼烟花背景
					jPanel1.add(bg);
					bg.setIcon(new ImageIcon(this.getClass().getResource("../images/bj01.gif")));
					bg.setBounds(-20, -25, 450, 280);//x,y237，20，，，450，280
					//
				}



				/*
					JLabel unameJl =new JLabel("生日快乐");
					unameJl.setBounds(164,23,100,28);
					unameJl.setFont(new Font("微软雅黑",Font.BOLD,18));//调整字体大小
					unameJl.setForeground(Color.red);
					jLabel2.add(unameJl);
					*/

			}


			{
				jPanel2 = new JPanel();
				getContentPane().add(jPanel2, BorderLayout.SOUTH);
				jPanel2.setLayout(null);
				jPanel2.setPreferredSize(new java.awt.Dimension(394, 40));
				jLabel3 = new JLabel(new ImageIcon(this.getClass().getResource("../images/searchh.jpg")));
				//给lable添加点击事件
				jLabel3.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent e) {
						AddFriendJF addFriendJF =new AddFriendJF(that.userInfo.getId());
						addFriendJF.loadJF();
					}
				});

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
						GridLayout jPanel5Layout = new GridLayout(2, 2);
						jPanel5Layout.setColumns(2);
						jPanel5Layout.setRows(2);
						jPanel3.add(jPanel5, BorderLayout.SOUTH);
						jPanel5.setLayout(jPanel5Layout);
						jPanel5.setPreferredSize(new java.awt.Dimension(389, 100));
						{
							jButton2 = new JButton();
							jPanel5.add(jButton2);
							jButton2.setText("\u964c\u751f\u4eba");
							jButton2.setPreferredSize(new java.awt.Dimension(389, 25));
						}
						{
							jButton3 = new JButton();
							jPanel5.add(jButton3);
							jButton3.setText("\u9ed1\u540d\u5355");
							jButton3.setPreferredSize(new java.awt.Dimension(389, 25));
						}
						{
							//添加好友  按昵称查询一次多个，按账号查询唯一性
//							JButton addBtn =new JButton("添加好友");
//							addBtn.setBounds(200,30,100,25);
//							addBtn.addActionListener(new ActionListener() {
//								@Override
//								public void actionPerformed(ActionEvent e) {
//									//添加好友界面加载 把当前用户的账户 传递到添加好友到界面去
//
//								}
//							});
//							jPanel5.add(addBtn);


						}
						{
							{
								JButton jButton4 = new JButton();
								jPanel5.add(jButton4);
								jButton4.setText("修改密码");
								jButton4.setPreferredSize(new java.awt.Dimension(389, 25));

//								findPwdJT.addMouseListener(new MouseAdapter() {
//									@Override
//									public void mouseClicked(MouseEvent e) {
////                super.mouseClicked(e);
//										QQMainJF qqMainJF =new QQMainJF();
//										qqMainJF.loadJF();
//									}
//								});
								jButton4.addActionListener(new ActionListener() {
									@Override
									public void actionPerformed(ActionEvent e) {
										//JOptionPane.showMessageDialog(QQMainJFrame.this,"敬请期待，功能稍后上线");
										UpdatePwd updatePwd = new UpdatePwd(userInfo.getId());
										updatePwd.loadJF();
									}
								});
							}

						}
					}
					{
						jScrollPane1 = new JScrollPane();
						jPanel3.add(jScrollPane1, BorderLayout.CENTER);
						{
							jPanel6 = new JPanel();
							//new GridLayout(行数, 列数, 水平间距,垂直间距);
							GridLayout jPanel6Layout = new GridLayout(50, 1, 0,10);

							////通过当前登陆用户账号 查询好友的账号，只显示账号不显示昵称
							////this.userInfo.getId();0-无数个好友


							//单表查询
							//主窗体有当前登陆的账号  this.userinfo.getid()

							//通过当前账号查询好友的账号
							//List<FriendsInfo> friends =friendsDao.getFrendsByHostId(this.userInfo.getId());;
							List<FriendsInfo> friends =friendsDao.getFriends(this.userInfo.getId());
							//System.out.println(this.userInfo.getId());


							//再通过好友账号查询好友的信息，刷新好友列表
							for (FriendsInfo friendsInfo:friends) {
								UserInfo info = userDao.getUserById(friendsInfo.getFriendid());

							}


							//通过当前账号好友刷新好友列表
							JLabel[] jls = new JLabel[friends.size()];
							for(int i=0;i<jls.length;i++){
								//new JLabel(文本,图片地址,放的位置);
								UserInfo info = userDao.getUserById(friends.get(i).getFriendid());//获取到当前好友的信息，并加载到界面
								//UserInfo info =friendsDao.getFrendsByHostId(friends.get(i).getFriendid());
								//System.out.println(friends.get(i).getFriendid());         //        .getResource("../images/QQfaces/LargeImage/"+this.userInfo.getFaceid()+".jpg"));

								//判断用户是否在线
								//定义图片变量
								String icon="";
								//icon="../images/QQfaces/LargeImage/"+info.getFaceid()+".png";


								if(info.getStateid()==1){//判断用户是否在线
									//离线/Users/dafei/MyQQ/src/com/xf/images/QQfaces/
									icon="../images/QQfaces/lixianImage/"+info.getFaceid()+".png";
								}else{
									//在线
									icon="../images/QQfaces/LargeImage/"+info.getFaceid()+".png";
								}
//


//								if(info.getStateid()==8){
//									state.setText("写代码");
//									state.setForeground(Color.red);
//								}else if(info.getStateid()==7){
//									state.setText("忙碌");
//									state.setForeground(Color.red);
//								}
//								else if(info.getStateid()==6){
//									state.setText("离开");
//									state.setForeground(Color.LIGHT_GRAY);
//								}
//								else if(info.getStateid()==5){
//									state.setText("隐身");
//									state.setForeground(Color.gray);
//								}
//								else if(info.getStateid()==4){
//									state.setText("Q我吧");
//									state.setForeground(Color.ORANGE);
//								}
//								else if(info.getStateid()==3){
//									state.setText("工作中");
//									state.setForeground(Color.red);
//								}
//								else if(info.getStateid()==2){
//									state.setText("在线");
//									state.setForeground(Color.green);
//								}
//								else if(info.getStateid()==1){
//									state.setText("下线");
//									state.setForeground(Color.gray);
//								}
//
//								state.setFont(new Font("微软雅黑", Font.PLAIN, 12));
								//状态
								JLabel stae=new JLabel();
								if(info.getStateid()==8){
									//stae="写代码";

									stae.setText("写代码");
									stae.setForeground(Color.red);

								}else if(info.getStateid()==7){
									stae.setText("忙碌");
									stae.setForeground(Color.red);
								}
								else if(info.getStateid()==6){
									stae.setText("离开");
									stae.setForeground(Color.LIGHT_GRAY);
								}
								else if(info.getStateid()==5){
									stae.setText("隐身");
									stae.setForeground(Color.gray);
								}
								else if(info.getStateid()==4){
									stae.setText("Q我吧");
									stae.setForeground(Color.ORANGE);
								}
								else if(info.getStateid()==3){
									stae.setText("工作中");

									stae.setForeground(Color.red);
								}
								else if(info.getStateid()==2){
									stae.setText("在线");

									stae.setForeground(Color.green);
								}
								else if(info.getStateid()==1){
									stae.setText("下线");
									stae.setForeground(Color.gray);

								}

								//
								jls[i] = new JLabel(info.getNickname()+"("+friends.get(i).getFriendid()+")"+"["+ stae.getText()+"]"+" "+info.getSign(), new ImageIcon(this.getClass().getResource(icon)), JLabel.LEFT);
								//jls[i] = new JLabel(info.getNickname()+"("+friends.get(i).getFriendid()+")", new ImageIcon(this.getClass().getResource(icon)), JLabel.LEFT);
								System.out.println(info.getNickname());
								//System.out.println(this.userInfo.getFaceid());
								//监听鼠标经过好与列表

								jls[i].addMouseListener(this);
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
		int i=JOptionPane.showConfirmDialog(QQMainJFrame.this,"您是否确定要关闭盗版QQ","",JOptionPane.OK_CANCEL_OPTION);
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



//
	@Override
	public void mouseClicked(MouseEvent e) {
		//先判断鼠标是否是双击效果
		if(e.getClickCount()==2){
			//QQChatJFrame qqChatJFrame =new QQChatJFrame(userInfo,"","");
			//先获取到我们点击到lable
			 JLabel label= (JLabel) e.getSource();
			 //从点击到lable中去获取好友到账户和昵称
			String str =label.getText();
//			System.out.println(str);
			//通过获取到到字符得到好友账户以及昵称
			String friendId=str.substring(str.indexOf("(")+1,str.indexOf(")"));
			//System.out.println(friendId);
			//获取好友昵称
			String nickName=str.substring(0,str.indexOf("("));
			System.out.println(nickName);
			QQChatJFrame qqChatJFrame =new QQChatJFrame(userInfo,friendId,nickName);
			qqChatJFrame.setVisible(true);
			//创建线程
			Thread thread =new Thread(qqChatJFrame);
			//启动线程
			thread.start();

		}
	}

	@Override
	public void mousePressed(MouseEvent e) {

	}

	@Override
	public void mouseReleased(MouseEvent e) {

	}

	@Override
	public void mouseEntered(MouseEvent e) {//鼠标划入的时候触发
	//获取事件源，谁触发，获取谁
		JLabel friendJL=(JLabel) e.getSource();
		//设置透明度
		friendJL.setOpaque(true);
		friendJL.setBackground(new Color(242,242,242));//MacOs 设置java JtextFiled文本框为透明色

		//设置字体颜色
		friendJL.setForeground(Color.BLUE);
	}

	@Override
	public void mouseExited(MouseEvent e) {//鼠标退出的时候触发
	//
		JLabel friendJL=(JLabel) e.getSource();
		friendJL.setOpaque(false);
		friendJL.setForeground(Color.black);
	}

	@Override
	public void run() {
//		int t=0;
//		while (true){
//			System.out.println("刷新"+t+"次");t++;
//			try {
//				JPanel jPanel = new JPanel();
//				GridLayout jPanelLayout = new GridLayout(50, 1, 0,10);
//				List<FriendsInfo> friends=friendsDao.getFriends(this.userInfo.getId());
//				JLabel[] jls = new JLabel[friends.size()];
//
//				for(int i=0;i<jls.length;i++){
//					//new JLabel(文本,图片地址,放的位置);
//					//获取到当前好友的信息
//					UserInfo info=userDao.getUserById(friends.get(i).getFriendid());
//					//判断好友是否在线
//					//定义图片变量
//					String icon ="";
//					if(info.getStateid()==2){
//						icon = "../images/QQfaces/lixianImage/"+info.getFaceid()+".png";
//					}
//					else {
//						icon = "../images/QQfaces/LargeImage/"+info.getFaceid()+".png";
//					}
//
//					jls[i] = new JLabel(info.getNickname()+"("+info.getId()+")", new ImageIcon(this.getClass().getResource(icon)), JLabel.LEFT);
//					//监听鼠标经过好友列表
//					jls[i].addMouseListener(this);
//					jPanel.add(jls[i]);
//					jPanel.setLayout(jPanelLayout);
//					jScrollPane1.setViewportView(jPanel);
//
//				}
//				//把jPopupMenu放到jsp1里
//				jScrollPane1.setComponentPopupMenu(jPopupMenu);
//				//把jPopupMenu放到jphy2里
//				jPanel.setComponentPopupMenu(jPopupMenu);
//
//
//				Thread.sleep(1000);
//
//			} catch (InterruptedException e) {
//				e.printStackTrace();
//			}
//		}
	}
}
