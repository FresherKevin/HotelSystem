	/**====================================================**
	 *     项目名             ：酒店管理系统 
	 *     模块名             ：系统登录成功后的主窗口
	 *     文件名             ：HotelMainGui.java
	 *     相关文件         ：HotelLoginGui.java DataBaseConnect.java
	 *     实现功能         ：系统登录成功后主界面
	 *     函数说明         ：
	 *     [## public MyHotelMainGui(int i){}]：
	 *        功能：构造函数     
	 *     [## public MyHotelMainGui(){}]：
	 *        功能：构造函数     组建登陆窗口
	 *     [## private boolean loginCheck() {}]:
	 *        功能：登录验证，仅类内使用
	 *     [## private void quit() {}]:
	 *        功能：关闭系统函数，仅类内使用
	 *     [## public void run(){}]
	 *        功能：线程执行刷新界面
	 *     [## public void setLabelText(JLabel jl,int row)]
	 *        功能：为JLabel设置text
	 **===================================================**/
package com.HotelGui;
import java.awt.*; 

import com.common.DataBaseConnect;
import com.databasejdbc.*;
import com.entity.Room;

import javax.swing.*;

import java.text.SimpleDateFormat;
import java.util.*;
import java.awt.event.*;
public class MyHotelMainGui extends JFrame implements ActionListener,Runnable
{
	
	
	public static void main(String[] args) {
		MyHotelMainGui name = new MyHotelMainGui();
	}
	
