package com.wipro.Report.bean;

import javax.persistence.*;

@Entity
@Table(name="RPT_LOGIN_TAB")
public class LoginBean{

	@Id
	@Column
	private String RPT_LOGIN_ID;
	
	@Column
	private String RPT_LOGIN_PWD;
	
	@Column
	private String RPT_USR_TYP;
	
	@Column
	private String RPT_USR_STATUS;

	public String getRPT_LOGIN_ID() {
		return RPT_LOGIN_ID;
	}

	public void setRPT_LOGIN_ID(String rPT_LOGIN_ID) {
		RPT_LOGIN_ID = rPT_LOGIN_ID;
	}

	public String getRPT_LOGIN_PWD() {
		return RPT_LOGIN_PWD;
	}

	public void setRPT_LOGIN_PWD(String rPT_LOGIN_PWD) {
		RPT_LOGIN_PWD = rPT_LOGIN_PWD;
	}

	public String getRPT_USR_TYP() {
		return RPT_USR_TYP;
	}

	public void setRPT_USR_TYP(String rPT_USR_TYP) {
		RPT_USR_TYP = rPT_USR_TYP;
	}

	public String getRPT_USR_STATUS() {
		return RPT_USR_STATUS;
	}

	public void setRPT_USR_STATUS(String rPT_USR_STATUS) {
		RPT_USR_STATUS = rPT_USR_STATUS;
	}
		
}
