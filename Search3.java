package cs320.lab11;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cs320.lab11.EmployeesEntry;

@WebServlet("/Search3")
public class Search3 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Search3() {
        super();
        // TODO Auto-generated constructor stub
    }

    protected void doGet( HttpServletRequest request,
            HttpServletResponse response ) throws ServletException, IOException
        {
        	List<EmployeesEntry> entries = new ArrayList<EmployeesEntry>();
            Connection c = null;
            try
            {
                String url = "jdbc:mysql://localhost/cs320stu75";
                String username = "cs320stu75";
                String password = "vLfwnZ.*";

               c = DriverManager.getConnection( url, username, password );
                Statement stmt = c.createStatement();
                ResultSet rs = stmt.executeQuery( "SELECT *, Employees.last_name FROM Employees INNER JOIN (SELECT last_name FROM Employees "
                		+ "GROUP BY last_name HAVING count(Emp_Id) > 1) dup ON Employees.last_name = dup.last_name where annual_salary > '$100,000'" );
                
                while( rs.next() )
                {
                	EmployeesEntry entry = new EmployeesEntry(
                			rs.getInt("emp_id"),rs.getString( "last_name"),rs.getString( "hire_date" ), 
                			rs.getString( "birth_date"),rs.getString( "sex"),rs.getString( "job_status"),
                			rs.getString( "pay_type"),rs.getString( "annual_salary"),rs.getInt( "years_service"));
                	entries.add(entry);
                	}
            }
            catch( SQLException e )
            {
                throw new ServletException( e );
            }
            finally
            {
            	try
            	{
            			if( c != null) c.close();
            	}
            	catch( SQLException e)
            	{
            		throw new ServletException(e);
            	}
            }
        	request.setAttribute("entries", entries);
            request.getRequestDispatcher("/WEB-INF/Search3.jsp").forward(
            		request, response);
            
        }

        protected void doPost( HttpServletRequest request,
            HttpServletResponse response ) throws ServletException, IOException
        {
            doGet( request, response );
        }
}

