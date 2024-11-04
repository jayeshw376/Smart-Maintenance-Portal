package com.smart.working;

import java.io.IOException;
import java.sql.*;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import com.mysql.jdbc.ResultSet;

/**
 * Servlet implementation class Viewdpt
 */
public class Viewdpt extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Viewdpt() {
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
		String demail=request.getParameter("depemail");
		String dname=request.getParameter("depname");
		String taluka=request.getParameter("taluka");
		String district=request.getParameter("district");
		String address=request.getParameter("address");
		String mobile=request.getParameter("mobile");
		try
		{
			Connection con = ConnetDB.getConnect();
			PreparedStatement ps9=con.prepareStatement("select * from adddep");
			ResultSet rs9 = (ResultSet) ps9.executeQuery();
			
			while(rs9.next())
			{
		    rs9.getString("demail");
		    rs9.getString("dname");
		    rs9.getString("taluka");
		    rs9.getString("district");
		    rs9.getString("address") ;
		    rs9.getString("mobile");
		    if(rs9.next())
		    {
		    	response.sendRedirect("welcomeadmine.html");
		    }
		    else
		    {
		    	response.sendRedirect("viewdpt.jsp");
		    	
		    }
			}
			
		}
		catch(Exception e)
		{
			System.out.println(e);
		}

	}

}
