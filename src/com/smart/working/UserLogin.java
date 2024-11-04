package com.smart.working;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class UserLogin
 */
public class UserLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserLogin() {
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
		String username=request.getParameter("username");
		String password=request.getParameter("password");
		try
		{
			Connection con = ConnetDB.getConnect();
			PreparedStatement ps7=con.prepareStatement("select * from user where username=? and password = ? ");
			ps7.setString(1, username);
			ps7.setString(2, password);
			ResultSet rs8=ps7.executeQuery();
			if(rs8.next())
			{ 
				Test.setUemail(rs8.getString(1));
				response.sendRedirect("welcome.html");	
			}
			
			else
			{
				response.sendRedirect("userlogin.html");
			}
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}

}
