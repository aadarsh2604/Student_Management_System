import java.io.*;
import java.sql.*;
import javax.servlet.http.*;
import javax.servlet.*;

public class LoginDemo extends HttpServlet
{
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		PrintWriter out= response.getWriter();
		out.println("<html>");
		out.println("<head>");
		out.println("<link rel='stylesheet' href='abc.css' />");
		out.println("</head>");
		out.println("<body>");
		String s1=request.getParameter("un");
		String s2=request.getParameter("up");
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql:///abhidb?allowPublicKeyRetrieval=true&useSSL=FALSE","root","root");
			Statement st=con.createStatement();
			ResultSet rs=st.executeQuery("select * from login where UNAME='"+s1+"' AND UPASS='"+s2+"'");
			if(rs.next())
			{
//			    Cookie ck= new Cookie("uname","ram");
//                            ck.setMaxAge(60*60);
//                            response.addCookie(ck);
                            HttpSession session= request.getSession();
                            session.setAttribute("uname",s1);
                            response.sendRedirect("MyMenuDemo");
			}
			else
			{
				RequestDispatcher requestDispatcher;
 
            requestDispatcher=request.getRequestDispatcher("login.html");
            requestDispatcher.include(request, response);
				out.println("<div id='invalid'>invalid username or password</div>");
				
			}
		    con.close();
		}
		catch(Exception e)
		{
			out.println(e);
		}
		out.println("</body>");
		out.println("</html>");
		out.close();
	}
    	
}