package com.emp.collection;

import java.util.ArrayList;

public interface EmpService {
	public ArrayList<Employee> displayEmployee();
	public void addEmployee(Employee emp);
	public void updateEmployee();
	public void deleteEmployee();
}
