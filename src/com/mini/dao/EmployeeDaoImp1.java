package com.mini.dao;

import com.mini.pojo.Employee;

public class EmployeeDaoImp1 implements EmployeeDao{

	Employee[] empList=new Employee[50];
	int index=0;
	
	@Override
	public boolean addEmployee(Employee e) {
		
		if (index<50) {
			empList[index]=e;
			index++;
			
			return true;
		}
		return false;
	}

	@Override
	public boolean updateEmployee(Employee e) {
	        for (int i = 0; i < index; i++) {
	            if (empList[i] != null && empList[i].getEmpId() == e.getEmpId()) {
	                empList[i] = e;
	                return true;
	            }
	        }
		
		return false;
	}
	/* This is for choice what you want to update
	 * @Override
		public boolean updateEmployee(int empId, String newName, String newDesignation, Double newSalary) {
    	for (int i = 0; i < index; i++) {
        if (empList[i] != null && empList[i].getEmpId() == empId) {
            Employee employee = empList[i];
            // Update only the attributes that are not null
            if (newName != null) {
                employee.setEmpName(newName);
            }
            if (newDesignation != null) {
                employee.setDesignation(newDesignation);
            }
            if (newSalary != null) {
                employee.setSalary(newSalary);
            }
            return true;
        }
    }
    return false;
}
	 */

	@Override
	public boolean deleteEmployee(int empId) {
		for (int i = 0; i < index; i++) {
            if (empList[i] != null && empList[i].getEmpId() == empId) {
                empList[i] = null;
                return true;
            }
        }
		
		return false;
	}

	@Override
	public Employee searchEmployeeById(int empId) {
	
		for(Employee emp: empList) {
			
			if(emp!=null) {
				int id=emp.getEmpId();//getting the id of employee object received from array
			if(id==empId) { //checking if object has the same id as user given id
			
				return emp;//if they match we are returning that employee object
			}
		}
	}
		return null;
}

	@Override
	public Employee[] showAllEmployees() {
		
		return empList;
	}

	@Override
	public Employee searchEmployeeByName(String empName) {
		 for (Employee emp : empList) {
		        if (emp != null && emp.getEmpName().equalsIgnoreCase(empName)) {
		            return emp;
		        }
		    }
		return null;
	}

	/*public LoginDaoImp1 makeobject() {
		// TODO Auto-generated method stub
		return null;
	}
	*/
}
