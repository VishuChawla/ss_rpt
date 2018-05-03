package com.wipro.Report.bean;

import java.sql.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="RPT_ACCOUNT_TAB")
public class Account {

	@Id
	@Column
	@GeneratedValue
	private int RPT_ACCOUNT_ID;
	
	@Column
	private String RPT_ACCOUNT_NAME;
	
	@Column
	private String RPT_VERTICAL;
	
	@Column
	private Date LAST_UPDATED_TS;
	
	@Column
	private String ADD_TS;

	public int getRPT_ACCOUNT_ID() {
		return RPT_ACCOUNT_ID;
	}

	public void setRPT_ACCOUNT_ID(int rPT_ACCOUNT_ID) {
		RPT_ACCOUNT_ID = rPT_ACCOUNT_ID;
	}

	public String getRPT_ACCOUNT_NAME() {
		return RPT_ACCOUNT_NAME;
	}

	public void setRPT_ACCOUNT_NAME(String rPT_ACCOUNT_NAME) {
		RPT_ACCOUNT_NAME = rPT_ACCOUNT_NAME;
	}

	public String getRPT_VERTICAL() {
		return RPT_VERTICAL;
	}

	public void setRPT_VERTICAL(String rPT_VERTICAL) {
		RPT_VERTICAL = rPT_VERTICAL;
	}

	public Date getLAST_UPDATED_TS() {
		return LAST_UPDATED_TS;
	}

	public void setLAST_UPDATED_TS(Date lAST_UPDATED_TS) {
		LAST_UPDATED_TS = lAST_UPDATED_TS;
	}

	public String getADD_TSl() {
		return ADD_TS;
	}

	public void setADD_TSl(String aDD_TS) {
		ADD_TS = aDD_TS;
	}
	
	
}
