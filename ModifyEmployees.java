package cs320.lab11;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
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
 * Servlet implementation class ModifyEmployees
 */
@WebServlet("/ModifyEmployees")
public class ModifyEmployees extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ModifyEmployees() {
        super();
        // TODO Auto-generated constructor stub
    }

 
    protected void doGet( HttpServletRequest request,
            HttpServletResponse response ) throws ServletException, IOException
        {
            request.getRequestDispatcher( "/WEB-INF/ModifyEmployees.jsp" ).forward(
                request, response );
        }

        protected void doPost( HttpServletRequest request,
            HttpServletResponse response ) throws ServletException, IOException
        {
      	List<EmployeesEntry> entries = new ArrayList<EmployeesEntry>();
       
      	Integer employee_id = Integer.parseInt(request.getParameter("employee_id"));
  
            Connection c = null;
            try
            {

            	  String url = "jdbc:mysql://localhost/cs320stu75";
  	            String username = "cs320stu75";
  	            String password = "vLfwnZ.*";
                String sql = "select * from Employees where emp_id = ?";

                    c = DriverManager.getConnection( url, username, password );
                    PreparedStatement pstmt = c.prepareStatement( sql );
                    pstmt.setInt(1, employee_id);
                    ResultSet rs = pstmt.executeQuery();
                    if(!rs.next())
                    {
                    	System.out.println("There are no patients with that id.");
                    }
                    else // Found patient
                    {
                		EmployeesEntry entry = new EmployeesEntry(
            			rs.getInt("emp_id"),rs.getString( "last_name"),rs.getString( "hire_date" ), 
            			rs.getString( "birth_date"),rs.getString( "sex"),rs.getString( "job_status"),
            			rs.getString( "pay_type"),rs.getString( "annual_salary"),rs.getInt( "years_service"));
            	entries.add(entry);
                    }
                    getServletContext().setAttribute("entries", entries);
                
            }
            catch( SQLException e )
            {
                throw new ServletException( e );
            }
            finally
            {
                try
                {
                    if( c != null ) c.close();
                }
                catch( SQLException e )
                {
                    throw new ServletException( e );
                }
            }
            response.sendRedirect("ModifyFound");
            
            
        }

    }
