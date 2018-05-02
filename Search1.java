package cs320.lab11;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cs320.lab11.EmployeesEntry;
/**
 * Servlet implementation class Search1
 */
@WebServlet("/Search1")
public class Search1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Search1() {
        super();
        // TODO Auto-generated constructor stub
    }
   
    public void init( ServletConfig config ) throws ServletException
    {
        super.init( config );

        try
        {
            Class.forName( "com.mysql.jdbc.Driver" );
        }
        catch( ClassNotFoundException e )
        {
            throw new ServletException( e );
        }
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
                ResultSet rs = stmt.executeQuery( "select * from Employees where sex='f' and annual_salary > '$40,000'" );
                
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
            request.getRequestDispatcher("/WEB-INF/Search1.jsp").forward(
            		request, response);
            
        }

        protected void doPost( HttpServletRequest request,
            HttpServletResponse response ) throws ServletException, IOException
        {
            doGet( request, response );
        }
}
