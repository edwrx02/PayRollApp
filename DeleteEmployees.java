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

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class DeleteEmployees
 */
@WebServlet("/DeleteEmployees")
public class DeleteEmployees extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteEmployees() {
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
	       request.getRequestDispatcher("/WEB-INF/DeleteEmployees.jsp").forward(request, response);
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
	        
	        Connection c = null;
	        try
	        {
	        	  String url = "jdbc:mysql://localhost/cs320stu75";
		            String username = "cs320stu75";
		            String password = "vLfwnZ.*";

	            c = DriverManager.getConnection( url, username, password );
	            
	            
	            Statement stmt = c.createStatement();
	            ResultSet rs = stmt.executeQuery( "select *from Employees");
	            
	           
	            while( rs.next() )
	            {
	            	if(employee_id == rs.getInt("emp_id")){
	            		match = true;
	            	}
	            }
	        
	            if(match == false){
	            	 response.sendRedirect( "DeleteEmployees" );
	            }
	            
	            
	            
	           // String sql = "Delete from employees where Emp_Id values (?)";
	         //   c = DriverManager.getConnection( url, username, password );
	            
	            PreparedStatement pstmt = c.prepareStatement("delete from Employees where Emp_Id = ?");
	            pstmt.setInt(1, employee_id);
	            pstmt.execute();   
	            pstmt.close();
	            
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
	        if(match == true){
	        response.sendRedirect( "Employees" );
	        }
	    }

	}
