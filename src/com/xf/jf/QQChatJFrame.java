package com.xf.jf;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Scrollbar;
import java.awt.event.*;
import java.net.SocketAddress;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextPane;

import javax.swing.WindowConstants;

import com.xf.beans.Messagesinfo;
import com.xf.beans.UserInfo;
import com.xf.dao.MsgDao;
import com.xf.dao.UserDao;
import jdk.internal.access.JavaIOFileDescriptorAccess;

import javax.swing.SwingUtilities;

import static java.lang.System.exit;


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
	//继承thread类
	//实现Runnable类
public class QQChatJFrame extends javax.swing.JFrame implements Runnable, ActionListener {
	private JPanel jPanel1;
	private JScrollPane jScrollPane1;
	private JLabel jLabel3;
	private JButton jButton1;
	private JButton jButton2;
	private JTextArea jTextArea2;
	private JPanel jPanel6;
	private JPanel jPanel5;
	private JLabel jLabel2;
	private JLabel jLabel1;
	private JPanel jPanel4;
	private JTextArea jTextArea1;
	private JPanel jPanel3;
	private JPanel jPanel2;
	//用户信息

	private UserInfo userInfo;
	//好友id
	private String friendId;
	//好友name
	private String fNickName;
	//控制是否结束循环读取消息
	private boolean flag = true;
	MsgDao msgDao =new MsgDao();
	UserDao userDao =new UserDao();
	//UserInfo userInfo=new UserInfo();


	/**
	 * Auto-generated main method to display this JFrame
	 */
	/*public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				QQChatJFrame inst = new QQChatJFrame();
				inst.setLocationRelativeTo(null);
				inst.setVisible(true);
			}
		});
	}*/

	public QQChatJFrame(UserInfo userInfo,String friendId,String fNickName) {
		super();
		this.userInfo = userInfo;
		this.friendId=friendId;
		this.fNickName=fNickName;
		initGUI();
		//窗体不能改变大小
		this.setResizable(false);
		this.setLocationRelativeTo(null);//居中
	}

