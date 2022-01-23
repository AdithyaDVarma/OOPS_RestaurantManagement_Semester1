import java.util.*;
import java.io.*;
public class Customer implements Serializable 
{
	String name;
	String date_of_birth;
	String email_id;
	String mobile_number;
	String address;
	int id;
	static ArrayList<Customer> CustomerData = new ArrayList();
	static File f = new File ("Customer.dat");
	static ObjectOutputStream out = null ;
	static Scanner sc = new Scanner(System.in);
	Customer(String name,String date_of_birth,String email_id,String mobile_number,String address,int id)
	{
		this.name=name;
		this.date_of_birth=date_of_birth;
		this.email_id=email_id;
		this.mobile_number=mobile_number;
		this.address=address;
		this.id=id;
	}
	static void add_Customer()
	{
		System.out.println("Please enter your details: ");
		System.out.println("Name:");
		String name = sc.next();
		System.out.println("Date of birth: ");
		String date_of_birth=sc.next();
		System.out.println("Email ID: ");
		String email_id=sc.next();
		System.out.println("Mobile number: ");
		String mobile_number=sc.next();
		System.out.println("Address: ");
		String address=sc.next();
		System.out.println("Create a user ID (less than 10 digits): ");
		int id= sc.nextInt();
		for (Customer customer : CustomerData ) 
		{
			if (customer.id==id)
			{
				System.out.println("Customer with ID "+id+" already exists and his/her name is: "+customer.name);
			    System.out.println("Enter another ID: ");
			    int new_id=sc.nextInt();
			    id=new_id;
			    break;}
	}
		Customer Newcustomer= new Customer(name, date_of_birth, email_id, mobile_number, address, id);
		CustomerData.add(Newcustomer);
		System.out.println("Customer added successfully. ");
	}
	static void view_customer()
	{
		System.out.println("View CUSTOMER details\n************************\n");
		System.out.println("Enter your ID to view your details");
		
		int id = sc.nextInt();
		for (Customer customer : CustomerData) 
		{
			if (customer.id == id) 
			{	System.out.println(" ID                NAME                DOB                      EMAIL ID                           MOBILE NUMBER                    ADDRESS");
				System.out.println("_____________________________________________________________________________________________________________________________________________________");
				System.out.println(id + "              "+customer.name + "             " + customer.date_of_birth + "               " + customer.email_id +"                  "
						+ "    "+ customer.mobile_number + "                   " + customer.address);
				System.out.println("_____________________________________________________________________________________________________________________________________________________");
				}
		}
	}
	static void update_Customer() 
	{
		System.out.println("Update CUSTOMER DETAILS");
		System.out.println("Enter your ID to update your details");
		
		int id = sc.nextInt();
		for (Customer customer : CustomerData) 
		{
			if (customer.id == id) 
			{
				System.out.println("Customer with id " + id + " found in the databse. Name:  " + customer.name);
				Customer oldcustomer = customer;
				System.out.println("Please enter your new details");
				System.out.println("Name:");
				String name = sc.next();
				System.out.println("Date of birth: ");
				String date_of_birth=sc.next();
				System.out.println("Email ID: ");
				String email_id=sc.next();
				System.out.println("Mobile number: ");
				String mobile_number=sc.next();
				System.out.println("Address: ");
				String address=sc.next();
				Customer Newcustomer=new Customer(name, date_of_birth, email_id, mobile_number, address, id);
				CustomerData.remove(oldcustomer);
				CustomerData.add(Newcustomer);
				System.out.println("Data updated successfully.");
			}
		}
	
	}
	static void writeData()
	{
		try 
		{
			out = new ObjectOutputStream(new FileOutputStream(f));
			for (Customer i : CustomerData)
				out.writeObject(i);

			out.close();

		} 
		catch (FileNotFoundException e) 
		{
			System.out.println("File Not Found");
		} 
		catch (IOException e) 
		{
			e.printStackTrace();
		}
	}
	public String toString() 
	{
		return "\n{id: " + id + " , Name: " + name + " , Date of birth: " + date_of_birth + " , Email: " + email_id + " , Mobile number: " + mobile_number + " , Address: " + address+" }";
	}
	public static void run() 
	{
		File f = new File("Customer.dat");
		try
		{
			ObjectInputStream read = new ObjectInputStream(new FileInputStream(f));

			while (true)
			{
				CustomerData.add((Customer) read.readObject());
			}
		} 
		catch (FileNotFoundException e)
		{
			System.out.println("File Not Found");
		} 
		catch (IOException e)
		{
		} 
		catch (ClassNotFoundException e)
		{
			e.printStackTrace();
		}
		int a=1;
		while(a==1) 
			{
		System.out.println("Enter choice: \n1.View Customer details\n2.Add a new customer\n3.Update customer details\n4.Exit");

		int choice = sc.nextInt();
		switch (choice) 
		{
			case 1:
				view_customer();
				break;
			case 2:
				add_Customer();
				break;
			case 3:
				update_Customer();
				break;
			case 4:
				System.out.println("You have exited successfully.");
				a=0;
				break;
			default:
				System.out.println("Invalid choice");
		}
			
		writeData();
			}
	}
}
