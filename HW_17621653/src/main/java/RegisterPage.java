

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.User;
import repository.UserRepository;

/**
 * Servlet implementation class RegisterPage
 */
@WebServlet("/RegisterPage")
public class RegisterPage extends HttpServlet {
	private static final long serialVersionUID = 1L;
      
    public RegisterPage() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");
		String firstName = request.getParameter("first_name");
		String lastName = request.getParameter("last_name");
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		User user = new User(firstName, lastName, email, password);
		if(!UserRepository.contains(user)) {
			UserRepository.addUser(user);
			RequestDispatcher rd=request.getRequestDispatcher("register_success.html");  
	        rd.forward(request,response);  
		}
		else {
			RequestDispatcher rd=request.getRequestDispatcher("register_failed.html");  
	        rd.forward(request,response); 
		}
		
	}
	

}
