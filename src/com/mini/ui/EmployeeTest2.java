package com.mini.ui;

import java.util.Arrays;
import java.util.Scanner;

import com.mini.dao.EmployeeDaoImp1;
import com.mini.dao.LoginDaoImp1;
import com.mini.pojo.Employee;

public class EmployeeTest2 {

    public static void main(String[] args) {
        boolean exit = false;
        boolean flag;
        int empId = 101;
        String empName;
        String Designation;
        Double Salary;
        String Username;
        String password;

        Employee e = null;
        EmployeeDaoImp1 eimp1 = new EmployeeDaoImp1();
        LoginDaoImp1 limp1 = new LoginDaoImp1();

        Scanner sc = new Scanner(System.in);
        while (!exit) {
            System.out.println("Enter 1 to Login");
            System.out.println("Enter 2 to Register");
            int i = sc.nextInt();
            sc.nextLine();

            if (i == 1) {
                System.out.println("Enter username:");
                Username = sc.nextLine();

                System.out.println("Enter Password:");
                password = sc.nextLine();

                if (limp1.adminLogin(Username, password)) {
                    System.out.println("You have logged in as Admin:");
                    while (!exit) {
                        System.out.println("1----> Show All Employees");
                        System.out.println("2----> Delete An Employee");
                        System.out.println("3----> Logout");
                        int option = sc.nextInt();

                        switch (option) {
                            case 1:
                                Employee[] employees = eimp1.showAllEmployees();
                                if (employees.length > 0) {
                                    for (Employee employee : employees) {
                                        if (employee != null) {
                                            System.out.println(employee);
                                        }
                                    }
                                } else {
                                    System.out.println("No employees registered yet.");
                                }
                                break;

                            case 2:
                                System.out.println("Enter the ID of the employee you want to delete:");
                                int deleteId = sc.nextInt();
                                sc.nextLine();

                                flag = eimp1.deleteEmployee(deleteId);
                                if (flag) {
                                    System.out.println("Employee Deleted Successfully!");
                                } else {
                                    System.err.println("Error While Deleting Employee.");
                                }
                                break;

                            case 3:
                                exit = true;
                                System.out.println("You have logged out successfully.");
                                break;
                        }
                    }
                } else if (limp1.employeeLogin(Username, password)) {
                    System.out.println("*********Welcome to SocialEmp*********");
                    exit = false;
                    while (!exit) {
                        System.out.println("\nPlease enter the number as given in option...");

                        System.out.println("2--------> Show all employees");
                        System.out.println("3--------> Search employee by id");
                        System.out.println("4--------> Update employee detail");
                        System.out.println("5--------> Delete employee profile");
                        System.out.println("6--------> Exit");

                        int option = sc.nextInt();
                        sc.nextLine();

                        switch (option) {
                            case 2:
                                Employee[] employees = eimp1.showAllEmployees();
                                if (employees.length > 0) {
                                    for (Employee employee : employees) {
                                        if (employee != null) {
                                            System.out.println(employee);
                                        }
                                    }
                                } else {
                                    System.out.println("No employees registered yet.");
                                }
                                break;

                            case 3:
                                System.out.println("Enter The ID Of Employee To Be Searched:");
                                int id = sc.nextInt();
                                sc.nextLine();

                                e = eimp1.searchEmployeeById(id);

                                if (e != null) {
                                    System.out.println("The Employee Found With Given Id:\n" + e);
                                } else {
                                    System.out.println("Sorry We Couldn't Find Any Employee With This Id.");
                                }
                                break;

                            case 4:
                                System.out.println("Enter the ID of the employee you want to update:");
                                int updateId = sc.nextInt();
                                sc.nextLine();

                                Employee updatedEmployee = eimp1.searchEmployeeById(updateId);
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
                                        System.err.println("Error While Updating Employee.");
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
                                    System.err.println("Error While Deleting Employee.");
                                }
                                break;

                            case 6:
                                exit = true;
                                System.out.println("Thank You Visit Again!");
                                break;
                        }
                    }
                } else {
                    System.out.println("Credentials do not match! Please try again.");
                }
            } else if (i == 2) {
                System.out.println("Enter Your Name:");
                empName = sc.nextLine();

                System.out.println("Enter Your Designation");
                Designation = sc.nextLine();

                System.out.println("Enter Your Salary");
                Salary = sc.nextDouble();
                sc.nextLine();

                empId += 9;
                e = new Employee(empId, empName, Designation, Salary);

                flag = eimp1.addEmployee(e);
                if (flag) {
                    System.out.println("Employee Registered Successfully!");
                    System.out.println(Arrays.toString(eimp1.showAllEmployees()));
                } else {
                    System.err.println("Error While Adding Employee.");
                }
            } else {
                System.out.println("Please enter 1 or 2 only.");
            }
        }
    }
}       