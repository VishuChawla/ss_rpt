package com.wipro.Report.DAO;

import java.util.ArrayList;

import com.wipro.Report.bean.AccountBean;
import com.wipro.Report.bean.EmployeeBean;
import com.wipro.Report.bean.ProjectBean;
import com.wipro.Report.bean.SkillBean;
import com.wipro.Report.bean.TargetBean;

public interface WFTReportDAO {
	 String uploadSkills(ArrayList<SkillBean> listSkillBean);
	 String uploadProjects(ArrayList<ProjectBean> listProjectBean);
	 String uploadAccounts(ArrayList<AccountBean> listAccountBean);
	 String uploadEmployee(ArrayList<EmployeeBean> listEmployeeBeans);
	 String uploadTarget(ArrayList<TargetBean> listTargetBeans);
}
