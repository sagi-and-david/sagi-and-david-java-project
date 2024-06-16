//Sagi Galian And David Bekker
package Main;

import java.util.Scanner;

public class Main {
	
<<<<<<< HEAD
=======
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
	
>>>>>>> 5ab59f420e2f5c84936efc01cff7a70e876ead93
	public static void main(String[] args) {
		//initiating the Management class
		Management management = new Management();
		
<<<<<<< HEAD
		//variables
		int command;
		boolean exitFlag = true;
		String buyerName = "";
		String buyerPassword = "";
		String buyerAddress = "";
		String sellerName = "";
		String sellerPassword = "";
		boolean leaveMode = false;
		
		//initiating both to -1 because no seller/buyer selected.
		int buyerIndex = -1;
		int sellerIndex = -1;
		
		//create reader
		Scanner reader = new Scanner(System.in);
		
		while(exitFlag) {
			
			//menu
			System.out.println("Enter command\n");
			System.out.println("0 - Exit\n");
			System.out.println("1 - add seller\n");
			System.out.println("2 - add buyer\n");
			System.out.println("3 - add product to seller\n");
			System.out.println("4 - add product to buyer\n");
			System.out.println("5 - customer pay\n");
			System.out.println("6 - all buyers information\n");
			System.out.println("7 - all sellers information: ");
=======
		while(exitFlag) {
			
			//menu
			menu();
>>>>>>> 5ab59f420e2f5c84936efc01cff7a70e876ead93
			
			//get input
			command = reader.nextInt();
			//switch case between the different commands
			switch(command) {
			case 0:
<<<<<<< HEAD
				//case 0 exit
				System.out.println("[Exiting] bye");
				//change exitFlag to false to stop the while loop
				exitFlag = false;
				//close reader
				reader.close();
				break;
			case 1:
				//case 1 add seller
				//loop for taken name
				
				leaveMode = false;
				
				while(true && leaveMode == false) {
					System.out.print("Enter seller name (Type quit to cancel): ");
					sellerName = reader.next();
					if (sellerName.equals("quit".toLowerCase())) {
						leaveMode = true;
						break;
					}
					sellerIndex = management.findSellerIndexByName(sellerName);
					if(sellerIndex != -1) {
						System.out.println("Seller already exists");
					}
					else {
						break;
					}	
				}
				
				//asking for the seller`s password
				while (sellerPassword.trim() == "" && leaveMode == false) {
					System.out.print("Enter seller password (Type quit to cancel): ");
					sellerPassword = reader.next();
				}
				// adding the seller to the array that in the management class
				if (leaveMode == false) {
					management.addSeller(sellerName, sellerPassword);
					System.out.println("[ Added seller! ]");			
				}
=======
				exit();
				break;
			case 1:
				addSeller();
>>>>>>> 5ab59f420e2f5c84936efc01cff7a70e876ead93
				break;
				
			case 2:
<<<<<<< HEAD
				//case 2 add buyer
				//loop for taken name
				leaveMode = false;
				while(true && leaveMode == false) {
					System.out.print("Enter buyer's name (Type quit to cancel): ");
					buyerName = reader.next();
					if (buyerName.equals("quit".toLowerCase())) {
						leaveMode = true;
						break;
					}
					buyerIndex = management.findBuyerIndexByName(buyerName);
					if(buyerIndex != -1) {
						System.out.println("Buyer already exists");
					}
					else {
						break;
					}	
				}
				//asking for the buyer`s password
				while (buyerPassword.trim() == "" && leaveMode == false) {
					System.out.print("Enter buyer password (No spaces allowed): ");
					buyerPassword = reader.next();
				}
				//asking for the buyer`s address
				while (buyerAddress.trim() == "" && leaveMode == false) {
					System.out.print("Enter buyer address (No spaces allowed): ");
					buyerAddress = reader.next();
				}
				// adding the buyer to the array that in the management class
				if (leaveMode == false) {
					management.addBuyer(buyerName, buyerPassword, buyerAddress);
					System.out.println("Buyer added to management class !");					
				}
=======
				addBuyer();
>>>>>>> 5ab59f420e2f5c84936efc01cff7a70e876ead93
				break;
				
			case 3:
<<<<<<< HEAD
				//add product to seller
				leaveMode = false;
				if (management.getSellersCount() == 0) {
					System.out.println("There are 0 available sellers.");
					break;
				}else {
					//add item to seller
					sellerIndex = -1;
					while(sellerIndex == -1 && leaveMode == false) {
						//loop choose existing seller
						//add item to seller
						//if no sellers available quit and leave a message
						
						System.out.println("choose seller (an existing one, Type quit to cancel): ");
						management.displaySellers();
						//seller name
						sellerName = reader.next();
						if (sellerName.equals("quit".toLowerCase())) {
							leaveMode = true;
							break;
						}
						sellerIndex = management.findSellerIndexByName(sellerName);
					}
					if (leaveMode == true) {
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
					
					// add product to seller
					management.getSellers()[sellerIndex].addProduct(item, itemPrice, category);
					System.out.println("Product added!");
					
					break;
				}
				
			case 4:
				//case 4 add item to buyer
				leaveMode = false;
				buyerIndex = -1;
				while(buyerIndex == -1) {
					//loop choose existing buyer
					System.out.println("choose buyer (Type quit to cancel): ");
					management.displayBuyers();
					//buyer name
					buyerName = reader.next();
					if (buyerName.equals("quit".toLowerCase())) {
						leaveMode = true;
						break;
					}
					buyerIndex = management.findBuyerIndexByName(buyerName);
				}
				
				sellerIndex = -1;
				while(sellerIndex == -1 && leaveMode == false) {
					//loop choose existing seller
					System.out.println("choose seller: ");
					management.displaySellers();
					//seller name
					sellerName = reader.next();
					sellerIndex = management.findSellerIndexByName(sellerName);
				}
				if (leaveMode == true) {
					break;
				}
				System.out.println("Here are the products you can find in " + sellerName + "`s store");
				String productName = "";
				Product chosenProduct = null;
				//buyer is choosing a product
				//displaying the products of the chosen seller
				System.out.println(sellerIndex);
				Seller chosenSeller = management.getSellers()[sellerIndex];
				System.out.println(chosenSeller.getName()); // remove 
				chosenSeller.displayProducts();
				if (chosenSeller.getProducts().length > 0) {
					
					while(true) {
						//loop choose existing product
						System.out.println("choose product: ");
						productName = reader.next();
						chosenProduct = management.getSellers()[sellerIndex].getExistingProduct(productName);
						if (chosenProduct != null) {
							break;
						}
					}
					management.buyers[buyerIndex].addProduct(chosenProduct.getName(), chosenProduct.getPrice(), chosenProduct.getCategory());
					System.out.println("Product Added. ");
				}else {
					System.out.println("There are no products in the store");
				}
				break;
			case 5:
				leaveMode = false;
				//case 5 choose buyer and pay
				System.out.println("choose buyer you want to pay with (Type quit to cancel): ");
				management.displayBuyers();
				//buyer name
				int chosenBuyerIndex = -1;
				do {
					buyerName = reader.next();
					if (buyerName.equals("quit".toLowerCase())) {
						leaveMode = true;
						break;
					}
					chosenBuyerIndex = management.findBuyerIndexByName(buyerName);
				}while(chosenBuyerIndex == -1);
				if (leaveMode == true) {
					break;
				}
				// show the cart, the total price.
				System.out.println("Here is your cart: ");
				Buyer buyer = management.getBuyers()[chosenBuyerIndex];
				buyer.displayProducts();
				System.out.println("Total price of: " + buyer.cartPrice());
				
				break;
			case 6:
				//case 6 show all buyers
				management.displayBuyers();
				break;
			case 7:
				//case 7 show all sellers
				management.displaySellers();
=======
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
>>>>>>> 5ab59f420e2f5c84936efc01cff7a70e876ead93
				break;
			}
		}
		
	}

}
