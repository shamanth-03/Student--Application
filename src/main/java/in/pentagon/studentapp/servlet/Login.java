package in.pentagon.studentapp.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Set;

import in.pentagon.studentapp.dao.StudentDAO;
import in.pentagon.studentapp.dao.StudentDAOImpl;
import in.pentagon.studentapp.dto.Student;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/login")
public class Login	extends HttpServlet {
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		StudentDAO sdao = new StudentDAOImpl();
		
		
		//PrintWriter out = resp.getWriter();
		String username = req.getParameter("Username");
		String pass = req.getParameter("Password");
		
		Student s = sdao.getStudent(username, pass);
		
		if(s != null) {
			//CREATING SESSION OBJECT
			HttpSession session= req.getSession(true);
			//out.println("<h1>Login Successfull!...Welcome "+s.getName()+"</h1>");
			session.setAttribute("student",s);
			req.setAttribute("success","Login Successful");
			RequestDispatcher rd = req.getRequestDispatcher("DashBoard.jsp");
			rd.forward(req, resp);
		}
		else {
			//out.println("<h1>Invalid login credentials...!</h1>");
			req.setAttribute("error","failed to login! ");
			RequestDispatcher rd = req.getRequestDispatcher("Login.jsp");
			rd.forward(req, resp);
		}
		
	}

}