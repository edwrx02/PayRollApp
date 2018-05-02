package cs320.lab11;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/ModifyFound")
public class ModifyFound extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ModifyFound() {
        super();
        // TODO Auto-generated constructor stub
    }


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/WEB-INF/ModifyFound.jsp").forward(request, response);
	}


	    protected void doPost( HttpServletRequest request,
	            HttpServletResponse response ) throws ServletException, IOException
	        {
	    	
	    	Integer employee_id = Integer.parseInt(request.getParameter("emp_id"));
	    	String last_name = request.getParameter("last_name");
	    	String hire_date = request.getParameter("hire_date");
			String birth_date = request.getParameter("birth_date");
			String sex = request.getParameter("sex");
			String job_status = request.getParameter("job_status");
			String pay_type = request.getParameter("pay_type");
			String annual_salary = request.getParameter("annual_salary");
			Integer years_service = Integer.parseInt(request.getParameter("years_service"));
	            Connection c = null;
	            try
	            {
	            	  String url = "jdbc:mysql://localhost/cs320stu75";
	  	            String username = "cs320stu75";
	  	            String password = "vLfwnZ.*";
	  	            
	                String sql = "update Employees set last_name = ?, hire_date = ?, birth_date = ?, sex = ?, job_status = ?, pay_type = ?, annual_salary = ?, years_service = ? where emp_id =" + employee_id ; 

	                c = DriverManager.getConnection( url, username, password );
	                PreparedStatement pstmt = c.prepareStatement( sql );
	                pstmt.setString(1, last_name);
	                pstmt.setString(2, hire_date);
	                pstmt.setString(3, birth_date);
	                pstmt.setString(4, sex);
	                pstmt.setString(5, job_status);
	                pstmt.setString(6, pay_type);
	                pstmt.setString(7, annual_salary);
	                pstmt.setInt(8, years_service);
	                pstmt.executeUpdate();
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

	            // send the user back to the guest book page
	            response.sendRedirect( "Employees" );
	}

}

