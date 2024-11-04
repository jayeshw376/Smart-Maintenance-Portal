package com.smart.working;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class AddComplain
 */
public class AddComplain extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddComplain() {
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
//		String status=request.getParameter("status");

		try
		{
			Connection con = ConnetDB.getConnect();
			PreparedStatement ps8=con.prepareStatement("insert into complain (title,description,department,date,pendingtask,completetask,uemail,demail) values(?,?,?,?,?,?,?,?)");
			ps8.setString(1, title);
			ps8.setString(2, description);
			ps8.setString(3, department);
			ps8.setString(4, date);
			ps8.setString(5, pendingtask);
			ps8.setString(6, completetask);
			ps8.setString(7, uemail);
			ps8.setString(8, demail);
//			ps8.setString(9, status);
			
			int i=ps8.executeUpdate();
			if(i>0)
			{
			response.sendRedirect("welcomeuser.html");
			}
			else 
			{
				response.sendRedirect("addcomplain.html");
			}
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}

}
