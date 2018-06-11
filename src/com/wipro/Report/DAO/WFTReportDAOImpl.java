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
import com.wipro.Report.bean.EmployeeBean;
import com.wipro.Report.bean.ProjectBean;
import com.wipro.Report.bean.SkillBean;
import com.wipro.Report.bean.TargetBean;

import oracle.jdbc.OracleTypes;

@Repository
public class WFTReportDAOImpl implements WFTReportDAO {

	private final static String STORED_PROC_INSERT_SKILL_TABLE = "call INSERT_SKILL_TAB(?,?,?)";
	private final static String STORED_PROC_INSERT_ACCOUNT_TABLE = "call INSERT_ACCOUNT_TAB(?,?,?)";
	private final static String STORED_PROC_INSERT_PROJECT_TABLE = "call INSERT_PROJECT_TAB(?,?,?,?,?)";
	private final static String STORED_PROC_INSERT_EMPLOYEE_TABLE = "call INSERT_EMP_TAB(?,?,?,?,?,?,?,?)";
	private final static String STORED_PROC_INSERT_TARGET_TABLE = "call INSERT_TARGET_TAB(?,?,?,?,?,?,?,?,?,?,?)";
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
		    	
		    	
		    	if(!rsType.equalsIgnoreCase("SUCCESS") || !rsType.equalsIgnoreCase("EXIST"))
		    		return "FAIL";
		    	   }
	    	return "Success";
		}catch(Exception E){
			E.printStackTrace();
			return "FAIL";
	}
}
	
	
	@Override
	@Transactional(propagation=Propagation.REQUIRED)
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
	    	
	    	System.out.println(listAccountBean.size() + " Size in uploadAccounts........");
	    	
	    	
	    	for (int i = 0; i < listAccountBean.size(); i++){
	    		accountBean = listAccountBean.get(i);
	    		
	    		System.out.println("Account Name: " + accountBean.getRPT_ACCOUNT_NAME() + "  Vertical Name: " + accountBean.getRPT_VERTICAL());
	    		
	    		stmt.setString(1, accountBean.getRPT_ACCOUNT_NAME());
	    		stmt.setString(2, accountBean.getRPT_VERTICAL());
	    		stmt.registerOutParameter(3, OracleTypes.CURSOR);
	    		stmt.execute();
	    		rsType = stmt.getString(3);
	    		
	    		System.out.println("Result Set:  " + rsType);
	    		
	    		if(!rsType.equalsIgnoreCase("SUCCESS") && !rsType.equalsIgnoreCase("EXIST"))
		    		{
	    			    System.out.println("Result Set in if statement:  " + rsType);
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
	@Transactional(propagation=Propagation.REQUIRED)
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
	    		if(!rsType.equalsIgnoreCase("SUCCESS") && !rsType.equalsIgnoreCase("EXIST"))
	    		{
    			    System.out.println("Result Set in if statement:  " + rsType);
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
	@Transactional(propagation=Propagation.REQUIRED)
	public String uploadEmployee(ArrayList<EmployeeBean> listEmployeeBeans) {
		EmployeeBean employeeBean = new EmployeeBean();
		System.out.println("uploadProjects.....");
		try
	    {
	    	session = sessionFactory.getCurrentSession();
	    	CallableStatement stmt = null;
	    	String rsType = null;
	    	SessionImpl sessionImpl = (SessionImpl) session;
	    	Connection conn = (Connection) sessionImpl.connection();
	    	stmt = (CallableStatement) conn.prepareCall(STORED_PROC_INSERT_EMPLOYEE_TABLE);
	    	for (int i = 0; i < listEmployeeBeans.size(); i++) {
	    		employeeBean = listEmployeeBeans.get(i);
	    		stmt.setInt(1,employeeBean.getRPT_EMP_ID());
	    		stmt.setString(2, employeeBean.getRPT_EMP_NAME());
	    		stmt.setString(3, employeeBean.getRPT_PROJECT_ID().getRPT_PROJECT_NAME());
	    		stmt.setString(4, employeeBean.getRPT_CAREER_BAND());
	    		stmt.setInt(5, employeeBean.getRPT_TOTAL_EXP());
	    		stmt.setString(6, employeeBean.getRPT_PMRY_SKILL());
	    		stmt.setString(7, employeeBean.getRPT_CUR_CMPTCY_LVL());
	    		stmt.registerOutParameter(8, OracleTypes.CURSOR);
	    		stmt.execute();
	    		rsType = stmt.getString(8);
	    		if(!rsType.equalsIgnoreCase("SUCCESS") && !rsType.equalsIgnoreCase("EXIST"))
	    		{
    			    System.out.println("Result Set in if statement:  " + rsType);
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
	@Transactional(propagation=Propagation.REQUIRED)
	public String uploadTarget(ArrayList<TargetBean> listTargetBeans) {
		TargetBean targetBean = new TargetBean();
		System.out.println("uploadTarget Table.....");
		try
	    {
	    	session = sessionFactory.getCurrentSession();
	    	CallableStatement stmt = null;
	    	String rsType = null;
	    	SessionImpl sessionImpl = (SessionImpl) session;
	    	Connection conn = (Connection) sessionImpl.connection();
	    	stmt = (CallableStatement) conn.prepareCall(STORED_PROC_INSERT_TARGET_TABLE);
	    	for (int i = 0; i < listTargetBeans.size(); i++) {
	    		targetBean = listTargetBeans.get(i);
	    		stmt.setInt(1, targetBean.getRPT_EMP_ID().getRPT_EMP_ID());
	    		stmt.setString(2, targetBean.getRPT_SKILL_ID().getRPT_SKILL_NAME());
	    		stmt.setString(3, String.valueOf(targetBean.getRPT_CUR_CMPTCY_LVL()));
	    		stmt.setString(4, String.valueOf(targetBean.getRPT_R_MOVE()));
	    		stmt.setString(5, String.valueOf(targetBean.getRPT_P_MOVE()));
	    		stmt.setDate(6, targetBean.getRPT_MON_MOV());
	    		stmt.setString(7, targetBean.getRPT_TRGT_TRNG());
	    		stmt.setDate(8, targetBean.getRPT_PLN_TRNG_MON());
	    		stmt.setDate(9, targetBean.getRPR_ACT_TRNG_MON());
	    		stmt.setString(10, targetBean.getRPT_JSCORE());
	    		stmt.registerOutParameter(11, OracleTypes.CURSOR);
	    		stmt.execute();
	    		rsType = stmt.getString(11);
	    		if(!rsType.equalsIgnoreCase("SUCCESS") && !rsType.equalsIgnoreCase("EXIST"))
	    		{
    			    System.out.println("Result Set in if statement:  " + rsType);
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
