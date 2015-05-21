package bac;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Login
 */
@WebServlet("/postWord")
public class PostWord extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PostWord() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		login(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		login(request, response);

	}
	
	private void login(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(request.getServletContext().getAttribute("postedWord")!=null){
			request.setAttribute("errorMsg", "There is already a word in session");
			request.getRequestDispatcher("/guesser.jsp").forward(request, response);
			return;
		}
		String postedWord = request.getParameter("word");
		if(postedWord==null || postedWord.length()<4){
			request.setAttribute("errorMessage", "Enter a four letter word");
			request.getRequestDispatcher("/enterWord.jsp").forward(request, response);
			return;
		}
		postedWord = postedWord.toUpperCase();
		String dictionary = (String)request.getServletContext().getAttribute("dictionary");
		if(dictionary.indexOf(postedWord)<0){
			request.setAttribute("errorMessage", "Not a valid word. Please enter valid words only!!");
			request.getRequestDispatcher("/enterWord.jsp").forward(request, response);
			return;
		}

		request.getServletContext().setAttribute("postedWord", postedWord);
		request.getRequestDispatcher("/guesser.jsp").forward(request, response);
	}

}
