/*
 * 结账界面，结账退房后更改数据库中房间状态 
 */
package com.databasejdbc;
import java.awt.*;  

import com.HotelGui.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.*;
import javax.swing.event.AncestorListener;
import javax.xml.crypto.Data;

import com.HotelGui.MyHotelMainGui;
import com.common.*;
import com.entity.Record;
import com.entity.Room;
public class CheckOut extends CheckIn implements ActionListener{

	JLabel jl;
	public final JTextField jtf;
	public JButton check_bt,checkout_bt;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CheckOut co=new CheckOut("客人退房","images\\checkout_bt.jpg");
	}
	public CheckOut(String str1,String path) {
		super(str1,path);
		jl=new JLabel("退房房间号");
		jl.setBounds(250,120, 80, 28);
		jl.setFont(new Font("宋体",Font.HANGING_BASELINE,14));
		jl.setForeground(Color.RED);
		jtf=new JTextField(10);
		jtf.setBounds(330, 120, 60, 28);
		cancel_bt.setVisible(false);
		checkout_bt=new JButton(new ImageIcon(path));
		checkout_bt.setBounds(160, 500, 85, 30);
		checkout_bt.setOpaque(false);
		checkout_bt.setActionCommand("1");	
		
		checkin_bt.setVisible(false);
		
		check_bt=new JButton("查   询");
		check_bt.setBounds(410, 120, 70, 28);
		check_bt.setOpaque(false);
		check_bt.setActionCommand("2");
		this.add(jl);
		this.add(jtf);
		this.add(checkout_bt);
		this.add(check_bt);
		Operation();
	}
	
	/*===========================JOptionPane.YES_OPTION========================**
	 * [## public void checkout_Bt(){}]     退房按钮操作
	 *      参  数            ：无
	 *      返回值          ：无
	 *      修饰符          ：public
	 *      功能              ：点击退房，更新数据库中该房间的状态从2为0
	 *===================================================*/
	public void checkout_Bt()
	{
		DataBaseConnect dc=new DataBaseConnect();
		try {
			Record one = new Record();
			one=dc.getDataFromAll(Integer.parseInt(room_num_jf.getText()));
			System.out.println(room_num_jf.getText());
			System.out.println(one.getOrder_id());
			
	    	String str=new String("'"+Integer.valueOf(room_num_jf.getText())+"','"+name_jf.getText()+"','"+id_jf.getText()+"','"+gender_jb.getSelectedItem().toString()+"','"+
	    			checkin_jf.getText()+"','"+checkout_jf.getText()+"','"+Integer.valueOf(charge_jf.getText())+"','"+Integer.valueOf(despoit_jf.getText())+"','"
	    			+phone_jf.getText()+"','"+one.getOrder_id()+"'");
			dc.insertData("History_all_table", str);
			dc.updateData("update room_table set roomstate=0 where roomnum="+Integer.valueOf(jtf.getText()));
			dc.updateData("delete from all_table where roomnum="+Integer.valueOf(jtf.getText()));
			} catch (Exception e1) {
				e1.printStackTrace();
				}
		MyHotelMainGui hm=new MyHotelMainGui(1);
		hm.updateRoomState();
	}
	/*===================================================**
	 * [## public void check_BT(){}]     退房按钮操作
	 *      参  数            ：无
	 *      返回值          ：无
	 *      修饰符          ：public
	 *      功能              ：点击查询，从数据库中返回数据到界面
	 *===================================================*/	
	public void check_Bt(String str) throws Exception
	{
		//check_bt.addActionListener(l);
		DataBaseConnect dc=new DataBaseConnect();
		
		//System.out.println(Integer.valueOf(jtf.getText().trim()));
		System.out.println("调试");
		Record record=dc.getDataFromAll(Integer.valueOf(jtf.getText().trim()));

		Room room=dc.RoomOperation(Integer.parseInt(jtf.getText().trim()));

		if(room.getRoomstate()==0)
		{
			   JOptionPane.showMessageDialog(this, str);
			   returnButton();
		}
		else 
		{
			//System.out.println("kankan"+data.get(0).toString());
			if (room.getRoomstate()==1) {
				System.out.println("提示预定");
				JOptionPane.showMessageDialog(this, "该房间暂处于预定状态");
			} 
			
			room_num_jf.setText(String.valueOf(record.getRoomnum()));
			name_jf.setText(record.getName());
			id_jf.setText(record.getId());
			gender_jb.setSelectedItem(record.getSexy());
			checkin_jf.setText(record.getCheckin());
			checkout_jf.setText(record.getCheckout());
			charge_jf.setText(String.valueOf(record.getCharge()));
			despoit_jf.setText(String.valueOf(record.getDespoit()));
			price_jf.setText(String.valueOf(room.getRoomprice()));
			room_type_jb.setSelectedItem(room.getRoomtype());
			phone_jf.setText(record.getPhone_num());
		}
	}
	public void Operation() {
		check_bt.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("查询");
				try {
					check_Bt("未入住");
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		
		checkout_bt.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				int flag=JOptionPane.showConfirmDialog(null, "已退房！","提示",JOptionPane.PLAIN_MESSAGE);
				if(flag==JOptionPane.YES_OPTION)
				{
					checkout_Bt();
				}
				return;
			}
		});
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
}

