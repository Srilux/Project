package com.app;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class RegisterServlet
 */
@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegisterServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	response.setContentType("text/html");
	PrintWriter out = response.getWriter();
	String userId=request.getParameter("userId");
	String name=request.getParameter("name");
	String email=request.getParameter("email");
	String country=request.getParameter("country");
	String password=request.getParameter("password");
		
	try {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/register","root","root");
		String query ="insert into register_user values('"+userId+"','"+name+"','"+email+"','"+country+"','"+password+"')";
		Statement st = conn.createStatement();
		int status = st.executeUpdate(query);
	if(status!=0) {
		out.print("<h1>Registration Successfully!</h1>");
	}else {
		out.print("<h1>Registration Failed!!</h1>");
	}
	st.close();
	conn.close();
	} catch (ClassNotFoundException e) {
		out.print("<h1>Something Wrong!</h1>");
		e.printStackTrace();
	} catch (SQLException e) {
		out.print("<h1>Something went Wrong!</h1>");
		e.printStackTrace();
    }
		
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
