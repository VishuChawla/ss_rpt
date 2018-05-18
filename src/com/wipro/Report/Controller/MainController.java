package com.wipro.Report.Controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.wipro.Report.bean.LoginBean;
import com.wipro.Report.util.User;

@Controller
public class MainController {

	LoginBean loginBean;
	

	@Autowired
	User userImpl;
	
	@RequestMapping(value="/start",method=RequestMethod.GET)
	public String doStart()
	{
		System.out.println("i am in main.");
		return "loginPage";
		
	}
	
	@RequestMapping(value="/login",method=RequestMethod.POST)
	public String login(@RequestParam("userID") String userID, @RequestParam("password") String password)
	{
		loginBean = new LoginBean();
		//userImpl = new UserImpl(); 
		System.out.println("I am inside controller....");
		System.out.println("userID: " +userID);
		System.out.println("password: " +password);
		String res="";
		loginBean.setRPT_LOGIN_ID(userID);
		loginBean.setRPT_LOGIN_PWD(password);
		if(loginBean.getRPT_LOGIN_ID().isEmpty() && loginBean.getRPT_LOGIN_PWD().isEmpty()){
			return "Error";
		}else {
				System.out.println("Not empty.." + loginBean.getRPT_LOGIN_ID() + " and " + loginBean.getRPT_LOGIN_PWD());
				loginBean.setRPT_USR_TYP("ABC");
				loginBean.setRTP_USR_STATUS("ACTIVE");
				System.out.println(loginBean.getRPT_LOGIN_ID() + " , " + loginBean.getRPT_LOGIN_PWD() + " , " + loginBean.getRPT_USR_TYP() + " , " + loginBean.getRTP_USR_STATUS());
				String result=userImpl.login(loginBean);
				System.out.println("result in main: "+ result);
				if(result.equals("ADMIN") || result.equals("USER")) {
					Map<String, Object> model=new HashMap<String, Object>();
					model.put("user", loginBean);
				}
				if(result.equals("ADMIN")) {
//					res= "admin";
					res= "options";
				}else if(result.equals("USER")) {
//						res= "user";
						res= "options";
						}else {
							res= "INVALID";
						}
		}
			return res;	
	}
}