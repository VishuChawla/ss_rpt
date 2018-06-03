package com.wipro.Report.DAO;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.util.ArrayList;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.impl.SessionImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.wipro.Report.bean.AccountBean;
import com.wipro.Report.bean.ProjectBean;
import com.wipro.Report.bean.SkillBean;

import oracle.jdbc.OracleTypes;

@Repository
public class WFTReportDAOImpl implements WFTReportDAO {

	private final static String STORED_PROC_INSERT_SKILL_TABLE = "call INSERT_SKILL_TAB(?,?,?)";
	private final static String STORED_PROC_INSERT_ACCOUNT_TABLE = "call INSERT_ACCOUNT(?,?,?)";
	private final static String STORED_PROC_INSERT_PROJECT_TABLE = "call INSERT_PROJECT(?,?,?,?,?)";
	
	@Autowired
	SessionFactory sessionFactory = null;
	Session session = null ;

	
	@Override
	@Transactional(propagation=Propagation.REQUIRED)
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
	    	System.out.println("-----------------------------------");
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
	public String uploadAccounts(ArrayList<AccountBean> listAccountBean){
		AccountBean accountBean = new AccountBean();
		System.out.println("uploadAccounts......");
		try{
			
			session = sessionFactory.getCurrentSession();
	    	CallableStatement stmt = null;
	    	String rsType = null;
	    	SessionImpl sessionImpl = (SessionImpl) session;
	    	Connection conn = (Connection) sessionImpl.connection();
	    	stmt = (CallableStatement) conn.prepareCall(STORED_PROC_INSERT_ACCOUNT_TABLE);
	    	for (int i = 0; i < listAccountBean.size(); i++){
	    		accountBean = listAccountBean.get(i);
	    		stmt.setString(1, accountBean.getRPT_ACCOUNT_NAME());
	    		stmt.setString(2, accountBean.getRPT_VERTICAL());
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
