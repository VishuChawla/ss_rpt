package com.wipro.Report.DAO;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.util.ArrayList;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.impl.SessionImpl;

import com.wipro.Report.bean.ProjectBean;
import com.wipro.Report.bean.SkillBean;

import oracle.jdbc.OracleTypes;

public class WFTReportDAOImpl implements WFTReportDAO {

	private final static String STORED_PROC_INSERT_SKILL_TABLE = "call INSERT_SKILL(?,?,?)";
	private final static String STORED_PROC_INSERT_PROJECT_TABLE = "call INSERT_PROJECT(?,?,?,?,?)";
	
	SessionFactory sessionFactory = null;
	Session session = null ;
	
	@Override
	public String uploadSkills(ArrayList<SkillBean> listSkillBean) {
		SkillBean skillBean = new SkillBean();
		System.out.println("uploadSkills.....");
		try
	    {
	    	session = sessionFactory.getCurrentSession();
	    	CallableStatement stmt = null;
	    	String rsType = null;
	    	SessionImpl sessionImpl = (SessionImpl) session;
	    	Connection conn = (Connection) sessionImpl.connection();
	    	stmt = (CallableStatement) conn.prepareCall(STORED_PROC_INSERT_SKILL_TABLE);
	    	
	    	for (int i = 0; i < listSkillBean.size(); i++) {
	    		skillBean = listSkillBean.get(i);
	    		stmt.setString(1, skillBean.getRPT_SKILL_NAME());
		    	stmt.setString(2, skillBean.getRPT_CTRY());
		    	stmt.registerOutParameter(3, OracleTypes.CURSOR);
		    	stmt.execute(); 		
		    	rsType = stmt.getString(3);
	    		if(rsType.isEmpty()){
	    			return "FAIL";
	    		}
	    	} 	
	    	return "Success";
		}catch(Exception E){
			E.printStackTrace();
			return "FAIL";
	}
	}

	@Override
	public String uploadProjects(ArrayList<ProjectBean> listProjectBeans) {
		ProjectBean projectBean = new ProjectBean();
		System.out.println("uploadProjects.....");
		try
	    {
	    	session = sessionFactory.getCurrentSession();
	    	CallableStatement stmt = null;
	    	String rsType = null;
	    	SessionImpl sessionImpl = (SessionImpl) session;
	    	Connection conn = (Connection) sessionImpl.connection();
	    	stmt = (CallableStatement) conn.prepareCall(STORED_PROC_INSERT_PROJECT_TABLE);
	    	for (int i = 0; i < listProjectBeans.size(); i++) {
	    		projectBean = listProjectBeans.get(i);
	    		stmt.setString(1, projectBean.getRPT_PROJECT_NAME());
	    		stmt.setString(2, projectBean.getRPT_PROJECT_MANAGER());
	    		stmt.setString(3, projectBean.getRPT_DELIVERY_MANAGER());
	    		stmt.setString(4, projectBean.getAccountID().getRPT_ACCOUNT_NAME());
	    		stmt.registerOutParameter(5, OracleTypes.CURSOR);
	    		stmt.execute();
	    		rsType = stmt.getString(5);
	    		if(rsType.isEmpty()){
	    			return "FAIL";
	    		}
	    	} 	
	    	return "Success";
		}catch(Exception E){
			E.printStackTrace();
			return "FAIL";
	}
	}
}
