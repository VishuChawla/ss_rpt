package com.wipro.Report.Controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.wipro.Report.bean.LoginBean;
import com.wipro.Report.util.User;

@Controller
@SessionAttributes({"Lid"})
public class MainController {

	@Autowired
	HttpSession httpSession;
	
	@Autowired
	User user;
	
	@RequestMapping(value="/loginnn",method=RequestMethod.GET)
	public String doStart(@ModelAttribute("Credentials")LoginBean loginBean)
	{
		String res="";
		System.out.println("I am inside controller....");
		if(!loginBean.getRPT_LOGIN_ID().isEmpty() && !loginBean.getRPT_LOGIN_PWD().isEmpty())
		{
			return "error";
		}else
		{
			String result=user.login(loginBean);
			System.out.println("result in main"+ result);
			if(result.equals("ADMIN") || result.equals("USER"))
			{
				Map<String, Object> model=new HashMap<String, Object>();
				model.put("user", loginBean);
			}
			if(result.equals("ADMIN"))
			{
//				res= "admin";
				res= "options";
			}else if(result.equals("USER"))
			{
//				res= "user";
				res= "options";
			}else
			{
				res= "INVALID";
			}
			}
		 	httpSession.setAttribute("Lid",loginBean.getRPT_LOGIN_ID());
			return res;
		}
			
}
