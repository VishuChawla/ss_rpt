package com.wipro.Report.DAO;

import com.wipro.Report.bean.LoginBean;

public interface LoginDAO {
	String authenticate(LoginBean loginBean);
}
