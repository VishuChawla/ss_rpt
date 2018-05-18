package com.wipro.Report.bean;

import java.sql.Date;

import javax.persistence.*;

@Entity
@Table(name="RPT_PROJECT_TAB")
public class ProjectBean {
	

	private int RPT_PROJECT_ID;
	
	@Column
	private String RPT_PROJECT_NAME;
	
	@Column
	private String	RPT_PROJECT_MANAGER;
	
	@Column
	private AccountBean RPT_ACCOUNT_ID;
	
	@Column
	private String RPT_DELIVERY_MANAGER;
	
	@Column
	private Date LAST_UPDATED_TS;
	
	@Column
	private String ADD_TS;

	@Id
	@Column
	public int getRPT_PROJECT_ID() {
		return RPT_PROJECT_ID;
	}

	public void setRPT_PROJECT_ID(int rPT_PROJECT_ID) {
		RPT_PROJECT_ID = rPT_PROJECT_ID;
	}

	public String getRPT_PROJECT_NAME() {
		return RPT_PROJECT_NAME;
	}

	public void setRPT_PROJECT_NAME(String rPT_PROJECT_NAME) {
		RPT_PROJECT_NAME = rPT_PROJECT_NAME;
	}

	public String getRPT_PROJECT_MANAGER() {
		return RPT_PROJECT_MANAGER;
	}

	public void setRPT_PROJECT_MANAGER(String rPT_PROJECT_MANAGER) {
		RPT_PROJECT_MANAGER = rPT_PROJECT_MANAGER;
	}


    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "RPT_ACCOUNT_ID")
    public AccountBean getAccountID() {
        return RPT_ACCOUNT_ID;
    }
 
    public void setAccountID(AccountBean account) {
        this.RPT_ACCOUNT_ID = account;
    }

	public String getRPT_DELIVERY_MANAGER() {
		return RPT_DELIVERY_MANAGER;
	}

	public void setRPT_DELIVERY_MANAGER(String rPT_DELIVERY_MANAGER) {
		RPT_DELIVERY_MANAGER = rPT_DELIVERY_MANAGER;
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

