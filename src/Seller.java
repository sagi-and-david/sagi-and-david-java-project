
public class Seller {
	private String name;
	private String password;
	private Product[] products;
	private int productsCount;
	
	public Seller(String name, String password) {
		this.name = name;
		this.password = password;
		this.products = new Product[10]; // initiating with 10 if needed will be expanded
		this.productsCount = 0;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Product[] getProducts() {
		return this.products;
	}

	public void expandProduct() {
		Product[] newProductsArray = new Product[this.products.length * 2];
		for (int i = 0; i < this.products.length; i++) {
			newProductsArray[i] = this.products[i];
		}
		this.products = newProductsArray;
	}
	
	public void addProduct(Product product) {
		if (this.productsCount >= this.products.length) {
			this.expandProduct();
		}
		this.products[this.productsCount] = product;
		
		this.productsCount++;
	}
	
	public void displayProducts() {
		for(int i = 0; i < this.products.length; i++) {
			if (this.products[i] == null) {
				break;
			}
		 
		 System.out.println(products[i].toString());
		}
	}
	
	public Product getExistingProduct(String productName) {
		for (int i = 0; i<this.products.length; i ++) {
			if (this.products[i] == null) {
				return null;
			}
			if (productName.equals(this.products[i].getName())) {
				return this.products[i];
			}
		}
		return null;
	}
	
}
