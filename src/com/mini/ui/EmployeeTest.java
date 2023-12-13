package com.mini.ui;

import java.util.Arrays;
import java.util.Scanner;

import com.mini.dao.EmployeeDaoImp1;
import com.mini.pojo.Employee;

public class EmployeeTest {


	public static void main(String[] args) {
		
		 boolean exit=false;
		 boolean flag;
		 int empId = 101;
		 String empName;
		 String Designation;
		 Double Salary;
		 
		 Employee e=null;
		 EmployeeDaoImp1 eimp1= new EmployeeDaoImp1();
		 
		Scanner sc=new Scanner(System.in);
		
		System.out.println("*************Wlcome To SocialEmp****************");
	
		while(exit==false) {
			
			System.out.println("***Please Enter The Number As Given In Option***");
			System.out.println("1.-----> Register Employee");
			System.out.println("2.-----> Show All Employee");
			System.out.println("3.-----> Search Employee By Id");
			System.out.println("4.-----> Update Employee Details");
			System.out.println("5.-----> Delete Employe Profile");
			System.out.println("6.-----> Search Employee By Name");
			System.out.println("7------> Exit");
			
			int option=sc.nextInt();
			sc.nextLine();
			
			switch(option) {
			
			case 1:
				System.out.println("Enter Your Name:-");
				empName=sc.nextLine();
				
				System.out.println("Enter Your Designation");
				Designation=sc.nextLine();
				
				System.out.println("Enter Your Salary");
				Salary=sc.nextDouble();
				sc.nextLine();
				
				empId+=9;
				e=new Employee(empId, empName, Designation, Salary) ; 				
				
				flag=eimp1.addEmployee(e);
				if(flag) {
					System.out.println("Employee Registerd Successfully..!");
					System.out.println(Arrays.toString(eimp1.showAllEmployees()));
				}
				else
					System.err.println("Error While Adding Employee..!!!!");
				break;
				
			case 2:
                Employee[] employees = eimp1.showAllEmployees();//This line retrieves an array of all registered employees from the data access object 
                if (employees.length > 0) { // It checks if there are employees in the array.
                    for (Employee employee : employees) { // It iterates through each employee in the array.
                        if (employee != null) { //It checks if the current array slot contains an employee object (i.e., it's not null).
                            System.out.println(employee); // If an employee is found, it prints the details of that employee to the console.
                        }
                    }
                } 
                else {
                    System.out.println("No employees registered yet.");
                }
                break;
                
                
			case 3:
				
				System.out.println("Enter The I'd Of Employee To Be Searched:-");
				int id=sc.nextInt();
				sc.nextLine();
				
				e=eimp1.searchEmployeeById(id);
				
				if(e!=null) {
					System.out.println("The Employee Found With Given Id:-\n"+e);
				}
				else {
					System.out.println("Sorry We Could't Find Any Employee With This I'd..!");
				}
				
				break;
				
			case 4:
                System.out.println("Enter the ID of the employee you want to update:");
                int updateId = sc.nextInt();
                sc.nextLine();

                Employee updatedEmployee = eimp1.searchEmployeeById(updateId);//It searches for the employee with the provided ID using the searchEmployeeById(updateId) method provided by the EmployeeDaoImp1 class. 
                																//If the employee with the given ID is found, their details are retrieved and stored in the updatedEmployee variable.
                if (updatedEmployee != null) {
                    System.out.println("Enter the updated name:");
                    empName = sc.nextLine();
                    System.out.println("Enter the updated designation:");
                    Designation = sc.nextLine();
                    System.out.println("Enter the updated salary:");
                    Salary = sc.nextDouble();
                    sc.nextLine();

                    updatedEmployee = new Employee(updateId, empName, Designation, Salary);

                    flag = eimp1.updateEmployee(updatedEmployee);
                    if (flag) {
                        System.out.println("Employee Updated Successfully!");
                    } else {
                        System.err.println("Error While Updating Employee..!!!!");
                    }
                } else {
                    System.out.println("Employee not found for updating.");
                }
                break;

            case 5:
                System.out.println("Enter the ID of the employee you want to delete:");
                int deleteId = sc.nextInt();
                sc.nextLine();

                flag = eimp1.deleteEmployee(deleteId);
                if (flag) {
                    System.out.println("Employee Deleted Successfully!");
                } else {
                    System.err.println("Error While Deleting Employee..!!!!");
                }
                break;
				
            case 6:
            	System.out.println("Enter the name of the employee you want to search:");
                empName = sc.nextLine();

                Employee foundEmployee = eimp1.searchEmployeeByName(empName);

                if (foundEmployee != null) {
                    System.out.println("Employee Found:\n" + foundEmployee);
                } else {
                    System.out.println("No employee found with the given name.");
                }
            	break;
			case 7:
				exit=true;
				System.out.println("ThankYou Visit Again..!");
				break;
				
			}
		}
	}
}
/* This Switch Case for which choice you want to update 
 * case 4:
    System.out.println("Enter the ID of the employee you want to update:");
    int updateId = sc.nextInt();
    sc.nextLine();

    Employee existingEmployee = eimp1.searchEmployeeById(updateId);
    
    if (existingEmployee != null) {
        System.out.println("Do you want to update the name? (y/n):");
        String updateNameOption = sc.nextLine();
        String newName = null;
        
        if ("y".equalsIgnoreCase(updateNameOption)) {
            System.out.println("Enter the updated name:");
            newName = sc.nextLine();
        }

        System.out.println("Do you want to update the designation? (y/n):");
        String updateDesignationOption = sc.nextLine();
        String newDesignation = null;
        
        if ("y".equalsIgnoreCase(updateDesignationOption)) {
            System.out.println("Enter the updated designation:");
            newDesignation = sc.nextLine();
        }

        System.out.println("Do you want to update the salary? (y/n):");
        String updateSalaryOption = sc.nextLine();
        Double newSalary = null;
        
        if ("y".equalsIgnoreCase(updateSalaryOption)) {
            System.out.println("Enter the updated salary:");
            newSalary = sc.nextDouble();
            sc.nextLine();
        }

        flag = eimp1.updateEmployee(updateId, newName, newDesignation, newSalary);
        if (flag) {
            System.out.println("Employee Updated Successfully!");
        } else {
            System.err.println("Error While Updating Employee..!!!!");
        }
    } else {
        System.out.println("Employee not found for updating.");
    }
    break;
 */
