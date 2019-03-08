	/**====================================================**
	 *     项目名             ：酒店管理系统 
	 *     模块名             ：数据库连接
	 *     文件名             ：DataBaseConnct.java
	 *     相关文件         ：
	 *     实现功能         ：jdbc连接数据库
	 *     函数说明         ：
	 *     [## public Vector getId(){}]：
	 *        功能：获取数据库中系统登录ID
	 *        
	 *     [## public void setId() {}]:
	 *        功能：设置数据库中系统登录ID
	 *        
	 *     [## public Vector getPassword(){}]:
	 *        功能：获取数据库中系统登录密码
	 *        
	 *     [## public void setPassword(){}]:
	 *        功能：设置数据库中系统登录密码
	 *        
	 *     [## public Vector getRoonnum(){}]：
	 *        功能：获取数据库中房间号
	 *        
	 *     [## public void setRoonnum() {}]:
	 *        功能：设置数据库中房间号
	 *        
	 *     [## public Vector getRoomtype(){}]:
	 *        功能：获取数据库中房间类型
	 *        
	 *     [## public void seRoomtype(){}]:
	 *        功能：设置数据库中房间类型
	 *        
	 *     [## public void Sql(String sql){}]:
	 *        功能：执行sql语句进行查询
	 *     
	 **===================================================**/
package com.common;
import java.sql.*;  
import java.util.Vector;

import javax.swing.JOptionPane;
import javax.xml.crypto.dsig.keyinfo.RetrievalMethod;

import com.entity.Order;
import com.entity.Record;
import com.entity.Room;
import com.sun.org.apache.regexp.internal.recompile;
public class DataBaseConnect {
	 private String driverName="com.microsoft.sqlserver.jdbc.SQLServerDriver";
	 private String dbURL="jdbc:sqlserver://localhost:1433;DatabaseName=hotel_mangerment_system";
	 private  String userName="sa";
	 private String userPwd="19980910";
	 private  Connection ct=null;
	 private ResultSet rs=null;
	 private Statement st;
	 private Vector id =new Vector();
	 private Vector  password =new Vector();

	/**====================================================**
	 *          获取数据库中系统登录ID
    **===================================================**/
	public Vector getId() {
		return id;
	}
	/**====================================================**
	 *          设置数据库中系统登录ID
    **===================================================**/
	public void setId(Vector id) {
		this.id = id;
	}
	/**====================================================**
	 *          获取数据库中系统登录密码
    **===================================================**/
	public Vector getPassword() {
		return password;
	}
	/**====================================================**
	 *          设置数据库中系统登录ID
    **===================================================**/
	public void setPassword(Vector password) {
		this.password = password;
	}

	
	/**====================================================**
	 *     [## public void Sql(String sql) {}]   
	 *       参数      ：String sql
	 *       返回值  ：无
	 *       修饰符  ：public
	 *       功能  ：创建sql查询，从数据库里查询登陆账号与密码
	 **===================================================**/
	public void Sql(String sql) throws Exception
	{
	 Class.forName(driverName);
	 ct=DriverManager.getConnection(dbURL,userName,userPwd);
	  st=ct.createStatement();
	  rs=st.executeQuery(sql);
	  while(rs.next())
		{
		  id.add(rs.getInt(1));
		  password.add(rs.getInt(2));
		}
	  if(rs!=null)
		  rs.close();
	  if(st!=null)
		  st.close();
	  if(ct!=null)
		  ct.close();
		}
	/**====================================================**
	 *     [## public Vector RoomOperation(int room_num) {}]  查询房间信息 
	 *       参数      ：int room_num
	 *       返回值  ：无
	 *       修饰符  ：public
	 *       功能  ：创建sql查询房间号与类型，类外可使用
	 **===================================================**/
	public Room RoomOperation(int room_num)throws Exception
	{
		Room room=new Room();
		Class.forName(driverName);
		ct=DriverManager.getConnection(dbURL,userName,userPwd);
		st=ct.createStatement();
		rs=st.executeQuery("select * from room_table where roomnum= "+room_num);
		if(rs.isAfterLast()==rs.isBeforeFirst()){
	        room=null;
		} else {
			while(rs.next())
			{
				  room.setRoomnum(rs.getInt(1));
				  room.setRoomtype(rs.getString(2));
				  room.setRoomstate(rs.getInt(3));
				  room.setRoomprice(rs.getInt(4));
			}
		}

		  if(rs!=null)
			  rs.close();
		  if(st!=null)
			  st.close();
		  if(ct!=null)
			  ct.close();
		  return room;
	}
 	/**====================================================**
	 *     [## public void RoomOperation(String sql) {}]  查询房间使用状态
	 *       参数      ：String sql
	 *       返回值  ：房间个数
	 *       修饰符  ：public
	 *       功能  ：创建sql查询满足条件房间使用状态，类外可使用
	 **===================================================**/
	public int getRow(String sql)throws Exception
	{
		 Class.forName(driverName);
		  ct=DriverManager.getConnection(dbURL,userName,userPwd);
		  int rowcount=0;
		  st=ct.createStatement();
		  rs=st.executeQuery(sql);
		  while(rs.next())
		  {
			  rowcount++;
		  }
		  if(rs!=null)
			  rs.close();
		  if(st!=null)
			  st.close();
		  if(ct!=null)
			  ct.close();
		  return rowcount;
	}
	
