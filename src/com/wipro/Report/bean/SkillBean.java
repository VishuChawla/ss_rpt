package com.wipro.Report.bean;

import java.sql.Date;

import javax.persistence.*;

@Entity
@Table(name="RPT_SKILL_TAB")
public class SkillBean {

	@Id
	@Column
	private String RPT_SKILL_ID;
	
	@Column
	private String RPT_SKILL_NAME;
	
	@Column
	private String RPT_CTRY;
	
	@Column
	private Date LAST_UPDATED_TS;
	
	@Column
	private String ADD_TS;

	public String getRPT_SKILL_ID() {
		return RPT_SKILL_ID;
	}

	public void setRPT_SKILL_ID(String rPT_SKILL_ID) {
		RPT_SKILL_ID = rPT_SKILL_ID;
	}

	public String getRPT_SKILL_NAME() {
		return RPT_SKILL_NAME;
	}

	public void setRPT_SKILL_NAME(String rPT_SKILL_NAME) {
		RPT_SKILL_NAME = rPT_SKILL_NAME;
	}

	public String getRPT_CTRY() {
		return RPT_CTRY;
	}

	public void setRPT_CTRY(String rPT_CTRY) {
		RPT_CTRY = rPT_CTRY;
	}

	public Date getLAST_UPDATED_TS() {
		return LAST_UPDATED_TS;
	}

	public void setLAST_UPDATED_TS(Date lAST_UPDATED_TS) {
		LAST_UPDATED_TS = lAST_UPDATED_TS;
	}

	public String getADD_TS() {
		return ADD_TS;
	}

	public void setADD_TS(String aDD_TS) {
		ADD_TS = aDD_TS;
	}
	
}
