package com.wipro.Report.DAO;

import com.wipro.Report.bean.LoginBean;

public interface LoginDAO {
	boolean authenticate(LoginBean loginBean);
	String authorize(String userID); 
	boolean changeLoginStatus(LoginBean  loginBean, String loginStatus);
	
}
