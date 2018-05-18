package com.wipro.Report.bean;

import java.sql.Date;

import javax.persistence.*;

@Entity
@Table(name="RPT_TARGET_TAB")
public class TargetBean {

	
	private int RPT_TARGET_ID;
		
	private SkillBean RPT_SKILL_ID;
	
	private EmployeeBean RPT_EMP_ID;
		
	private char RPT_CUR_CMPTCY_LVL;
		
	private char RPT_R_MOVE;
		
	private char RPT_P_MOVE;
		
	private Date RPT_MON_MOV;
		
	private String RPT_TRGT_TRNG;
		
	private Date RPT_PLN_TRNG_MON;
		
	private Date RPR_ACT_TRNG_MON;
		
	private String RPT_JSCORE;
		
	private Date LAST_UPDATED_TS;
		
	private String ADD_TS;
	
	public TargetBean() {}
    
	
    @Id
	@Column
	public int getRPT_TARGET_ID() {
		return RPT_TARGET_ID;
	}
    
	public void setRPT_TARGET_ID(int rPT_TARGET_ID) {
		RPT_TARGET_ID = rPT_TARGET_ID;
	}

	@Column
	public char getRPT_CUR_CMPTCY_LVL() {
		return RPT_CUR_CMPTCY_LVL;
	}

	public void setRPT_CUR_CMPTCY_LVL(char rPT_CUR_CMPTCY_LVL) {
		RPT_CUR_CMPTCY_LVL = rPT_CUR_CMPTCY_LVL;
	}

	@Column
	public char getRPT_R_MOVE() {
		return RPT_R_MOVE;
	}

	public void setRPT_R_MOVE(char rPT_R_MOVE) {
		RPT_R_MOVE = rPT_R_MOVE;
	}

	@Column
	public char getRPT_P_MOVE() {
		return RPT_P_MOVE;
	}

	public void setRPT_P_MOVE(char rPT_P_MOVE) {
		RPT_P_MOVE = rPT_P_MOVE;
	}

	@Column
	public Date getRPT_MON_MOV() {
		return RPT_MON_MOV;
	}

	public void setRPT_MON_MOV(Date rPT_MON_MOV) {
		RPT_MON_MOV = rPT_MON_MOV;
	}

	@Column
	public String getRPT_TRGT_TRNG() {
		return RPT_TRGT_TRNG;
	}

	public void setRPT_TRGT_TRNG(String rPT_TRGT_TRNG) {
		RPT_TRGT_TRNG = rPT_TRGT_TRNG;
	}

	@Column
	public Date getRPT_PLN_TRNG_MON() {
		return RPT_PLN_TRNG_MON;
	}

	public void setRPT_PLN_TRNG_MON(Date rPT_PLN_TRNG_MON) {
		RPT_PLN_TRNG_MON = rPT_PLN_TRNG_MON;
	}

	@Column
	public Date getRPR_ACT_TRNG_MON() {
		return RPR_ACT_TRNG_MON;
	}

	public void setRPR_ACT_TRNG_MON(Date rPR_ACT_TRNG_MON) {
		RPR_ACT_TRNG_MON = rPR_ACT_TRNG_MON;
	}

	@Column
	public String getRPT_JSCORE() {
		return RPT_JSCORE;
	}

	public void setRPT_JSCORE(String rPT_JSCORE) {
		RPT_JSCORE = rPT_JSCORE;
	}

	@Column
	public Date getLAST_UPDATED_TS() {
		return LAST_UPDATED_TS;
	}

	public void setLAST_UPDATED_TS(Date lAST_UPDATED_TS) {
		LAST_UPDATED_TS = lAST_UPDATED_TS;
	}

	@Column
	public String getADD_TS() {
		return ADD_TS;
	}

	public void setADD_TS(String aDD_TS) {
		ADD_TS = aDD_TS;
	}
	
	@OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "RPT_EMP_ID")
    public EmployeeBean getRPT_EMP_ID() {
    	return RPT_EMP_ID;
    }
    
    public void setRPT_EMP_ID(EmployeeBean eb) {
        this.RPT_EMP_ID = eb;
    }
	
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "RPT_SKILL_ID")
    public SkillBean getRPT_SKILL_ID() {
    	return RPT_SKILL_ID;
    }
    
    public void setRPT_SKILL_ID(SkillBean sb) {
        this.RPT_SKILL_ID = sb;
    }
	
}
