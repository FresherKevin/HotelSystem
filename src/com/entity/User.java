/**
 * @Title: User.java
 * @Description:
 * @Copyright: Copyright (c) 2018 
 * @Company:nuaa
 * @author xck&kevin
 * @date 2018年12月31日
 * @version 1.0
 */
package com.entity;

import com.common.DataBaseConnect;

/**
 * @author Kevin
 *
 */
public class User {
	private int id;
	private int password;
	private DataBaseConnect dc;
	
	/**
	 * 
	 */
	public User(int id,int password) {
		// TODO Auto-generated constructor stub
		dc=new DataBaseConnect();
		this.id=id;
		this.password=password;
	}
	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}
	/**
	 * @return the password
	 */
	public int getPassword() {
		return password;
	}
	/**
	 * @param password the password to set
	 */
	public void setPassword(int password) {
		this.password = password;
	}
	/**
	 * 
	 * @param loginchoice
	 * @return
	 */
	public int logincheck(int loginchoice) {
		int flag=0;
		if(loginchoice==0)
		{
			try {
				dc.Sql("select id,pass_word from managers_table");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			flag = 1;
		}
		if(loginchoice==1)
		{
			try {
				dc.Sql("select id,pass_word from common_table");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			flag = 1;
		}
		if(loginchoice==2)
		{
			try {
				dc.Sql("select id,pass_word from customers_table");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			flag = 2;
		}
		int temp=0;
		String password=String.valueOf(this.getPassword());
		String accountnum=String.valueOf(this.getId());
		for(int i=0;i<dc.getId().size();i++)
		{
			if(accountnum.equals(dc.getId().get(i).toString()) && password.equals(dc.getPassword().get(i).toString()))
			{
				temp=1;
				break;
			}
		}

		if (temp==0) {
			if(!dc.getId().contains(Integer.parseInt(accountnum))){
				flag=4;
				return flag;
			}
			return 0;
		} else {
			return flag;
		}
	}
}
