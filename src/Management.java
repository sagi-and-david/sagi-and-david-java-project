import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Management{
	//Buyer[] buyers;
	//Seller[] sellers;
	int humansCount;
	Human[] humans;
	int sellersCount;
	int buyersCount;
	
	public Management() {
		//this.buyers = new Buyer[10];// initiating with 10 if needed will be expanded
		//this.sellers = new Seller[10];// initiating with 10 if needed will be expanded
		
		this.humans = new Human[10];
		this.humansCount = 0;
		this.sellersCount = 0;
		this.buyersCount = 0;
		
		// adding buyer and seller for checking
		/*
		this.buyers[0] = new Buyer("sagi","password1","maale adumim");
		this.sellers[0] = new Seller("david","password2");
		
		this.sellers[0].addProduct("milk", 12, "FOOD");
		this.sellers[0].addProduct("shirt", 89, "CLOTHS");
		this.sellers[0].addProduct("wallet", 330, "SPECIAL");
		this.sellers[0].addProduct("ball", 33, "SPORT");

		this.sellersCount++;
		this.buyersCount++;
		*/
	}
	
//	public Buyer[] getBuyers() {
//		return buyers;
//	}
//
//	public Seller[] getSellers() {
//		return sellers;
//	}
	public Human[] getHumans() {
		return humans;
	}
	
//	public void addSeller(String name, String password) {
//		if (this.sellersCount >= this.sellers.length) {
//			this.expandSellersArray();
//		}
//		this.sellers[sellersCount] = new Seller(name, password);
//		this.sellersCount++;
//	}
//	
//	public void addBuyer(String name, String password, String address) {
//		if (this.buyersCount >= this.buyers.length) {
//			this.expandBuyersArray();
//		}
//		//System.out.println("index that will be in: " + buyersCount);
//		this.buyers[buyersCount] = new Buyer(name, password, address);
//		this.buyersCount++;
//	}
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
	/*
	public void displayBuyers() {
		//displays buyers without cart
		for (int i = 0; i < this.buyers.length; i++) {
			//using the get methods in the Buyer class
			if (this.buyers[i] == null) {
				break;
			}
			System.out.println("Buyer name: " + this.buyers[i].getName() + " Buyer password: " + this.buyers[i].getPassword() + " Buyer address: " + this.buyers[i].getAddress());
		}
	}
	public void displaySellers() {
		//displays sellers without products
		for (int i = 0; i < this.sellers.length; i++) {
			//using the get methods in the Seller class
			if (this.sellers[i] == null) {
				break;
			}
			System.out.println("Seller name: " + this.sellers[i].getName() + " Seller password: " + this.sellers[i].getPassword());
		}
	}*/
	
	public void displayHumans(boolean isBuyer) {
		for (int i = 0; i < this.humans.length; i++) {
			//using the get methods in the Buyer class
			if (this.humans[i] == null) {
				break;
			}
			
			if (isBuyer) {
				if (humans[i] instanceof Buyer) {
					System.out.println(((Buyer)humans[i]).toString());
				}
			}else {
				if (humans[i] instanceof Seller) {
					System.out.println(((Seller)humans[i]).toString());
				}
			}
		} 
	}
	
	/*
	public void displayBuyersWithCart() 
		//displays buyers with cart
		for (int i = 0; i < this.humans.length; i++) {
			//using the get methods in the Buyer class
			if (this.humans[i] == null) {
				break;
			}
			if (humans[i] instanceof Buyer) {
				Buyer tempBuyer = (Buyer)humans[i];
				//print full buyer info
				System.out.println("Buyer name: " + tempBuyer.getName() + " Buyer password: " + tempBuyer.getPassword() + " Buyer address: " + tempBuyer.getAddress());
				if(tempBuyer.getProducts() != null) {
					System.out.println("current cart: ");
					tempBuyer.displayProducts();
					
				}
				if(tempBuyer.getPreviousCarts() != null) {
					System.out.println("previous carts: ");
					tempBuyer.displayPreviousCarts();
				}				
			}
		}
	}*/ 
	
	public void displayBuyersWithCart() {
	    // Create an array of Buyers
	    Buyer[] buyers = new Buyer[buyersCount];

	    // Populate the array with Buyers
	    int index = 0;
	    for (Human human : humans) {
	        if (human instanceof Buyer) {
	            buyers[index++] = (Buyer) human;
	        }
	    }

	    // Sort buyers based on name using Comparator
	    Arrays.sort(buyers, Comparator.comparing(Buyer::getName));

	    // Print buyers with their carts
	    for (Buyer buyer : buyers) {
	        System.out.println("Buyer name: " + buyer.getName() + " Buyer password: " + buyer.getPassword() + " Buyer address: " + buyer.getAddress());
	        if (buyer.getProducts() != null) {
	            System.out.println("current cart: ");
	            buyer.displayProducts();
	        }
	        if (buyer.getPreviousCarts() != null) {
	            System.out.println("previous carts: ");
	            buyer.displayPreviousCarts();
	        }	        
	    }
	}

	// sagi fisrt
	
	/*
	public void displaySellersWithProducts() { // do not delete this will print the sellers but not in order
		//displays sellers with products
		
		for (int i = 0; i < humans.length; i++) {
			//using the get methods in the Seller class
			if (humans[i] == null) {
				//if null no seller exists
				break;
			}
			if (humans[i] instanceof Seller) {
				Seller tempSeller = (Seller)humans[i];
				//print info of seller
				System.out.println("Seller name: " + tempSeller.getName() + " Seller password: " + tempSeller.getPassword());
				tempSeller.displayProducts();
			}
		}
	}*/
	public void displaySellersWithProducts() {
	    // Create an array of Sellers
	    Seller[] sellers = new Seller[sellersCount];

	    // Populate the array with Sellers
	    int index = 0;
	    for (Human human : humans) {
	        if (human instanceof Seller) {
	            sellers[index++] = (Seller) human;
	        }
	    }

	    // Sort sellers based on product count in descending order using Comparator
	    Arrays.sort(sellers, Comparator.comparingInt(Seller::getProductsCount).reversed());

	    // Print sellers with their products
	    for (Seller seller : sellers) {
	        System.out.println("Seller name: " + seller.getName() + " Seller password: " + seller.getPassword());
	        seller.displayProducts();
	    }
	}


	/*
	private void bubbleSort(Human arr[], int n)
    {
		int counter = 0;
		Seller[] sellers = new Seller[this.sellersCount];
		for (int i = 0; i < this.humansCount; i++) {
			if (humans[i] instanceof Seller) {
				sellers[counter] = (Seller)humans[i];
				counter ++;
			}
		}
		
		Seller temp;
        int i, j;
        boolean swapped;
        for (i = 0; i < n - 1; i++) {
            swapped = false;
            for (j = 0; j < n - i - 1; j++) {
                if (sellers[j].getProductsCount() > sellers[j + 1].getProductsCount()) {

                    // Swap arr[j] and arr[j+1]
                    temp = sellers[j];
                    sellers[j] = sellers[j + 1];
                    sellers[j + 1] = temp;
                    swapped = true;
                }
            }

            // If no two elements were
            // swapped by inner loop, then break
            if (swapped == false)
                break;
        }
    }*/
	
	public void displayAllItemsFromACategory(String category) {
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
						System.out.println(tempSeller.getProducts()[j].toString());
					}
				}
			}
		}
	}
	/*
	private void expandSellersArray() {
		Seller[] newSellersArray = new Seller[this.sellers.length * 2];
		for (int i = 0; i < this.sellers.length; i++) {
			newSellersArray[i] = this.sellers[i];
		}
		this.sellers = newSellersArray;
	}
	
	
	private void expandBuyersArray() {
		Buyer[] newBuyersArray = new Buyer[this.buyers.length * 2];
		for (int i = 0; i < this.buyers.length; i++) {
			newBuyersArray[i] = this.buyers[i];
		}
		this.buyers = newBuyersArray;
	}
	*/
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
	
	/*
	public boolean checkBuyerExistance(String newBuyerName) {
		for(int i = 0; i < buyers.length; i++) {
			if (buyers[i] == null) {
				return false;
			}else {
				if (buyers[i].getName().equals(newBuyerName)) {
					return true;
				}
			}
		}
		return false;
	}
	
	public boolean checkSellerExistance(String newSellerName) {
		for(int i = 0; i < sellers.length; i++) {
			if (sellers[i] == null) {
				return false;
				
			}else {
				if (sellers[i].getName().equals(newSellerName)) {
					return true;
					
				}
			}
		}
		return false;
	}
	*/
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
	
	/*
	public int findSellerIndexByName(String name) {
		
		for (int i = 0; i < this.sellers.length; i++) {
			if (this.sellers[i] == null) {
				return -1;
			}
			if (this.sellers[i].getName().equals(name)) {
				return i;
			}
		}
		return -1;
	}
	
	public int findBuyerIndexByName(String name) {
		for (int i = 0; i < this.buyers.length; i++) {
			if (this.buyers[i] == null) {
				return -1;
			}
			if (this.buyers[i].getName().equals(name)) {
				return i;
			}
		}
		return -1;
	}
	*/
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
