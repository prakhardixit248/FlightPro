package com.nagarro.view;
import java.util.*;

import com.nagarro.controller.*;
import com.nagarro.model.*;
public class Display 
{
	public void display(ArrayList<Flight> list)
	{
		Iterator<Flight> iter=list.iterator();
		
		if(iter.hasNext())
			System.out.println("FlightNumber  |  fare   |   Duration   |    Date    |     Time   |   Class  |  AirLines");
		
		
		while(iter.hasNext())
		{
			Flight flight=iter.next();
			System.out.println(flight.toString());
		}
	}
}
