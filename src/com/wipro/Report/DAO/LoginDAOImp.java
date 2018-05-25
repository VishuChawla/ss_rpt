package com.wipro.Report.DAO;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.impl.SessionImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
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
	Transaction tx = null;
	
	@Override
	@Transactional(propagation=Propagation.REQUIRED)
	public boolean authenticate(LoginBean loginBean) {
		boolean result=false;

		System.out.println("LoginDAOImpl..");
//		Session session=sessionFactory.getCurrentSession();
	    
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
	    	String ls = "Temp";
	    	if(ls.isEmpty())
	    	{
	    		System.out.println("false");
	    		result=true;
//	    		result=false;
	    	}else
	    	{
	    		System.out.println("true");
	    		result=true;
	    	}
	    	return result;
	    	
	    }catch (Exception e) {
	    	
	    	e.printStackTrace();
	    	return false;
		}
	}

	@Override
	@Transactional(propagation=Propagation.REQUIRED)
	public String authorize(String userID) {
		String type="ADMIN";
		System.out.println("userid  "+userID);
		Session session=sessionFactory.getCurrentSession();
	    try
	    {
//	    	tx = session.beginTransaction();
//	    	String sql="from LoginBean where USERID=?";
//	    	Query query=session.createQuery(sql);
//	    	query.setString(0,userID);
//	    	List<LoginBean> ls=query.list();
	    	String ls = "ABC";
	    	
	    	if(ls.isEmpty())
	    	{
//	    		type="INVALID";
	    		return type;
	    	}else
	    	{
//	    		type=ls.get(0).getRPT_USR_TYP();
	    		System.out.println("TYPE:  "+type);
	    	}
	    	return type;
	    	
	    
	    }catch (Exception e) {
			e.printStackTrace();
			return "INVALID";
		}

	}

	@Override
	@Transactional(propagation=Propagation.REQUIRED)
	public boolean changeLoginStatus(LoginBean loginBean, String loginStatus) {
		
		System.out.println("userid  "+loginBean.getRPT_LOGIN_ID());
		Session session=sessionFactory.getCurrentSession();
	    try
	    {
//	    	tx = session.beginTransaction();
//	    	String sql="UPDATE RPT_LOGIN_TAB SET RTP_USR_STATUS=? WHERE RPT_LOGIN_ID=?";
//	    	Query query=session.createQuery(sql);
//	    	query.setString(0,loginStatus);
//	    	query.setString(1, loginBean.getRPT_LOGIN_ID());
	    	return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
}
