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
import org.springframework.stereotype.Service;

import com.wipro.Report.bean.InsightBean;
import com.wipro.Report.bean.SkillBean;

@Service
public class insightReportImpl implements InsightReport{

	
//	@Autowired
//	WFTReportDAO wftReportDAOImpl;
	
	@Override
	@SuppressWarnings("resource")
	public String readFromExcel(InputStream inpStream) throws IOException {
		XSSFWorkbook myExcelBook;
		
		
		try {
			myExcelBook = new XSSFWorkbook(inpStream);
			
			List<String> sheetNames = new ArrayList<String>(); //List to store All Sheet names present in the provided workbook
			for (int i=0; i<myExcelBook.getNumberOfSheets(); i++) {    // Loop to read the sheetnames andstore in List
			    sheetNames.add( myExcelBook.getSheetName(i) );
			}
			    XSSFSheet myExcelSheet = myExcelBook.getSheet(sheetNames.get(0));
				System.out.println("Sheet name is: " + sheetNames.get(0));
			
				 for (int k=2; k<=myExcelSheet.getLastRowNum(); k++){  
					 XSSFRow row = myExcelSheet.getRow(k);
					 InsightBean insightBean = new InsightBean();
					 SkillBean skillBean = new SkillBean();
					 
					 int empID = getIntValue(row.getCell(0));
					 String skill = row.getCell(2).getStringCellValue();
					 skillBean.setRPT_SKILL_NAME(skill);
					 String javaSplit = row.getCell(3).getStringCellValue();
					 String catgry = row.getCell(4).getStringCellValue();
					 char mode = 0;
					 if (!row.getCell(5).getStringCellValue().equals(null))
					 {
						 mode =  row.getCell(5).getStringCellValue().charAt(0);
					 }
					 String loc = row.getCell(6).getStringCellValue();
					 String flag = row.getCell(7).getStringCellValue();
					 String SL = row.getCell(8).getStringCellValue();
					 java.util.Date StDate1 = new java.util.Date();
					 StDate1 = getDateValue(row.getCell(9));
					 Date StDate = new Date(StDate1.getTime());
					 java.util.Date EndDate1 = new java.util.Date();
					 EndDate1  = getDateValue(row.getCell(10));					
					 int durDay = getIntValue(row.getCell(11));
					 java.util.Date bookedOn1 = new java.util.Date();
					 bookedOn1 = getDateValue(row.getCell(12));
					 Date bookedOn = new Date(bookedOn1.getTime());
					 int booking = getIntValue(row.getCell(13));
					 int evnt = getIntValue(row.getCell(14));
					 int evntShort = getIntValue(row.getCell(15));
					
					 String eventSrtText = row.getCell(16).getStringCellValue();
					
					 String catID = row.getCell(17).getStringCellValue();
					
					 String SteamID = row.getCell(18).getStringCellValue();
					 String SteamName = row.getCell(19).getStringCellValue();
					
					 String CustID = row.getCell(20).getStringCellValue();
					 String CustName = row.getCell(21).getStringCellValue();
					
					 int durDate = getIntValue(row.getCell(22));
					 int durHr = getIntValue(row.getCell(23));
					
					 String mail = row.getCell(24).getStringCellValue();
					 java.util.Date endDate1 = new java.util.Date();
					 endDate1 = getDateValue(row.getCell(25));
					 Date endDate = new Date(endDate1.getTime());
					
					
					 char rptEvnt = 0;
					 if (!row.getCell(26).getStringCellValue().equals(null))
					 {
						 rptEvnt = row.getCell(26).getStringCellValue().charAt(0);
					 }
					
					 int grp1 = getIntValue(row.getCell(27));
					 int grp2 = getIntValue(row.getCell(28));
					 int grp3 = getIntValue(row.getCell(29));
					 int evntType = getIntValue(row.getCell(30));
					 
					 String evntTypeText = row.getCell(31).getStringCellValue();
					 String gender = row.getCell(32).getStringCellValue();
					 
					 String level = row.getCell(33).getStringCellValue();
					 String levelName = row.getCell(34).getStringCellValue();
					 String assign = row.getCell(35).getStringCellValue();
					 int orgNo =  getIntValue(row.getCell(36));
					 int poID = getIntValue(row.getCell(37));
					 
					 String psGrp = row.getCell(38).getStringCellValue();
					 int cstCntr = getIntValue(row.getCell(39));
					 String reqMailID = row.getCell(40).getStringCellValue();
					 int reqID = getIntValue(row.getCell(41));
					 
					 java.util.Date skillBegDate1 = new java.util.Date();
					 endDate1 = getDateValue(row.getCell(42));
					 Date skillBegDate = new Date(skillBegDate1.getTime());
					
					 java.util.Date skillEndDate1 = new java.util.Date();
					 endDate1 = getDateValue(row.getCell(43));
					 Date skillEndDate = new Date(skillEndDate1.getTime());
					
        			 java.util.Date skillStartDate1 = new java.util.Date();
					 endDate1 = getDateValue(row.getCell(44));
					 Date skillStartDate = new Date(skillStartDate1.getTime());
					 
					 String subID = row.getCell(45).getStringCellValue();
					 String subName = row.getCell(46).getStringCellValue();
					 
					 int trNo = getIntValue(row.getCell(47));
					 String sbu = row.getCell(48).getStringCellValue();
					 String vertical = row.getCell(49).getStringCellValue();
					 String pract = row.getCell(50).getStringCellValue();
					 String subPract = row.getCell(51).getStringCellValue();
					 
					 char modelType = 0;
					 if (!row.getCell(52).getStringCellValue().equals(null))
					 {
						 modelType = row.getCell(52).getStringCellValue().charAt(0);
					 }
					 String trngType = row.getCell(53).getStringCellValue();
					 
					
					 
				 }
				
				
				
				
				
				
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "Error";
		}
		
		
		
		
		
		
		return null;
	}

	
	
	private int getIntValue(XSSFCell cell) {
		int val = 0;
		int dataType = cell.getCellType();
		switch(dataType) {
			case Cell.CELL_TYPE_NUMERIC :
				val = (int) cell.getNumericCellValue();
				break;
				
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
