package com.wipro.Report.DAO;

import java.sql.CallableStatement;
import java.sql.Connection;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.impl.SessionImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.wipro.Report.bean.LoginBean;

import oracle.jdbc.OracleTypes;

@Repository("loginDAO")
public class LoginDAOImp implements LoginDAO{


	private final static String STORED_PROC_USER_LOGIN = "call USER_LOGIN(?,?,?,?)";
	@Autowired
	SessionFactory sessionFactory = null;
	Session session = null ;
	
	@Override
	@Transactional(propagation=Propagation.REQUIRED)
	public String authenticate(LoginBean loginBean) {
		String result="";

		System.out.println("LoginDAOImpl..");
	    try
	    {
	    	
	    	session = sessionFactory.getCurrentSession();
	    	CallableStatement stmt = null;
	    	String rsType = null;
	    	String rsStatus = null;
	    	SessionImpl sessionImpl = (SessionImpl) session;
	    	Connection conn = (Connection) sessionImpl.connection();
	    	stmt = (CallableStatement) conn.prepareCall(STORED_PROC_USER_LOGIN);
	    	stmt.setString(1, loginBean.getRPT_LOGIN_ID());
	    	stmt.setString(2, loginBean.getRPT_LOGIN_PWD());	    	
	    	stmt.registerOutParameter(3, OracleTypes.CURSOR);
	    	stmt.registerOutParameter(4, OracleTypes.CURSOR);
	    	stmt.execute(); 		
	    	rsType = stmt.getString(3);
	    	rsStatus = stmt.getString(4);
	    	System.out.println("rsType: " + rsType);
	    	System.out.println("rsStatus: " + rsStatus);
	    	if(rsType.isEmpty())
	    	{
	    		System.out.println("false");
	    		result="NONE";
	    	}else
	    	{
	    		System.out.println("true");
	    		result=rsType;
	    	}
	    	return result;
	    	
	    }catch (Exception e) {
	    	
	    	e.printStackTrace();
	    	return "NONE";
		}
	}
}
