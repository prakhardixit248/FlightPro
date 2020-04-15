package com.nagarro.controller;
import java.text.SimpleDateFormat;

import java.util.Date;
import java.text.ParseException;
public class Validation
{
	String dept_loc,arrival_loc,date;
    int choiceCode;

    
	public Validation(String dept_loc, String arrival_loc, String date, int choiceCode) 
	{
		super();
		this.dept_loc = dept_loc;
		this.arrival_loc = arrival_loc;
		this.date = date;
		this.choiceCode = choiceCode;
	}

	public boolean validateLocation()
	{
		if(dept_loc.length()==3 && arrival_loc.length()==3)
			return true;
		System.out.println("Wrong Location Code");
		
		return false;
	}
	
	public boolean validate()
	{
		
		return validateJavaDate(date) && validateChoiceCode() && validateLocation();
			
	}
	public boolean validateChoiceCode() 
	{
		if(choiceCode==1 || choiceCode==2)
		{
			
			return true;
			
		}
		System.out.println("Wrong choiceCode ");
		
		return false;
	}


	public static boolean validateJavaDate(String strDate)
	   {
	
		if (strDate.trim().equals(""))
		{
		    return false;
		}
	
		else
		{
		    SimpleDateFormat sdfrmt = new SimpleDateFormat("dd-mm-yyyy");
		    sdfrmt.setLenient(false);
		    
		    try
		    {
		        Date javaDate = sdfrmt.parse(strDate); 
		    }
		    
		    catch (ParseException e)
		    {
		        System.out.println(strDate+" is Invalid Date format");
		        
		        return false;
		    }
		    
		    return true;
		}
}
}