package com.smart.working;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class UserRegis
 */
public class UserRegis extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserRegis() {
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
		String uemail=request.getParameter("uemail");
		String upassword=request.getParameter("upassword");
		String name=request.getParameter("name");
		String mobile=request.getParameter("mobile");
		String address=request.getParameter("address");

		try
		{
			Connection con = ConnetDB.getConnect();
			PreparedStatement ps5=con.prepareStatement("insert into userdet values(?,?,?,?,?)");
			ps5.setString(1, uemail);
			ps5.setString(2, upassword);
			ps5.setString(3, name);
			ps5.setString(4, mobile);
			ps5.setString(5, address);
			
			
			int i=ps5.executeUpdate();
			if(i>0)
			{
			response.sendRedirect("welcomeuser.html");
			}
			else
			{
				response.sendRedirect("userregis.html");
			}
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}

}
