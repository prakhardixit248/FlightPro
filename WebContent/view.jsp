<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
pageEncoding="ISO-8859-1" import="java.io.IOException,java.util.List,org.hibernate.Session,org.hibernate.SessionFactory,org.hibernate.Transaction,org.hibernate.cfg.Configuration,com.nagarro.controller.Store,com.nagarro.model.Flight,com.nagarro.controller.*"
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%
String dept_loc, arrival_loc, date, fclass;

int choiceCode;

dept_loc=request.getParameter("dept").toUpperCase().trim();

arrival_loc=request.getParameter("arrv").toUpperCase().trim();

date=request.getParameter("date").trim();

String abc[]=date.split("[//-]");

date=abc[2]+"-"+abc[1]+"-"+abc[0];

choiceCode=Integer.parseInt(request.getParameter("choice").trim());

fclass=request.getParameter("fclass").toUpperCase().trim();

SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
Session hibsession = sessionFactory.openSession();
Transaction t=hibsession.beginTransaction();
List<Flight> list=hibsession.createQuery("from Flight f where f.departLoc='"+dept_loc+"' and f.arrivalLoc='"+arrival_loc+"' and f.date='"+date+ "' and fclass like '"+fclass +"%'" ).list();
Sort sort=new Sort();
sort.sort(list, choiceCode);
%>
<table>
<tr>
<th>Flight Number</th>
<th>Fare</th>
<th>Duration</th>
<th>Date</th>
<th>Time</th>
<th>Class</th>
<th>Airlines</th>
</tr>
<%
for(Flight flight : list)
{
%>
<tr>
<td><%out.print(flight.getFlightNum()); %></td>
<td><%out.print(flight.getFare()); %></td>
<td><%out.print(flight.getDuration()); %></td>
<td><%out.print(flight.getDate()); %></td>
<td><%out.print(flight.getTime()); %></td>
<td><%out.print(flight.getFclass()); %></td>
<td><%out.print(flight.getFilename()); %></td>
</tr>
<%}%>

</table>
</body>
</html>