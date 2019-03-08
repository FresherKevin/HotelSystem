/*
 * 换房操作
 */
package com.databasejdbc;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import com.HotelGui.MyHotelMainGui;
import com.common.DataBaseConnect;

public class ChangeRoom extends CheckOut {
	/*
	public static void main(String[] args) {
		ChangeRoom name = new ChangeRoom("客人退房","images\\checkout_bt.jpg");
	}
*/
	JLabel jj;
	JTextField jjtf;
	public ChangeRoom(String str1, String path) {
		super(str1, path);
		jl.setText("原房间号");
		jl.setBounds(200,120, 80, 28);
		jtf.setBounds(280, 120, 60, 28);
		check_bt.setBounds(550, 120, 100, 28);
		check_bt.setContentAreaFilled(false);

		jj=new JLabel("换 至");
		jjtf=new JTextField(10);
		jjtf.setBounds(460, 120, 60, 28);
		jj.setFont(new Font("宋体",Font.HANGING_BASELINE,14));
		jj.setBounds(400,120, 100, 28);
		checkout_bt.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
				int flag=JOptionPane.showConfirmDialog(null, "已换房！","提示",JOptionPane.PLAIN_MESSAGE);
				if(flag==JOptionPane.YES_OPTION)
				{
					change_Bt();
				}
				return;
			}
		});
		this.add(jj);
		this.add(jjtf);
		
		// TODO Auto-generated constructor stub
	}

	/*===========================JOptionPane.YES_OPTION========================**
	 * [## public void checkout_Bt(){}]     退房按钮操作
	 *      参  数            ：无
	 *      返回值          ：无
	 *      修饰符          ：public
	 *      功能              ：点击退房，更新数据库中该房间的状态从2为0
	 *===================================================*/
	public void change_Bt()
	{
		DataBaseConnect dc=new DataBaseConnect();
		try {
			dc.updateData("update room_table set roomstate=0 where roomnum="+Integer.valueOf(jtf.getText()));
			dc.updateData("update room_table set roomstate=2 where roomnum="+Integer.valueOf(jjtf.getText()));
			dc.updateData("update all_table set roomnum="+Integer.valueOf(jjtf.getText())+" where id="+id_jf.getText());
			} catch (Exception e1) {
				e1.printStackTrace();
				}
		MyHotelMainGui hm=new MyHotelMainGui(1);
		hm.updateRoomState();
	}

}
