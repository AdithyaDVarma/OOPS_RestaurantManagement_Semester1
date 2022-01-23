import java.io.*;
import java.util.*;

public class Employee implements Serializable {
	String name, email , specialist, mobilenumber, address;
	int id;
	double salary;

	static ArrayList<Employee> employeeList = new ArrayList();
	static File f = new File("employee.dat");
	static ObjectOutputStream out = null;
	static Scanner sc = new Scanner(System.in);

	Employee(String name, String email, String specialist,String mobilenumber, String address, int id, double salary) {
		this.name = name;
		this.email = email;
		this.specialist = specialist;
		this.mobilenumber = mobilenumber;
		this.address = address;
		this.id = id;
		this.salary = salary;
	}


	static void add_employee() {
		System.out.println("********************ADD EMPLOYEE********************");
		System.out.println();
		int new_id=0;
		System.out.println("Enter employee name: ");
		String name = sc.next();
		System.out.println("Enter email ID: ");
		String email = sc.next();
		System.out.println("Enter designation: ");
		String specialist = sc.next();
		System.out.println("Enter mobile number: ");
		String mobilenumber = sc.next();
		System.out.println("Enter address: ");
		String address = sc.next();
		System.out.println("Enter employee ID: ");
		int id = sc.nextInt();
		System.out.println("Enter salary: ");
		double salary = sc.nextDouble();
		for (Employee emp : employeeList) {
			if (emp.id==id) {
				System.out.println("Employee with ID "+id+" already exists and his/her name is: "+emp.name);
			    System.out.println("Enter another ID: ");
			    new_id=sc.nextInt();
			    id=new_id;
			    break;}
	}
		
		Employee Newemp = new Employee(name, email, specialist, mobilenumber, address,id, salary);
		employeeList.add(Newemp);

		System.out.println("Employee added successfully.");
	}

	static void delete_employee() {
		System.out.println("********************DELETE EMPLOYEE********************");
		System.out.println();
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter the id of the employee to be deleted: ");
		int id=sc.nextInt();
		for (Employee emp : employeeList) {
			if (emp.id == id) {
				employeeList.remove(emp);
			    System.out.println("Record has been deleted");
			    break;
			}
		}
	}

	static void edit_employee() {
		System.out.println("********************EDIT EMPLOYEE********************");
		System.out.println();
		
		// take input
		
		
		System.out.println("Enter ID of the employee to be updated");
		int id = sc.nextInt();
		for (Employee emp : employeeList) {
			
			if (emp.id == id) {
				System.out.println("Employee found in databse with id " + id + " and Name: " + emp.name);
				Employee oldemp = emp;
				System.out.println("\nEnter new details: \n");
				System.out.println("Enter employee name: ");
				String name = sc.next();
				System.out.println("Enter email ID: ");
				String email = sc.next();
				System.out.println("Enter designation: ");
				String specialist = sc.next();
				System.out.println("Enter mobile number: ");
				String mobilenumber = sc.next();
				System.out.println("Enter address: ");
				String address = sc.next();
				System.out.println("Enter salary: ");
				double salary = sc.nextDouble();
				Employee Newemp = new Employee(name, email, specialist, mobilenumber,address,id,salary);
				employeeList.remove(oldemp);
				employeeList.add(Newemp);
				System.out.println("The record has been updated :)");
				break;
			}
			
		}
	}

	static void writeData() {
		try {
			out = new ObjectOutputStream(new FileOutputStream(f));
			for (Employee i : employeeList)
				out.writeObject(i);

			out.close();

		} catch (FileNotFoundException e) {
			System.out.println("File Not Found");
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public String toString() 
	{
		return " "+id + "         " + name  + "             " + email+"              "+mobilenumber+"              "+address+"             "+salary+"                "+specialist+ "\n___________________________________________________________________________________________________________________________________________________________________";
	}

	public static void run() {
		File f = new File("employee.dat");
		try {
			ObjectInputStream read = new ObjectInputStream(new FileInputStream(f));

			while (true) {
				employeeList.add((Employee) read.readObject());
			}
		} catch (FileNotFoundException e) {
			System.out.println("File Not Found");
		} catch (IOException e) {
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		int a=1;
		while(a==1) {
		System.out.println("\nEnter choice: \n\n1.View the Employees\n2.Add an Employee\n3.Delete an Employee\n4.Update an Employee\n5.Exit");
		int choice = sc.nextInt();
		switch (choice) {
			case 1:
				System.out.println("___________________________________________________________________________________________________________________________________________________________________");
				System.out.println(" ID          NAME                 EMAIL                   MOBILE NUMBER               ADDRESS                   SALARY                DESIGNATION                        ");
				System.out.println("___________________________________________________________________________________________________________________________________________________________________");
				for (Employee e :employeeList) {
				System.out.println(e);
				}		
				break;
			case 2:
				add_employee();
				break;
			case 3:
				delete_employee();
				break;
			case 4:
				edit_employee();
				break;
			default:
				System.out.println("Invalid choice");
			case 5:
				System.out.println("You have exited successfully.");
				a=0;
			
			
		}
		
		writeData();
		}
	}
}