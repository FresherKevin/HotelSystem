/**
 * @Title: Ordermanager.java
 * @Description:
 * @Copyright: Copyright (c) 2018 
 * @Company:nuaa
 * @author xck&kevin
 * @date 2018年12月31日
 * @version 1.0
 */
package com.databasejdbc;

import java.awt.Color;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.Calendar;
import java.util.Vector;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import com.HotelGui.HotelLoginGui;
import com.common.DataBaseConnect;
import com.entity.Order;
import com.entity.Room;

/**
 * @author Kevin
 *
 */
public class Ordermanager extends JFrame {
	JLabel name_jl, gender_jl, id_jl, charge_jl, despoit_jl, room_num_jl, room_type_jl, checkin_jl, checkout_jl,
			tital_jl, tip_jl, phone_jl, order_id_jl, tip1_jl, tip2_jl;
	JButton checkin_bt, cancel_bt, return_bt, begin_bt, check_bt;
	JComboBox<String> gender_jb, room_type_jb;
	JTextField name_jf, id_jf;
	JTextField phone_jf, room_num_jf;
	JTextField despoit_jf;
	JTextField charge_jf;
	JTextField checkin_jf;
	JTextField checkout_jf;
	JTextField order_id_jf;
	private String order_id;

	public static void main(String[] args) {
		Ordermanager name = new Ordermanager("处理预定单", "images\\checkin_bt.jpg");
	}

	/**
	 * ====================================================** **[## public
	 * CheckIn(){}] 构造函数 参数 ：String str1,String path //界面Tital、按钮UI地址 返回值 ：无 修饰符
	 * ：public 功能  ：构造函数，初始化入住登记界面
	 ** ===================================================
	 **/
	public Ordermanager(String str1, String path) {
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

		checkin_bt = new JButton(new ImageIcon(path));
		checkin_bt.setBounds(160, 550, 85, 30);
		checkin_bt.setOpaque(false);

		order_id_jl = new JLabel("订单号");
		order_id_jl.setBounds(150, 100, 60, 30);
		order_id_jl.setFont(new Font("宋体", Font.HANGING_BASELINE, 14));
		order_id_jf = new JTextField(10);
		order_id_jf.setBounds(230, 100, 140, 27);

		check_bt = new JButton("查询");
		check_bt.setBounds(400, 100, 85, 30);
		check_bt.setOpaque(false);

		begin_bt = new JButton("安排");
		begin_bt.setBounds(600, 100, 85, 30);
		begin_bt.setOpaque(false);

		cancel_bt = new JButton(new ImageIcon("images\\cancel_bt.jpg"));
		cancel_bt.setBounds(345, 550, 85, 30);
		cancel_bt.setOpaque(false);

		return_bt = new JButton(new ImageIcon("images\\return_bt.jpg"));
		return_bt.setBounds(530, 550, 85, 30);
		return_bt.setOpaque(false);
		return_bt.setActionCommand("1");
		/**
		 * ========================================** 返回按钮注册监听
		 * =========================================
		 */
		return_bt.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if (e.getActionCommand().equals("1"))
					returnButton();
			}
		});

		this.setLayout(null);
		this.add(tital_jl);
		this.add(tip1_jl);
		this.add(tip2_jl);
		this.add(begin_bt);
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
				Order returndata = new Order();
				try {
					returndata = dc.GetOrder(order_id_jf.getText());
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				System.out.println(returndata);
				if (returndata == null) {
					JOptionPane.showConfirmDialog(null, "无此预订单!", "提示", JOptionPane.CLOSED_OPTION);
				} else {
					name_jf.setText(returndata.getName());
					id_jf.setText(returndata.getID_num());
					gender_jb.setSelectedItem(returndata.getGender());
					room_type_jb.setSelectedItem(returndata.getRoom_type());
					checkin_jf.setText(returndata.getCheckin());
					checkout_jf.setText(returndata.getCheckout());
					phone_jf.setText(returndata.getPhonenum());
				}
			}
		});

		begin_bt.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				DataBaseConnect dc = new DataBaseConnect();
				Order returndata = new Order();
				try {
					returndata = dc.GetOrder();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				System.out.println("#####returndata");

				if (returndata==null) {
					JOptionPane.showConfirmDialog(null, "暂无预订单!", "提示", JOptionPane.CLOSED_OPTION);
				} else {
					name_jf.setText(returndata.getName());
					id_jf.setText(returndata.getID_num());
					gender_jb.setSelectedItem(returndata.getGender());
					room_type_jb.setSelectedItem(returndata.getRoom_type());
					checkin_jf.setText(returndata.getCheckin());
					checkout_jf.setText(returndata.getCheckout());
					phone_jf.setText(returndata.getPhonenum());
					order_id_jf.setText(returndata.getOrder_id());
				}
			}
		});
		cancel_bt.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				name_jf.setText("");
				id_jf.setText("");
				checkin_jf.setText("");
				checkout_jf.setText("");
				phone_jf.setText("");
				charge_jf.setText("");
				despoit_jf.setText("");
				room_num_jf.setText("");
				room_num_jf.setText("");
				gender_jb.setSelectedIndex(0);
				room_type_jb.setSelectedIndex(0);
			}

		});
		checkin_bt.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				DataBaseConnect dc = new DataBaseConnect();
				String str = new String(
						"'" + room_num_jf.getText() + "','" + name_jf.getText() + "','" + id_jf.getText() + "','"
								+ gender_jb.getSelectedItem().toString() + "','" + checkin_jf.getText() + "','"
								+ checkout_jf.getText() + "','" + charge_jf.getText() + "','" + despoit_jf.getText()
								+ "','" + 0 + "','" + phone_jf.getText() + "','" + order_id_jf.getText() + "'");
				System.out.println(str);
				/**
				 * 检查房间状态
				 */
				Room room_check = new Room();
				try {
					room_check = dc.RoomOperation(Integer.parseInt(room_num_jf.getText()));
				} catch (Exception e2) {
					// TODO Auto-generated catch block
					e2.printStackTrace();
				}
				if (String.valueOf(room_check.getRoomstate()).equalsIgnoreCase("0")) {

					String room_sql = "update room_table set roomstate=" + 1 + " where roomnum="
							+ Integer.valueOf(room_num_jf.getText());
					String order_sql = "update Order_table set Order_state=" + 1 + " where Order_id = '" + order_id_jf.getText()+"'";
					try {
						dc.insertData("all_table", str);
						dc.updateData(room_sql);
						dc.updateData(order_sql);
					} catch (Exception e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					JOptionPane.showConfirmDialog(null, "登记成功!", "提示", JOptionPane.CLOSED_OPTION);
					order_id_jf.setText("");
					name_jf.setText("");
					id_jf.setText("");
					checkin_jf.setText("");
					checkout_jf.setText("");
					phone_jf.setText("");
					charge_jf.setText("");
					despoit_jf.setText("");
					room_num_jf.setText("");
					room_num_jf.setText("");
					gender_jb.setSelectedIndex(0);
					room_type_jb.setSelectedIndex(0);
				} else {
					JOptionPane.showConfirmDialog(null, "登记失败，房间已被占用!", "提示", JOptionPane.CLOSED_OPTION);
					charge_jf.setText("");
					despoit_jf.setText("");
					room_num_jf.setText("");
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
