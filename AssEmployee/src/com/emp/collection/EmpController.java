package com.emp.collection;
import java.util.ArrayList;
import java.util.Scanner;
public class EmpController 
{
	public static void display()
	{
		EmpServiceImpl service = new EmpServiceImpl();
		ArrayList<Employee> list = service.displayEmployee();
	}
	public static void addData()
	{
		Scanner scan = new Scanner(System.in);
		Employee emp = new Employee();
		System.out.println("Enter Name: ");
		emp.setName(scan.next());
		System.out.println("Enter Designation: ");
		emp.setDesignation(scan.next());
		System.out.println("Enter Salary: ");
		emp.setSalary(scan.nextFloat());
		EmpServiceImpl service = new EmpServiceImpl();
		service.addEmployee(emp);
	}
	public static void updateData()
	{
		EmpServiceImpl service = new EmpServiceImpl();
		service.updateEmployee();		
	
	}
	public static void delete()
	{
		EmpServiceImpl service = new EmpServiceImpl();
		service.deleteEmployee();
	}
	public static void main(String[] args) 
	{
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter your choice to perform the operation : ");
		System.out.println("1.Display Data \n2.Add Data \n3.Update Data \n4.Delete Data");
		int opt = sc.nextInt();
		switch(opt)
		{
		case 1:
			EmpController.display();
			break;
		case 2:
			EmpController.addData();
			EmpController.display();
			break;
		case 3:
			EmpController.updateData();
			EmpController.display();
			break;
		case 4:
			EmpController.delete();
			EmpController.display();
			break;
		default :
			System.out.println("Enter the valid option");
			break;
		}
	}
}