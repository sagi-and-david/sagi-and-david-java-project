import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Management{

	int humansCount;
	Human[] humans;
	int sellersCount;
	int buyersCount;
	
	public Management() {

		this.humans = new Human[10];
		this.humansCount = 0;
		this.sellersCount = 0;
		this.buyersCount = 0;
	}
	

	public Human[] getHumans() {
		return humans;
	}
	
	public void addHuman(String name, String password, String address) { // if address is null the human is seller
		if (this.humansCount >= this.humans.length) {
			this.expandHumansArray();
		}
		if (address == null) {
			this.humans[humansCount] = new Seller(name, password);
			this.humansCount++;
			this.sellersCount++;
		}else {
			this.humans[humansCount] = new Buyer(name, password, address);
			this.humansCount++;
			this.buyersCount++;
		}
	}

	public String displayHumans(boolean isBuyer) {
		
		String printText = "";
		
		for (int i = 0; i < this.humans.length; i++) {
			//using the get methods in the Buyer class
			if (this.humans[i] == null) {
				break;
			}
			
			if (isBuyer) {
				if (humans[i] instanceof Buyer) {
					printText += ((Buyer)humans[i]).toString() + "\n";
				}
			}else {
				if (humans[i] instanceof Seller) {
					printText += ((Seller)humans[i]).toString() + "\n";
				}
			}
		} 
		return printText;
	}
	
	public String displayBuyersWithCart() {
	    // Create an array of Buyers
	    Buyer[] buyers = new Buyer[buyersCount];

	    // Populate the array with Buyers
	    int index = 0;
	    
	    String printText = "";
	    
	    for (Human human : humans) {
	        if (human instanceof Buyer) {
	            buyers[index++] = (Buyer) human;
	        }
	    }

	    // Sort buyers based on name using Comparator
	    Arrays.sort(buyers, Comparator.comparing(Buyer::getName));

	    // Print buyers with their carts
	    for (Buyer buyer : buyers) {
	        printText += "Buyer name: " + buyer.getName() + " Buyer password: " + buyer.getPassword() + " Buyer address: " + buyer.getAddress() + "\n";
	        if (buyer.getProducts() != null) {
	            printText += "current cart: \n";
	            printText += buyer.displayProducts() + "\n";
	        }
	        if (buyer.getPreviousCarts() != null) {
	            printText += "previous carts: \n";
	            printText += buyer.displayPreviousCarts() + "\n";
	        }	        
	    }
	    return printText;
	}

	public String displaySellersWithProducts() {
	    // Create an array of Sellers
	    Seller[] sellers = new Seller[sellersCount];

	    // Populate the array with Sellers
	    int index = 0;
	    
	    String printText = "";
	    
	    for (Human human : humans) {
	        if (human instanceof Seller) {
	            sellers[index++] = (Seller) human;
	        }
	    }

	    // Sort sellers based on product count in descending order using Comparator
	    Arrays.sort(sellers, Comparator.comparingInt(Seller::getProductsCount).reversed());

	    // Print sellers with their products
	    for (Seller seller : sellers) {
	    	printText += "Seller name: " + seller.getName() + " Seller password: " + seller.getPassword() + "\n";
	        printText += seller.displayProducts() + "\n";
	    }
	    return printText;
	}

	public String displayAllItemsFromACategory(String category) {
		String printText = "";
		for (int i = 0; i < this.humans.length; i++) {
			//using the get methods in the Seller class
			if (this.humans[i] == null) {
				//if null no seller exists
				break;
			}
			if (humans[i] instanceof Seller) {
				Seller tempSeller = (Seller)humans[i];
				//run on products from seller and if product from category print it
				for(int j = 0; j < tempSeller.getProducts().length; j++) {
					if(tempSeller.getProducts() == null) {
						//if null no products exit
						break;
					}
					if(tempSeller.getProducts()[j] == null) {
						//if null end of products in product array or no products in products array then exit
						break;
					}
					if(tempSeller.getProducts()[j].getCategory() == null) {
						//no category
						break;
					}
					if(tempSeller.getProducts()[j].getCategory().equals(category)) {
						//if product category fits category then print
						printText += tempSeller.getProducts()[j].toString() + "\n";
					}
				}
			}
		}
		return printText;
	}

	public int getSellersCount() {
		return sellersCount;
	}

	public int getBuyersCount() {
		return buyersCount;
	}

	private void expandHumansArray() {
		Human[] newHumansArray = new Human[this.humans.length * 2];
		for (int i = 0; i < this.humans.length; i++) {
			newHumansArray[i] = this.humans[i];
		}
		this.humans = newHumansArray;
	}
	
	public boolean checkBuyerExistance(String humanName, boolean isBuyer) {
		for(int i = 0; i < humans.length; i++) {
			if (humans[i] == null) {
				return false;
			}
			if (isBuyer) {
				if (humans[i] instanceof Buyer) {
					if (humans[i].getName().equals(humanName)) {
						return true;
					}					
				}
			}else {
				if (humans[i] instanceof Seller) {
					if (humans[i].getName().equals(humanName)) {
						return true;
					}					
				}
			}
			
		}
		return false;
	}
	
	public int findSellerOrBuyerIndexByName(String name, boolean isBuyer) {
		
		for (int i = 0; i < humans.length; i++) {
			if (this.humans[i] == null) {
				return -1;
			}
			if (isBuyer) {
				if (humans[i] instanceof Buyer) {
					if (humans[i].getName().equals(name)) {
						return i;
					}					
				}
			}else {
				if (humans[i] instanceof Seller) {
					if (humans[i].getName().equals(name)) {
						return i;
					}					
				}
			}
		}
		return -1;
	}
	
	
}
