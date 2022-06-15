package com.xf.beans;

import java.util.Date;

public class Messagesinfo {

	private String id;
	private String fromuserid;
	private String touserid;
	private String message;
	private String messagetypeid;
	private String messagestate;
	private Date messagedate;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getFromuserid() {
		return fromuserid;
	}
	public void setFromuserid(String fromuserid) {
		this.fromuserid = fromuserid;
	}
	public String getTouserid() {
		return touserid;
	}
	public void setTouserid(String touserid) {
		this.touserid = touserid;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getMessagetypeid() {
		return messagetypeid;
	}
	public void setMessagetypeid(String messagetypeid) {
		this.messagetypeid = messagetypeid;
	}
	public String getMessagestate() {
		return messagestate;
	}
	public void setMessagestate(String messagestate) {
		this.messagestate = messagestate;
	}
	public Date getMessagedate() {
		return messagedate;
	}
	public void setMessagedate(Date messagedate) {
		this.messagedate = messagedate;
	}
}
