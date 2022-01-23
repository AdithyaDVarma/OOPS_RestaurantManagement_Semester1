import java.util.*;
import java.io.*;
public class Equipment implements Serializable
{
	String cutlery_name;
	int quantity_of_cutlery;
	int id;
	static ArrayList<Equipment> EquipmentData = new ArrayList();
    static File f = new File("Equipment.dat");
    static ObjectOutputStream out = null;
    static Scanner sc = new Scanner(System.in);
    Equipment(String cutlery_name, int quantity_of_cutlery, int id)
    {
    	this.cutlery_name=cutlery_name;
    	this.quantity_of_cutlery=quantity_of_cutlery;
    	this.id=id;
    }
    static void add_Equipment()
    {
    	System.out.println("Enter the name of Equipment: ");
    	String cutlery_name=sc.next();
    	System.out.println("Enter the quantity of Equipment: ");
    	int quantity_of_cutlery=sc.nextInt();
    	System.out.println("Enter an ID for the Equipment: ");
    	int id=sc.nextInt();
    	Equipment Newequipment= new Equipment(cutlery_name, quantity_of_cutlery, id);
    	EquipmentData.add(Newequipment);
    	System.out.println("Equipment added successfully.");
    }
    static void view_Equipment()
	{
		System.out.println("View EQUIPMENT DETAILS");
		System.out.println("Enter ID to view EQUIPMENT details");
		
		int id = sc.nextInt();
		for (Equipment equipment : EquipmentData) 
		{
			if (equipment.id == id) 
			{
				System.out.println("____________________________________");
				System.out.println(" ID      EQUIPMENT       QUANTITY");
				System.out.println("____________________________________");
				System.out.println(equipment);
				System.out.println("____________________________________");
			}
		}
	}
	static void update_Equipment() 
	{
		System.out.println("Update EQUIPMENT DETAILS");
		System.out.println("Enter ID to update EQUIPMENT details");
		
		int id = sc.nextInt();
		for (Equipment equipment : EquipmentData) 
		{
			if (equipment.id == id) 
			{
				Equipment oldequipment = equipment;
		    	System.out.println("Enter the name of Equipment: ");
		    	String cutlery_name=sc.next();
		    	System.out.println("Enter the quantity of Equipment: ");
		    	int quantity_of_cutlery=sc.nextInt();
		    	Equipment Newequipment= new Equipment(cutlery_name, quantity_of_cutlery, id);
				EquipmentData.remove(oldequipment);
				EquipmentData.add(Newequipment);
				System.out.println("Equipment updated successfully. ");
				break;
			}
			
		}
		
	
	}
	static void delete_Equipment()
	{
		System.out.println("Delete EQUIPMENT DETAILS");
		System.out.println("Enter ID to delete EQUIPMENT details ");
		int id=sc.nextInt();
		for (Equipment equipment : EquipmentData)
		{
			if (equipment.id == id)
			{
				EquipmentData.remove(equipment);
			    System.out.println("Equipment has been deleted");
			    break;
			}
		}
	}
	static void writeData()
	{
		try 
		{
			out = new ObjectOutputStream(new FileOutputStream(f));
			for (Equipment i : EquipmentData)
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
		return " " + id + "      " + cutlery_name + "            " + quantity_of_cutlery;
	}
	public static void run() 
	{
		File f = new File("Equipment.dat");
		try
		{
			ObjectInputStream read = new ObjectInputStream(new FileInputStream(f));

			while (true)
			{
				EquipmentData.add((Equipment) read.readObject());
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
		System.out.println("\nEnter choice: \n1.View all equipments \n2.View an equipment's details\n3.Add new Equipment\n4.Update Equipment details\n5.Delete Equipment deatails\n6.Exit");

		int choice = sc.nextInt();
		switch (choice) 
		{
		
			case 1:
				System.out.println("____________________________________");
				System.out.println(" ID      EQUIPMENT       QUANTITY");
				System.out.println("____________________________________");
				for (Equipment e:EquipmentData) {
					System.out.println(e);
					System.out.println("____________________________________");	
				}
				break;
			case 2:
				view_Equipment();
				break;
			case 3:
				add_Equipment();
				break;
			case 4:
				update_Equipment();
				break;
			case 5:
				delete_Equipment();
				break;
			case 6:
				System.out.println("You have exited successfully.");
				a=0;
				break;
			default:
				System.out.println("Invalid choice.");
		}
			
		writeData();
			}
	}
}
