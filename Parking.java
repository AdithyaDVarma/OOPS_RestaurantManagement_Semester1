import java.io.*;
import java.util.*;

public class Parking implements Serializable {
	String name, v_no ;
	long mobilenumber;
	static ArrayList<Parking> parkingList = new ArrayList();
	static File f = new File("parking.dat");
	static ObjectOutputStream out = null;
	static Scanner sc = new Scanner(System.in);

	Parking(String name, String v_no,long mobilenumber) {
		this.name = name;
		this.v_no = v_no;
		this.mobilenumber = mobilenumber;
	}


	
	static void add_parking() {
		System.out.println("Enter name:  ");
		String name = sc.next();
		System.out.println("Enter vehicle number:   ");
		String v_no = sc.next();
		System.out.println("Enter mobile number:   ");
		long mobilenumber = sc.nextLong();
		Parking Newpark = new Parking(name, v_no, mobilenumber);
		parkingList.add(Newpark);

		System.out.println("\nParking successful !");
	}
	
	static void delete_parkinglot() {
		Scanner sc=new Scanner(System.in);
		System.out.println("Please enter your mobile number so that you can depart from the restaurant: ");
		long check=sc.nextLong();
		for (Parking pak: parkingList) {
			if (pak.mobilenumber==check) {
				parkingList.remove(pak);
				System.out.println("Your record has been cleared.");
			    break;
			}
		}
	}

	static void writeData() {
		try {
			out = new ObjectOutputStream(new FileOutputStream(f));
			for (Parking i :parkingList)
				out.writeObject(i);

			out.close();

		} catch (FileNotFoundException e) {
			System.out.println("File Not Found");
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public String toString() 
	{	return " "+name + "                    " + v_no  + "             " + mobilenumber+"  "+"\n_______________________________________________________________________";
		
	}

	public static void run() {
		File f = new File("parking.dat");
		try {
			ObjectInputStream read = new ObjectInputStream(new FileInputStream(f));

			while (true) {
				parkingList.add((Parking) read.readObject());
			}
		} catch (FileNotFoundException e) {
			System.out.println("Parking: ");
		} catch (IOException e) {
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		int a=1;
		while(a==1) {
		System.out.println("\nEnter choice: \n\n1.View Parking lot\n2.Add vehicle\n3.Delete your record \n4.Exit");
		int choice = sc.nextInt();
		switch (choice) {
			case 1:
				System.out.println(" NAME                   VEHICLE NUMBER          MOBILE NUMBER            ");
				System.out.println("_______________________________________________________________________");
				for (Parking i :parkingList) {
					System.out.println(i);
				}
				
				break;
			case 2:
				add_parking();
				break;
			default:
				System.out.println("Invalid choice");
			case 3:
				delete_parkinglot();
				break;
			case 4:
				System.out.println("You have exited successfully.");
				a=0;
			
			
		}
		
		writeData();
		}
	}
}