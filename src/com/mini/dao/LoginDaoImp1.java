package com.mini.dao;

import com.mini.pojo.Employee;

public class LoginDaoImp1 implements LoginDao {

    @Override
    public boolean employeeLogin(String Username, String password) {
        Employee[] empList = new EmployeeDaoImp1().showAllEmployees();
        for (Employee e : empList) {
            if (e != null && e.getUsername() != null && e.getUsername().equals(Username) &&
                e.getPassword() != null && e.getPassword().equals(password)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean adminLogin(String Username, String password) {
        return Username.equals("Admin") && password.equals("admin@123");
    }
}

/*package com.mini.dao;

import com.mini.pojo.Employee;

public class LoginDaoImp1 implements LoginDao {

	@Override
	public boolean employeeLogin(String Username, String password) {
		
		Employee[] empList=new EmployeeDaoImp1().showAllEmployees();
		for(Employee e:empList) {
			
			if (e!=null && e.getUsername().equals(Username) && e.getPassword().equals(password))
				
				return true;
		}
	
		return false;
	}

	@Override
	public boolean AdminLogin(String Username, String password) {
		if(Username.equals("Admin") && password.equals("admin@123"))
			return true;
		return false;
	}

	
}
*/