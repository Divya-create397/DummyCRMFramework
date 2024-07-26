package com.GlobalLogistics.generic.FileUtility;

import java.io.FileInputStream;
import java.util.Properties;

public class FileUtility 
{
	public String getDataFromPropertiesFile(String key) throws Throwable
	{
		FileInputStream f=new FileInputStream("./src/main/resources/CommonData.properties");
		Properties p=new Properties();
		p.load(f);
		String data=p.getProperty(key);
		return data;
	}


}
