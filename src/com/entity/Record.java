/**
 * @Title: Record.java
 * @Description:
 * @Copyright: Copyright (c) 2018 
 * @Company:nuaa
 * @author xck&kevin
 * @date 2018年12月31日
 * @version 1.0
 */
package com.entity;

/**
 * @author Kevin
 *
 */
public class Record {
	private int roomnum;
	private String name;
	private String id;
	private String sexy;
	
	private String checkin;
	private String checkout;
	private int charge;
	private int despoit;
	private int isliving;
	
	private String phone_num;
	private String Order_id;
	/**
	 * @return the phone_num
	 */
	public String getPhone_num() {
		return phone_num;
	}
	/**
	 * @param phone_num the phone_num to set
	 */
	public void setPhone_num(String phone_num) {
		this.phone_num = phone_num;
	}
	/**
	 * @return the order_id
	 */
	public String getOrder_id() {
		return Order_id;
	}
	/**
	 * @param order_id the order_id to set
	 */
	public void setOrder_id(String order_id) {
		Order_id = order_id;
	}
	/**
	 * @return the roomnum
	 */
	public int getRoomnum() {
		return roomnum;
	}
	/**
	 * @param roomnum the roomnum to set
	 */
	public void setRoomnum(int roomnum) {
		this.roomnum = roomnum;
	}
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * @return the sexy
	 */
	public String getSexy() {
		return sexy;
	}
	/**
	 * @param sexy the sexy to set
	 */
	public void setSexy(String sexy) {
		this.sexy = sexy;
	}
	/**
	 * @return the id
	 */
	public String getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(String id) {
		this.id = id;
	}
	/**
	 * @return the checkin
	 */
	public String getCheckin() {
		return checkin;
	}
	/**
	 * @param checkin the checkin to set
	 */
	public void setCheckin(String checkin) {
		this.checkin = checkin;
	}
	/**
	 * @return the checkout
	 */
	public String getCheckout() {
		return checkout;
	}
	/**
	 * @param checkout the checkout to set
	 */
	public void setCheckout(String checkout) {
		this.checkout = checkout;
	}
	/**
	 * @return the charge
	 */
	public int getCharge() {
		return charge;
	}
	/**
	 * @param charge the charge to set
	 */
	public void setCharge(int charge) {
		this.charge = charge;
	}
	/**
	 * @return the despoit
	 */
	public int getDespoit() {
		return despoit;
	}
	/**
	 * @param despoit the despoit to set
	 */
	public void setDespoit(int despoit) {
		this.despoit = despoit;
	}
	/**
	 * @return the isliving
	 */
	public int getIsliving() {
		return isliving;
	}
	/**
	 * @param isliving the isliving to set
	 */
	public void setIsliving(int isliving) {
		this.isliving = isliving;
	}

}
