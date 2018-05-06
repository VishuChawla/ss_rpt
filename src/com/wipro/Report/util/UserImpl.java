package com.wipro.Report.util;


//import javax.swing.text.StyledEditorKit.BoldAction;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wipro.Report.bean.LoginBean;
import com.wipro.Report.DAO.LoginDAO;



@Service("user")
public class UserImpl implements User{

	@Autowired
	LoginDAO loginDAO;


	@Override
	public String login(LoginBean loginBean) {
		String result="";
		boolean res=false;
		if(loginBean==null || loginBean.getRPT_LOGIN_ID()==null || loginBean.getRPT_LOGIN_PWD()==null)
		{
			result="error";
		}else
		{
		 res=loginDAO.authenticate(loginBean);
		 System.out.println("res   "+res);
		 if(res==true)
		 {
			 String type=loginDAO.authorize(loginBean.getRPT_LOGIN_ID());
			 System.out.println("type   "+type);
			 loginBean.setRPT_USR_TYP(type);
			 if(type.equalsIgnoreCase("ADMIN") || type.equalsIgnoreCase("USER"))
			 {
				 System.out.println("ADMIN");
				 boolean change=loginDAO.changeLoginStatus(loginBean, "ACTIVE");
				 if(change==true)
				 {
					 System.out.println("change...."+change);
					 result=type;
				 }else
				 {
					 result="INVALID";
					 System.out.println("INVALID");
				 }
			 }else
			 {
				 result="INVALID";
			 }
			 
		}else
		{
			result="INVALID";
		}
		}
		
     	return result;
	}


	@Override
	public boolean logout(String LId) {
		// TODO Auto-generated method stub
		return false;
	}


	@Override
	public String addUser(LoginBean loginBean) {
		// TODO Auto-generated method stub
		return null;
	}

//	@Override
//	@Transactional(propagation=Propagation.REQUIRED)
//	public boolean logout(String userId) {
//		boolean result=true;
//		
//		try
//		{
//		CredentialsBean credentialsBean=credentialsDAO.findByID(userId);
//		System.out.println("in user logout method i m bean:  "+credentialsBean!=null);
//		if(credentialsBean!=null)
//		{
//			boolean res=authentication.changeLoginStatus(credentialsBean, 0);
//			if(res!=false)
//			{
//				return true;
//			}else
//			{
//				return false;
//			}
//		}else
//		{
//			return false;
//		}
//
//		}catch (Exception e) {
//			e.printStackTrace();
//			return false;
//		}
//
//	}
}
