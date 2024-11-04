package com.smart.working;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class HelpLine
 */
public class HelpLine extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public HelpLine() {
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
		doGet(request, response);
		String name=request.getParameter("name");
		String contact=request.getParameter("contact");

		try
		{
			Connection con = ConnetDB.getConnect();
			PreparedStatement ps1=con.prepareStatement("insert into help values(?,?)");
			ps1.setString(1, name);
			ps1.setString(2, contact);
		
			
			int i=ps1.executeUpdate();
			if(i>0)
			{
			response.sendRedirect("welcomeadmine.html");
			}
			else
			{
				response.sendRedirect("helpline.html");
			}
		}
		catch(Exception e)
		{
			System.out.println(e);
		}

	}

}
