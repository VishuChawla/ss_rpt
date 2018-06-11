package com.wipro.Report.Service;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wipro.Report.DAO.WFTReportDAO;
import com.wipro.Report.bean.AccountBean;
import com.wipro.Report.bean.EmployeeBean;
import com.wipro.Report.bean.ProjectBean;
import com.wipro.Report.bean.SkillBean;
import com.wipro.Report.bean.TargetBean;

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
		ArrayList<EmployeeBean> listEmployeeBeans = new ArrayList<EmployeeBean>();
		ArrayList<TargetBean> listTargetBeans = new ArrayList<TargetBean>();
		
		XSSFWorkbook myExcelBook;
		
		try {
			
			myExcelBook = new XSSFWorkbook(inpStream);
		 //To read the workbook
		List<String> sheetNames = new ArrayList<String>(); //List to store All Sheet names present in the provided workbook
		for (int i=0; i<myExcelBook.getNumberOfSheets(); i++) {    // Loop to read the sheetnames andstore in List
		    sheetNames.add( myExcelBook.getSheetName(i) );
		}
//		System.out.println("Sheet Numbers are: " + sheetNames.size());
		for(int i=1; i<sheetNames.size()-1; i++)						//Loop to iterated all the sheets one by one 
		{
			XSSFSheet myExcelSheet = myExcelBook.getSheet(sheetNames.get(i));  //To store the sheet name and read
			System.out.println("Sheet name is: " + sheetNames.get(i));
			XSSFRow row1 = myExcelSheet.getRow(3);
			int cells = myExcelSheet.getRow(3).getPhysicalNumberOfCells();
//			System.out.println("Skills names are:  ");
//			System.out.println("-------------------  " + cells);
			
			int colAdd = 0;
			
			for(int k=15; k<=cells-2; k=k+4){
				String skill = row1.getCell(k).getStringCellValue();
				if (!skill.equalsIgnoreCase("Remark") && !skill.equalsIgnoreCase("Remarks") ){
					SkillBean skillBean = new SkillBean();				
					skillBean.setRPT_SKILL_NAME(skill);
					skillBean.setRPT_CTRY(sheetNames.get(i));
					listSkillBeans.add(skillBean);
//					System.out.println(skillBean.getRPT_SKILL_NAME());
					
					for (int j=5; j<=myExcelSheet.getLastRowNum(); j++){ 
						XSSFRow row = myExcelSheet.getRow(j);
//						System.out.println("ID  : " +getIntValue(row.getCell(1)) );

						TargetBean targetBean = new TargetBean();
						EmployeeBean employeeBean = new EmployeeBean();
						int empID = getIntValue(row.getCell(1));
//						System.out.println("**************************************"); 
					
						employeeBean.setRPT_EMP_ID(empID);
						
						char currntCompLevel = 0;
						if (!row.getCell(11).getStringCellValue().equals(null)){
							currntCompLevel = row.getCell(11).getStringCellValue().charAt(0);
						}
						char rptRMove = 0; 
						
						if (!row.getCell(12).getStringCellValue().equals(null))
						{
							rptRMove = row.getCell(12).getStringCellValue().charAt(0);
						}
						
						char rptPMove = 0;
						if (!row.getCell(13).getStringCellValue().equals(null))
						{
							rptRMove = row.getCell(13).getStringCellValue().charAt(0);;
						}
						
//						System.out.println("rptRMove:  " + rptRMove + " rptPMove:  " + rptPMove + " EMP-ID: " + empID);
						
						java.util.Date rptMonMove1 = new java.util.Date();
						rptMonMove1 = getDateValue(row.getCell(14));
						Date rptMonMove = new Date(rptMonMove1.getTime());

						String targetTrain = row.getCell(15+colAdd).getStringCellValue();
											
						java.util.Date planTrngMon1 = new java.util.Date();
						planTrngMon1 = getDateValue(row.getCell(16+colAdd));
						Date planTrngMon = new Date(planTrngMon1.getTime());
						
						java.util.Date actualTrngMon1 = new java.util.Date();
						actualTrngMon1 = getDateValue(row.getCell(17+colAdd));
						Date actualTrngMon =  new Date(actualTrngMon1.getTime());
						
//						System.out.println("Skill: "+ skillBean.getRPT_SKILL_NAME() + " EmpID: " + empID + " rptMonMove:  " + rptMonMove +
//								" planTrngMon:  " + planTrngMon + " actualTrngMon:  " + actualTrngMon);
					
						String jScore = row.getCell(18+colAdd).getStringCellValue();
						targetBean.setRPT_EMP_ID(employeeBean);
						targetBean.setRPT_SKILL_ID(skillBean);
						targetBean.setRPT_CUR_CMPTCY_LVL(currntCompLevel);
						targetBean.setRPT_R_MOVE(rptRMove);
						targetBean.setRPT_P_MOVE(rptPMove);
						targetBean.setRPT_MON_MOV(rptMonMove);
						targetBean.setRPT_TRGT_TRNG(targetTrain);
						targetBean.setRPT_PLN_TRNG_MON(planTrngMon);
						targetBean.setRPR_ACT_TRNG_MON(actualTrngMon);
						targetBean.setRPT_JSCORE(jScore);
						listTargetBeans.add(targetBean);
				}
					colAdd = colAdd+4;
				
				}
			}
//			System.out.println("-------------------");
			
		    for (int k=5; k<=myExcelSheet.getLastRowNum(); k++){         //Start Iteration from the row 5
		    	XSSFRow row = myExcelSheet.getRow(k);
		    	ProjectBean projectBean = new ProjectBean();
		    	AccountBean accountBean = new AccountBean();
		    	EmployeeBean employeeBean = new EmployeeBean();
//		    	TargetBean targetBean = new TargetBean();  	
		    	
		    	String accountName = row.getCell(3).getStringCellValue();
		    	String vertical = row.getCell(4).getStringCellValue();
		    	accountBean.setRPT_ACCOUNT_NAME(accountName);
		    	accountBean.setRPT_VERTICAL(vertical);
		    	listAccountBeans.add(accountBean);
	    	
		    	String projectName = row.getCell(5).getStringCellValue();		   //Row:5, cell(column):5 and store in name variable
		    	String projectPMName = row.getCell(6).getStringCellValue();
		    	String projectDMName = row.getCell(7).getStringCellValue();
		    	projectBean.setRPT_PROJECT_NAME(projectName);
		    	projectBean.setRPT_PROJECT_MANAGER(projectPMName);
		    	projectBean.setRPT_DELIVERY_MANAGER(projectDMName);
		    	projectBean.setAccountID(accountBean);
		    	listProjectBeans.add(projectBean);
		    	
//		    	System.out.println(row.getCell(0).getCellType() + "-------------------");
		    	int empID = getIntValue(row.getCell(1));
//		    	System.out.println("empID:  ---- " + empID);
		    	String empName = row.getCell(2).getStringCellValue();
//		    	System.out.println("Employee Name: ************** " + empName);
		    	String band = row.getCell(8).getStringCellValue();
//		    	System.out.println(row.getCell(9).getCellType() + "-------------------");
		    	int exprnc = getIntValue(row.getCell(9));
		    	 
//		    	System.out.println("exprnc: ---- " + exprnc);
		    	
		    	String primSkill = row.getCell(10).getStringCellValue();
		    	String curntCompLev = row.getCell(11).getStringCellValue();
		    	employeeBean.setRPT_EMP_ID(empID);
		    	employeeBean.setRPT_EMP_NAME(empName);
		    	employeeBean.setRPT_PROJECT_ID(projectBean);
		    	employeeBean.setRPT_CAREER_BAND(band);
		    	employeeBean.setRPT_TOTAL_EXP(exprnc);
		    	employeeBean.setRPT_PMRY_SKILL(primSkill);
		    	employeeBean.setRPT_CUR_CMPTCY_LVL(curntCompLev);
		    	listEmployeeBeans.add(employeeBean);
		    	}

		}
		
		SkillBean skillBeantemp = new SkillBean();
		for (int ik = 0; ik < listSkillBeans.size(); ik++) {
			skillBeantemp = listSkillBeans.get(ik);
			System.out.println("Skill name: " + skillBeantemp.getRPT_SKILL_NAME() + 
					"Skill Category: " + skillBeantemp.getRPT_CTRY());
		}
		
		AccountBean accountBean = new AccountBean();
		for (int ik = 0; ik < listAccountBeans.size(); ik++) {
			accountBean = listAccountBeans.get(ik);
			System.out.println("Account Name: " + accountBean.getRPT_ACCOUNT_NAME() + 
					"Vertical name: " + accountBean.getRPT_VERTICAL());
		}
		System.out.println("Sizeeeee:   " + listAccountBeans.size());
		
    	ProjectBean listProjectBeansTemp = new ProjectBean();
		for (int ik = 0; ik < listProjectBeans.size(); ik++) {
			listProjectBeansTemp = listProjectBeans.get(ik);
			System.out.println("Project name: " + listProjectBeansTemp.getRPT_PROJECT_NAME() + 
					" PM: " + listProjectBeansTemp.getRPT_PROJECT_MANAGER() +
					" DM: " + listProjectBeansTemp.getRPT_DELIVERY_MANAGER());
		}
		
		EmployeeBean employeeBeanTemp = new EmployeeBean();
		for (int ik = 0; ik < listEmployeeBeans.size(); ik++) {
			employeeBeanTemp = listEmployeeBeans.get(ik);
		System.out.println("Emp ID: " + employeeBeanTemp.getRPT_EMP_ID() + 
				" Emp Name: " + employeeBeanTemp.getRPT_EMP_NAME() +
				" Project Name: " + employeeBeanTemp.getRPT_PROJECT_ID().getRPT_PROJECT_NAME() + 
				" Band: " + employeeBeanTemp.getRPT_CAREER_BAND() +
				" Experience: " + employeeBeanTemp.getRPT_TOTAL_EXP() +
				" Primary Skill: " + employeeBeanTemp.getRPT_PMRY_SKILL() +
				" Compt. Level: " + employeeBeanTemp.getRPT_CUR_CMPTCY_LVL());
			
	}
		TargetBean targetBeanTemp = new TargetBean();
		for (int ik = 0; ik < listTargetBeans.size(); ik++) {
			targetBeanTemp = listTargetBeans.get(ik);
			System.out.print(targetBeanTemp.getRPT_EMP_ID().getRPT_EMP_ID());
			System.out.print(" " + targetBeanTemp.getRPT_SKILL_ID().getRPT_SKILL_NAME());
			System.out.print(" " + targetBeanTemp.getRPT_CUR_CMPTCY_LVL());
			System.out.print(" " + targetBeanTemp.getRPT_R_MOVE());
			System.out.print(" " + targetBeanTemp.getRPT_P_MOVE());
			System.out.print(" " + targetBeanTemp.getRPT_MON_MOV());
			System.out.print(" " + targetBeanTemp.getRPT_TRGT_TRNG());
			System.out.print(" " + targetBeanTemp.getRPT_PLN_TRNG_MON());
			System.out.print(" " + targetBeanTemp.getRPR_ACT_TRNG_MON());
			System.out.print(" " + targetBeanTemp.getRPT_JSCORE());
			System.out.println();
		}
//		System.out.println("********************* Size of Target Bean:  " + listTargetBeans.size());
			
		
//		wftReportDAOImpl.uploadSkills(listSkillBeans);     // Need to keep only this statement...
//		wftReportDAOImpl.uploadAccounts(listAccountBeans);	// Need to keep only this statement...
//		wftReportDAOImpl.uploadProjects(listProjectBeans);  // Need to keep only this statement...
//		wftReportDAOImpl.uploadEmployee(listEmployeeBeans);  // Need to keep only this statement...
//		wftReportDAOImpl.uploadTarget(listTargetBeans);
			return "Success";
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "Error";
		}
		
	}

	private int getIntValue(XSSFCell cell) {
		int val = 0;
		int dataType = cell.getCellType();
		switch(dataType) {
			case Cell.CELL_TYPE_NUMERIC :
				val = (int) cell.getNumericCellValue();
				break;
				
//			case Cell.CELL_TYPE_STRING:
//				obj = (String) cell.getStringCellValue();
//				break;
				
			case Cell.CELL_TYPE_BLANK:
				val = 0;
		}
		return val;
	}
	
	private java.util.Date getDateValue(XSSFCell cell) {
		int dataType = cell.getCellType();
		switch(dataType) {
				case Cell.CELL_TYPE_BLANK:
					java.util.Date val = new java.util.Date(System.currentTimeMillis());
					System.out.println("cell is blanck..");
					return val;
				default:
					java.util.Date val1 = cell.getDateCellValue();
					return val1;
		}
	}
	
	
}
