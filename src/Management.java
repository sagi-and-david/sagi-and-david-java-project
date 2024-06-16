
public class Management{
	Buyer[] buyers;
	Seller[] sellers;
	int sellersCount;
	int buyersCount;
	
	public Management() {
		this.buyers = new Buyer[10];// initiating with 10 if needed will be expanded
		this.sellers = new Seller[10];// initiating with 10 if needed will be expanded
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
	
	public Buyer[] getBuyers() {
		return buyers;
	}

	public Seller[] getSellers() {
		return sellers;
	}
	
	public void addSeller(String name, String password) {
		if (this.sellersCount >= this.sellers.length) {
			this.expandSellersArray();
		}
		this.sellers[sellersCount] = new Seller(name, password);
		this.sellersCount++;
	}
	
	public void addBuyer(String name, String password, String address) {
		if (this.buyersCount >= this.buyers.length) {
			this.expandBuyersArray();
		}
		System.out.println("index that will be in: " + buyersCount);
		this.buyers[buyersCount] = new Buyer(name, password, address);
		this.buyersCount++;
	}
	
	public void displayBuyers() {
		for (int i = 0; i < this.buyers.length; i++) {
			//using the get methods in the Buyer class
			if (this.buyers[i] == null) {
				break;
			}
			System.out.println("Buyer name: " + this.buyers[i].getName() + " Buyer password: " + this.buyers[i].getPassword() + " Buyer address: " + this.buyers[i].getAddress());
		}
	}
	public void displaySellers() {
		for (int i = 0; i < this.sellers.length; i++) {
			//using the get methods in the Seller class
			if (this.sellers[i] == null) {
				break;
			}
			System.out.println("Seller name: " + this.sellers[i].getName() + " Seller password: " + this.sellers[i].getPassword());
		}
	}
	
	private void expandSellersArray() {
		Seller[] newSellersArray = new Seller[this.sellers.length * 2];
		for (int i = 0; i < this.sellers.length; i++) {
			newSellersArray[i] = this.sellers[i];
		}
		this.sellers = newSellersArray;
	}
	
	public int getSellersCount() {
		return sellersCount;
	}

	public int getBuyersCount() {
		return buyersCount;
	}

	private void expandBuyersArray() {
		Buyer[] newBuyersArray = new Buyer[this.buyers.length * 2];
		for (int i = 0; i < this.buyers.length; i++) {
			newBuyersArray[i] = this.buyers[i];
		}
		this.buyers = newBuyersArray;
	}
	
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
	
}
