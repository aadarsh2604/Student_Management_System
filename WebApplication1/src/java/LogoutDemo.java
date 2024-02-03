import java.io.*;
import java.sql.*;
import javax.servlet.http.*;
import javax.servlet.*;

public class LogoutDemo extends HttpServlet
{
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
//		Cookie ck= new Cookie("uname","");
//                ck.setMaxAge(0);
//                response.addCookie(ck);
                HttpSession session= request.getSession();
                session.invalidate();
                response.sendRedirect("login.html");
	}	
}