	private void initGUI() {
		try {
			setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			{
				jPanel1 = new JPanel();
				getContentPane().add(jPanel1, BorderLayout.CENTER);
				jPanel1.setLayout(null);

				{//发送数据
					jTextArea2 = new JTextArea();
					jPanel1.add(jTextArea2);
					jTextArea2.setFont(new Font("幼圆",Font.PLAIN,18));
					jTextArea2.setBounds(0, 499, 878, 96);
					jTextArea2.addKeyListener(new KeyListener() {
						@Override
						public void keyTyped(KeyEvent e) {

						}

						@Override
						public void keyPressed(KeyEvent e) {
						//System.out.println(e.getKeyChar(),e.getKeyCode());
							if(e.getKeyCode()==10){
								String msg=jTextArea2.getText().trim();
								//发送消息，吧消息添加到数据库
								msgDao.addMsg(userInfo.getId(),friendId,msg);
								//把消息框清空
								jTextArea2.setText("");
							}
						}

						@Override
						public void keyReleased(KeyEvent e) {

						}
					});

				}

				{
					jButton1 = new JButton();
					jPanel1.add(jButton1);
					jButton1.setText("发送");
					jButton1.addActionListener(new ActionListener() {
						@Override
						public void actionPerformed(ActionEvent e) {

							String msg=jTextArea2.getText().trim();
							//发送消息，吧消息添加到数据库
							msgDao.addMsg(userInfo.getId(),friendId,msg);
							//把消息框清空
							jTextArea2.setText("");
							jTextArea1.setSelectionStart(jTextArea1.getText().length());

						}
					});
					jButton1.setBounds(538, 607, 102, 31);
				}
				{
					jButton2 = new JButton();
					jPanel1.add(jButton2);
					jButton2.setText("关闭");
					jButton2.addActionListener(this);

					jButton2.setBounds(658, 607, 102, 31);
				}
				{
					jLabel1 = new JLabel();
					//图片自动调整，适应jlabel的大小
					ImageIcon image1 = new ImageIcon(this.getClass().getResource("../images/QQ秀1.jpeg"));
					image1.setImage(image1.getImage().getScaledInstance(150, 180, Image.SCALE_DEFAULT));
					jLabel1.setIcon(image1);
					jPanel1.add(jLabel1);
					jLabel1.setBounds(710, -40, 355, 392);//(696, 64, 177, 198);//900 700
				}
				{
					jLabel2 = new JLabel();
					//图片自动调整，适应jlabel的大小
					ImageIcon image2 = new ImageIcon(this.getClass().getResource("../images/QQ秀2.gif"));
					image2.setImage(image2.getImage().getScaledInstance(150, 180, Image.SCALE_DEFAULT));
					jLabel2.setIcon(image2);
					jPanel1.add(jLabel2);
					jLabel2.setBounds(710, 180, 355, 392);//(696, 268, 177, 198);
				}
				{
					jScrollPane1 = new JScrollPane();
					jPanel1.add(jScrollPane1);
					jScrollPane1.setBounds(0, 64, 691, 402);
					{
						jTextArea1 = new JTextArea();
						jTextArea1.setFont(new Font("幼圆",Font.PLAIN,18));
						jTextArea1.setSelectedTextColor(Color.blue);
						//设置不可编辑
						jTextArea1.setEditable(false);
						jTextArea1.setSelectionStart(jTextArea1.getText().length());
						//发消息的人的昵称
						//接受消息的人的昵称消息内容

						//小猪猪：
						//hello
						//小甜甜：
						//hi
						//获取聊天记录
						//查询当前用户与他的某个好友的聊天记录    通过两个账户来查询    当前用户的账户以及好友账户
						//
						List<Messagesinfo> msgs= msgDao.getMsg(this.userInfo.getId(),friendId);
						//显示发送者以及他的信息
						//内容拼接
						StringBuffer sb =new StringBuffer();
						//对所有消息进行循环遍历
						for (Messagesinfo messagesinfo: msgs) {
							sb.append(messagesinfo.getFromuserid()+"：");
							sb.append("\n");
							sb.append(messagesinfo.getMessage()+"\n");

						}
						//jTextArea1.setSelectionStart(jTextArea1.getText().length());
						jTextArea1.setText(sb.toString());
						//设置文本内容显示的范围
						jTextArea1.setSelectionStart(jTextArea1.getText().length());
						//jTextArea1.setSelectionStart(jTextArea1.getText().length());
						//jTextArea1.setSelectionStart(jTextArea1.getText().length());
						//激活自动换行功能
						jTextArea1.setLineWrap(true);
						//激活断行不断字功能
						jTextArea1.setWrapStyleWord(true);
						jScrollPane1.setViewportView(jTextArea1);
						//jTextArea1.setPreferredSize(new java.awt.Dimension(691, 399));
					}
				}
				{
					jLabel3 = new JLabel();


					jLabel3.setText("您正在和:"+fNickName+"("+friendId+")聊天\n");
					jLabel3.setFont(new Font("幼圆", 1, 18));
					jLabel3.setForeground(Color.black);
					jPanel1.add(jLabel3);
					jLabel3.setBounds(180, 16, 500, 35);
				}
			}
			pack();
			setSize(900, 700);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void run() {

	while(flag){
		//获取聊天记录
		//查询当前用户与他的某个好友的聊天记录    通过两个账户来查询    当前用户的账户以及好友账户
		//
		List<Messagesinfo> msgs= msgDao.getMsg(this.userInfo.getId(),friendId);
		//显示发送者以及他的信息
		//内容拼接
		StringBuffer sb =new StringBuffer();
		//对所有消息进行循环遍历
		for (Messagesinfo messagesinfo: msgs) {
			//通过发送者账户去获取到发送者到信息
			UserInfo userInfo =userDao.getUserById(Integer.parseInt(messagesinfo.getFromuserid()));
			sb.append(userInfo.getNickname()+"："+messagesinfo.getMessagedate());
			//System.out.println(messagesinfo.getMessagedate());
			sb.append("\n");
			sb.append("\n");
			sb.append("          "+messagesinfo.getMessage()+"\n");
			sb.append("\n");
		}
		jTextArea1.setFont(new Font("宋体",Font.BOLD,14));

		//jTextArea1.setBackground(new Color(255,255,255,255));
		jTextArea1.setText(sb.toString());
		jTextArea1.setSelectedTextColor(Color.red);

		jTextArea1.setSelectionStart(jTextArea1.getText().length());
		//
		//jTextArea1.setSelectedTextColor(Color.blue);

		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	}

	@Override//点击关闭窗口，并且终止消息列表刷新，避免浪费资源
	public void actionPerformed(ActionEvent e) {
		flag=false;
		this.dispose();
	}
}
