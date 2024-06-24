import java.util.Date;

public class Buyer {
	private String name;
	private String password;
	private String address;
	private Product[] products;
	private Cart[] previousCarts;
	private int productsCount;
	private int previousCartsCount;
	
	//constructor
	public Buyer(String name, String password, String address) {
		this.name = name;
		this.password = password;
		this.address = address;
		this.products = new Product[10]; // initiating with 10 if needed will be expanded
		this.productsCount = 0;
		this.previousCarts = new Cart[10];//initiating empty array in length 10 will expand if needed
		this.previousCartsCount = 0;
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
	
	public Cart[] getPreviousCarts() {
		return this.previousCarts;
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
	
	private Product[] expandProductArray(Product[] array) {
		Product[] newProductsArray = new Product[array.length * 2];
		for (int i = 0; i < array.length; i++) {
			newProductsArray[i] = array[i];
		}
		return newProductsArray;
	}
	
	private Cart[] expandCartArray(Cart[] array) {
		Cart[] newCartsArray = new Cart[array.length * 2];
		for (int i = 0; i < array.length; i++) {
			newCartsArray[i] = array[i];
		}
		return newCartsArray;
	}
	
	//adding a product
	public void addProduct(String name, double price, String category) {
		if (this.productsCount >= this.products.length) {
			//expand products
			this.products = expandProductArray(this.products);
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
			 System.out.println(this.products[i].toString());
		}
	}
	
	//display each previous product using the display method in "Product class"
	public void displayPreviousCarts() {
		for(int i = 0; i < this.previousCarts.length; i++) {
			if (this.previousCarts[i] == null) {
				break;
			}
			 System.out.println(this.previousCarts[i].toString());
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
	
	public void moveToPreviousCarts() {
		//expand if needed previous products to the size of products
		while(this.previousCarts.length < this.previousCartsCount) {
			this.previousCarts = expandCartArray(this.previousCarts);
		}
		if(this.productsCount != 0) {
			Product[] newProductsArray = new Product[this.productsCount];
			for(int i = 0; i < this.productsCount; i++) {
				newProductsArray[i] = this.products[i];
			}
		
		
		//move products into previous products and than reset products
			this.previousCarts[this.previousCartsCount] = new Cart(newProductsArray, new Date());
			this.products = new Product[10];	
			this.previousCartsCount++;
			this.productsCount = 0;
		}
	}
}
