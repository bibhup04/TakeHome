package HigherLowerGame;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;

/**
 * Servlet implementation class HigerLowerServlet
 */
public class HigerLowerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public HigerLowerServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out = response.getWriter();
		Random random = new Random();
        int randomNumber = random.nextInt(1000);
        request.setAttribute("previousNo", randomNumber);
        out.println(String.format("<h1>'%s'</h1>",randomNumber));
        out.println("<button id = `Higher` onclick=`randonGuess(this.id);`>Higher</button>");
        out.println("<button id = `Lower` onclick=`randonGuess(this.id);`>Lower</button>");
        out.println("<script>");
        out.println("function randomGuess(buttonId) {");
        out.println(String.format("    var pervNo = '%d'",randomNumber));
        out.println("    var nextNo = Math.floor(Math.random() * 1000) + 1;");
        out.println("    console.log('Button clicked ' + buttonId + ' and prev no ' + pervNo + ' Next no-' + nextNo);");
        out.println("}");
        out.println("</script>");
//        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/HigherLower.html");
//        dispatcher.forward(request, response);
        //doGet(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//doGet(request, response);
		
		Random random = new Random();
        int randomNumber = random.nextInt(1000);
        request.setAttribute("previousNo", randomNumber);

        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/HigherLower.html");
        dispatcher.forward(request, response);
	}

}
