package com.smart.working;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//import .service.ConnetDB;

/**
 * Servlet implementation class DepartmentLogin
 */
public class DepartmentLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DepartmentLogin() {
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
		String demail=request.getParameter("demail");
		String dpassword=request.getParameter("dpassword");
		try
		{
			Connection con = ConnetDB.getConnect();
			PreparedStatement ps8=con.prepareStatement("select * from adddep where demail=? and dpassword = ? ");
			ps8.setString(1, demail);
			ps8.setString(2, dpassword);
			ResultSet rs8=ps8.executeQuery();
			if(rs8.next())
			{ 
				Test.setDepartment((rs8.getString(3)));
				response.sendRedirect("welcomedepartment.html");	
			}
			
			else
			{
				response.sendRedirect("departmentlogin.html");
			}
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}

}
