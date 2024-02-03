import java.io.*;
import java.sql.*;
import javax.servlet.http.*;
import javax.servlet.*;

public class RegisDemo extends HttpServlet
{
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		PrintWriter out= response.getWriter();
		out.println("<html>");
		out.println("<head>");
		String s1=request.getParameter("un");
		String s2=request.getParameter("up");
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql:///abhidb?allowPublicKeyRetrieval=true&useSSL=FALSE","root","root");
			Statement st=con.createStatement();
			st.executeUpdate("insert into login values('"+s1+"','"+s2+"')");
			response.sendRedirect("login.html");
			con.close();
		}
		catch(Exception e)
		{
			out.println(e);
		}
		out.println("</html>");
		out.println("</head>");
		out.close();
	}
}