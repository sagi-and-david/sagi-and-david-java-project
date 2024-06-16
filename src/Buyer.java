
public class Buyer {
	private String name;
	private String password;
	private String address;
	private Product[] products;
	private int productsCount;
	
	//constructor
	public Buyer(String name, String password, String address) {
		this.name = name;
		this.password = password;
		this.address = address;
		this.products = new Product[10]; // initiating with 10 if needed will be expanded
		this.productsCount = 0;
	}
	
	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getAddress() {
		return this.address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Product[] getProducts() {
		return this.products;
	}

	public void setProducts(Product[] products) {
		this.products = products;
	}
	
	public String getName() {
		return this.name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public void expandProduct() {
		Product[] newProductsArray = new Product[this.products.length * 2];
		for (int i = 0; i < this.products.length; i++) {
			newProductsArray[i] = this.products[i];
		}
		this.products = newProductsArray;
	}
	
	//adding a product
	public void addProduct(String name, double price, String category) {
		if (this.productsCount >= this.products.length) {
			this.expandProduct();
		}
		this.products[this.productsCount] = new Product(name, price, category);
		
		this.productsCount++;
	}
	
	//display each product using the display method in "Product class"
	public void displayProducts() {
		for(int i = 0; i < this.products.length; i++) {
			if (this.products[i] == null) {
				break;
			}
			 System.out.println(products[i].toString());
		}
	}
	
	//calculating the sum of the products in the products array.
	public double cartPrice() {
		double sum = 0;
		for (int i = 0; i < this.products.length; i++) {
			if (this.products[i] == null) {
				return sum;
			}
			sum += this.products[i].getPrice();
		}
		return sum;
	}
	
}
