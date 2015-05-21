package bac;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Login
 */
@WebServlet("/guessIt")
public class Guesser extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Guesser() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		handle(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		handle(request, response);

	}
	
	private void handle(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ServletContext application = request.getServletContext();
		String guess = request.getParameter("word");
		if(guess==null || guess.length()<4){
			request.setAttribute("errorMessage", "Enter a four letter word");
			request.getRequestDispatcher("/guesser.jsp").forward(request, response);
			return;
		}
		guess = guess.toUpperCase();
		String dictionary = (String)application.getAttribute("dictionary");
		if(dictionary.indexOf(guess)<0){
			request.setAttribute("errorMessage", "Not a valid word. Please enter valid words only!!");
			request.getRequestDispatcher("/guesser.jsp").forward(request, response);
			return;
		}
		String pw = (String)application.getAttribute("postedWord");
		pw=pw.toUpperCase();
		
		
		if(pw==null){
			request.getRequestDispatcher("/enterWord.jsp").forward(request, response);
			return;
		}
		Attempt attempt = new Attempt();
		attempt.setGuessedBy((String)request.getSession().getAttribute("userId"));
		attempt.setWord(guess);
		List<Attempt> attempts = (List<Attempt>)application.getAttribute("attempts");
		if(attempts==null){
			attempts = new ArrayList<Attempt>();
			application.setAttribute("attempts", attempts);
		}
		attempts.add(attempt);
		int bulls=0,cows=0;
		for(int i=0;i<pw.length();i++){
			boolean matched = false;
			int index = 0;
			if(guess.charAt(i)==pw.charAt(i)){
				bulls++;
				matched=true;
				index = i;
			}
			if(matched){
				pw=pw.substring(0,index)+" " + pw.substring(index+1);
			}
		}
		
		for(int i=0;i<pw.length();i++){
			boolean matched = false;
			int index = 0;
			if(pw.indexOf(guess.charAt(i))>-1){
				index = pw.indexOf(guess.charAt(i));
				cows++;
				matched=true;
			}
			if(matched){
				pw=pw.substring(0,index)+" " + pw.substring(index+1);
			}
		}

		attempt.setBulls(bulls);
		attempt.setCows(cows);
		
		if(bulls==pw.length()){
			//success
			application.removeAttribute("postedWord");
			application.removeAttribute("attempts");
			request.setAttribute("successMsg", "Bingo!!! Found the word in "+attempts.size()+" attempts.");
			request.getRequestDispatcher("/enterWord.jsp").forward(request, response);
			
		}else{
			request.getRequestDispatcher("/guesser.jsp").forward(request, response);
		}
	}

}
