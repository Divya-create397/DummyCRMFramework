package com.GlobalLogistics.generic.WebDriverUtility;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;

public class JavaUtility
{
	public int getRandomNumber()
	{
		Random r=new Random();
		int randomInt=r.nextInt(5000);
		return randomInt;
	}
	
	public String getSystemDateYYYYMMDD()
	{
		Date d=new Date();
		SimpleDateFormat s=new SimpleDateFormat("YYYY-MM-DD");
		String date=s.format(d);
		return date;
	}
	
	public String getRequiredDateYYYYMMDD(int days)
	{
		Date d=new Date();
		//System.out.println(d.toString());
		SimpleDateFormat sim=new SimpleDateFormat("yyyy-MM-dd");
	
		Calendar cal=sim.getCalendar();
		cal.add(Calendar.DAY_OF_MONTH, days);
		String requiredDate=sim.format(cal.getTime());
		return requiredDate;
		
		
	}


}
