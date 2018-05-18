package com.wipro.Report.bean;

import java.sql.Date;

import javax.persistence.*;

@Entity
@Table(name="RPT_INSIGHT_TAB")
public class InsightBean {

	
	private int RPT_ATTENDEE_ID;
	
	@Column
	private String RPT_SKILL_NAME;
	
	@Column
	private SkillBean RPT_SKILL_ID;
	
	@Column
	private String RPT_JAVA_SPLIT;
	
	@Column
	private String RPT_CATEGORY;
	
	@Column
	private char RPT_MODE;
	
	@Column
	private String RPT_LOCATION;
	
	@Column
	private String RPT_ON_OFF_FLG;
	
	@Column
	private String RPT_SL;
	
	@Column
	private Date RPT_ATT_ST_DT;
	
	@Column
	private Date RPT_ATT_END_DT;
	
	@Column
	private int RPT_ATT_DUR_DAY;
	
	@Column
	private Date RPT_BOOKED_ON;
	
	@Column
	private int RPT_BOOKINGS;
	
	@Column
	private int RPT_EVNT;
	
	@Column
	private int RPT_EVNT_SHORT;
	
	@Column
	private String RPT_BUS_EVNT_SHRT_TXT;
	
	@Column
	private String RPT_CAT_ID;
	
	@Column
	private String RPT_CG_STRM_ID;
	
	@Column
	private String RPT_CG_STRM_NAME;
	
	@Column
	private String RPT_CLUSTER_ID;
	
	@Column
	private String RPT_CLUSTER_NAME;
	
	@Column
	private int RPT_DUR_DAY;
	
	@Column
	private int RPT_DUR_HRS;
	
	@Column
	private String RPT_EMAIL_ID;
	
	@Column
	private Date RPT_END_DATE;
	
	@Column
	private char RPT_EVENT;
	
	@Column
	private int RPT_EVNT_GRP1;
	
	@Column
	private int RPT_EVNT_GRP2;
	
	@Column
	private int RPT_EVNT_GRP3;
	
	@Column
	private int RPT_EVNT_TYP;
	
	@Column
	private String RPT_EVNT_TYP_TXT;
	
	@Column
	private String RPT_GENDER;
	
	@Column
	private String RPT_LEVEL;
	
	@Column
	private String RPT_EVNT_NAME;
	
	@Column
	private String RPT_ORG_ASSIGN;
	
	@Column
	private int RPT_ORGNO;
	
	@Column
	private int RPT_POS_ID;
	
	@Column
	private String RPT_PS_GROUP;
	
	@Column
	private int RPT_REQ_COST_CNTR;
	
	@Column
	private String RPT_REQ_MAIL_ID;
	
	@Column
	private int RPT_REQ_ID;
	
	@Column
	private Date RPT_SKILL_BEG_DATE;
	
	@Column
	private Date RPT_SKILL_END_DATE;
	
	@Column
	private Date RPT_START_DATE;
	
	@Column
	private String RPT_SUB_STRM_ID;
	
	@Column
	private String RPT_SUB_STRM_NAME;
	
	@Column
	private int RPT_TR_NO;
	
	@Column
	private String RPT_SBU;
	
	@Column
	private String RPT_VERTICAL;
	
	@Column
	private String RPT_LGC_PRACT;
	
	@Column
	private String RPT_LGC_SUB_PRACT;
	
	@Column
	private char RPT_MODEL_TYPE;
	
