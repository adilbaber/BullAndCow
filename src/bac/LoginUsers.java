package bac;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Login
 */
@WebServlet("/loginUser")
public class LoginUsers extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginUsers() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		process(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		process(request, response);

	}
	
	private void process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<User> userList = new ArrayList<User>();
		userList.add(new User("Thirunavukkarasu", "Kirubanandam", "TK"));
		userList.add(new User("Adil", "Mohammad", "AM"));
		userList.add(new User("Sunayana", "Vaghela", "SRV"));
		userList.add(new User("Thais", "Firminos", "TF"));
		userList.add(new User("Bhabani", "Padhi", "BP"));
		response.setContentType("application/json");
		PrintWriter out = response.getWriter();
		String o = userList.toString();
		out.print(o);
		out.flush();
		return;
	}

}
