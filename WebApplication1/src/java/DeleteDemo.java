import java.io.*;
import java.sql.*;
import javax.servlet.http.*;
import javax.servlet.*;

public class DeleteDemo extends HttpServlet
{
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		PrintWriter out= response.getWriter();
		out.println("<html>");
		out.println("<head>");
		String s1=request.getParameter("u1");
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql:///abhidb?allowPublicKeyRetrieval=true&useSSL=FALSE","root","root");
			Statement st=con.createStatement();
			st.executeUpdate("delete from insmarks where URNO='"+s1+"'");
			response.sendRedirect("showall");
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