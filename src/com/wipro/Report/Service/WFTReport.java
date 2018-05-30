package com.wipro.Report.Service;

import java.io.IOException;
import java.io.InputStream;

public interface WFTReport {

	public String readFromExcel(InputStream inpStream) throws IOException;
}
