package com.wipro.Report.util;


import org.springframework.beans.factory.annotation.Autowired;

//import javax.swing.text.StyledEditorKit.BoldAction;

import org.springframework.stereotype.Service;

import com.wipro.Report.DAO.LoginDAO;
import com.wipro.Report.bean.LoginBean;



@Service("user")
public class UserImpl implements User{


	@Autowired
	LoginDAO loginDAOImp;

	@Override
	public String login(LoginBean loginBean) {
		String result="";
		System.out.println("UserImpl.. Login Method");
		String res="";
		if(loginBean==null || loginBean.getRPT_LOGIN_ID()==null || loginBean.getRPT_LOGIN_PWD()==null)
		{
			result="error";
		}else
		{
		 res=loginDAOImp.authenticate(loginBean);
		 System.out.println("res   "+res);
		 if(res.equalsIgnoreCase("ADMIN") || res.equalsIgnoreCase("USER"))
		 {
			 result=res;
			 
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
}
