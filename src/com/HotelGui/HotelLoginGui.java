	/**====================================================**
	 *     项目名             ：酒店管理系统 
	 *     模块名             ：系统登录窗口
	 *     文件名             ：HotelLoginGui.java
	 *     相关文件         ：DataBaseConnct.java   HotelMainGui.java
	 *     实现功能         ：系统登录界面
	 *     函数说明         ：
	 *     [## public MyJframe(){}]：
	 *        功能：构造函数     组建登录窗口
	 *     [## public void enevtOperation(final MyLoginJframe mj){}]
	 *        功能：登录界面的事件监听处理
	 *     [## private boolean loginCheck() {}]:
	 *        功能：登录验证，仅类内使用
	 *     [## private void quit() {}]:
	 *        功能：关闭系统函数，仅类内使用
	 **===================================================**/
package com.HotelGui;
import com.common.*;//引入包 
import com.databasejdbc.CheckIn;
import com.databasejdbc.OrderRoom;
import com.entity.User;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.jws.soap.SOAPBinding.Style;
import javax.swing.*;

import java.util.*;
public class HotelLoginGui extends JFrame  {
	
	DataBaseConnect dc;
	JPasswordField passwordnum;
	JTextField accountnum;
	JLabel password,account,login,backimg,backimg1;
	JLabel tiplabel;
	JComboBox<String> loginchoice;
	JButton loginbutton,registerbutton,exitbutton;
	JPanel jp,jp0,jp1,jp2,jp3,jp4,jp5;
	Vector<String> dept=new Vector<String>();
	private String id_now,user_type;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		HotelLoginGui logingui=new HotelLoginGui();
	}
	/**=======================================================**
	 *               设置当前成功登录的ID
	 **========================================================*/
	public void setId_now(String id_now) {
		this.id_now = id_now;
	}

	/**=======================================================**
	 *               获得当前成功登录的ID
	 **========================================================*/
	public String getId_now() {
		return  id_now;
	}
	/**====================================================**
	 *     **[## public MyJframe() {}]    组建登录窗口
	 *       参数      ：无
	 *       返回值  ：无
	 *       修饰符  ：public
	 *       功能  ：组建登录窗口
	 **===================================================**/

	public HotelLoginGui()
	{   dc=new DataBaseConnect();//连接数据库实例
		jp=new JPanel();

		jp.setBounds(0, -5,550, 200);
		jp0=new JPanel();
		jp0.setBounds(0,190,250,250);
		jp1=new JPanel();
		jp1.setBounds(270, 215, 250, 30);
		jp2=new JPanel();
		jp2.setBounds(270, 250, 250, 30);
		jp3=new JPanel();
		jp3.setBounds(270, 280, 250, 30);
		jp4=new JPanel();
		jp4.setBounds(270, 335, 250, 40);
		jp5=new JPanel();
		jp5.setBounds(270, 380, 250, 30);
		dept.add("经理");
		dept.add("普通员工");
		dept.add("顾客");
		account=new JLabel("账  户");
		password=new  JLabel("密  码");
		login=new JLabel("用  户                  ");
		backimg=new JLabel(new ImageIcon("images\\7day.jpg"));
		backimg1=new JLabel(new ImageIcon("images\\back2.jpg"));
		tiplabel=new JLabel();
		tiplabel.setFont(new Font("宋体", Font.PLAIN, 12));
		tiplabel.setForeground(Color.red);
		tiplabel.setVisible(false);
		passwordnum=new  JPasswordField(12);
		accountnum=new JTextField(12);
		loginbutton=new JButton("登  录");
		loginbutton.setOpaque(false);
		loginbutton.setContentAreaFilled(false);
		
		registerbutton=new JButton("注  册");
		registerbutton.setOpaque(false);
		registerbutton.setContentAreaFilled(false);
		
		exitbutton =new JButton("退  出");
		exitbutton.setOpaque(false);
		exitbutton.setContentAreaFilled(false);
		
		loginchoice =new JComboBox(dept);
		jp.add(backimg);
		jp0.add(backimg1);
		jp1.add(account);
		jp1.add(accountnum);
		jp2.add(password);
		jp2.add(passwordnum);
		jp3.add(login);
		jp3.add(loginchoice);
		jp4.add(loginbutton);
		jp4.add(registerbutton);
		jp4.add(exitbutton);
		jp5.add(tiplabel);
		
	    this.add(jp);
	    this.add(jp0);
	    this.add(jp1);
	    this.add(jp2);
	    this.add(jp3);
	    this.add(jp4);
	    this.add(jp5);
	    this.setTitle("系统登录");
	    this.setLayout(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);
		this.setBounds(320, 160, 550, 450);
		this.setIconImage(new ImageIcon("images\\icon.jpg").getImage());
		this.setVisible(true);
		enevtOperation();
	}
	/**====================================================**
	 *     **[## private void enevtOperation() {}]    事件处理
	 *       参数      ：无
	 *       返回值  ：无
	 *       修饰符  ：public
	 *       功能  ：登录窗口的事件操作
	 **===================================================**/
	public void cancel() {
		this.dispose();
	}
	
	public void enevtOperation()
	{
		/**=======================================================**
		 *               登录按钮监听事件
		 **========================================================*/
		loginbutton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				int id=Integer.parseInt(accountnum.getText());
				int password=Integer.parseInt(passwordnum.getText());
				User user = new User(id,password);
				int flag = user.logincheck(loginchoice.getSelectedIndex());
				
				
				if (flag==4) {
					tiplabel.setText("账号不存在，先注册");
				}
				else if(flag!=0)
				{
					tiplabel.setText("正  在  登  录...");
					//记录当前的操作记录
					id_now=accountnum.getText();
					user_type=loginchoice.getSelectedItem().toString();
					if (flag!=2) {
						MyHotelMainGui mm=new MyHotelMainGui();  //登录到主界面
						cancel();
						
						//显示当前的操作人员信息
						mm.setId_now(id_now);
						mm.setUser_type(user_type);
						mm.enevtOpration();
						mm.updateRoomState();
						Thread th=new Thread(mm);
						th.start();
					} else {
						OrderRoom or=new OrderRoom("预订登记","images\\checkin_bt.jpg");
						cancel();
					}

				}
				else if(accountnum.getText().isEmpty() && passwordnum.getPassword().length==0)
					tiplabel.setText("密码与账号不能为空!");
				else if(accountnum.getText().isEmpty() && passwordnum.getPassword().length!=0)
					tiplabel.setText("请输入账号...");
				else if(accountnum.getText().isEmpty()==false && passwordnum.getPassword().length==0)
					tiplabel.setText("请输入密码...");
				else
					tiplabel.setText("请检查后重新输入!");
				
				tiplabel.setVisible(true);
			}
		});
		/**=======================================================**
		 *              重置按钮监听事件
		 **========================================================*/
		registerbutton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				switch (loginchoice.getSelectedIndex()) {
				case 0:
				{
					String str="'"+Integer.parseInt(accountnum.getText())+"','"+Integer.parseInt(passwordnum.getText())+"'";
					try {
						dc.insertData("managers_table", str);
					} catch (Exception e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					tiplabel.setText("注册成功 可以登录");
					tiplabel.setVisible(true);
					break;
				}
				case 1:
				{
					String str="'"+Integer.parseInt(accountnum.getText())+"','"+Integer.parseInt(passwordnum.getText())+"'";
					try {
						dc.insertData("common_table", str);
					} catch (Exception e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					tiplabel.setText("注册成功 可以登录");
					tiplabel.setVisible(true);
					break;
				}
				case 2:
				{
					String str="'"+Integer.parseInt(accountnum.getText())+"','"+Integer.parseInt(passwordnum.getText())+"'";
					try {
						dc.insertData("customers_table", str);
					} catch (Exception e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					tiplabel.setText("注册成功 可以登录");
					tiplabel.setVisible(true);
					break;
				}
				default:
					break;
				}
			  }
			
		});
		/**=======================================================**
		 *              退出按钮监听事件
		 **========================================================*/
		exitbutton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				quit();
				
			}
		});
	}
	
	/**====================================================**
	 *     **[## private void quit() {}]    系统退出
	 *       参数      ：无
	 *       返回值  ：无
	 *       修饰符  ：private
	 *       功能  ：关闭系统函数，仅类内使用
	 **===================================================**/
	private void quit()
	{
		int flag=0;
		String msg="你 确 定 要 关 闭 系 统 吗？";
		flag=JOptionPane.showConfirmDialog(null, msg,"提示",JOptionPane.YES_NO_OPTION);
		if(flag==JOptionPane.YES_OPTION)
		{
			this.setVisible(false);
			System.exit(0);
		}
		return;
	}

}







