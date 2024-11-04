<%@ page import ="com.smart.working.*"  %>
<%@ page import ="java.sql.*"  %>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<% 
  String demail = request.getParameter("demail");
try
	{
		Connection con = ConnetDB.getConnect();
		PreparedStatement ps2= con.prepareStatement("Delete from adddep where demail=?");
		ps2.setString(1, demail);
		int i=ps2.executeUpdate();
		if(i>0)
		{
		response.sendRedirect("viewdpt.jsp");
		}
		else
		{
			response.sendRedirect("welcomeadmine.html");
		}
	}
	catch(Exception e)
	{
	 e.printStackTrace();	
	}
	
	%>

</body>
</html>