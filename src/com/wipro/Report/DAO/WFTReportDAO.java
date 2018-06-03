package com.wipro.Report.DAO;

import java.util.ArrayList;

import com.wipro.Report.bean.AccountBean;
import com.wipro.Report.bean.ProjectBean;
import com.wipro.Report.bean.SkillBean;

public interface WFTReportDAO {
	 String uploadSkills(ArrayList<SkillBean> listSkillBean);
	 String uploadProjects(ArrayList<ProjectBean> listProjectBean);
	String uploadAccounts(ArrayList<AccountBean> listAccountBean);
}
