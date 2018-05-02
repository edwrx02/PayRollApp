package cs320.lab11;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
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

import cs320.Final.BluRayBean;
import cs320.Final.CDBean;
import cs320.Final.DVDBean;
import cs320.lab11.EmployeesEntry;

@WebServlet("/SearchId")
public class SearchId extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SearchId() {
        super();
        // TODO Auto-generated constructor stub
    }

    protected void doGet( HttpServletRequest request,
	        HttpServletResponse response ) throws ServletException, IOException
	    {
	       request.getRequestDispatcher("/WEB-INF/SearchId.jsp").forward(request, response);
	    }

	   
    @SuppressWarnings("unchecked")
	    protected void doPost( HttpServletRequest request,
	        HttpServletResponse response ) throws ServletException, IOException
	    {
	    	
	    	
//	    	Boolean emp = false;
//	    	if ( request.getParameter("employee_id") != null 
//					|| request.getParameter("employee_id").trim().length() == 0 ){
//	    		emp = true;
//	    	}
//	    	
//	    	 if(emp == true){
//            	 response.sendRedirect( "DeleteEmployees" );
//            }
	    	
	    	// get the user input
	      
	        Integer employee_id = Integer.parseInt(request.getParameter("employee_id"));
	        
	        Boolean match = false;
	        List<EmployeesEntry> entries = new ArrayList<EmployeesEntry>();
	        Connection c = null;
	        try
	        {
	            String url = "jdbc:mysql://localhost/cs320stu75";
	            String username = "cs320stu75";
	            String password = "vLfwnZ.*";

	            c = DriverManager.getConnection( url, username, password );
	            
	            
	            Statement stmt = c.createStatement();
	            ResultSet rs = stmt.executeQuery( "select *from Employees");
	            
	           
	            while(rs.next()){
		            
	            	if(employee_id == rs.getInt("emp_id")){
	            				EmployeesEntry entry = new EmployeesEntry(
	                			rs.getInt("emp_id"),rs.getString( "last_name"),rs.getString( "hire_date" ), 
	                			rs.getString( "birth_date"),rs.getString( "sex"),rs.getString( "job_status"),
	                			rs.getString( "pay_type"),rs.getString( "annual_salary"),rs.getInt( "years_service"));
	            				entries.add(entry);	
	            	}
	            	
	            }
	            
	            
	            while( rs.next() )
	            {
	            	if(employee_id == rs.getInt("emp_id")){
	            		match = true;
	            	}
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

	        // send the user back to the guest book page
	        
	     
           	
	       request.setAttribute("entries", entries);
	        request.getRequestDispatcher("/WEB-INF/ShowId.jsp").forward(
	            		request, response);
	        
	        
	
	        
	    }

	}


