/**
 * @Title: Check_byOrder.java
 * @Description:
 * @Copyright: Copyright (c) 2018 
 * @Company:nuaa
 * @author xck&kevin
 * @date 2019年1月3日
 * @version 1.0
 */
package com.databasejdbc;

import java.awt.Color;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.Vector;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import com.common.DataBaseConnect;
import com.entity.Record;
import com.entity.Room;

/**
 * @author Kevin
 *
 */
public class Check_byOrder extends JFrame {
	JLabel name_jl, gender_jl, id_jl, charge_jl, despoit_jl, room_num_jl, room_type_jl, checkin_jl, checkout_jl,
			tital_jl, tip_jl, phone_jl, order_id_jl, tip1_jl, tip2_jl;
	JButton return_bt, check_bt;
	JComboBox<String> gender_jb, room_type_jb;
	JTextField name_jf, id_jf;
	JTextField phone_jf, room_num_jf;
	JTextField despoit_jf;
	JTextField charge_jf;
	JTextField checkin_jf;
	JTextField checkout_jf;
	JTextField order_id_jf;

	public static void main(String[] args) {
		Check_byOrder name = new Check_byOrder("入住查询", "images\\checkin_bt.jpg");
	}


	public Check_byOrder(String str1, String path) {
		
		tital_jl = new JLabel(str1);
		tital_jl.setBounds(300, 20, 200, 60);
		tital_jl.setFont(new Font("宋体", Font.BOLD, 23));
		
		tip1_jl = new JLabel("##信息如下################################");
		tip1_jl.setBounds(150, 120, 500, 40);
		tip1_jl.setForeground(Color.blue);
		tip1_jl.setFont(new Font("宋体", Font.HANGING_BASELINE, 15));
		
		tip2_jl = new JLabel("##信息如上################################");
		tip2_jl.setBounds(150, 370, 500, 40);
		tip2_jl.setForeground(Color.blue);
		tip2_jl.setFont(new Font("宋体", Font.HANGING_BASELINE, 15));
		
		name_jl = new JLabel("姓    名");
		name_jl.setBounds(150, 170, 60, 30);
		name_jl.setFont(new Font("宋体", Font.HANGING_BASELINE, 14));
		name_jf = new JTextField(10);
		name_jf.setBounds(230, 170, 140, 27);
		
		id_jl = new JLabel("身份证号");
		id_jl.setBounds(450, 170, 60, 30);
		id_jl.setFont(new Font("宋体", Font.HANGING_BASELINE, 14));
		id_jf = new JTextField(10);
		id_jf.setBounds(530, 170, 140, 27);
		
		gender_jl = new JLabel("性    别");
		gender_jl.setBounds(150, 220, 60, 30);
		gender_jl.setFont(new Font("宋体", Font.HANGING_BASELINE, 14));
		gender_jb = new JComboBox<String>();
		gender_jb.setBounds(230, 220, 140, 27);
		gender_jb.addItem("男");
		gender_jb.addItem("女");
		
		room_type_jl = new JLabel("预期房间");
		room_type_jl.setBounds(450, 220, 60, 30);
		room_type_jl.setFont(new Font("宋体", Font.HANGING_BASELINE, 14));
		room_type_jb = new JComboBox<String>();
		room_type_jb.setBounds(530, 220, 140, 27);
		room_type_jb.addItem("商务单间");
		room_type_jb.addItem("商务标间");
		room_type_jb.addItem("大床房");
		room_type_jb.addItem("杂物间");
		
		checkin_jl = new JLabel("入住日期");
		checkin_jl.setBounds(150, 270, 60, 40);
		checkin_jl.setFont(new Font("宋体", Font.HANGING_BASELINE, 14));
		checkin_jf = new JTextField(10);
		checkin_jf.setBounds(230, 270, 140, 27);
		
		checkout_jl = new JLabel("离店日期");
		checkout_jl.setBounds(450, 270, 60, 30);
		checkout_jl.setFont(new Font("宋体", Font.HANGING_BASELINE, 14));
		checkout_jf = new JTextField(10);
		checkout_jf.setBounds(530, 270, 140, 27);
		
		phone_jl = new JLabel("手机号码");
		phone_jl.setBounds(150, 320, 60, 30);
		phone_jl.setFont(new Font("宋体", Font.HANGING_BASELINE, 14));
		phone_jf = new JTextField(10);
		phone_jf.setBounds(230, 320, 140, 27);
		
		room_num_jl = new JLabel("安排房号");
		room_num_jl.setBounds(150, 420, 60, 30);
		room_num_jl.setFont(new Font("宋体", Font.HANGING_BASELINE, 14));
		room_num_jf = new JTextField(10);
		room_num_jf.setBounds(230, 420, 140, 27);
		
		charge_jl = new JLabel("实际收费");
		charge_jl.setBounds(150, 470, 60, 30);
		charge_jl.setFont(new Font("宋体", Font.HANGING_BASELINE, 14));
		charge_jf = new JTextField(10);
		charge_jf.setBounds(230, 470, 140, 27);
		
		despoit_jl = new JLabel("预收押金");
		despoit_jl.setBounds(450, 470, 60, 30);
		despoit_jl.setFont(new Font("宋体", Font.HANGING_BASELINE, 14));
		despoit_jf = new JTextField(10);
		despoit_jf.setBounds(530, 470, 140, 27);
		
		order_id_jl = new JLabel("订单号");
		order_id_jl.setBounds(150, 100, 60, 30);
		order_id_jl.setFont(new Font("宋体", Font.HANGING_BASELINE, 14));
		order_id_jf = new JTextField(10);
		order_id_jf.setBounds(230, 100, 140, 27);
		
		check_bt = new JButton("查询");
		check_bt.setBounds(400, 100, 85, 30);
		check_bt.setOpaque(false);
		
		return_bt = new JButton(new ImageIcon("images\\return_bt.jpg"));
		return_bt.setBounds(530, 550, 85, 30);
		return_bt.setOpaque(false);
		return_bt.setActionCommand("1");
		
		this.setLayout(null);
		this.add(tital_jl);
		this.add(tip1_jl);
		this.add(tip2_jl);

		this.add(check_bt);
		this.add(name_jl);
		this.add(name_jf);
		this.add(id_jl);
		this.add(gender_jl);
		this.add(room_type_jl);
		
		this.add(checkin_jl);
		this.add(checkout_jl);
		this.add(phone_jl);
		this.add(phone_jf);
		
		this.add(room_num_jl);
		this.add(room_num_jf);
		
		this.add(charge_jl);
		this.add(charge_jf);
		this.add(despoit_jl);
		this.add(despoit_jf);
		this.add(order_id_jl);
		this.add(order_id_jf);
		

		this.add(return_bt);
		this.add(id_jf);
		this.add(gender_jb);
		this.add(room_type_jb);
		
		this.add(checkin_jf);
		this.add(checkout_jf);
		
		this.setTitle(str1);
		this.setIconImage(new ImageIcon("images\\入住登记.jpg").getImage());
		this.setBounds(250, 80, Toolkit.getDefaultToolkit().getScreenSize().width - 600,
				Toolkit.getDefaultToolkit().getScreenSize().height - 150);
		this.setResizable(false);
		this.setVisible(true);
		Order_Operation();
	}