	@Column
	private String RPT_TRNG_TYPE;

	
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "RPT_SKILL_ID")
    public SkillBean getRPT_SKILL_ID() {
    	return RPT_SKILL_ID;

    }
    
    public void setRPT_SKILL_ID(SkillBean sb) {
        this.RPT_SKILL_ID = sb;
    }
	
    @Id
	@Column
	public int getRPT_ATTENDEE_ID() {
		return RPT_ATTENDEE_ID;
	}

	public void setRPT_ATTENDEE_ID(int rPT_ATTENDEE_ID) {
		RPT_ATTENDEE_ID = rPT_ATTENDEE_ID;
	}

	public String getRPT_SKILL_NAME() {
		return RPT_SKILL_NAME;
	}

	public void setRPT_SKILL_NAME(String rPT_SKILL_NAME) {
		RPT_SKILL_NAME = rPT_SKILL_NAME;
	}

	public String getRPT_JAVA_SPLIT() {
		return RPT_JAVA_SPLIT;
	}

	public void setRPT_JAVA_SPLIT(String rPT_JAVA_SPLIT) {
		RPT_JAVA_SPLIT = rPT_JAVA_SPLIT;
	}

	public String getRPT_CATEGORY() {
		return RPT_CATEGORY;
	}

	public void setRPT_CATEGORY(String rPT_CATEGORY) {
		RPT_CATEGORY = rPT_CATEGORY;
	}

	public char getRPT_MODE() {
		return RPT_MODE;
	}

	public void setRPT_MODE(char rPT_MODE) {
		RPT_MODE = rPT_MODE;
	}

	public String getRPT_LOCATION() {
		return RPT_LOCATION;
	}

	public void setRPT_LOCATION(String rPT_LOCATION) {
		RPT_LOCATION = rPT_LOCATION;
	}

	public String getRPT_ON_OFF_FLG() {
		return RPT_ON_OFF_FLG;
	}

	public void setRPT_ON_OFF_FLG(String rPT_ON_OFF_FLG) {
		RPT_ON_OFF_FLG = rPT_ON_OFF_FLG;
	}

	public String getRPT_SL() {
		return RPT_SL;
	}

	public void setRPT_SL(String rPT_SL) {
		RPT_SL = rPT_SL;
	}

	public Date getRPT_ATT_ST_DT() {
		return RPT_ATT_ST_DT;
	}

	public void setRPT_ATT_ST_DT(Date rPT_ATT_ST_DT) {
		RPT_ATT_ST_DT = rPT_ATT_ST_DT;
	}

	public Date getRPT_ATT_END_DT() {
		return RPT_ATT_END_DT;
	}

	public void setRPT_ATT_END_DT(Date rPT_ATT_END_DT) {
		RPT_ATT_END_DT = rPT_ATT_END_DT;
	}

	public int getRPT_ATT_DUR_DAY() {
		return RPT_ATT_DUR_DAY;
	}

	public void setRPT_ATT_DUR_DAY(int rPT_ATT_DUR_DAY) {
		RPT_ATT_DUR_DAY = rPT_ATT_DUR_DAY;
	}

	public Date getRPT_BOOKED_ON() {
		return RPT_BOOKED_ON;
	}

	public void setRPT_BOOKED_ON(Date rPT_BOOKED_ON) {
		RPT_BOOKED_ON = rPT_BOOKED_ON;
	}

	public int getRPT_BOOKINGS() {
		return RPT_BOOKINGS;
	}

	public void setRPT_BOOKINGS(int rPT_BOOKINGS) {
		RPT_BOOKINGS = rPT_BOOKINGS;
	}

	public int getRPT_EVNT() {
		return RPT_EVNT;
	}

	public void setRPT_EVNT(int rPT_EVNT) {
		RPT_EVNT = rPT_EVNT;
	}

	public int getRPT_EVNT_SHORT() {
		return RPT_EVNT_SHORT;
	}

	public void setRPT_EVNT_SHORT(int rPT_EVNT_SHORT) {
		RPT_EVNT_SHORT = rPT_EVNT_SHORT;
	}

	public String getRPT_BUS_EVNT_SHRT_TXT() {
		return RPT_BUS_EVNT_SHRT_TXT;
	}

	public void setRPT_BUS_EVNT_SHRT_TXT(String rPT_BUS_EVNT_SHRT_TXT) {
		RPT_BUS_EVNT_SHRT_TXT = rPT_BUS_EVNT_SHRT_TXT;
	}

	public String getRPT_CAT_ID() {
		return RPT_CAT_ID;
	}

	public void setRPT_CAT_ID(String rPT_CAT_ID) {
		RPT_CAT_ID = rPT_CAT_ID;
	}

	public String getRPT_CG_STRM_ID() {
		return RPT_CG_STRM_ID;
	}

	public void setRPT_CG_STRM_ID(String rPT_CG_STRM_ID) {
		RPT_CG_STRM_ID = rPT_CG_STRM_ID;
	}

	public String getRPT_CG_STRM_NAME() {
		return RPT_CG_STRM_NAME;
	}

	public void setRPT_CG_STRM_NAME(String rPT_CG_STRM_NAME) {
		RPT_CG_STRM_NAME = rPT_CG_STRM_NAME;
	}

	public String getRPT_CLUSTER_ID() {
		return RPT_CLUSTER_ID;
	}

	public void setRPT_CLUSTER_ID(String rPT_CLUSTER_ID) {
		RPT_CLUSTER_ID = rPT_CLUSTER_ID;
	}

	public String getRPT_CLUSTER_NAME() {
		return RPT_CLUSTER_NAME;
	}

	public void setRPT_CLUSTER_NAME(String rPT_CLUSTER_NAME) {
		RPT_CLUSTER_NAME = rPT_CLUSTER_NAME;
	}

	public int getRPT_DUR_DAY() {
		return RPT_DUR_DAY;
	}

	public void setRPT_DUR_DAY(int rPT_DUR_DAY) {
		RPT_DUR_DAY = rPT_DUR_DAY;
	}

	public int getRPT_DUR_HRS() {
		return RPT_DUR_HRS;
	}

	public void setRPT_DUR_HRS(int rPT_DUR_HRS) {
		RPT_DUR_HRS = rPT_DUR_HRS;
	}

	public String getRPT_EMAIL_ID() {
		return RPT_EMAIL_ID;
	}

	public void setRPT_EMAIL_ID(String rPT_EMAIL_ID) {
		RPT_EMAIL_ID = rPT_EMAIL_ID;
	}

	public Date getRPT_END_DATE() {
		return RPT_END_DATE;
	}

	public void setRPT_END_DATE(Date rPT_END_DATE) {
		RPT_END_DATE = rPT_END_DATE;
	}

	public char getRPT_EVENT() {
		return RPT_EVENT;
	}

	public void setRPT_EVENT(char rPT_EVENT) {
		RPT_EVENT = rPT_EVENT;
	}

	public int getRPT_EVNT_GRP1() {
		return RPT_EVNT_GRP1;
	}

	public void setRPT_EVNT_GRP1(int rPT_EVNT_GRP1) {
		RPT_EVNT_GRP1 = rPT_EVNT_GRP1;
	}

	public int getRPT_EVNT_GRP2() {
		return RPT_EVNT_GRP2;
	}

	public void setRPT_EVNT_GRP2(int rPT_EVNT_GRP2) {
		RPT_EVNT_GRP2 = rPT_EVNT_GRP2;
	}

	public int getRPT_EVNT_GRP3() {
		return RPT_EVNT_GRP3;
	}

	public void setRPT_EVNT_GRP3(int rPT_EVNT_GRP3) {
		RPT_EVNT_GRP3 = rPT_EVNT_GRP3;
	}

	public int getRPT_EVNT_TYP() {
		return RPT_EVNT_TYP;
	}

	public void setRPT_EVNT_TYP(int rPT_EVNT_TYP) {
		RPT_EVNT_TYP = rPT_EVNT_TYP;
	}

	public String getRPT_EVNT_TYP_TXT() {
		return RPT_EVNT_TYP_TXT;
	}

	public void setRPT_EVNT_TYP_TXT(String rPT_EVNT_TYP_TXT) {
		RPT_EVNT_TYP_TXT = rPT_EVNT_TYP_TXT;
	}

	public String getRPT_GENDER() {
		return RPT_GENDER;
	}

	public void setRPT_GENDER(String rPT_GENDER) {
		RPT_GENDER = rPT_GENDER;
	}

	public String getRPT_LEVEL() {
		return RPT_LEVEL;
	}

	public void setRPT_LEVEL(String rPT_LEVEL) {
		RPT_LEVEL = rPT_LEVEL;
	}

	public String getRPT_EVNT_NAME() {
		return RPT_EVNT_NAME;
	}

	public void setRPT_EVNT_NAME(String rPT_EVNT_NAME) {
		RPT_EVNT_NAME = rPT_EVNT_NAME;
	}

	public String getRPT_ORG_ASSIGN() {
		return RPT_ORG_ASSIGN;
	}

	public void setRPT_ORG_ASSIGN(String rPT_ORG_ASSIGN) {
		RPT_ORG_ASSIGN = rPT_ORG_ASSIGN;
	}

	public int getRPT_ORGNO() {
		return RPT_ORGNO;
	}

	public void setRPT_ORGNO(int rPT_ORGNO) {
		RPT_ORGNO = rPT_ORGNO;
	}

	public int getRPT_POS_ID() {
		return RPT_POS_ID;
	}

	public void setRPT_POS_ID(int rPT_POS_ID) {
		RPT_POS_ID = rPT_POS_ID;
	}

	public String getRPT_PS_GROUP() {
		return RPT_PS_GROUP;
	}

	public void setRPT_PS_GROUP(String rPT_PS_GROUP) {
		RPT_PS_GROUP = rPT_PS_GROUP;
	}

	public int getRPT_REQ_COST_CNTR() {
		return RPT_REQ_COST_CNTR;
	}

	public void setRPT_REQ_COST_CNTR(int rPT_REQ_COST_CNTR) {
		RPT_REQ_COST_CNTR = rPT_REQ_COST_CNTR;
	}

	public String getRPT_REQ_MAIL_ID() {
		return RPT_REQ_MAIL_ID;
	}

	public void setRPT_REQ_MAIL_ID(String rPT_REQ_MAIL_ID) {
		RPT_REQ_MAIL_ID = rPT_REQ_MAIL_ID;
	}

	public int getRPT_REQ_ID() {
		return RPT_REQ_ID;
	}

	public void setRPT_REQ_ID(int rPT_REQ_ID) {
		RPT_REQ_ID = rPT_REQ_ID;
	}

	public Date getRPT_SKILL_BEG_DATE() {
		return RPT_SKILL_BEG_DATE;
	}

	public void setRPT_SKILL_BEG_DATE(Date rPT_SKILL_BEG_DATE) {
		RPT_SKILL_BEG_DATE = rPT_SKILL_BEG_DATE;
	}

	public Date getRPT_SKILL_END_DATE() {
		return RPT_SKILL_END_DATE;
	}

	public void setRPT_SKILL_END_DATE(Date rPT_SKILL_END_DATE) {
		RPT_SKILL_END_DATE = rPT_SKILL_END_DATE;
	}

	public Date getRPT_START_DATE() {
		return RPT_START_DATE;
	}

	public void setRPT_START_DATE(Date rPT_START_DATE) {
		RPT_START_DATE = rPT_START_DATE;
	}

	public String getRPT_SUB_STRM_ID() {
		return RPT_SUB_STRM_ID;
	}

	public void setRPT_SUB_STRM_ID(String rPT_SUB_STRM_ID) {
		RPT_SUB_STRM_ID = rPT_SUB_STRM_ID;
	}

	public String getRPT_SUB_STRM_NAME() {
		return RPT_SUB_STRM_NAME;
	}

	public void setRPT_SUB_STRM_NAME(String rPT_SUB_STRM_NAME) {
		RPT_SUB_STRM_NAME = rPT_SUB_STRM_NAME;
	}

	public int getRPT_TR_NO() {
		return RPT_TR_NO;
	}

	public void setRPT_TR_NO(int rPT_TR_NO) {
		RPT_TR_NO = rPT_TR_NO;
	}

	public String getRPT_SBU() {
		return RPT_SBU;
	}

	public void setRPT_SBU(String rPT_SBU) {
		RPT_SBU = rPT_SBU;
	}

	public String getRPT_VERTICAL() {
		return RPT_VERTICAL;
	}

	public void setRPT_VERTICAL(String rPT_VERTICAL) {
		RPT_VERTICAL = rPT_VERTICAL;
	}

	public String getRPT_LGC_PRACT() {
		return RPT_LGC_PRACT;
	}

	public void setRPT_LGC_PRACT(String rPT_LGC_PRACT) {
		RPT_LGC_PRACT = rPT_LGC_PRACT;
	}

	public String getRPT_LGC_SUB_PRACT() {
		return RPT_LGC_SUB_PRACT;
	}

	public void setRPT_LGC_SUB_PRACT(String rPT_LGC_SUB_PRACT) {
		RPT_LGC_SUB_PRACT = rPT_LGC_SUB_PRACT;
	}

	public char getRPT_MODEL_TYPE() {
		return RPT_MODEL_TYPE;
	}

	public void setRPT_MODEL_TYPE(char rPT_MODEL_TYPE) {
		RPT_MODEL_TYPE = rPT_MODEL_TYPE;
	}

	public String getRPT_TRNG_TYPE() {
		return RPT_TRNG_TYPE;
	}

	public void setRPT_TRNG_TYPE(String rPT_TRNG_TYPE) {
		RPT_TRNG_TYPE = rPT_TRNG_TYPE;
	}
	
	
}
