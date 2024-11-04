package com.smart.working;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Status
 */
public class Status extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Status() {
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
		try
		{
			Connection con = ConnetDB.getConnect();
		    String qaz=Test.getDepartment();
		    String status =request.getParameter("status");
			PreparedStatement ps7=con.prepareStatement("update complain set status =? where department=? ");
			ps7.setString(1, status);
			ps7.setString(2, qaz);
			
			int i=ps7.executeUpdate();
			if(i>0)
			{ 
				
				response.sendRedirect("welcomedepartment.html");	
			}
			
			else
			{
				response.sendRedirect(" status.html");
			}
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}

}