	/**
	* 
	*/
	public void Order_Operation() {

		check_bt.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				DataBaseConnect dc = new DataBaseConnect();
				Record record = new Record();
				Room room = new Room();
				try {
					//System.out.println(order_id_jf.getText());
					record = dc.getDataFromAll(order_id_jf.getText());
					System.out.println(record.getRoomnum());
					room = dc.RoomOperation(record.getRoomnum());
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				if (record==null) {
					JOptionPane.showConfirmDialog(null, "未入住成功!", "提示", JOptionPane.CLOSED_OPTION);
				} else {
					room_num_jf.setText(String.valueOf(record.getRoomnum()));
					name_jf.setText(record.getName());
					id_jf.setText(record.getId());
					gender_jb.setSelectedItem(record.getSexy());
					System.out.println(room.getRoomtype());
					room_type_jb.setSelectedItem(room.getRoomtype());
					checkin_jf.setText(record.getCheckin());
					checkout_jf.setText(record.getCheckout());
					charge_jf.setText(String.valueOf(record.getCharge()));
					despoit_jf.setText(String.valueOf(record.getDespoit()));
					phone_jf.setText(record.getPhone_num());
				}
			}
		});
		return_bt.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				returnButton();

			}
		});
	}

	public void returnButton() {
		this.dispose();
	}

}