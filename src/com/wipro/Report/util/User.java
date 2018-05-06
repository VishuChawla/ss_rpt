package com.wipro.Report.util;

import com.wipro.Report.bean.LoginBean;

public interface User {
	String login(LoginBean loginBean);
	boolean logout(String LId);
	String addUser(LoginBean loginBean);

}
