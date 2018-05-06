package com.wipro.Report.bean;

import javax.persistence.*;

@Entity
@Table(name="COLM_NME_MAP_TAB")
public class MappingBean {

	@Id
	@Column
	private int RPT_COLM_ID;
	
	@Column
	private String RPT_DB_COLM_NAME;
	
	@Column
	private String RPT_EXL_COLM_NAME;
	
}
