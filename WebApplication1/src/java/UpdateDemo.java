import java.io.*;
import java.sql.*;
import javax.servlet.http.*;
import javax.servlet.*;

public class UpdateDemo extends HttpServlet
{
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		PrintWriter out= response.getWriter();
                String s1=request.getParameter("u1");
		out.println("<html>");
		out.println("<head>");
		out.println("<link rel='stylesheet' href='abc.css' />");
		out.println("</head>");
		out.println("<body>");
        out.println("<div id='mymenu'><ul><li>Home</li><li><a href='insdemo.html'>Insert</a></li><li><a href='showall'>ShowAll</a></li><li><a href='searchdemo.html'>Search</a></li><li><a href='updatedemo.html'>Update</a></li><li><a href='deletedemo.html'>Delete</a></li><li>About</li><li>Contact</li></ul></div>"); 
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql:///abhidb?allowPublicKeyRetrieval=true&useSSL=FALSE","root","root");
			Statement st=con.createStatement();
			ResultSet rs=st.executeQuery("select * from insmarks where URNO='"+s1+"'");
		    out.println("<center>");
                    out.println("<form action='UpdateDemo1'>");
		    out.println("<table cellpadding='12' border=1>");
		  	if(rs.next())
			{
				out.println("<tr>");
                                out.println("<th>RNO</th>");
				out.println("<td><input type='text' value='"+rs.getString(1)+"' name='u1'></td>");
				out.println("</tr>");
                                out.println("<tr>");
                                out.println("<th>NAME</th>");
                                out.println("<td><input type='text' value='"+rs.getString(2)+"' name='u2'></td>");
		                out.println("</tr>");
                                out.println("<tr>");
                                out.println("<th>PHY</th>");
                                out.println("<td><input type='text' value='"+rs.getString(3)+"' name='u3'></td>");
	                        out.println("</tr>");
                                out.println("<tr>");
                                out.println("<th>CHE</th>");	
                                out.println("<td><input type='text' value='"+rs.getString(4)+"' name='u4'></td>");
		                out.println("</tr>");
                                out.println("<tr>");
                                out.println("<th>MATHS</th>");
                                out.println("<td><input type='text' value='"+rs.getString(5)+"' name='u5'></td>");
				out.println("</tr>");
                                out.println("<tr>");
                                out.println("<th colspan='2'><input type='submit' value='Update' class='B'></td>");
				out.println("</tr>");
			}
                        else
                        {
                               out.println("invalid username or password");
                        }
		    out.println("</table>");
                    out.println("</form>");
			out.println("</center>");
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