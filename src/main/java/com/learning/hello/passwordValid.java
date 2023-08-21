package com.learning.hello;

import jakarta.servlet.RequestDispatcher; 
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import org.apache.jasper.tagplugins.jstl.core.Out;

/**
 * Servlet implementation class passwordValid
 */
public class passwordValid extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public passwordValid() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		try {
			PrintWriter out = response.getWriter();
			String password = request.getParameter("pass");
			System.out.println("password is "+ password);
			Path path =Paths.get("/home/bibhu04/eclipse-workspace/WebPage/src/main/java/com/learning/hello/passwords.txt");
		    List<String> bannedPasswordList = Files.readAllLines(path);
			if(bannedPasswordList.contains(password)){
				out.println(String.format("<h1>'%s' is a banned password</h1>",password));
			}
				//out.println(String.format("<h1>'%s' is a banned password</h1>",password));
			else {
//				out.println("<h1>You have entered a strong password.</h1>");
				RequestDispatcher rd=request.getRequestDispatcher("WelcomeServlet");
				rd.forward(request, response);
			}
			} catch (IOException e) {
		      e.printStackTrace();
		    }

	}

	
	

}
