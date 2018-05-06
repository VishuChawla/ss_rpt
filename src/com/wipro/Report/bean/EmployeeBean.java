package com.wipro.Report.bean;

import java.sql.Date;

import javax.persistence.*;

@Entity
@Table(name="RPT_EMPLOYEE_TAB")
public class EmployeeBean {

	@Id
	@Column
	private int RPT_EMP_ID;
	
	@Column
	private String RPT_EMP_NAME;
	
	@Column
	private ProjectBean RPT_PROJECT_ID;
	
	@Column
	private String RPT_CAREER_BAND;
	
	@Column
	private int RPT_TOTAL_EXP;
	
	@Column
	private String RPT_PMRY_SKILL;

	@Column
	private char RPT_CUR_CMPTCY_LVL;
	
	@Column
	private Date LAST_UPDATED_TS;
	
	@Column
	private String ADD_TS;
	
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "RPT_PROJECT_ID")
    public ProjectBean getProjectID() {
        return RPT_PROJECT_ID;
    }
 
    public void setAccountID(ProjectBean project) {
        this.RPT_PROJECT_ID = project;
    }
	
	public int getRPT_EMP_ID() {
		return RPT_EMP_ID;
	}

	public void setRPT_EMP_ID(int rPT_EMP_ID) {
		RPT_EMP_ID = rPT_EMP_ID;
	}

	public String getRPT_EMP_NAME() {
		return RPT_EMP_NAME;
	}

	public void setRPT_EMP_NAME(String rPT_EMP_NAME) {
		RPT_EMP_NAME = rPT_EMP_NAME;
	}

	public String getRPT_CAREER_BAND() {
		return RPT_CAREER_BAND;
	}

	public void setRPT_CAREER_BAND(String rPT_CAREER_BAND) {
		RPT_CAREER_BAND = rPT_CAREER_BAND;
	}

	public int getRPT_TOTAL_EXP() {
		return RPT_TOTAL_EXP;
	}

	public void setRPT_TOTAL_EXP(int rPT_TOTAL_EXP) {
		RPT_TOTAL_EXP = rPT_TOTAL_EXP;
	}

	public String getRPT_PMRY_SKILL() {
		return RPT_PMRY_SKILL;
	}

	public void setRPT_PMRY_SKILL(String rPT_PMRY_SKILL) {
		RPT_PMRY_SKILL = rPT_PMRY_SKILL;
	}

	public char getRPT_CUR_CMPTCY_LVL() {
		return RPT_CUR_CMPTCY_LVL;
	}

	public void setRPT_CUR_CMPTCY_LVL(char rPT_CUR_CMPTCY_LVL) {
		RPT_CUR_CMPTCY_LVL = rPT_CUR_CMPTCY_LVL;
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
