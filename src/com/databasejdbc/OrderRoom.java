/**
 * @Title: OrderRoom.java
 * @Description:
 * @Copyright: Copyright (c) 2018 
 * @Company:nuaa
 * @author xck&kevin
 * @date 2018年12月31日
 * @version 1.0
 */
package com.databasejdbc;
import com.HotelGui.HotelLoginGui;
import com.HotelGui.MyHotelMainGui;

import com.common.*;

import sun.invoke.empty.Empty;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Calendar;

import javax.swing.*;
/**
 * @author Kevin
 *
 */
public class OrderRoom extends JFrame {
	
	JLabel name_jl,gender_jl,id_jl,room_num_jl,room_type_jl,checkin_jl,checkout_jl,tital_jl,tip_jl,phone_jl,tip_jl1,tip_jl2;
	JButton checkin_bt,cancel_bt,return_bt;
	JComboBox<String> gender_jb,room_type_jb;
	JTextField name_jf,id_jf;
	JTextField phone_jf;

	JTextField checkin_jf;
	JTextField checkout_jf;
	public static void main(String[] args) {
		OrderRoom name = new OrderRoom("预定","images\\checkin_bt.jpg");
	}
/**====================================================**
 *     **[## public CheckIn(){}]    构造函数
 *       参数      ：String str1,String path  //界面Tital、按钮UI地址
 *       返回值  ：无
 *       修饰符  ：public
 *       功能  ：构造函数，初始化入住登记界面
 **===================================================**/
	public OrderRoom(String str1,String path)
	{
		tital_jl=new JLabel(str1);
		tital_jl.setBounds(300,20, 100, 60);
		tital_jl.setFont(new Font("宋体",Font.BOLD,23));
		tip_jl=new JLabel("（以下信息请完整填写）");
		tip_jl.setBounds(270,70, 200, 30);
		tip_jl.setFont(new Font("宋体",Font.HANGING_BASELINE,14));
		
		name_jl=new JLabel("姓    名");
		name_jl.setBounds(150, 170, 60, 30);
		name_jl.setFont(new Font("宋体",Font.HANGING_BASELINE,14));
		name_jf=new JTextField(10);
		name_jf.setBounds(230, 170, 140, 27);
	
		id_jl=new JLabel("身份证号");
		id_jl.setBounds(450, 170, 60, 30);
		id_jl.setFont(new Font("宋体",Font.HANGING_BASELINE,14));
		id_jf=new JTextField(10);
		id_jf.setBounds(530, 170, 140, 27);
		
		gender_jl=new JLabel("性    别");
		gender_jl.setBounds(150, 220, 60, 30);
		gender_jl.setFont(new Font("宋体",Font.HANGING_BASELINE,14));
		gender_jb=new JComboBox<String>();
		gender_jb.setBounds(230, 220, 140, 27);
		gender_jb.addItem("男");
		gender_jb.addItem("女");
		
		
		room_type_jl=new JLabel("预期房间");
		room_type_jl.setBounds(450, 220, 60, 30);
		room_type_jl.setFont(new Font("宋体",Font.HANGING_BASELINE,14));
		room_type_jb=new JComboBox<String>();
		room_type_jb.setBounds(530, 220, 140, 27);
		room_type_jb.addItem("商务单间");
		room_type_jb.addItem("商务标间");
		room_type_jb.addItem("大床房");
		room_type_jb.addItem("杂物间");
		
		
		checkin_jl=new JLabel("入住日期");
		tip_jl1=new JLabel("(####-##-##)");
		tip_jl1.setBounds(145, 300, 80, 40);
		checkin_jl.setBounds(150, 270, 60, 40);
		checkin_jl.setFont(new Font("宋体",Font.HANGING_BASELINE,14));
		checkin_jf=new JTextField(10);
		checkin_jf.setBounds(230, 270, 140, 27);
		
		checkout_jl=new JLabel("离店日期");
		tip_jl2=new JLabel("(####-##-##)");
		tip_jl2.setBounds(445, 300, 80, 40);
		checkout_jl.setBounds(450, 270, 60, 30);
		checkout_jl.setFont(new Font("宋体",Font.HANGING_BASELINE,14));
		checkout_jf=new JTextField(10);
		checkout_jf.setBounds(530, 270, 140, 27);
		
		phone_jl=new JLabel("手机号码");
		phone_jl.setBounds(150, 370, 60, 30);
		phone_jl.setFont(new Font("宋体",Font.HANGING_BASELINE,14));
		phone_jf=new JTextField(10);
		phone_jf.setBounds(230, 370, 140, 27);
		
		
		checkin_bt=new JButton(new ImageIcon(path));
		checkin_bt.setBounds(160, 500, 85, 30);
		checkin_bt.setOpaque(false);
		
		cancel_bt=new JButton(new ImageIcon("images\\cancel_bt.jpg"));
		cancel_bt.setBounds(345, 500, 85, 30);
		cancel_bt.setOpaque(false);
		
		return_bt=new JButton(new ImageIcon("images\\return_bt.jpg"));
		return_bt.setBounds(530, 500, 85, 30);
		return_bt.setOpaque(false);
		return_bt.setActionCommand("1");
		/**========================================**
		 *               返回按钮注册监听
		 =========================================*/
		return_bt.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if(e.getActionCommand().equals("1"))
					returnButton();
			}
		});
		
		this.setLayout(null);
		this.add(tital_jl);
		this.add(tip_jl);
		this.add(name_jl);
		this.add(name_jf);
		this.add(id_jl);
		this.add(gender_jl);
		this.add(room_type_jl);
	
	
		this.add(checkin_jl);
		this.add(tip_jl1);
		this.add(checkout_jl);
		this.add(tip_jl2);
		this.add(phone_jl);
		this.add(phone_jf);
		
		this.add(checkin_bt);
		this.add(cancel_bt);
		this.add(return_bt);
		this.add(id_jf);
		this.add(gender_jb);
		this.add(room_type_jb);
	
		this.add(checkin_jf);
		this.add(checkout_jf);
	
		this.setTitle(str1);
		this.setIconImage(new ImageIcon("images\\入住登记.jpg").getImage());
		this.setBounds(250, 80, Toolkit.getDefaultToolkit().getScreenSize().width-600,Toolkit.getDefaultToolkit().getScreenSize().height-150);
		this.setResizable(false);
		this.setVisible(true);
		Order_Operation();
	}
	/**
	 * 按钮操作
	 */
	public void Order_Operation() {
		
		cancel_bt.addActionListener(new ActionListener() {
	
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				name_jf.setText("");
				id_jf.setText("");
				
				checkin_jf.setText("");
				checkout_jf.setText("");
				phone_jf.setText("");
				gender_jb.setSelectedIndex(0);
				room_type_jb.setSelectedIndex(0);
			}
			
		});
		checkin_bt.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub	
				DataBaseConnect ns = new DataBaseConnect();
				int empty_num=1;
				try {
					empty_num = ns.getRow("select * from room_table where roomstate=0");
				} catch (Exception e2) {
					// TODO Auto-generated catch block
					e2.printStackTrace();
				}
				if (empty_num == 0) {
					JOptionPane.showConfirmDialog(null, "抱歉，暂无空房间","提示",JOptionPane.CLOSED_OPTION);
				} else {
					//获取当前时间作为预定单号
					Calendar date = Calendar.getInstance();
					String order_id=String.valueOf(date.get(Calendar.YEAR))+String.valueOf(date.get(Calendar.MONTH)+1)+
							String.valueOf(date.get(Calendar.DAY_OF_MONTH))+String.valueOf(date.get(Calendar.HOUR_OF_DAY))
							+String.valueOf(date.get(Calendar.MINUTE))+String.valueOf(date.get(Calendar.SECOND));
			    	DataBaseConnect dc=new DataBaseConnect();
			    	String str=new String("'"+name_jf.getText()+"','"+id_jf.getText()+"','"+gender_jb.getSelectedItem().toString()+"','"+
			    			room_type_jb.getSelectedItem().toString()+"','"+checkin_jf.getText()+"','"+checkout_jf.getText()+"','"+phone_jf.getText()+"','"+order_id+"','"+0+"'");
			    	System.out.println(str);
			    	try {
						dc.insertData("Order_table", str);
					} catch (Exception e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
			    	JOptionPane.showConfirmDialog(null, "登记成功!你的订单号为:"+order_id,"提示",JOptionPane.CLOSED_OPTION);
				}
	

			}
		});
		return_bt.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				returnButton();
				HotelLoginGui login = new HotelLoginGui();
				
			}
		});
	}

	
	public void returnButton()
	{
		this.dispose();
	}

}

