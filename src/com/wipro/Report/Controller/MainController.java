package com.wipro.Report.Controller;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.wipro.Report.Service.WFTReport;
import com.wipro.Report.bean.LoginBean;
import com.wipro.Report.util.User;

@Controller
@Scope("session")
public class MainController {

	LoginBean loginBean;

	@Autowired
	User userImpl;
	
	@Autowired
	WFTReport wFTReportImpl;
	
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
				System.out.println(loginBean.getRPT_LOGIN_ID() + " , " + loginBean.getRPT_LOGIN_PWD() + " , " + loginBean.getRPT_USR_TYP() + " , " + loginBean.getRPT_USR_STATUS());
				String result=userImpl.login(loginBean);
				System.out.println("result in main: "+ result);
				if(result.equalsIgnoreCase("ADMIN")) {
//					res= "admin";
					res= "options";
				}else if(result.equalsIgnoreCase("USER")) {
//						res= "user";
						res= "options";
						}else {
							res= "INVALID";
						}
		}
			return res;	
	}
	
	@RequestMapping(value="/UploadWFT",method=RequestMethod.POST)
	public String UploadWFT(){
		String CurrentOption = "UploadWFT";
		System.out.println("Choosed Option: " + CurrentOption);
		return "browse";
		
	}
	
	@RequestMapping(value="/UploadInsightRpt",method=RequestMethod.POST)
	public String UploadInsightRpt(){
		String CurrentOption = "UploadInsightRpt";
		System.out.println("Choosed Option: " + CurrentOption);;
		return "browse";
		
	}
	
	@RequestMapping(value="/GenerateReport",method=RequestMethod.GET)
	public String GenerateReport(){
		String CurrentOption = "GenerateReport";
		System.out.println("Choosed Option: " + CurrentOption);
		System.out.println("The controller is going to the Options page because the insigh report would have been downloaded");
		return "options";
		
	}
	 
	@RequestMapping(value="/loader",method=RequestMethod.POST)
	public String loader(@RequestParam("path")  MultipartFile file, HttpServletRequest request) throws IOException{ //
		String CurrentOption = "Loader";
		InputStream inputStream = new ByteArrayInputStream(file.getBytes());
		request.getSession().setAttribute("path", inputStream);
		System.out.println("Choosed Option: " + CurrentOption + "-" + file.getBytes().length);// + " Path:  " + path);
		return "loader";
		
	}
	
	@RequestMapping(value="/options",method=RequestMethod.GET)
	public String Options(HttpServletRequest session) throws IOException{
		String CurrentOption = "Running loader but processing PATH veriable..."; 
		String result= null;
		
		InputStream inputStream = (InputStream) session.getSession().getAttribute("path");
		System.out.println("-----------------------------------------------" + inputStream);

//		wFTReportImpl = new WFTReportImpl();
		String res = wFTReportImpl.readFromExcel(inputStream);
		System.out.println("-----------------------------------------------");
		if (res.equalsIgnoreCase("Success")){
			result = "options";
		}else{
			result = "Error";
		}
		
//		try {
//			System.out.println("This is the session attribute :    " + inputStream);
//			readFromExcel(inputStream);
//			
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
		System.out.println("Choosed Option: " + CurrentOption);
		return result;
		
	}
	
	@RequestMapping(value="/optionsAfterLoad",method=RequestMethod.GET)
	public String Options(){
		String CurrentOption = "Back to Options"; 
		System.out.println("Choosed Option: " + CurrentOption);
		return "options";
		
	} 
	

}