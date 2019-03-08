/*
 * 显示某一房间住客信息
 */
package com.databasejdbc;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

import com.common.DataBaseConnect;

public class CheckMsg extends CheckOut{
	public CheckMsg(String str1, String path) {
		super(str1, path);
		this.cancel_bt.setVisible(false);
		this.checkout_bt.setVisible(false);
		this.tip_jl.setVisible(false);
		this.check_bt.setVisible(false);
		this.jl.setVisible(false);
		this.jtf.setVisible(false);
		this.checkin_bt.setIcon(new ImageIcon("images\\checkin_bt.jpg"));
		this.checkin_bt.setVisible(true);
		// TODO Auto-generated constructor stub
		checkin_bt.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				DataBaseConnect dc = new DataBaseConnect();
				String room_sql="update room_table set roomstate="+2+" where roomnum="+Integer.valueOf(room_num_jf.getText());
				String all_sql="update all_table set isliving="+1+" where id="+Integer.valueOf(id_jf.getText());
				try {
					dc.updateData(room_sql);
					dc.updateData(all_sql);
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}	
				JOptionPane.showConfirmDialog(null, "登记成功!","提示",JOptionPane.CLOSED_OPTION);
			}
		});
	}

}
