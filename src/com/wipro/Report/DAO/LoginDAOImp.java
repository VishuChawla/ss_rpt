package com.wipro.Report.DAO;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.wipro.Report.bean.LoginBean;

@Repository("loginDAO")
public class LoginDAOImp implements LoginDAO{


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
	    	//tx = session.beginTransaction();
	    	session.beginTransaction();
	    	String sql="from LoginBean where RPT_LOGIN_ID=? and RPT_LOGIN_PWD=? and RTP_USR_STATUS=INACTIVE";
	    	Query query=session.createQuery(sql);
	    	query.setString(0,loginBean.getRPT_LOGIN_ID());
	    	query.setString(1,loginBean.getRPT_LOGIN_PWD());
	    	List<LoginBean> ls=query.list();
	    	if(ls.isEmpty())
	    	{
	    		System.out.println("false");
	    		result=false;
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
		String type="";
		System.out.println("userid  "+userID);
		Session session=sessionFactory.getCurrentSession();
	    try
	    {
	    	tx = session.beginTransaction();
	    	String sql="from LoginBean where USERID=?";
	    	Query query=session.createQuery(sql);
	    	query.setString(0,userID);
	    	List<LoginBean> ls=query.list();
	    	if(ls.isEmpty())
	    	{
	    		type="INVALID";
	    	}else
	    	{
	    		type=ls.get(0).getRPT_USR_TYP();
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
	    	tx = session.beginTransaction();
	    	String sql="UPDATE RPT_LOGIN_TAB SET RTP_USR_STATUS=? WHERE RPT_LOGIN_ID=?";
	    	Query query=session.createQuery(sql);
	    	query.setString(0,loginStatus);
	    	query.setString(1, loginBean.getRPT_LOGIN_ID());
	    	return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
}
