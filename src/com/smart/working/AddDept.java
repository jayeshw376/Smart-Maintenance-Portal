package com.smart.working;

import java.io.IOException;
import java.sql.*;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



/**
 * Servlet implementation class AddDept
 */
public class AddDept extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddDept() {
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
		String dpassword=request.getParameter("deppassword");
		String dname=request.getParameter("depname");
		String taluka=request.getParameter("taluka");
		String district=request.getParameter("district");
		String address=request.getParameter("address");
		String mobile=request.getParameter("mobile");
		try
		{
			Connection con = ConnetDB.getConnect();
			PreparedStatement ps1=con.prepareStatement("insert into adddep values(?,?,?,?,?,?,?)");
			ps1.setString(1, demail);
			ps1.setString(2, dpassword);
			ps1.setString(3, dname);
			ps1.setString(4, taluka);
			ps1.setString(5, district);
			ps1.setString(6, address);
			ps1.setString(7, mobile);
			
			int i=ps1.executeUpdate();
			if(i>0)
			{
			response.sendRedirect("welcomeadmine.html");
			}
			else
			{
				response.sendRedirect("adddept.html");
			}
		}
		catch(Exception e)
		{
			System.out.println(e);
		}


	}

}
