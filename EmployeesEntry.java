package cs320.lab11;

public class EmployeesEntry {

	Integer emp_id;
	String last_name;
	String hire_date;
	String birth_date;
	String sex;
	String job_status;
	String pay_type;
	String annual_salary;
	Integer years_service;
	
	public EmployeesEntry(Integer emp_id, String last_name, String hire_date,
			String birth_date, String sex, String job_status, String pay_type,
			String annual_salary, Integer years_service) {
		super();
		this.emp_id = emp_id;
		this.last_name = last_name;
		this.hire_date = hire_date;
		this.birth_date = birth_date;
		this.sex = sex;
		this.job_status = job_status;
		this.pay_type = pay_type;
		this.annual_salary = annual_salary;
		this.years_service = years_service;
	}

	public Integer getEmp_id() {
		return emp_id;
	}

	public void setEmp_id(Integer emp_id) {
		this.emp_id = emp_id;
	}

	public String getLast_name() {
		return last_name;
	}

	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}

	public String getHire_date() {
		return hire_date;
	}

	public void setHire_date(String hire_date) {
		this.hire_date = hire_date;
	}

	public String getBirth_date() {
		return birth_date;
	}

	public void setBirth_date(String birth_date) {
		this.birth_date = birth_date;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getJob_status() {
		return job_status;
	}

	public void setJob_status(String job_status) {
		this.job_status = job_status;
	}

	public String getPay_type() {
		return pay_type;
	}

	public void setPay_type(String pay_type) {
		this.pay_type = pay_type;
	}

	public String getAnnual_salary() {
		return annual_salary;
	}

	public void setAnnual_salary(String annual_salary) {
		this.annual_salary = annual_salary;
	}

	public Integer getYears_service() {
		return years_service;
	}

	public void setYears_service(Integer years_service) {
		this.years_service = years_service;
	}
	
	
	
	 
	
}
