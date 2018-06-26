package com.anbot.model;

import java.util.Date;

public class User {
    private Integer userId;

	private String userName;

	private String password;

	private String name;

	private String tele;

	private String email;

	private Integer companyId;

	private String companyDns;

	private String dept;

	private Integer managerId;

	private Integer roleId;

	private Integer online;

	private Date createT;

	private Date modifyT;

	private Date lastloginT;

	private Integer count;

	private Integer enable;

	private Integer tryLoginTimes;

	private String verificationCode;

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName == null ? null : userName.trim();
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password == null ? null : password.trim();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name == null ? null : name.trim();
	}

	public String getTele() {
		return tele;
	}

	public void setTele(String tele) {
		this.tele = tele == null ? null : tele.trim();
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email == null ? null : email.trim();
	}

	public Integer getCompanyId() {
		return companyId;
	}

	public void setCompanyId(Integer companyId) {
		this.companyId = companyId;
	}

	public String getCompanyDns() {
		return companyDns;
	}

	public void setCompanyDns(String companyDns) {
		this.companyDns = companyDns == null ? null : companyDns.trim();
	}

	public String getDept() {
		return dept;
	}

	public void setDept(String dept) {
		this.dept = dept == null ? null : dept.trim();
	}

	public Integer getManagerId() {
		return managerId;
	}

	public void setManagerId(Integer managerId) {
		this.managerId = managerId;
	}

	public Integer getRoleId() {
		return roleId;
	}

	public void setRoleId(Integer roleId) {
		this.roleId = roleId;
	}

	public Integer getOnline() {
		return online;
	}

	public void setOnline(Integer online) {
		this.online = online;
	}

	public Date getCreateT() {
		return createT;
	}

	public void setCreateT(Date createT) {
		this.createT = createT;
	}

	public Date getModifyT() {
		return modifyT;
	}

	public void setModifyT(Date modifyT) {
		this.modifyT = modifyT;
	}

	public Date getLastloginT() {
		return lastloginT;
	}

	public void setLastloginT(Date lastloginT) {
		this.lastloginT = lastloginT;
	}

	public Integer getCount() {
		return count;
	}

	public void setCount(Integer count) {
		this.count = count;
	}

	public Integer getEnable() {
		return enable;
	}

	public void setEnable(Integer enable) {
		this.enable = enable;
	}

	public Integer getTryLoginTimes() {
		return tryLoginTimes;
	}

	public void setTryLoginTimes(Integer tryLoginTimes) {
		this.tryLoginTimes = tryLoginTimes;
	}

	public String getVerificationCode() {
		return verificationCode;
	}

	public void setVerificationCode(String verificationCode) {
		this.verificationCode = verificationCode == null ? null : verificationCode.trim();
	}

}