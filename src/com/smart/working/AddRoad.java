package com.smart.working;
import java.util.Date;
import java.io.IOException;
import java.sql.*;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class AddRoad
 */
public class AddRoad extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddRoad() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		String roadname=request.getParameter("roadname");
		String location=request.getParameter("location");
		String departname=request.getParameter("departname");
		 String deadlinedate=request.getParameter("deadlinedate");
		
		try
		{
			Connection con = ConnetDB.getConnect();
			PreparedStatement ps4=con.prepareStatement("insert into roadmain values(?,?,?,?)");
			ps4.setString(1,roadname );
			ps4.setString(2, location);
			ps4.setString(3, departname );
			ps4.setString(4, deadlinedate);
			
			int i=ps4.executeUpdate();
			if(i>0)
			{
			response.sendRedirect("welcomeadmine.html");
			}
			else
			{
				response.sendRedirect("addroad.html");
			}
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}

}