	/**====================================================**
	 *     [## public  void insertData(){}] 插入记录
	 *       参数      ：String table_name,String str
	 *       返回值  ：无
	 *       修饰符  ：public
	 *       功能  ：向数据库中插入记录
	 **===================================================
	 * @throws Exception **/
	public void insertData(String table_name,String str) throws Exception
	{
		Class.forName(driverName);
		ct=DriverManager.getConnection(dbURL,userName,userPwd);
		ct.setAutoCommit(false);
		st=ct.createStatement();
	    String sql="insert into"+" "+table_name+" "+"values"+"("+str+")";
		st.executeUpdate(sql);
		ct.commit();
		if(st!=null)
		  st.close();
		if(ct!=null)
		  ct.close();
			
		}	
	/**====================================================**
	 *     [## public void updateData(String str){}] 更新记录
	 *       参数      ：String sql
	 *       返回值  ：无
	 *       修饰符  ：public
	 *       功能  ：向数据库中更新记录
	 **===================================================*/
	public void updateData(String sql) throws Exception
	{
		Class.forName(driverName);
		ct=DriverManager.getConnection(dbURL,userName,userPwd);
		ct.setAutoCommit(false);
		st=ct.createStatement();
		st.executeUpdate(sql);
		ct.commit();
		if(st!=null)
		  st.close();
		if(ct!=null)
		  ct.close();
	}
	/**====================================================**
	 *     [## public void getDataFromAll(){}] 从All__table中获取数据
	 *       参数      ：int room_num
	 *       返回值  ：Vector<object> data
	 *       修饰符  ：public
	 *       功能  ：根据房间号从All_table中获取数据并返回
	 **===================================================*/
    public Record getDataFromAll(int room_num) throws Exception
    {
    	Record data=new Record();
		Class.forName(driverName);
		ct=DriverManager.getConnection(dbURL,userName,userPwd);
		ct.setAutoCommit(false);
		st=ct.createStatement();
		rs=st.executeQuery("select * from all_table where roomnum="+room_num);
		if(rs.isAfterLast()==rs.isBeforeFirst()){
			data=null;
		}
		else{
			while(rs.next())
			{
				data.setRoomnum(rs.getInt(1));
				data.setName(rs.getString(2));
				data.setId(rs.getString(3));
				data.setSexy(rs.getString(4));
				data.setCheckin(rs.getString(5));
				data.setCheckout(rs.getString(6));
				data.setCharge(rs.getInt(7));
				data.setDespoit(rs.getInt(8));
				data.setIsliving(rs.getInt(9));
				data.setPhone_num(rs.getString(10));
				data.setOrder_id(rs.getString(11));
			}
		}

		if(rs!=null)
			rs.close();
		if(st!=null)
			st.close();
		if(ct!=null)
			ct.close();
	    return data;
		}
    public Record getDataFromAll(String Order_id) throws Exception
    {
    	Record data=new Record();
		Class.forName(driverName);
		ct=DriverManager.getConnection(dbURL,userName,userPwd);
		ct.setAutoCommit(false);
		st=ct.createStatement();
		rs=st.executeQuery("select * from all_table where order_id= '"+Order_id+"'");
		if (rs.isAfterLast()==rs.isBeforeFirst()){
	       data=null;
		} else {
			while(rs.next())
			{
				data.setRoomnum(rs.getInt(1));
				data.setName(rs.getString(2));
				data.setId(rs.getString(3));
				data.setSexy(rs.getString(4));
				data.setCheckin(rs.getString(5));
				data.setCheckout(rs.getString(6));
				data.setCharge(rs.getInt(7));
				data.setDespoit(rs.getInt(8));
				data.setIsliving(rs.getInt(9));
				data.setPhone_num(rs.getString(10));
				data.setOrder_id(rs.getString(11));
			}
		}

		if(rs!=null)
			rs.close();
		if(st!=null)
			st.close();
		if(ct!=null)
			ct.close();
	    return data;
		}
	/**====================================================**
	 *     [## public Vector RoomOperation(int room_num) {}]  查询房间信息 
	 *       参数      ：无
	 *       返回值  ：return returedata;
	 *       修饰符  ：public
	 *       功能  ：创建sql查询房间号与类型,与入住状态并返回，类外可使用
	 **===================================================**/
	public Vector<Room> RoomOperation()throws Exception
	{
		 Vector<Room> returedata=new Vector<Room>();
		 Class.forName(driverName);
		 ct=DriverManager.getConnection(dbURL,userName,userPwd);
		  st=ct.createStatement();
		  rs=st.executeQuery("select roomnum,roomtype,roomstate from room_table");
		  while(rs.next())
			{
			  Room room = new Room();
			  room.setRoomnum(rs.getInt(1));
			  room.setRoomtype(rs.getString(2));
			  room.setRoomstate(rs.getInt(3));
			  returedata.add(room);
			}
		  if(rs!=null)
			  rs.close();
		  if(st!=null)
			  st.close();
		  if(ct!=null)
			  ct.close();
		  return returedata;
	}
	/**
	 * 
	 * @return 预定单全部数据
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	public Vector GetOrder_all() throws ClassNotFoundException, SQLException {
		Vector<Order> returndata = new Vector<Order>();
		Class.forName(driverName);
		ct=DriverManager.getConnection(dbURL,userName,userPwd);
		st=ct.createStatement();
		rs=st.executeQuery("select * from Order_table where Order_state = 0");
		  while(rs.next())
			{
			  Order order = new Order();
			  order.setName(rs.getString(1));
			  order.setID_num(rs.getString(2));
			  order.setGender(rs.getString(3));
			  order.setRoom_type(rs.getString(4));
			  order.setCheckin(rs.getString(5));
			  order.setCheckout(rs.getString(6));  
			  order.setPhonenum(rs.getString(7));
			  order.setOrder_id(rs.getString(8));
			  order.setOrder_state(rs.getString(9));

			  returndata.add(order);
			}
		  if(rs!=null)
			  rs.close();
		  if(st!=null)
			  st.close();
		  if(ct!=null)
			  ct.close();
		  return returndata;
	}
	public Order GetOrder() throws SQLException {
		Order order = new Order();
		ct=DriverManager.getConnection(dbURL,userName,userPwd);
		st=ct.createStatement();
		rs=st.executeQuery("select top 1 * from Order_table where Order_state = 0");
		if (rs.isAfterLast()==rs.isBeforeFirst()) {
			order=null;
		} else {
			while(rs.next())
			{
			  order.setName(rs.getString(1));
			  order.setID_num(rs.getString(2));
			  order.setGender(rs.getString(3));
			  order.setRoom_type(rs.getString(4));
			  order.setCheckin(rs.getString(5));
			  order.setCheckout(rs.getString(6));  
			  order.setPhonenum(rs.getString(7));
			  order.setOrder_id(rs.getString(8));
			  order.setOrder_state(rs.getString(9));
			}			
		}
		  System.out.println("####order");
		 
		 if(rs!=null)
			  rs.close();
		 if(st!=null)
			  st.close();
		 if(ct!=null)
			  ct.close();
		return order;
		
	}
	public Order GetOrder(String order_id) throws SQLException {
		Order order = new Order();
		
		ct=DriverManager.getConnection(dbURL,userName,userPwd);
		st=ct.createStatement();
		String str="select * from Order_table where Order_state = 0 and order_id = '"+order_id+"'";
		System.out.println(str);
		rs=st.executeQuery(str);
		if (rs.isAfterLast()==rs.isBeforeFirst()) {
			order=null;
		} else {
			while(rs.next())
			{
			  order.setName(rs.getString(1));
			  order.setID_num(rs.getString(2));
			  order.setGender(rs.getString(3));
			  order.setRoom_type(rs.getString(4));
			  order.setCheckin(rs.getString(5));
			  order.setCheckout(rs.getString(6));  
			  order.setPhonenum(rs.getString(7));
			  order.setOrder_id(rs.getString(8));
			  order.setOrder_state(rs.getString(9));
			}
		}

		 System.out.println("####info");
		 if(rs!=null)
			  rs.close();
		 if(st!=null)
			  st.close();
		 if(ct!=null)
			  ct.close();
		return order;
		
	}
}


