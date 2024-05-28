//Sagi Galian And David Bekker
package Main;

import java.util.Scanner;

public class Main {
	
	//variables
	private static int command;
	private static boolean exitFlag = true;
	private static String buyerName;
	private static String sellerName;
		
	//buyers and sellers first free index
	private static int sellersIndex = 0;
	private static int buyersIndex = 0;
		
	//create reader
	private static Scanner reader = new Scanner(System.in);
	
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
	
	public static void exit() {
		//case 0 exit
		System.out.println("exiting");
		//change exitFlag to false to stop the while loop
		exitFlag = false;
		//close reader
		reader.close();
	}
	
	public static void addSeller() {
		//case 1 add seller
		//loop for taken name
		System.out.println("enter seller name: ");
		String newSellerName = reader.next();
		while(checkExistance(sellers, newSellerName)) {
			System.out.println("seller already exists");
			System.out.println("enter seller name: ");
			newSellerName = reader.next();
		}
		if(sellersIndex == sellers.length) {
			//if max length reached expend
			sellers = expendArr(sellers);
		}
		//add seller
		sellers[sellersIndex] = newSellerName;
		sellersIndex += 1;
	}
	
	public static void addBuyer() {
		//case 2 add buyer
		//loop for taken name
		System.out.println("enter buyer's name: ");
		String newBuyerName = reader.next();
		while(checkExistance(buyers, newBuyerName)) {
			System.out.println("buyer's already exists");
			System.out.println("enter buyer's name: ");
			newBuyerName = reader.next();

		}
		if(buyersIndex == buyers.length) {
			//if max length reached expend
			buyers = expendArr(buyers);
		}
		//add seller
		buyers[buyersIndex] = newBuyerName;
		buyersIndex += 1;
	}
	
	public static void addItemToSeller() {
		//add item to seller
		System.out.println("choose seller (back to exit): ");
		printArr(sellers);
		sellerName = reader.next();
		while(!checkExistance(sellers,sellerName)) {
			//back
			if(sellerName.equals("back")) {
				return;
			}
			//loop choose existing seller
			//add item to seller
			System.out.println("choose seller (back to exit): ");
			printArr(sellers);
			//seller name
			sellerName = reader.next();
			
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
	}
	
	public static void addItemToBuyer() {
		//case 4 add item to buyer
		System.out.println("choose buyer (back to exit): ");
		printArr(buyers);
		//buyer name
		buyerName = reader.next();
		while(!checkExistance(buyers,buyerName)) {
			if(buyerName.equals("back")) {
				return;
			}
			//loop choose existing buyer
			System.out.println("choose buyer (back to exit): ");
			printArr(buyers);
			//buyer name
			buyerName = reader.next();
		}
		System.out.println("choose seller (back to exit): ");
		printArr(sellers);
		//seller name
		sellerName = reader.next();
		while(!checkExistance(sellers,sellerName)) {
			if(sellerName.equals("back")) {
				return;
			}
			//loop choose existing seller
			System.out.println("choose seller (back to exit): ");
			printArr(sellers);
			//seller name
			sellerName = reader.next();
		}
	}
	
	public static void chooseBuyerAndPay() {
		//case 5 choose buyer and pay
		System.out.println("choose buyer you want to pay with (back to exit): ");
		printArr(buyers);
		//buyer name
		buyerName = reader.next();
		if(buyerName.equals("back")) {
			return;
		}
	}
	
	public static void printBuyers() {
		//case 6 show all buyers
		printArr(buyers);
	}
	
	public static void printSellers() {
		//case 7 show all sellers
		printArr(sellers);
	}
	
	public static void menu() {
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
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		while(exitFlag) {
			
			//menu
			menu();
			
			//get input
			command = reader.nextInt();
			//switch case between the different commands
			switch(command) {
			case 0:
				exit();
				break;
			case 1:
				addSeller();
				break;
			case 2:
				addBuyer();
				break;
			case 3:
				addItemToSeller();
				break;
			case 4:
				addItemToBuyer();
				break;
			case 5:
				chooseBuyerAndPay();
				break;
			case 6:
				printBuyers();
				break;
			case 7:
				printSellers();
				break;
			}
		}
		
	}

}
