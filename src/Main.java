//Sagi Galian 214804445
//David Bekker 328088521
//teacher: Eyal Eisenstein
import java.util.Scanner;

public class Main {
	

	//variables
	private static boolean exitFlag = true;
		
		
	//create reader
	private static Scanner reader = new Scanner(System.in);
		
	// function to handle exit
	public static void exit() {
		//case 0 exit
		System.out.println("[Exiting] bye");
		//change exitFlag to false to stop the while loop
		exitFlag = false;
		//close reader
		reader.close();
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
		System.out.println("7 - all sellers items list\n");
		System.out.println("8 - show all items from a category: ");
	}
	
	public static void main(String[] args) {
		//initiating the Management class
		Management management = new Management();
		
		//variables
		int command;
		String buyerName = "";
		String buyerPassword = "";
		String buyerAddress = "";
		String sellerName = "";
		String sellerPassword = "";
		boolean leaveMode = false;
		
		//initiating both to -1 because no seller/buyer selected.
		int buyerIndex = -1;
		int sellerIndex = -1;

		while(exitFlag) {
			
			//menu
			menu();
			
			//get input
			command = reader.nextInt();
			//switch case between the different commands
			
			//reset leaveMode flag
			leaveMode = false;
			switch(command) {
			case 0:
				//case 0 exit
				exit();
				break;
			case 1:
				//case 1 add seller
				//loop for taken name
				
				while(!leaveMode) {
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
				while (sellerPassword.trim() == "" && !leaveMode) {
					System.out.print("Enter seller password (Type quit to cancel): ");
					sellerPassword = reader.next();
				}
				// adding the seller to the array that in the management class
				if (!leaveMode) {
					management.addSeller(sellerName, sellerPassword);
					System.out.println("[ Added seller! ]");	
					//reset password for next seller
					sellerPassword = "";
				}
				break;
				
			case 2:

				//case 2 add buyer
				//loop for taken name
				while(!leaveMode) {
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
				if (!leaveMode) {
					management.addBuyer(buyerName, buyerPassword, buyerAddress);
					System.out.println("Buyer added to management class !");					
				}

				break;
				
			case 3:

				//add product to seller
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
					if (leaveMode) {
						break;
					}
					System.out.println("enter item name you want to add: ");
					//item name
					String item = reader.next();
					while(management.getSellers()[sellerIndex].getExistingProduct(item) != null) {
						//product already exists
						System.out.println("item already exists");
						System.out.println("enter item name you want to add: ");
						//item name
						item = reader.next();
					}	
					System.out.println("enter item price: ");
					
					//item price
					double itemPrice = reader.nextDouble();
					
					//item category
			        String category;
			        while (true) {
			            System.out.println("Enter item category (kids, electricity, office, clothes): ");
			            category = reader.next();
			            if (Categories.contains(category.toLowerCase())) {
			                break;
			            } else {
			                System.out.println("Invalid category. Please choose again.");
			            }
			        }
					
					System.out.println("Does the product have a special wrap? (yes/no): ");
			        String specialWrap = reader.next();
					while(!specialWrap.toLowerCase().equals("yes") && !specialWrap.toLowerCase().equals("no")) {
						//enter if answer isn't yes or no is wrong exit if category is right
						System.out.println("wrong answer choose again");
						System.out.println("Does the product have a special wrap? (yes/no): ");
						specialWrap = reader.next();
					}
			        Product product;
			        //check for wrap if yes get added cost else normal product
			        if (specialWrap.toLowerCase().equals("yes")) {
			            System.out.println("Enter the additional cost for the special wrap: ");
			            double addedCost = reader.nextDouble();
			            product = new SpecialProduct(item, itemPrice, category, true, addedCost);
			        } 
			        else {
			            product = new Product(item, itemPrice, category);
			        }
					// add product to seller
					management.getSellers()[sellerIndex].addProduct(product);
					System.out.println("Product added!");
					break;
				}
				
			case 4:
				//case 4 add item to buyer
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
				if (leaveMode) {
					break;
				}
				System.out.println("Here are the products you can find in " + sellerName + "`s store");
				String productName = "";
				Product chosenProduct = null;
				//buyer is choosing a product
				//displaying the products of the chosen seller
				System.out.println(sellerIndex);
				//get seller
				Seller chosenSeller = management.getSellers()[sellerIndex];
				//System.out.println(chosenSeller.getName()); // remove 
				chosenSeller.displayProducts();
				if (chosenSeller.getProducts()[0] != null) {
					
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
				}
				else {
					System.out.println("There are no products in the store");
				}
				break;
			case 5:
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
				if (leaveMode) {
					break;
				}
				// show the cart, the total price.
				System.out.println("Here is your cart: ");
				Buyer buyer = management.getBuyers()[chosenBuyerIndex];
				buyer.displayProducts();
				System.out.println("Total price of: " + buyer.cartPrice());
				management.getBuyers()[chosenBuyerIndex].moveToPreviousCarts();
				break;
			case 6:
				//case 6 show all buyers
				management.displayBuyersWithCart();
				break;
			case 7:
				//case 7 show all sellers
				management.displaySellersWithProducts();
				break;
			
			case 8:
				System.out.println("choose category (kids, electricity, office, clothes) type quit to cancel");
				String category = reader.next();
				if (category.equals("quit".toLowerCase())) {
					leaveMode = true;
					break;
				}
				while(!Categories.contains(category)) {
					//enter if category is wrong exit if category is right
					System.out.println("wrong category choose again");
					System.out.println("choose category (kids, electricity, office, clothes) type quit to cancel");
					category = reader.next();
				}
				if(leaveMode) {
					break;
				}
				management.displayAllItemsFromACategory(category);
				break;
			}
		}
	}
}
