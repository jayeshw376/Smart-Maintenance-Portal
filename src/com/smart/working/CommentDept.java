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
 * Servlet implementation class CommentDept
 */
public class CommentDept extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CommentDept() {
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
		    String abc=Test.getUemail();
		    String comment =request.getParameter("comment");
			PreparedStatement ps7=con.prepareStatement("update complain set comment =? where uemail=? ");
			ps7.setString(1, comment);
			ps7.setString(2, abc);
			
			int i=ps7.executeUpdate();
			if(i>0)
			{ 
				
				response.sendRedirect("userown.jsp");	
			}
			
			else
			{
				response.sendRedirect(" commentdept.html");
			}
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}

}
