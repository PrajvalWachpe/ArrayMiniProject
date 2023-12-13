package com.mini.pojo;

public class Employee {

	private int empId;
	private String empName;
	private String Designation;
	private Double Salary;
	private String Username;
	private String password;
	
	public Employee() {
		super();
	}
	
	
	public Employee(int empId, String empName, String designation, Double salary) {
		super();
		this.empId = empId;
		this.empName = empName;
		Designation = designation;
		Salary = salary;
	}


	public Employee(int empId, String empName, String Designation, Double Salary, String Username, String password) {
		super();
		this.empId=empId;
		this.empName=empName; 
		this.Designation=Designation;
		this.Salary=Salary;
		this.Username=Username;
		this.password=password;
	}
	
	
	
	@Override
	public String toString() {
		return "Employee [empId=" + empId + ", empName=" + empName + ", Designation=" + Designation + ", Salary="
				+ Salary + ", Username=" + Username + ", password=" + password + "]";
	}
	public int getEmpId() {
		return empId;
	}
	public void setEmpId(int empId) {
		this.empId = empId;
	}
	public String getEmpName() {
		return empName;
	}
	public void setEmpName(String empName) {
		this.empName = empName;
	}
	public String getDesignation() {
		return Designation;
	}
	public void setDesignation(String designation) {
		Designation = designation;
	}
	public Double getSalary() {
		return Salary;
	}
	public void setSalary(Double salary) {
		Salary = salary;
	}
	public String getUsername() {
		return Username;
	}
	public void setUsername(String username) {
		Username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	

}
