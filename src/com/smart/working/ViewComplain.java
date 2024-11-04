package com.smart.working;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mysql.jdbc.ResultSet;

/**
 * Servlet implementation class ViewComplain
 */
public class ViewComplain extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ViewComplain() {
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
		String title=request.getParameter("title");
		String description=request.getParameter("description");
		String department=request.getParameter("department");
		String date=request.getParameter("date");
		String pendingtask=request.getParameter("pendingtask");
		String completetask=request.getParameter("completetask");
		String uemail=request.getParameter("uemail");
		String demail=request.getParameter("demail");
		try
		{
			Connection con = ConnetDB.getConnect();
			PreparedStatement ps10=con.prepareStatement("select * from adddep");
			ResultSet rs10 = (ResultSet) ps10.executeQuery();
			
			while(rs10.next())
			{
		    rs10.getString("title");
		    rs10.getString("description");
		    rs10.getString("department");
		    rs10.getString("date");
		    rs10.getString("pendingtask") ;
		    rs10.getString("completetask");
		    rs10.getString("uemail");
		    rs10.getString("demail");
		    if(rs10.next())
		    {
		    	response.sendRedirect("welcomeuser.html");
		    }
		    else
		    {
		    	response.sendRedirect("viewcomplain.jsp");
		    	
		    }
			}
			
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}

}
