package com.xf.beans;


//qq用户信息
public class UserInfo {

	@Override
	public String toString() {
		return "UserInfo [id=" + id + ", loginpwd=" + loginpwd + ", friendshippolicyid=" + friendshippolicyid
				+ ", nickname=" + nickname + ", faceid=" + faceid + ", sex=" + sex + ", age=" + age + ", name=" + name
				+ ", bloodtypeid=" + bloodtypeid + ", starid=" + starid + ", animalyearid=" + animalyearid
				+ ", address=" + address + ", stateid=" + stateid + ", questionid=" + questionid + ", answer=" + answer
				+ "]";
	}

	public String getSign() {
		return sign;
	}

	public void setSign(String sign) {
		this.sign = sign;
	}

	private String sign;
	private int id;
	private String loginpwd;
	private int friendshippolicyid;
	private String nickname;
	private int faceid;
	private String sex;
	private int age;
	private String name;
	private int bloodtypeid;
	private int starid;
	private int animalyearid;
	private String address;
	private int stateid;
	private int questionid;
	private String answer;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getLoginpwd() {
		return loginpwd;
	}
	public void setLoginpwd(String loginpwd) {
		this.loginpwd = loginpwd;
	}
	public int getFriendshippolicyid() {
		return friendshippolicyid;
	}
	public void setFriendshippolicyid(int friendshippolicyid) {
		this.friendshippolicyid = friendshippolicyid;
	}
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	public int getFaceid() {
		return faceid;
	}
	public void setFaceid(int faceid) {
		this.faceid = faceid;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getBloodtypeid() {
		return bloodtypeid;
	}
	public void setBloodtypeid(int bloodtypeid) {
		this.bloodtypeid = bloodtypeid;
	}
	public int getStarid() {
		return starid;
	}
	public void setStarid(int starid) {
		this.starid = starid;
	}
	public int getAnimalyearid() {
		return animalyearid;
	}
	public void setAnimalyearid(int animalyearid) {
		this.animalyearid = animalyearid;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public int getStateid() {
		return stateid;
	}
	public void setStateid(int stateid) {
		this.stateid = stateid;
	}
	public int getQuestionid() {
		return questionid;
	}
	public void setQuestionid(int questionid) {
		this.questionid = questionid;
	}
	public String getAnswer() {
		return answer;
	}
	public void setAnswer(String answer) {
		this.answer = answer;
	}
	
	
}
