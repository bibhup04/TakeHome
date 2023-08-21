package com.learning.hello;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;

import org.apache.jasper.tagplugins.jstl.core.Out;

/**
 * Servlet implementation class Fibonacci
 */
public class Fibonacci extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Fibonacci() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		try {
		      Map<String, String[]> parameterMap = req.getParameterMap();
		      parameterMap.entrySet().stream().forEach(entry -> {
		        System.out.print("key: " + entry.getKey());
		        System.out.print(" values: " + Arrays.toString(entry.getValue()) + "\n");
		      });
		      ArrayList<Integer> fibSer = new ArrayList<>();
		      
		      PrintWriter out = resp.getWriter();
		      String userName = parameterMap.get("n")[0];
		      int num=Integer.valueOf(parameterMap.get("n")[0]);
		      fibSer = fibon(num);
		      out.println(String.format("<h1>FIbonacci series for %s is, %s!</h1>", num,fibSer));
		      
		    } catch (IOException e) {
		      // TODO Auto-generated catch block
		      e.printStackTrace();
		    }
		
		
	}
	public ArrayList fibon(int x) {
		ArrayList<Integer> arr = new ArrayList<>();
		int a =0;
		int b = 1;
		int c;
		arr.add(a);
		arr.add(b);
		while(x>1) {
			c= a+b;
			a=b;
			b=c;
			x-=1;
			arr.add(c);
		}
		return arr;
	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	 @Override
	  protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	    PrintWriter out = response.getWriter();
	      int limit = Integer.valueOf(request.getParameter("formLimit"));
	      out.println(String.format("<p>%s</p>", fibon(limit)));
	  }

}