	public MyHotelMainGui(int i)
	{	
	} 
	private static final FocusListener FocusListener = null;
    String roomnum,roomtype;
	JPopupMenu popupMenu;
	JMenuBar jmb;
	JPanel jp1,jp2,room_jp1;
	JLabel time_jl,order_jl,login_jl,change_jl,checkout_jl,relogin_jl,money_jl,exit_jl,emploer_jl;
	JMenu jm1,jm2,jm3,jm4,jm5,jm6,jm7,jm8,bt_jm;
	JButton time_bt,order_bt,login_bt,change_bt,checkout_bt,relogin_bt,money_bt,exit_bt,emploer_bt,oneF_bt,twoF_bt,threeF_bt,fourF_bt;
	Vector<JButton> roomjb=new Vector<JButton>();
	Vector<JPopupMenu> popupVector=new Vector<JPopupMenu>();
	JLabel statelabel,state,staticsstate;
	JButton jj;
	JLabel allroom_jl,empty_jl,ordered_jl,isliv_jl,else_jl,allroom_jl1,empty_jl1,ordered_jl1,isliv_jl1,else_jl1;
	String id_now,user_type;
	/**=======================================================**
	 *               获取当前成功登录的ID
	 **========================================================*/
    public String getId_now() {
		return id_now;
	}
	/**=======================================================**
	 *               获取当前成功登录的用户类型
	 **========================================================*/
	public String getUser_type() {
		return user_type;
	}
	/**=======================================================**
	 *               设置当前成功登录的ID
	 **========================================================*/
	public void setId_now(String id_now) {
		this.id_now = id_now;
	}
	/**=======================================================**
	 *               设置当前成功登录的用户类型
	 **========================================================*/
	public void setUser_type(String user_type) {
		this.user_type = user_type;
	}
	/**====================================================**
	 *     **[## public MyHotelMainGui() {}]    构造函数
	 *       参数      ：无
	 *       返回值  ：无
	 *       修饰符  ：public
	 *       功能  ：构造函数，初始化主界面
	 **===================================================**/
	public MyHotelMainGui()
	{
		//为每个房间设置点击事件
		for( int i=0;i<32;i++)
		{
			 final String str;
			 if(i<9)
		     {
		        str="40"+(i+1);
		     }
		     else
		     {
		    	  str="4"+(i+1);
		     }
			 popupMenu =  new  JPopupMenu ();
			 popupVector.add(popupMenu);
			 JMenuItem orderMenuItem =  new  JMenuItem ("新预定") ;
			 orderMenuItem.setFont(new Font("宋体",Font.ITALIC,14));
			 popupVector.get(i).add ( orderMenuItem ) ;
		     //添加事件
		     orderMenuItem.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					CheckIn ck=new CheckIn("预订登记","images\\checkin_bt.jpg");
					ck.room_num_jf.setText(str);
					ck.cancelButton();
					//登記入住
					ck.checkinButton(1);
					updateRoomState();
				}
			});
	     JMenuItem checkinMenuItem =  new  JMenuItem ("入住登记") ;
	     checkinMenuItem.setFont(new Font("宋体",Font.ITALIC,14));
	     popupVector.get(i).add ( checkinMenuItem ) ;
	     checkinMenuItem.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				CheckIn ck=new CheckIn("入住登记","images\\checkin_bt.jpg");
				ck.room_num_jf.setText(str);
				ck.cancelButton();
				//登記入住
				ck.checkinButton(2);
				updateRoomState();
			}
		});
		
	
	     // Separator
	     popupMenu.addSeparator () ;
	     JMenuItem changeMenuItem =  new  JMenuItem ("客人换房") ;
	     changeMenuItem.setFont(new Font("宋体",Font.ITALIC,14));
	     popupVector.get(i).add ( changeMenuItem ) ;
	     changeMenuItem.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				ChangeRoom cr=new ChangeRoom("客人换房","images\\change_bt.jpg");
				cr.check_bt.setVisible(false);
				cr.jtf.setText(str);
				try {
					cr.check_Bt("房间未入住！");
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				
			}
		});
	     JMenuItem msgMenuItem =  new  JMenuItem ("客人信息") ;
	     msgMenuItem.setFont(new Font("宋体",Font.ITALIC,14));
	     popupVector.get(i).add ( msgMenuItem ) ;
	     msgMenuItem.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				CheckMsg cm=new CheckMsg("客人信息","images\\");
				cm.check_bt.setVisible(false);
			    cm.jtf.setText(str);	
				try {
					cm.check_Bt("房间未入住！");
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
	     JMenuItem reckMenuItem =  new  JMenuItem ("客人续住") ;
	     reckMenuItem.setFont(new Font("宋体",Font.ITALIC,14));
	     popupVector.get(i).add ( reckMenuItem ) ;
	     popupMenu.addSeparator () ;
	     JMenuItem checkoutMenuItem =  new  JMenuItem ("客人退房") ;
	     checkoutMenuItem.setFont(new Font("宋体",Font.ITALIC,14));
	     popupVector.get(i).add ( checkoutMenuItem ) ;
	     checkoutMenuItem.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				CheckOut co=new CheckOut("客人退房","images\\checkout_bt.jpg");
				co.check_bt.setVisible(false);
			     co.jtf.setText(str);	
					try {
						co.check_Bt("房间未入住！");
					} catch (Exception e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
			}
		});
		}
		oneF_bt=new JButton(new ImageIcon("images\\1F.jpg"));
		oneF_bt.setBounds(20, 170, 60,50);
		twoF_bt=new JButton(new ImageIcon("images\\2F.jpg"));
		twoF_bt.setBounds(20, 250, 60,50);
		threeF_bt=new JButton(new ImageIcon("images\\3F.jpg"));
		threeF_bt.setBounds(20, 330, 60,50);
		fourF_bt=new JButton(new ImageIcon("images\\4F.jpg"));
		fourF_bt.setBounds(20, 410, 60,50);
		for(int i=0;i<32;i++)
		{
			JButton jb=new JButton();
			roomjb.add(jb);
			if(i<8)
			    roomjb.get(i).setBounds(90*i, 0, 90, 90);
			else if(i<16)
				roomjb.get(i).setBounds(90*(i-8), 90, 90, 90);
			else if(i<24)
				roomjb.get(i).setBounds(90*(i-16), 180, 90, 90);
			else
				roomjb.get(i).setBounds(90*(i-24), 270, 90, 90);
			roomjb.get(i).setContentAreaFilled(false);
			roomjb.get(i).setComponentPopupMenu (popupVector.get(i));
		}
		//放置房间的JPanel
		room_jp1=new JPanel();
		room_jp1.setLayout(null);
		room_jp1.setBounds(120, 150, 730, 367);

		allroom_jl=new JLabel(new ImageIcon("images\\all.jpg"));
		allroom_jl1=new JLabel();
		allroom_jl.setBounds(950, 150, 75, 30);
		allroom_jl1.setBounds(1110, 150, 75, 30);
		empty_jl=new JLabel(new ImageIcon("images\\empty.jpg"));
		empty_jl1=new JLabel();
		empty_jl.setBounds(950, 200, 75, 30);
		empty_jl1.setBounds(1110, 200, 75, 30);
		ordered_jl=new JLabel(new ImageIcon("images\\order.jpg"));
		ordered_jl1=new JLabel();
		ordered_jl.setBounds(950, 250, 75, 30);
		ordered_jl1.setBounds(1110, 250, 75, 30);
		isliv_jl=new JLabel(new ImageIcon("images\\isliv.jpg"));
		isliv_jl1=new JLabel();
		isliv_jl.setBounds(950, 300, 75, 30);
		isliv_jl1.setBounds(1110, 300, 75, 30);
		else_jl=new JLabel(new ImageIcon("images\\else.jpg"));
		else_jl1=new JLabel();
		else_jl1.setBounds(1110, 350, 75, 30);
		else_jl.setBounds(950, 350, 75, 30);
		state=new JLabel("实时房态统计");
		state.setFont(new Font("宋体",Font.PLAIN,14));
		state.setBounds(1000, 90, 100, 40);
		staticsstate=new JLabel();
		staticsstate.setFont(new Font("宋体",Font.PLAIN,25));
		staticsstate.setBounds(970, 420, 250, 60);
		staticsstate.setForeground(Color.red);
			/**
		 * 底部登录状态显示
		 */
		jp2=new JPanel();
		jp2.setBounds(10, 570, 950, 50);
		
		statelabel=new JLabel();
		statelabel.setFont(new Font("宋体",Font.CENTER_BASELINE,12));
		jp2.add(statelabel);
		
		time_jl=new JLabel("实时房态");
		time_jl.setFont(new Font("宋体",Font.LAYOUT_NO_LIMIT_CONTEXT,10));
		time_jl.setBounds(10, 53, 40, 10);
		time_bt=new JButton(new ImageIcon("images\\实时房态.jpg"));
		time_bt.setBounds(10, 10, 40, 40);
		time_bt.setBorderPainted(false);

		order_bt=new JButton(new ImageIcon("images\\预定登记.jpg"));
		order_bt.setBounds(65, 10, 40, 40);
		order_bt.setBorderPainted(false);

		order_jl=new JLabel("预定管理");
		order_jl.setFont(new Font("宋体",Font.LAYOUT_NO_LIMIT_CONTEXT,10));
		order_jl.setBounds(65, 53, 40, 10);
		
		login_bt=new JButton(new ImageIcon("images\\入住登记.jpg"));
		login_bt.setBounds(120, 10, 40, 40);
		login_bt.setBorderPainted(false);

		login_jl=new JLabel("入住查询");
		login_jl.setFont(new Font("宋体",Font.LAYOUT_NO_LIMIT_CONTEXT,10));
		login_jl.setBounds(120, 53, 40, 10);
		
		change_bt=new JButton(new ImageIcon("images\\客人换房.jpg"));
		change_bt.setBounds(175, 10, 40, 40);
		change_bt.setBorderPainted(false);

		change_jl=new JLabel("客人换房");
		change_jl.setFont(new Font("宋体",Font.LAYOUT_NO_LIMIT_CONTEXT,10));
		change_jl.setBounds(175, 53, 40, 10);
		
		relogin_bt=new JButton(new ImageIcon("images\\客房续住.jpg"));
		relogin_bt.setBounds(230, 10, 40, 40);
		relogin_bt.setBorderPainted(false);

		relogin_jl=new JLabel("客人续住");
		relogin_jl.setFont(new Font("宋体",Font.LAYOUT_NO_LIMIT_CONTEXT,10));
		relogin_jl.setBounds(230, 53, 40, 10);
		
		checkout_jl=new JLabel("客人退房");
		checkout_jl.setFont(new Font("宋体",Font.LAYOUT_NO_LIMIT_CONTEXT,10));
		checkout_jl.setBounds(285, 53, 40, 10);
		checkout_bt=new JButton(new ImageIcon("images\\客人退房.jpg"));
		checkout_bt.setBounds(285, 10, 40, 40);
		checkout_bt.setBorderPainted(false);
	

		money_bt=new JButton(new ImageIcon("images\\收银报表.jpg"));
		money_bt.setBounds(340, 10, 40, 40);
		money_bt.setBorderPainted(false);

		money_jl=new JLabel("财务报表");
		money_jl.setFont(new Font("宋体",Font.LAYOUT_NO_LIMIT_CONTEXT,10));
		money_jl.setBounds(340, 53, 40, 10);
		
		exit_bt=new JButton(new ImageIcon("images\\退出系统.png"));
		exit_bt.setBounds(450, 10, 40, 40);
		exit_bt.setBorderPainted(false);

		exit_jl=new JLabel("退出系统");
		exit_jl.setFont(new Font("宋体",Font.LAYOUT_NO_LIMIT_CONTEXT,10));
		exit_jl.setBounds(450, 53, 40, 10);
		
		emploer_bt=new JButton(new ImageIcon("images\\员工管理.jpg"));
		emploer_bt.setBounds(395, 10, 40, 40);
		emploer_bt.setBorderPainted(false);

		emploer_jl=new JLabel("员工管理");
		emploer_jl.setFont(new Font("宋体",Font.LAYOUT_NO_LIMIT_CONTEXT,10));
		emploer_jl.setBounds(395, 53, 40, 10);
		
		jm1=new JMenu("预订接待(A)");
		jm1.setFont(new Font("宋体",Font.LAYOUT_NO_LIMIT_CONTEXT,12));
		jm2=new JMenu("前台营业(B)");
		jm2.setFont(new Font("宋体",Font.LAYOUT_NO_LIMIT_CONTEXT,12));
		jm3=new JMenu("客户管理(C)");
		jm3.setFont(new Font("宋体",Font.LAYOUT_NO_LIMIT_CONTEXT,12));
		jm4=new JMenu("员工管理(D)");
		jm4.setFont(new Font("宋体",Font.LAYOUT_NO_LIMIT_CONTEXT,12));
		jm5=new JMenu("财务报表(E)");
		jm5.setFont(new Font("宋体",Font.LAYOUT_NO_LIMIT_CONTEXT,12));
		jm6=new JMenu("综合查询(Z)");
		jm6.setFont(new Font("宋体",Font.LAYOUT_NO_LIMIT_CONTEXT,12));
		jm7=new JMenu("窗口(P)");
		jm7.setFont(new Font("宋体",Font.LAYOUT_NO_LIMIT_CONTEXT,12));
		jm8=new JMenu("帮助(H)");
		jm8.setFont(new Font("宋体",Font.LAYOUT_NO_LIMIT_CONTEXT,12));
		
		jmb=new JMenuBar();
		jmb.add(jm1);
		jmb.add(jm2);
		jmb.add(jm3);
		jmb.add(jm4);
		jmb.add(jm5);
		jmb.add(jm6);
		jmb.add(jm7);
		jmb.add(jm8);
		
		for(int i=0;i<32;i++)
		{
			room_jp1.add(roomjb.get(i));
		}
     	
		this.add(oneF_bt);
		this.add(twoF_bt);
		this.add(threeF_bt);
		this.add(fourF_bt);
		
		this.add(time_bt);
		this.add(order_bt);
		this.add(login_bt);
		this.add(change_bt);
		this.add(relogin_bt);
		this.add(change_bt);
		this.add(checkout_bt);
		this.add(money_bt);
		this.add(exit_bt);
		this.add(emploer_bt);
		this.add(time_jl);
		this.add(order_jl);
		this.add(login_jl);
		this.add(change_jl);
		this.add(relogin_jl);
		this.add(change_jl);
		this.add(checkout_jl);
		this.add(money_jl);
		this.add(exit_jl);
		this.add(emploer_jl);
		this.add(jp2);
		this.add(state);
		this.add(allroom_jl);
		this.add(empty_jl);
		this.add(isliv_jl);
		this.add(ordered_jl);
		this.add(else_jl);
		this.add(allroom_jl1);
		this.add(empty_jl1);
		this.add(isliv_jl1);
		this.add(ordered_jl1);
		this.add(else_jl1);
		this.add(staticsstate);
		this.setResizable(false);
		this.setIconImage(new ImageIcon("images\\icon.jpg").getImage());
		this.setTitle("七天快捷连锁酒店管理系统"+"——"+"["+"实时房态"+"]");
		this.setFont(new Font("宋体",Font.LAYOUT_NO_LIMIT_CONTEXT,12));
		this.setJMenuBar(jmb);
		this.setLocation(50, 50);
		this.setLayout(null);
		this.add(room_jp1);
		this.setSize(Toolkit.getDefaultToolkit().getScreenSize().width-100,Toolkit.getDefaultToolkit().getScreenSize().height-100);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
	/**====================================================**
	 *     **[## public void enevtOpration {}]    主窗体上的事件监听
	 *       参数      ：无
	 *       返回值  ：无
	 *       修饰符  ：public
	 *       功能  ：监听用户在主窗体中的操作
	 **===================================================**/
	public void enevtOpration()
	{
		order_bt.addMouseListener(new MouseListener() {

			
			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				Ordermanager OR = new Ordermanager("处理预定单", "images\\checkin_bt.jpg");
			}

			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				order_bt.setBorderPainted(true);
			}

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				order_bt.setBorderPainted(false);
			}
		});
		login_bt.addMouseListener(new MouseListener() {

			
			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				Check_byOrder cbo = new Check_byOrder("入住查询", "images\\checkin_bt.jpg");
				updateRoomState();
			}

			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				login_bt.setBorderPainted(true);
			}

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				login_bt.setBorderPainted(false);
			}
		});
		change_bt.addMouseListener(new MouseListener() {

			
			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				ChangeRoom cr=new ChangeRoom("客人换房", "images\\change_bt.jpg");
				updateRoomState();
				repaint();		
			}

			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				change_bt.setBorderPainted(true);
			}

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				change_bt.setBorderPainted(false);
			}
		});
		relogin_bt.addMouseListener(new MouseListener() {

			
			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				relogin_bt.setBorderPainted(true);
			}

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				relogin_bt.setBorderPainted(false);
			}
		});
		checkout_bt.addMouseListener(new MouseListener() {
			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				CheckOut co=new CheckOut("客人退房","images\\checkout_bt.jpg");
			}

			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				checkout_bt.setBorderPainted(true);
			}

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				checkout_bt.setBorderPainted(false);
			}
		});
		money_bt.addMouseListener(new MouseListener() {

			
			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				money_bt.setBorderPainted(true);
			}

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				money_bt.setBorderPainted(false);
			}
		});
		emploer_bt.addMouseListener(new MouseListener() {

			
			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				emploer_bt.setBorderPainted(true);
			}

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				emploer_bt.setBorderPainted(false);
			}
		});
		exit_bt.addMouseListener(new MouseListener() {

			
			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				quit();
			}

			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				exit_bt.setBorderPainted(true);
			}

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				exit_bt.setBorderPainted(false);
			}
		});
		time_bt.addMouseListener(new MouseListener() {

			
			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				updateRoomState();
			}

			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				time_bt.setBorderPainted(true);
			}

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				time_bt.setBorderPainted(false);
			}
		});
		
	}
	/**====================================================**
	 *     **[## public void run() {}]    线程执行，随着系统改变当前时间
	 *       参数      ：无
	 *       返回值  ：无
	 *       修饰符  ：public
	 *       功能  ：使用线程使当前界面时间随着系统改变当
	 **===================================================**/
	public void run() {
		// TODO Auto-generated method stub
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		while(true)
		{
		statelabel.setText("当前时间为："+df.format(new Date())+"         "+"当前登录的用户为："+id_now+"         "+"用户类型为："+user_type);
		statelabel.repaint();
		this.repaint();

		}
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
/**====================================================**
 *     **[## public void setLabelText(JLabel jl,int row) {}]  为JLabel设置text
 *       返回值  ：无
 *       修饰符  ：public
 *       功能  ：为JLabel设置text
 **===================================================**/
public void setLabelText(JLabel jl,int row)
{

	jl.setText(Integer.toString(row)+"   "+"间");
}
/**====================================================**
 *     **[## public void updateRoomState{}]  更新入住状态
 *       返回值  ：无
 *       修饰符  ：public
 *       功能  ：更新入住统计情况
 **===================================================
 * @throws Exception **/
public void updateRoomState() 
{
	DataBaseConnect ns=new DataBaseConnect();
	Vector<Room> returndata = null;
	
	/**
	 * 从room中读取数据  
	 */
	int all_num=0,empty_num=0,order_num=0,islive_num=0,else_num=0;
	try {
		all_num = ns.getRow("select * from room_table");
		empty_num = ns.getRow("select * from room_table where roomstate=0");
		order_num = ns.getRow("select * from room_table where roomstate=1");
		islive_num =  ns.getRow("select * from room_table where roomstate=2");
		else_num = ns.getRow("select * from room_table  where roomstate=3");
	} catch (Exception e1) {
		// TODO Auto-generated catch block
		e1.printStackTrace();
	}
	setLabelText(allroom_jl1, all_num);
	setLabelText(empty_jl1, empty_num);
	setLabelText(ordered_jl1, order_num);
	setLabelText(isliv_jl1,islive_num);
	setLabelText(else_jl1,else_num );
	
	try {
		staticsstate.setText("入 住 率 :"+ " "+(int)(islive_num*100/all_num)+"%");
		returndata=ns.RoomOperation();
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	for(int i=0;i<returndata.size();i++)
	{
		try{
		roomjb.get(i).setText("<html>" +returndata.get(i).getRoomnum()+"<br>"+returndata.get(i).getRoomtype()+"</html>");
		
		}catch(Exception e){}
		
		try{
		if(returndata.get(i).getRoomstate()==0)
			roomjb.get(i).setForeground(Color.BLUE);
		else if(returndata.get(i).getRoomstate()==1)
			roomjb.get(i).setForeground(Color.pink);
		else
			roomjb.get(i).setForeground(Color.red);
			}catch(Exception e){}
		repaint();
		
	}
	
	}

}
