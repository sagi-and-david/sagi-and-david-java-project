//Sagi Galian 214804445
//David Bekker 328088521
//teacher: Eyal Eisenstein
import javax.print.attribute.standard.JobKOctets;
import java.security.KeyStore;
import java.util.*;
<<<<<<< HEAD

=======
>>>>>>> 926750609378702dafe8f16d3265cd9596d62f30

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
<<<<<<< HEAD
		System.out.println("	Order 99");
		System.out.println("	Order 100");
		System.out.println("	Order 101");
		System.out.println("	Order 102");
		System.out.println("	Order 103");
=======
		System.out.println("	99- Display names by order in the array");
		System.out.println("	100-Display names by order in the array no duplicates");
		System.out.println("	101-Get number of duplicates for a given name");
		System.out.println("	102-Double each name into an arraylist");
		System.out.println("	103-Print names by length.");
>>>>>>> 926750609378702dafe8f16d3265cd9596d62f30
	}

	
	public static void addSeller(Management management){
		System.out.println("[Adding Seller] fill the details below");
		boolean running = true;
		String sellerName = "";
		String sellerPassword = "";
		int sellerIndex;
		while(running) {
			System.out.print("	Enter seller name (Type quit to cancel): ");
			sellerName = reader.next();
			if (sellerName.equals("quit".toLowerCase())) {
				running = false;
				return;
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
		while (sellerPassword.trim().isEmpty()) {
			System.out.print("	Enter seller password (Type quit to cancel): ");
			sellerPassword = reader.next();
		}
		// adding the seller to the array that in the management class
		management.addHuman(sellerName, sellerPassword, null);
		System.out.println("	[ Added seller ]");
		//reset password for next seller
	}
	
	
	public static void addBuyer(Management management){
		//case 2 add buyer
		boolean running = true;
		String buyerAddress = "";
		String buyerPassword = "";
		String buyerName = "";
		int buyerIndex;
		System.out.println("[Adding Buyer] enter the details below");
		//loop for taken name
		while(running) {
			System.out.print("	Enter buyer's name (Type quit to cancel): ");
			buyerName = reader.next();
			if (buyerName.equals("quit".toLowerCase())) {
				running = false;
				return;
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
		while (buyerPassword.trim().isEmpty()) {
			System.out.print("	Enter buyer password (No spaces allowed): ");
			buyerPassword = reader.next();
		}
		//asking for the buyer`s address
		while (buyerAddress.trim().isEmpty()) {
			System.out.print("	Enter buyer address (No spaces allowed): ");
			buyerAddress = reader.next();
		}
		// adding the buyer to the array that in the management class
		management.addHuman(buyerName, buyerPassword, buyerAddress);
		System.out.println("	[Buyer added]");
	}

	
	public static void addProductToSeller(Management management){
		//add product to seller
		int sellerIndex;
		String sellerName = "";
		boolean running = true;
		System.out.println("[Adding product to seller] fill the details below");
		if (management.getSellersCount() == 0) {
			System.out.println("	There are 0 available sellers.");
			return;
		}else {
			//add item to seller
			sellerIndex = -1;
			while(sellerIndex == -1 && running) {
				//loop choose existing seller
				//add item to seller
				//if no sellers available quit and leave a message

				System.out.println("	choose seller (an existing one, Type quit to cancel): ");
				management.displayHumans(false);
				System.out.println("choose seller (an existing one, Type quit to cancel): ");
				System.out.println(management.displayHumans(false));
				//seller name
				sellerName = reader.next();
				if (sellerName.equals("quit".toLowerCase())) {
					return;
				}
				sellerIndex = management.findSellerOrBuyerIndexByName(sellerName, false);
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
		}
	}
	
	
	public static void addItemToBuyer(Management management) {
		//case 4 add item to buyer
	    int buyerIndex = -1;
	    int sellerIndex = -1;
	    String buyerName = ""; // Initialize buyerName
	    String sellerName = ""; // Initialize sellerName
	    boolean leaveMode = false;

	    System.out.println("[Adding product to buyer] Fill in the details below:");

	    // Loop to choose an existing buyer
	    while (buyerIndex == -1) {
	        System.out.println("	Available Buyers:");
	        System.out.println(management.displayHumans(true)); // Display all buyers
	        System.out.println("	Choose buyer (Type quit to cancel): ");
	        buyerName = reader.next();
	        if (buyerName.equalsIgnoreCase("quit")) {
	            leaveMode = true;
	            break;
	        }
	        buyerIndex = management.findSellerOrBuyerIndexByName(buyerName, true);
	        if (buyerIndex == -1) {
	            System.out.println("	Buyer doesn't exist, try again.");
	        }
	    }

	    // Exit if leaveMode is set
	    if (leaveMode) {
	        System.out.println("	Action canceled.");
	        return;
	    }

	    // Loop to choose an existing seller
	    while (sellerIndex == -1) {
	        System.out.println("	Available Sellers:");
	        System.out.println(management.displayHumans(false)); // Display all sellers
	        System.out.println("	Choose seller: ");
	        sellerName = reader.next();
	        sellerIndex = management.findSellerOrBuyerIndexByName(sellerName, false);
	        if (sellerIndex == -1) {
	            System.out.println("	Seller doesn't exist, try again.");
	        }
	    }

	    System.out.println("	Here are the products available in " + sellerName + "'s store:");

	    // Display products from the chosen seller
	    Seller chosenSeller = (Seller) management.getHumans()[sellerIndex];
	    System.out.println(chosenSeller.displayProducts());

	    if (chosenSeller.getProducts()[0] == null) {
	        System.out.println("	There are no products in the store.");
	        return;
	    }

	    // Buyer chooses a product
	    String productName;
	    Product chosenProduct = null;
	    while (chosenProduct == null) {
	        System.out.println("	Choose a product: ");
	        productName = reader.next();
	        chosenProduct = chosenSeller.getExistingProduct(productName);
	        if (chosenProduct == null) {
	            System.out.println("	Product doesn't exist, try again.");
	        }
	    }

	    // Add the product to the buyer's cart
	    Buyer tempBuyer = (Buyer) management.getHumans()[buyerIndex];
	    tempBuyer.addProduct(chosenProduct.getName(), chosenProduct.getPrice(), chosenProduct.getCategory());
	    System.out.println("	[Product Added] " + chosenProduct.getName() + " has been added to " + buyerName + "'s cart.");
	}

	
	public static void handleBuyerPayment(Management management) {
		//case 5 payment
	    int buyerIndex = -1;
	    String buyerName = ""; // Initialize buyerName

	    System.out.println("[Processing payment] Please select a buyer to proceed:");

	    // Loop to choose an existing buyer
	    while (buyerIndex == -1) {
	        System.out.println("    Available Buyers:");
	        System.out.println(management.displayHumans(true)); // Display all buyers
	        System.out.println("    Choose buyer (Type quit to cancel): ");
	        buyerName = reader.next();
	        if (buyerName.equalsIgnoreCase("quit")) {
	            System.out.println("    Payment process canceled.");
	            return;
	        }
	        buyerIndex = management.findSellerOrBuyerIndexByName(buyerName, true);
	        if (buyerIndex == -1) {
	            System.out.println("    Buyer doesn't exist, try again.");
	        }
	    }

	    // Get the buyer's cart and process payment
	    Buyer buyer = (Buyer) management.getHumans()[buyerIndex];
	    double totalAmount = buyer.cartPrice();
	    
	    if (totalAmount > 0) {
	        System.out.println("    Total amount to pay: " + totalAmount);
	        System.out.println("    Proceed with payment? (yes/no)");

	        String paymentChoice = reader.next();
	        if (paymentChoice.equalsIgnoreCase("yes")) {
	            System.out.println("    Payment of " + totalAmount + " processed successfully.");
	            buyer.moveToPreviousCarts();  
	            buyer.clearCart();// Clear the cart after successful payment
	            System.out.println("    Thank you for your purchase, " + buyerName + "!");
	        } else {
	            System.out.println("    Payment canceled.");
	        }
	    } else {
	        System.out.println("    Your cart is empty, no payment required.");
	    }
	}

	
	public static void displayAllBuyersWithCarts(Management management) {
		//case 6 display all buyers with their carts
	    if (management != null) {
	        System.out.println("[All Buyers With Their Carts]");
	        System.out.println(management.displayBuyersWithCart());  // Assuming this method already exists
	    } else {
	        System.out.println("Management system not initialized.");
	    }
	}

	
	public static void displayAllSellersWithProducts(Management management) {
		//case 7 display all sellers with products
	    if (management != null) {
	        System.out.println("[All Sellers With Their Products]");
	        System.out.println(management.displaySellersWithProducts());  // Assuming this method already exists in Management class
	    } else {
	        System.out.println("Management system not initialized.");
	    }
	}

	
	public static void displayItemsFromCategory(Management management) {
		//case 8 display items from a category
	    boolean leaveMode = false;

	    // Prompt for category selection
	    System.out.println("Choose category (kids, electricity, office, clothes) type quit to cancel:");
	    String category = reader.next();
	    
	    // Exit if the user types 'quit'
	    if (category.equalsIgnoreCase("quit")) {
	        leaveMode = true;
	    }
	    
	    // Validate category input
	    while (!leaveMode && !Categories.contains(category)) {
	        System.out.println("Wrong category. Choose again (kids, electricity, office, clothes):");
	        category = reader.next();
	        if (category.equalsIgnoreCase("quit")) {
	            leaveMode = true;
	        }
	    }
	    
	    // If the user didn't choose to leave, display items from the chosen category
	    if (!leaveMode) {
	        String items = management.displayAllItemsFromACategory(category);
	        System.out.println(items.isEmpty() ? "No items found in this category." : items);
	    }
	}

	
	public static void changeCartForBuyer(Management management) {
	    boolean leaveMode = false;
	    String buyerName;
	    int buyerIndex = -1; // Initialize buyerIndex to a default value (-1)

	    // Loop to find the buyer by name
	    while (!leaveMode) {
	        System.out.println(management.displayHumans(true)); // Display all humans (buyers/sellers)
	        System.out.print("Enter buyer's name (Type quit to cancel): ");
	        buyerName = reader.next();
	        
	        if (buyerName.equalsIgnoreCase("quit")) {
	            leaveMode = true;
	            break;
	        }
	        
	        // Find the index of the buyer
	        buyerIndex = management.findSellerOrBuyerIndexByName(buyerName, true);
	        
	        if (buyerIndex == -1) {
	            System.out.println("Buyer doesn't exist! Try again.");
	        } else {
	            break; // Exit if the buyer exists
	        }
	    }
	    
	    // If leaveMode is true, exit the function
	    if (leaveMode) {
	        return;
	    }

	    // Now that we have a valid buyerIndex, retrieve the buyer object
	    Buyer temporaryBuyer = (Buyer) management.getHumans()[buyerIndex];
	    
	    // Check if the buyer has any products in their current cart
	    if (temporaryBuyer.getProducts().length > 0) {
	        System.out.println("Your current cart is not empty, are you sure you want to proceed with changing the cart? (yes/no): ");
	        String result = reader.next();
	        
	        while (!result.equalsIgnoreCase("yes") && !result.equalsIgnoreCase("no")) {
	            System.out.println("Invalid response. Please answer 'yes' or 'no'.");
	            result = reader.next();
	        }
	        
	        if (result.equalsIgnoreCase("no")) {
	            System.out.println("Your cart remains unchanged.");
	            return; // Exit if the user chooses "no"
	        }
	    }

	    // Display the buyer's previous carts and allow the user to select one
	    System.out.println(temporaryBuyer.displayPreviousCarts());
	    
	    int cartNumber;
	    // Input loop to ensure valid cart selection
	    do {
	        try {
	            System.out.print("Enter the number of the cart you want to select: ");
	            cartNumber = reader.nextInt();
	            if (cartNumber < 0 || cartNumber >= temporaryBuyer.getPreviousCarts().length) {
	                throw new Exception("There is no cart indexed " + cartNumber);
	            }
	            break; // Exit if valid cart number is entered
	        } catch (Exception e) {
	            System.out.println("Error: " + e.getMessage());
	            reader.next(); // Clear the invalid input
	        }
	    } while (true); 
	    
	    // Set the selected previous cart as the current cart
	    temporaryBuyer.setProducts(temporaryBuyer.getPreviousCarts()[cartNumber].getProducts());
	    System.out.println("[SUCCESS] Your cart has been updated!");
	}
	
	
	public static void createBots(Management management) {
		//case 10 create bots
		System.out.println("[Creating Bots] notice this is 'demo mode' for checking, your real data will get lost");
		management.reset();
		int botsAmount = 5;
		// adding sellers.
		int basePrice = 50;
		for(int i = 0; i < botsAmount; i++){
			management.addHuman("Sellerbot" + i, "password" + i, null);
			Seller tmpSeller = (Seller)management.getHumans()[i];
			tmpSeller.addProduct(new Product("productExample" + i, i + basePrice, "kids"));
		}
		//adding buyers.
		for(int i = 0; i < botsAmount; i++){
			management.addHuman("Buyerbot" + i, "password" + i, "address" + i);
			Buyer tmpBuyer = (Buyer)management.getHumans()[botsAmount + i];
			tmpBuyer.addProduct("productExample"+i, i + basePrice, "kids");
		}
		System.out.println("[Added bots] - 5 sellers - 5 buyers - each with one product.");
		
	}
	
	
	public static void printHumanNamesByOrder(Management management) {
		System.out.println(management.displayHumansByName());
	}
	
	
	public static void printHumanNamesByOrderNoDuplicates(Management management) {
		Iterator<String> iter = management.uniqueStrings.iterator();
		String currStr = "";
		while(iter.hasNext()){
			currStr = iter.next();
			System.out.println(currStr + "........" + management.countMap.get(currStr));
		}
	}

	public static void insertEachNameTwiceIntoArrayListAndDisplay(Management management){
		ListIterator<String> listIter = management.doubleNames.listIterator(management.doubleNames.size());
		while (listIter.hasPrevious()){
			System.out.println(listIter.previous());
		}
	}

	public static void buildTreeSet(Management management){
		management.orderHumanByTheLengthOfTheName();
		Iterator<String> iter = management.sortedNames.iterator();
        while(iter.hasNext()){
			System.out.println(iter.next());
        }
	}
	
	public static void getNumberOfDuplicatesByGivenName(Management management) {

		System.out.println("enter a string: ");
		String input = reader.next();
		Integer times = management.countMap.get(input.toLowerCase());
		System.out.println("the number of times " + input 
							+ " appears in the original array is " 
<<<<<<< HEAD
							+ management.timesANameShowsInHumans(input));
=======
							+ (times == null? 0: times));
>>>>>>> 926750609378702dafe8f16d3265cd9596d62f30
		}
	
	
	public static void order102(Management management) {
		ArrayList<String> arraylist = management.humansWithOutDuplicatesWithArrayList();
		ListIterator<String> it = arraylist.listIterator();
		//go to the end
		while(it.hasNext()) {
			it.next();
		}
		//go backwards
		while(it.hasPrevious()) {
			System.out.println(it.previous() + "\n");
		}
	}
	
	
	public static void order103(Management management) {
		String humansList = management.allHumansFromTreeSet();
		System.out.println(humansList.toUpperCase());
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
				//exit
				exit();
				break;

			case 1:
				//add Seller
				addSeller(management);
				break;
				
			case 2:
				//add Buyer
				addBuyer(management);
				break;
				
			case 3:
				//add product to seller
				addProductToSeller(management);
				break;
				
			case 4:
				//add item to buyer
				addItemToBuyer(management);
				break;

			case 5:
				handleBuyerPayment(management);
				break;
			case 6:
				//case 6 show all buyers
				displayAllBuyersWithCarts(management);
				break;
			case 7:
				//case 7 show all sellers
				displayAllSellersWithProducts(management);
				break;
			
			case 8:
				//case 8 display all items from a category 
				displayItemsFromCategory(management);
				break;
				
			case 9:
				//case 9 change cart for buyer
				changeCartForBuyer(management);
				break;
				
			case 10:
				//case 10 create bots
				createBots(management);
				break;
			
			case 99:
				printHumanNamesByOrder(management);
				break;
			case 100:
				printHumanNamesByOrderNoDuplicates(management);
				break;	
			case 101:
				getNumberOfDuplicatesByGivenName(management);
				break;	
<<<<<<< HEAD
			case 102:
				order102(management);
				break;
			case 103:
				order103(management);
=======

			case 102:
				insertEachNameTwiceIntoArrayListAndDisplay(management);
				break;

			case 103:
				buildTreeSet(management);
>>>>>>> 926750609378702dafe8f16d3265cd9596d62f30
				break;
			}
		}
	}
}
