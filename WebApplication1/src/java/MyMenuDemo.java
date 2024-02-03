import java.io.*;
import java.sql.*;
import javax.servlet.http.*;
import javax.servlet.*;

public class MyMenuDemo extends HttpServlet
{
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		PrintWriter out= response.getWriter();
		out.println("<html>");
		out.println("<head>");
//                Cookie ck[]=request.getCookies();
                HttpSession session= request.getSession();
                String s=(String)session.getAttribute("uname");
                if(s!=null)
                {
		out.println("<link rel='stylesheet' href='abc.css' />");
		out.println("</head>");
		out.println("<body>");
                out.println("<div id='mymenu'><ul><li>Home</li><li><a href='insdemo.html'>Insert</a></li><li><a href='showall'>ShowAll</a></li><li><a href='searchdemo.html'>Search</a></li><li><a href='updatedemo.html'>Update</a></li><li><a href='deletedemo.html'>Delete</a></li><li><a href='LogoutDemo'>Logout</a></li><li>Contact</li></ul></div>"); 
		out.println("welcome "+s);
                }
                else
                {
		response.sendRedirect("login.html");
                }
		out.println("</body>");
		out.println("</html>");
		out.close();
	}	
}