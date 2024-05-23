//Sagi Galian And David Bekker
import java.util.Scanner;

public class Main {
	
	//sellers and buyers arrays
	private static	String[] sellers = new String[] {""};
	private static String[] buyers = new String[] {""};
	
	public static void printArr(String[] arr) {
		for(int i = 0; i < arr.length; i ++) {
			if(arr[i] == null) {
				break;
			}
			System.out.println(arr[i]);
		}
	}
	
	public static String[] expendArr(String[] arr) {
		//expend arr
		String[] expendedArr = new String[2 * arr.length];
		for(int i = 0; i<arr.length; i++) {
			expendedArr[i] = arr[i];
		}
		return expendedArr;
	}
	
	public static boolean checkExistance(String[] arr, String name) {
		//checks is buyer or seller already exists
		//if exists return true
		//else return false
		for(int i = 0; i < arr.length; i++) {
			if(arr[i] == null) {
				break;
			}
			if(arr[i].equals(name)) {
				return true;
			}
		}
		return false;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//variables
		int command;
		boolean exitFlag = true;
		String buyerName;
		String sellerName;
		
		//buyers and sellers first free index
		int sellersIndex = 0;
		int buyersIndex = 0;
		
		//create reader
		Scanner reader = new Scanner(System.in);
		
		while(exitFlag) {
			
			//menu
			System.out.println("enter command\n");
			System.out.println("0 - Exit\n");
			System.out.println("1 - add seller\n");
			System.out.println("2 - add buyer\n");
			System.out.println("3 - add item to seller\n");
			System.out.println("4 - add item to buyer\n");
			System.out.println("5 - customer pay\n");
			System.out.println("6 - all buyers items list\n");
			System.out.println("7 - all customers items list: ");
			
			//get input
			command = reader.nextInt();
			//switch case between the different commands
			switch(command) {
			case 0:
				//case 0 exit
				System.out.println("exiting");
				//change exitFlag to false to stop the while loop
				exitFlag = false;
				//close reader
				reader.close();
				break;
			case 1:
				//case 1 add seller
				//loop for taken name
				while(true) {
					System.out.println("enter seller name: ");
					String newSellerName = reader.next();
					if(checkExistance(sellers, newSellerName)) {
						System.out.println("seller already exists");
					}
					else {
						if(sellersIndex == sellers.length) {
							//if max length reached expend
							sellers = expendArr(sellers);
						}
						//add seller
						sellers[sellersIndex] = newSellerName;
						sellersIndex += 1;
						break;
					}	
				}
				break;
			case 2:
				//case 2 add buyer
				//loop for taken name
				while(true) {
					System.out.println("enter buyer's name: ");
					String newBuyerName = reader.next();
					if(checkExistance(buyers, newBuyerName)) {
						System.out.println("buyer's already exists");
					}
					else {
						if(buyersIndex == buyers.length) {
							//if max length reached expend
							buyers = expendArr(buyers);
						}
						//add seller
						buyers[buyersIndex] = newBuyerName;
						buyersIndex += 1;
						break;
					}	
				}
				break;
			case 3:
				//add item to seller
				while(true) {
					//loop choose existing seller
					//add item to seller
					System.out.println("choose seller (back to exit): ");
					printArr(sellers);
					//seller name
					sellerName = reader.next();
					if(sellerName.equals("back")) {
						break;
					}
					if(checkExistance(sellers,sellerName)) {
						break;
					}
				}
				if(sellerName.equals("back")) {
					break;
				}
				System.out.println("enter item name you want to add: ");
				//item name
				String item = reader.next();
				System.out.println("enter item price: ");
				//item price
				double itemPrice = reader.nextInt();
				System.out.println("enter item category: ");
				//item category
				String category = reader.next();
				break;
			case 4:
				//case 4 add item to buyer
				while(true) {
					//loop choose existing buyer
					System.out.println("choose buyer (back to exit): ");
					printArr(buyers);
					//buyer name
					buyerName = reader.next();
					if(buyerName.equals("back")) {
						break;
					}
					if(checkExistance(buyers,buyerName)) {
						break;
					}
				}
				while(true) {
					//loop choose existing seller
					System.out.println("choose seller (back to exit): ");
					printArr(sellers);
					//seller name
					sellerName = reader.next();
					if(sellerName.equals("back")) {
						break;
					}
					if(checkExistance(sellers,sellerName)) {
						break;
					}
				}
				break;
			case 5:
				//case 5 choose buyer and pay
				System.out.println("choose buyer you want to pay with (back to exit): ");
				printArr(buyers);
				//buyer name
				buyerName = reader.next();
				if(buyerName.equals("back")) {
					break;
				}
				break;
			case 6:
				//case 6 show all buyers
				printArr(buyers);
				break;
			case 7:
				//case 7 show all sellers
				printArr(buyers);
				break;
			}
		}
		
	}

}
