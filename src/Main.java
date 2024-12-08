//Sagi Galian 214804445
//David Bekker 328088521
//teacher: Eyal Eisenstein
import java.util.InputMismatchException;
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
		System.out.println("------------------------");
		System.out.println("|     Enter Command    |");
		System.out.println("------------------------");

		System.out.println("	0 - Exit");
		System.out.println("	1 - add seller");
		System.out.println("	2 - add buyer");
		System.out.println("	3 - add item to seller");
		System.out.println("	4 - add item to buyer");
		System.out.println("	5 - customer pay");
		System.out.println("	6 - all buyers items list");
		System.out.println("	7 - all sellers items list");
		System.out.println("	8 - show all items from a category: ");
		System.out.println("	9 - change cart for buyer: ");
		System.out.println("	10- Buyers/sellers auto creation");
	}
	
	public static void main(String[] args) throws Exception {
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
			
			
			do {
	            try {
	                System.out.print("Enter the Command: ");
	    			command = reader.nextInt();
	                break;  // Exit the loop if input is successfully read
	            } catch (InputMismatchException e) {
	                System.out.println("Error: Command must be an integer, try again");
	                reader.next();  // Clear the invalid input from scanner
	            }
	        } while (true); 
			
			//reset leaveMode flag
			leaveMode = false;
			//switch case between the different commands
			switch(command) {
			case 0:
				//case 0 exit
				exit();
				break;
			case 1:
				//case 1 add seller
				//loop for taken name
				System.out.println("[Adding Seller] fill the details below");
				while(!leaveMode) {
					System.out.print("	Enter seller name (Type quit to cancel): ");
					sellerName = reader.next();
					if (sellerName.equals("quit".toLowerCase())) {
						leaveMode = true;
						break;
					}
					sellerIndex = management.findSellerOrBuyerIndexByName(sellerName, false);
					if(sellerIndex != -1) {
						System.out.println("	Seller already exists");
					}
					else {
						break;
					}	
				}
				
				//asking for the seller`s password
				while (sellerPassword.trim() == "" && !leaveMode) {
					System.out.print("	Enter seller password (Type quit to cancel): ");
					sellerPassword = reader.next();
				}
				// adding the seller to the array that in the management class
				if (!leaveMode) {
					management.addHuman(sellerName, sellerPassword, null);
					System.out.println("	[ Added seller ]");
					//reset password for next seller
					sellerPassword = "";
				}
				break;
				
			case 2:
				buyerAddress = "";
				buyerPassword = "";
				//case 2 add buyer
				//loop for taken name
				System.out.println("[Adding Buyer] enter the details below");
				while(!leaveMode) {
					System.out.print("	Enter buyer's name (Type quit to cancel): ");
					buyerName = reader.next();
					if (buyerName.equals("quit".toLowerCase())) {
						leaveMode = true;
						break;
					}
					buyerIndex = management.findSellerOrBuyerIndexByName(buyerName, true);
					if(buyerIndex != -1) {
						System.out.println("	Buyer already exists");
					}
					else {
						break;
					}	
				}
				//asking for the buyer`s password
				while (buyerPassword.trim() == "" && leaveMode == false) {
					System.out.print("	Enter buyer password (No spaces allowed): ");
					buyerPassword = reader.next();
				}
				//asking for the buyer`s address
				while (buyerAddress.trim() == "" && leaveMode == false) {
					System.out.print("	Enter buyer address (No spaces allowed): ");
					buyerAddress = reader.next();
				}
				// adding the buyer to the array that in the management class
				if (!leaveMode) {
					management.addHuman(buyerName, buyerPassword, buyerAddress);
					System.out.println("	[Buyer added]");
				}
				break;
				
			case 3:
				//add product to seller
				System.out.println("[Adding product to seller] fill the details below");
				if (management.getSellersCount() == 0) {
					System.out.println("	There are 0 available sellers.");
					break;
				}else {
					//add item to seller
					sellerIndex = -1;
					while(sellerIndex == -1 && leaveMode == false) {
						//loop choose existing seller
						//add item to seller
						//if no sellers available quit and leave a message
						
<<<<<<< HEAD
						System.out.println("	choose seller (an existing one, Type quit to cancel): ");
						management.displayHumans(false);
=======
						System.out.println("choose seller (an existing one, Type quit to cancel): ");
						System.out.println(management.displayHumans(false));
>>>>>>> fe675c540e1e9dd1b26b3a914a5188d87d932ae4
						//seller name
						sellerName = reader.next();
						if (sellerName.equals("quit".toLowerCase())) {
							leaveMode = true;
							break;
						}
						sellerIndex = management.findSellerOrBuyerIndexByName(sellerName, false);
					}
					if (leaveMode) {
						break;
					}
					System.out.println("	Enter item name you want to add: ");
					//item name
					String item = reader.next();
					Seller tempSeller = (Seller)management.getHumans()[sellerIndex]; // cast to seller so we can use the 'getExistingProducts' method
					while(tempSeller.getExistingProduct(item) != null) {
						//product already exists
						System.out.println("	Item already exists");
						System.out.println("	Enter item name you want to add: ");
						//item name
						item = reader.next();
					}	
					
					//item price
					double itemPrice;
					do {
			            try {
			                System.out.print("	Enter the price: ");
			                itemPrice = reader.nextDouble();
			                break;  // Exit the loop if input is successfully read
			            } catch (InputMismatchException e) {
			                System.out.println("	Error: Price must be a number, try again");
			                reader.next();  // Clear the invalid input from scanner
			            }
			        } while (true); 
					
					
					//item category
			        String category;
			        while (true) {
			            System.out.println("	Enter item category (kids, electricity, office, clothes): ");
			            category = reader.next();
			            if (Categories.contains(category.toLowerCase())) {
			                break;
			            } else {
			                System.out.println("	Invalid category. Please choose again.");
			            }
			        }
					
					System.out.println("	Does the product have a special wrap? (yes/no): ");
			        String specialWrap = reader.next();
					while(!specialWrap.toLowerCase().equals("yes") && !specialWrap.toLowerCase().equals("no")) {
						//enter if answer isn't yes or no is wrong exit if category is right
						System.out.println("	Wrong answer choose again");
						System.out.println("	Does the product have a special wrap? (yes/no): ");
						specialWrap = reader.next();
					}
			        Product product;
			        //check for wrap if yes get added cost else normal product
			        if (specialWrap.toLowerCase().equals("yes")) {
			            System.out.println("	Enter the additional cost for the special wrap: ");
			            double addedCost;
			            do {
				            try {
				                System.out.print("	Enter the price: ");
				                addedCost = reader.nextDouble();
				                break;  // Exit the loop if input is successfully read
				            } catch (InputMismatchException e) {
				                System.out.println("	Error: Price must be a number, try again");
				                reader.next();  // Clear the invalid input from scanner
				            }
				        } while (true); 
			            product = new SpecialProduct(item, itemPrice, category, true, addedCost);
			        } 
			        else {
			            product = new Product(item, itemPrice, category);
			        }
					// add product to seller
			        tempSeller = (Seller)management.getHumans()[sellerIndex]; // same casting as before
					tempSeller.addProduct(product);
					System.out.println("	[Product added]");
					break;
				}
				
			case 4:
				//case 4 add item to buyer
				buyerIndex = -1;
				System.out.println("[Adding product to buyer] fill the details below");
				while(buyerIndex == -1) {
					//loop choose existing buyer
<<<<<<< HEAD
					System.out.println("	choose buyer (Type quit to cancel): ");
					management.displayHumans(true);
=======
					System.out.println("choose buyer (Type quit to cancel): ");
					System.out.println(management.displayHumans(true));
>>>>>>> fe675c540e1e9dd1b26b3a914a5188d87d932ae4
					//buyer name
					buyerName = reader.next();
					if (buyerName.equals("quit".toLowerCase())) {
						leaveMode = true;
						break;
					}
					buyerIndex = management.findSellerOrBuyerIndexByName(buyerName, true);
				}
				
				sellerIndex = -1;
				while(sellerIndex == -1 && leaveMode == false) {
					//loop choose existing seller
<<<<<<< HEAD
					System.out.println("	Choose seller: ");
					management.displayHumans(false);
=======
					System.out.println("choose seller: ");
					System.out.println(management.displayHumans(false));
>>>>>>> fe675c540e1e9dd1b26b3a914a5188d87d932ae4
					//seller name
					sellerName = reader.next();
					sellerIndex = management.findSellerOrBuyerIndexByName(sellerName, false);
				}
				if (leaveMode) {
					break;
				}
				System.out.println("	Here are the products you can find in " + sellerName + "`s store");
				String productName = "";
				Product chosenProduct = null;
				//buyer is choosing a product
				//displaying the products of the chosen seller
				//get seller
				Seller chosenSeller = (Seller)management.getHumans()[sellerIndex];
				//System.out.println(chosenSeller.getName()); // remove 
				System.out.println(chosenSeller.displayProducts());
				if (chosenSeller.getProducts()[0] != null) {
					
					Seller tempSeller;
					while(true) {
						//loop choose existing product
						System.out.println("	Choose product: ");
						productName = reader.next();
						tempSeller = (Seller)management.getHumans()[sellerIndex];
						chosenProduct = tempSeller.getExistingProduct(productName);
						if (chosenProduct != null) {
							break;
						}
					}
					Buyer tempBuyer = (Buyer)management.getHumans()[buyerIndex];
					tempBuyer.addProduct(chosenProduct.getName(), chosenProduct.getPrice(), chosenProduct.getCategory());
					System.out.println("	[Product Added] ");
				}
				else {
					System.out.println("	There are no products in the store");
				}
				break;

			case 5:	
				while(!leaveMode) {
					System.out.println(management.displayHumans(true));
					System.out.print("Enter buyer's name (Type quit to cancel): ");
					buyerName = reader.next();
					if (buyerName.equals("quit".toLowerCase())) {
						leaveMode = true;
						break;
					}
					buyerIndex = management.findSellerOrBuyerIndexByName(buyerName, true);
					if(buyerIndex == -1) {
						System.out.println("Buyer doesnt exists!, try again.");
					}
					else {
						break;
					}	
				}
				
				if(leaveMode) {
					//quit
					break;
				}
				
				// show the cart, the total price.				
				Buyer buyer = (Buyer)management.getHumans()[buyerIndex];
				try {
		            if (buyer.getProductsCount() == 0) {
		                throw new Exception("The cart is empty!");
		            } else {
		                System.out.println("Here is your cart: ");
		                System.out.println(buyer.displayProducts());
		                System.out.println("Total price of: " + buyer.cartPrice());
		                buyer.moveToPreviousCarts();
		            }
		        } catch (Exception e) {
		            System.out.println("Error: " + e.getMessage());
		        }
				break;
			case 6:
				//case 6 show all buyers
				System.out.print(management.displayBuyersWithCart());
				break;
			case 7:
				//case 7 show all sellers
				System.out.println(management.displaySellersWithProducts());
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
				System.out.println(management.displayAllItemsFromACategory(category));
				break;
				
			case 9:
				while(!leaveMode) {
					System.out.println(management.displayHumans(true));
					System.out.print("Enter buyer's name (Type quit to cancel): ");
					buyerName = reader.next();
					if (buyerName.equals("quit".toLowerCase())) {
						leaveMode = true;
						break;
					}
					buyerIndex = management.findSellerOrBuyerIndexByName(buyerName, true);
					if(buyerIndex == -1) {
						System.out.println("Buyer doesnt exists!, try again.");
					}
					else {
						break;
					}	
				}
				if(leaveMode) {
					break;
				}
				// show the cart, the total price.				
				Buyer temporaryBuyer = (Buyer)management.getHumans()[buyerIndex];
				
				if (temporaryBuyer.getProducts().length > 0) {
					System.out.println("Your currect cart is not empty, are you sure you want to proceed? (yes/no): ");
			        String result = reader.next();
					while(!result.toLowerCase().equals("yes") && !result.toLowerCase().equals("no")) {
						//enter if answer isn't yes or no is wrong exit if category is right
						System.out.println("wrong answer choose again");
						System.out.println("Does the product have a special wrap? (yes/no): ");
						result = reader.next();
					}
					if (result.equals("no")) {
						System.out.println("Your cart remained the same.");
						break;
					}
				}
				
				System.out.println(temporaryBuyer.displayPreviousCarts());
				int cartNumber;
				do {
		            try {
		                System.out.print("Enter wanted cart: ");
		    			cartNumber = reader.nextInt();
		    			if (cartNumber >= temporaryBuyer.getPreviousCarts().length || cartNumber < 0) {
		    				throw new Exception("There is no cart indexed " + cartNumber);
		    			}
		                break;  // Exit the loop if input is successfully read
		            } catch (Exception e) {
		                System.out.println("Error: " + e.getMessage());
		                reader.next();  // Clear the invalid input from scanner
		            }
		        } while (true); 
				
				// setting the prev cart to the new cart
				temporaryBuyer.setProducts(temporaryBuyer.getPreviousCarts()[cartNumber].getProducts());
				System.out.println("[SUCCESS] Your cart has been updated !");
				
				
				break;

				case 10:
					int botsAmount = 5;
					// adding sellers.
					int basePrice = 50;
					for(int i = 0; i < botsAmount; i++){
						management.addHuman("Sellerbot" + i, "password" + i, null);
						Seller tmpSeller = (Seller)management.getHumans()[i];
						tmpSeller.addProduct(new Product("productExample" + i, i + basePrice, "category" + i));
					}
					//adding buyers.
					for(int i = 0; i < botsAmount; i++){
						management.addHuman("Buyerbot" + i, "password" + i, "address" + i);
						Buyer tmpBuyer = (Buyer)management.getHumans()[botsAmount + i];
						tmpBuyer.addProduct("productExample"+i, i + basePrice, "category" + i);
					}
					System.out.println("[Added bots] - 5 sellers - 5 buyers - each with one product.");
					break;
			}

		}
	}
}
