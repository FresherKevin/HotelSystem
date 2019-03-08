	/**====================================================**
	 *     项目名             ：酒店管理系统   
	 *     模块名             ：入住登记窗口与预定登记窗口
	 *     文件名             ：CheckIn.java
	 *     相关文件         ：DataBaseConnct.java 
	 *     实现功能         ：入住登记或预定登记并写入数据库
	 *     函数说明         ：
	 *     [## public CheckIn(){}]：
	 *        功能：构造函数     组建入住登记窗口
	 *        
	 *     [## public void cancelButton(){}]
	 *        功能：取消按钮的事件监听处理
	 *        
	 *     [## returnButton{}]:
	 *        功能：返回按钮的事件监听处理
	 *        
	 *     [## public void checkinButton(final int flag){}]:
	 *        功能：确定登记按钮的事件监听处理
	 *      
	 **===================================================**/
package com.databasejdbc;
import com.HotelGui.MyHotelMainGui;
import com.common.*;

import java.util.*;
import java.awt.*;
import java.awt.Event.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.*;
public class CheckIn extends JFrame {

	JLabel name_jl,gender_jl,id_jl,room_num_jl,room_type_jl,checkin_jl,checkout_jl,tital_jl,tip_jl,price_jl,charge_jl,despoit_jl,tip_jl1,tip_jl2,phone_jl;
	JButton checkin_bt,cancel_bt,return_bt;
	public JComboBox<String> gender_jb;
	public JComboBox<String> room_type_jb;
	JTextField name_jf,id_jf;
	public JTextField room_num_jf;
	JTextField price_jf,phone_jf;
	JTextField despoit_jf;
	JTextField charge_jf;
	JTextField checkin_jf;
	JTextField checkout_jf;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CheckIn ck=new CheckIn("入住登记","images\\checkin_bt.jpg");
		ck.cancelButton();

	}
	/**====================================================**
	 *     **[## public CheckIn(){}]    构造函数
	 *       参数      ：String str1,String path  //界面Tital、按钮UI地址
	 *       返回值  ：无
	 *       修饰符  ：public
	 *       功能  ：构造函数，初始化入住登记界面
	 **===================================================**/
	public CheckIn(String str1,String path)

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
		
		
		room_num_jl=new JLabel("房 间 号");
		room_num_jl.setBounds(450, 220, 60, 30);
		room_num_jl.setFont(new Font("宋体",Font.HANGING_BASELINE,14));
		room_num_jf=new JTextField(10);
		room_num_jf.setBounds(530, 220, 140, 27);
		
		room_type_jl=new JLabel("房间标准");
		room_type_jl.setBounds(150, 270, 60, 30);
		room_type_jl.setFont(new Font("宋体",Font.HANGING_BASELINE,14));
		room_type_jb=new JComboBox<String>();
		room_type_jb.setBounds(230, 270, 140, 27);
		room_type_jb.addItem("商务单间");
		room_type_jb.addItem("商务标间");
		room_type_jb.addItem("大床房");
		room_type_jb.addItem("杂物间");
		
		price_jl=new JLabel("房间价格");
		price_jl.setBounds(450, 270, 60, 30);
		price_jl.setFont(new Font("宋体",Font.HANGING_BASELINE,14));
		price_jf=new JTextField(10);
		price_jf.setBounds(530, 270, 140, 27);
		
		charge_jl=new JLabel("实际收费");
		charge_jl.setBounds(150, 320, 60, 30);
		charge_jl.setFont(new Font("宋体",Font.HANGING_BASELINE,14));
		charge_jf=new JTextField(10);
		charge_jf.setBounds(230, 320, 140, 27);
		
		despoit_jl=new JLabel("预收押金");
		despoit_jl.setBounds(450, 320, 60, 30);
		despoit_jl.setFont(new Font("宋体",Font.HANGING_BASELINE,14));
		despoit_jf=new JTextField(10);
		despoit_jf.setBounds(530, 320, 140, 27);
		
		checkin_jl=new JLabel("入住日期");
		tip_jl1=new JLabel("(####-##-##)");
		tip_jl1.setBounds(145, 400, 80, 40);
		checkin_jl.setBounds(150, 370, 60, 40);
		checkin_jl.setFont(new Font("宋体",Font.HANGING_BASELINE,14));
		checkin_jf=new JTextField(10);
		checkin_jf.setBounds(230, 370, 140, 27);
		
		checkout_jl=new JLabel("离店日期");
		tip_jl2=new JLabel("(####-##-##)");
		tip_jl2.setBounds(445, 400, 80, 40);
		checkout_jl.setBounds(450, 370, 60, 30);
		checkout_jl.setFont(new Font("宋体",Font.HANGING_BASELINE,14));
		checkout_jf=new JTextField(10);
		checkout_jf.setBounds(530, 370, 140, 27);
		
		phone_jl = new JLabel("手机号码");
		phone_jl.setBounds(150, 425, 60, 30);
		phone_jl.setFont(new Font("宋体", Font.HANGING_BASELINE, 14));
		phone_jf = new JTextField(10);
		phone_jf.setBounds(230, 425, 140, 27);
		
		
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
		this.add(room_num_jl);
		this.add(room_type_jl);
		this.add(price_jl);
		this.add(charge_jl);
		this.add(despoit_jl);
		this.add(checkin_jl);
		this.add(phone_jl);
		this.add(tip_jl1);
		this.add(checkout_jl);
		this.add(tip_jl2);
		this.add(checkin_bt);
		this.add(cancel_bt);
		this.add(return_bt);
		this.add(id_jf);
		this.add(gender_jb);
		this.add(room_num_jf);
		this.add(room_type_jb);
		this.add(price_jf);
		this.add(charge_jf);
		this.add(phone_jf);
		this.add(despoit_jf);
		this.add(checkin_jf);
		this.add(checkout_jf);
		
		this.setTitle(str1);
		this.setIconImage(new ImageIcon("images\\入住登记.jpg").getImage());
		this.setBounds(250, 80, Toolkit.getDefaultToolkit().getScreenSize().width-600,Toolkit.getDefaultToolkit().getScreenSize().height-150);
		this.setResizable(false);
		this.setVisible(true);
}
	
	/**====================================================**
	 *     **[## public void cancelButton()  {}]    取消按钮操作
	 *       参数      ：无
	 *       返回值  ：无
	 *       修饰符  ：public
	 *       功能  ：点击取消按钮清空操作
	 **===================================================**/
    public void cancelButton() 
    {
	cancel_bt.addActionListener(new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			name_jf.setText("");
			id_jf.setText("");
			room_num_jf.setText("");
			charge_jf.setText("");
			price_jf.setText("");
			despoit_jf.setText("");
			checkin_jf.setText("");
			checkout_jf.setText("");
			gender_jb.setSelectedIndex(0);
			room_type_jb.setSelectedIndex(0);
		}
		
	});
	}
	/**====================================================**
	 *     **[## public void returnButton() {}]  返回按钮操作
	 *       参数      ：无
	 *       返回值  ：无
	 *       修饰符  ：public
	 *       功能  ：点击返回按钮返回到主界面，入住登记界面释放
	 **===================================================**/
    public void returnButton()
    {
    	this.dispose();
	}
	/**====================================================**
	 *     **[## public void checkinButton(int flag)  {}]    确定按钮操作
	 *       参数      ：int flag flag==1,则表示入住登记状态更改 ；flag==2，则表示预订登记状态更改
	 *       返回值  ：无
	 *       修饰符  ：public
	 *       功能  ：点击确定按钮进行入住登记输入数据库操作操作
	 **===================================================**/
    public void checkinButton(final int flag)
    {
    	checkin_bt.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub	
				
			    	DataBaseConnect dc=new DataBaseConnect();
			    	int isliving=0;
			    	/**
			    	 * flag=2 代表入住
			    	 */
			    	if (flag==2) {
						isliving=1;
					}
			    	/**
			    	 * flag=1 代表预定
			    	 */
			    	if (flag==1) {
						isliving=0;
					}
			    	Calendar date = Calendar.getInstance();
			    	String order_id=String.valueOf(date.get(Calendar.YEAR))+String.valueOf(date.get(Calendar.MONTH)+1)+
							String.valueOf(date.get(Calendar.DAY_OF_MONTH))+String.valueOf(date.get(Calendar.HOUR_OF_DAY))
							+String.valueOf(date.get(Calendar.MINUTE))+String.valueOf(date.get(Calendar.SECOND));
			    	
			    	String str=new String("'"+Integer.valueOf(room_num_jf.getText())+"','"+name_jf.getText()+"','"+id_jf.getText()+"','"+gender_jb.getSelectedItem().toString()+"','"+
			    			checkin_jf.getText()+"','"+checkout_jf.getText()+"','"+Integer.valueOf(charge_jf.getText())+"','"+Integer.valueOf(despoit_jf.getText())
			    			+"','"+isliving+"','"+phone_jf.getText()+"','"+order_id+"'");
			    	System.out.println(str);
			    	try {
						dc.insertData("all_table", str);
					} catch (Exception e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
			    	String sql="update room_table set roomstate="+flag+" where roomnum="+Integer.valueOf(room_num_jf.getText());
			    	try {
						dc.updateData(sql);
					} catch (Exception e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
			    	JOptionPane.showConfirmDialog(null, "登记成功!","提示",JOptionPane.CLOSED_OPTION);
			}
		});

    
    }
}
