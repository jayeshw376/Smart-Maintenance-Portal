package com.smart.working;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class DeptReply
 */
public class DeptReply extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeptReply() {
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
		    String abc=Test.getDepartment();
		    String def=Test.getUemail();
		    String reply =request.getParameter("reply");
			PreparedStatement ps7=con.prepareStatement("update complain set reply=?  where department=? and uemail=?");
			ps7.setString(1, reply);
			ps7.setString(2, abc);
			ps7.setString(3, def);
			
			int i=ps7.executeUpdate();
			if(i>0)
			{ 
				
				response.sendRedirect("owndeptc.jsp");	
			}
			
			else
			{
				response.sendRedirect("depreply.html");
			}
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}

}
