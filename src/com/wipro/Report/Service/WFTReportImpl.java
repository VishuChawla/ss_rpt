package com.wipro.Report.Service;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wipro.Report.DAO.WFTReportDAO;
import com.wipro.Report.bean.AccountBean;
import com.wipro.Report.bean.ProjectBean;
import com.wipro.Report.bean.SkillBean;

@Service
public class WFTReportImpl implements WFTReport{
	
	
	@Autowired
	WFTReportDAO wftReportDAOImpl;

	@Override
	@SuppressWarnings("resource")
	public String readFromExcel(InputStream inpStream) {
		 
		
	
		ArrayList<SkillBean> listSkillBeans = new ArrayList<SkillBean>();
		ArrayList<AccountBean> listAccountBeans = new ArrayList<AccountBean>();
		ArrayList<ProjectBean> listProjectBeans = new ArrayList<ProjectBean>();
		
		
		XSSFWorkbook myExcelBook;
		
		try {
			
			myExcelBook = new XSSFWorkbook(inpStream);
		 //To read the workbook
		List<String> sheetNames = new ArrayList<String>(); //List to store All Sheet names present in the provided workbook
		for (int i=0; i<myExcelBook.getNumberOfSheets(); i++) {    // Loop to read the sheetnames andstore in List
		    sheetNames.add( myExcelBook.getSheetName(i) );
		}
		System.out.println("Sheet Numbers are: " + sheetNames.size());
		for(int i=1; i<sheetNames.size()-1; i++)						//Loop to iterated all the sheets one by one 
		{
			XSSFSheet myExcelSheet = myExcelBook.getSheet(sheetNames.get(i));  //To store the sheet name and read
			System.out.println("Sheet name is: " + sheetNames.get(i));
			XSSFRow row1 = myExcelSheet.getRow(3);
			int cells = myExcelSheet.getRow(3).getPhysicalNumberOfCells();
			System.out.println("Skills names are:  ");
			System.out.println("-------------------  " + cells);
			
			for(int k=15; k<=cells-2; k=k+4){
				String skill = row1.getCell(k).getStringCellValue();
				if (!skill.equalsIgnoreCase("Remark") && !skill.equalsIgnoreCase("Remarks") ){
					SkillBean skillBean = new SkillBean();
//					System.out.println(skill);
					skillBean.setRPT_SKILL_NAME(skill);
					skillBean.setRPT_CTRY(sheetNames.get(i));
					listSkillBeans.add(skillBean);
				}
			}
//			System.out.println("-------------------");
			
		    for (int k=5; k<=myExcelSheet.getLastRowNum(); k++){         //Start Iteration from the row 5
		    	XSSFRow row = myExcelSheet.getRow(k);
		    	ProjectBean projectBean = new ProjectBean();
		    	AccountBean accountBean = new AccountBean();
	    	
		    	String accountName = row.getCell(3).getStringCellValue();
		    	String vertical = row.getCell(4).getStringCellValue();
		    	
		    	accountBean.setRPT_ACCOUNT_NAME(accountName);
		    	accountBean.setRPT_VERTICAL(vertical);
		    	listAccountBeans.add(accountBean);
		    	String projectName = row.getCell(5).getStringCellValue();		   //Row:5, cell(column):5 and store in name variable
		    	String projectPMName = row.getCell(6).getStringCellValue();
//		    	String accountName = row.getCell(3).getStringCellValue();
		    	String projectDMName = row.getCell(7).getStringCellValue();
		    	projectBean.setRPT_PROJECT_NAME(projectName);
		    	projectBean.setRPT_PROJECT_MANAGER(projectPMName);
		    	projectBean.setRPT_DELIVERY_MANAGER(projectDMName);
		    	projectBean.setAccountID(accountBean);
		    	listProjectBeans.add(projectBean);
		    	}
		}
		
		
//		SkillBean skillBeantemp = new SkillBean();
//		for (int ik = 0; ik < listSkillBeans.size(); ik++) {
//			skillBeantemp = listSkillBeans.get(ik);
//			System.out.println("Skill name: " + skillBeantemp.getRPT_SKILL_NAME() + 
//					"Skill Category: " + skillBeantemp.getRPT_CTRY());
//		}
		
//		AccountBean accountBean = new AccountBean();
//		for (int ik = 0; ik < listAccountBeans.size(); ik++) {
//			accountBean = listAccountBeans.get(ik);
//			System.out.println("Account Name: " + accountBean.getRPT_ACCOUNT_NAME() + 
//					"Vertical name: " + accountBean.getRPT_VERTICAL());
//		}
//		System.out.println("Sizeeeee:   " + listAccountBeans.size());
		
//    	ProjectBean listProjectBeansTemp = new ProjectBean();
//		for (int ik = 0; ik < listProjectBeans.size(); ik++) {
//			listProjectBeansTemp = listProjectBeans.get(ik);
//			System.out.println("Project name: " + listProjectBeansTemp.getRPT_PROJECT_NAME() + 
//					" PM: " + listProjectBeansTemp.getRPT_PROJECT_MANAGER() +
//					" DM: " + listProjectBeansTemp.getRPT_DELIVERY_MANAGER());
//		}
		
		
		wftReportDAOImpl.uploadSkills(listSkillBeans);     // Need to keep only this statement...
//		wftReportDAOImpl.uploadAccounts(listAccountBeans);	// Need to keep only this statement...
//		wftReportDAOImpl.uploadProjects(listProjectBeans);  // Need to keep only this statement...
		
		
			return "Success";
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "ERROR";
		}
		
	}
}
