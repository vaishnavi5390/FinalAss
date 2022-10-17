package com.emp.collection;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Scanner;
import com.db.concept.ConnectionFactory;
public class EmpServiceImpl implements EmpService
{
	public ArrayList<Employee> displayEmployee() 
	{
		ArrayList<Employee> list = new ArrayList<Employee>();
		try
        {
            Connection con = ConnectionFactory.getConnection();
            Statement statement = con.createStatement();
            ResultSet set = statement.executeQuery("select * from employee1");
            while(set.next())
            {
            	System.out.println(set.getInt(1)+" "+set.getString(2)+" "+set.getString(3)+" "+set.getFloat(4));
            }
        }    
        catch (Exception e)
        {
            System.out.println(e);
        }
		return list;
	}
	public void addEmployee(Employee emp) 
	{
		try
        {    
            Connection con=ConnectionFactory.getConnection();
            Statement statement=con.createStatement();
            statement.executeUpdate("insert  into employee1(`name`,`designation`,`salary`) values('"+emp.getName()+"','"+emp.getDesignation()+"','"+emp.getSalary()+"')");
        }    
        catch (Exception e)
        {
            System.out.println(e);
        }
	}
	public void updateEmployee() 
	{
		try
        {    
            Connection con=ConnectionFactory.getConnection();
            Statement statement=con.createStatement();
            Scanner sc = new Scanner(System.in);
    		System.out.println("Please enter userid to update : ");
    		int id = sc.nextInt();
    		System.out.println("Please enter new Designation for user : ");
    		String desi = sc.next();
    		String q1 = "update `assesment`.`employee1` set `designation` = '"+desi+"' where id = '"+id+"'";
            statement.executeUpdate(q1);
            System.out.println("Please enter new Salary for user : ");
    		String salary = sc.next();
    		String q2 = "update `assesment`.`employee1` set `salary` = '"+salary+"' where id = '"+id+"'";
    		statement.executeUpdate(q2);
    		System.out.println("Details updated sucessfully");
        }
        catch (Exception e)
        {
            System.out.println(e);
        }	
	}
	public void deleteEmployee() 
	{
		try
        {    
            Connection con=ConnectionFactory.getConnection();
            Statement statement=con.createStatement();
            Scanner sc = new Scanner(System.in);
    		System.out.println("Please enter userid to delete: ");
    		int id = sc.nextInt();
    		String q = "delete from `assesment`.`employee1` WHERE id = '"+id+"'";
            statement.executeUpdate(q);
            System.out.println("Data deleted from the database");
        }
        catch (Exception e)
        {
            System.out.println(e);
        }		
	}
}