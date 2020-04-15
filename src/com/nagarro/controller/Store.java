package com.nagarro.controller;
import java.util.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import com.nagarro.model.*;
import com.opencsv.*;
import java.io.*;
import org.hibernate.Transaction;
public class Store 
{
	public void store() throws Exception
	{

	      File f = null;
	      File[] paths = null;
	      Flight flight;
	      CSVReader reader;
	      SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
	      Session session = sessionFactory.openSession();
	      Transaction t;
	      
	      f = new File("E:\\eclipse-workspace\\FlightPro\\src\\FlightInformation\\");
	                                 
	      paths = f.listFiles();
	        
	        for(File st : paths)
	        {
	        	
	        	reader = new CSVReader(new FileReader(st.getAbsolutePath()),'|');

	        	
	        	List<String[]> records = reader.readAll();
	 		
	 		
	        	String fs[];

	        	Iterator<String[]> iterator = records.iterator();
	        	iterator.next();
	 		
	        	while (iterator.hasNext()) 
	        	{
	        		String[] record = iterator.next();
	        		if(record[7].equalsIgnoreCase("Y")) //Saving Flight Data Only if Seat_Availability is Y Else Discarding
	        		{
	        			t=session.beginTransaction();
		        		flight = new Flight();
		        		flight.setFlightNum(record[0]);
		        		flight.setDepartLoc(record[1]);
		        		flight.setArrivalLoc(record[2]);
		        		flight.setDate(record[3]);
		        		flight.setTime(record[4]);
		        		flight.setDuration(record[5]);
		        		flight.setFare(Integer.parseInt(record[6]));
		        		flight.setAvail(record[7]);
		        		flight.setFclass(record[8]);
		        		
		        		fs=st.getName().split("[//.]");
		        		flight.setFilename(fs[0]);
		        		
		        		session.save(flight);
		        		
		        		t.commit();
		        		
	        		}	
	 		   }
	        	
	     }
	        session.close();
	        	
	}
}
