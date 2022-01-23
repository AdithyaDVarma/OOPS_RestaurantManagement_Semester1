import java.util.Scanner;
public class main {
	public static void main(String[] args ) {
		int a=1;
		int b=1;
		int c=1;
		Scanner myobj= new Scanner(System.in);
		while(a==1) {
			System.out.println("\nWELCOME TO THE RESTAURANT MANAGEMENT SYSTEM\n********************************************\nENTER CHOICE: \n1.ADMIN\n2.CUSTOMER\n3.EXIT");
			int ch=myobj.nextInt();
			switch (ch) {
				case 1:
					int pass=70122;
					System.out.println("\nADMIN LOGIN");
					System.out.println("---------------");
					System.out.println("ENTER PASSWORD: ");
					int p=myobj.nextInt();
					if(p==pass) {
						System.out.println("SUCCESSFULLY LOGGED IN AS ADMIN");
						while(b==1) {
							System.out.println("\nADMIN MENU\n____________________\nCHOOSE YOUR OPTION:\n1.EMPLOYEE\n2.EQUIPMENT\n3.EXIT");
							int ch1=myobj.nextInt();
							switch(ch1) {
								case 1:
									Employee.run();
									break;
								case 2:
									Equipment.run();
									break;
								default:
									System.out.println("INVALID CHOICE");
								
								case 3:
									System.out.println("YOU HAVE EXITED SUCCESSFULLY\n");
									b=0;
							}
						}
					}
					else if(p != pass) {
						System.out.println("INCORRECT PASSWORD");
						break;
					}
					break;
					
				case 2:
					while(c==1) {
						System.out.println("\nCUSTOMER MENU\n____________________\nCHOOSE YOUR OPTION:\n1.REGULAR\n2.PARKING\n3.EXIT");
						int ch2=myobj.nextInt();
						switch(ch2) {
							case 1:
								Customer.run();
								break;
							case 2:
								Parking.run();
								break;
							case 3:
								c=0;
								System.out.println("YOU HAVE EXITED SUCCESSFULLY\n");	
					   }
					}
				
				case 3:
					System.out.println("\nTHANK YOU FOR USING THE RESTAURANT MANAGEMENT SYSTEM");
					a=0;
			}
		}
	}
}
