import java.util.Arrays;
import java.util.Date;

public class Buyer extends Human{
	private String address;
	private Product[] products;
	private Cart[] previousCarts;
	private int productsCount;
	
	private int previousCartsCount;
	
	//constructor
	public Buyer(String name, String password, String address) {
		super(name, password);
		this.address = address;
		this.products = new Product[10]; // initiating with 10 if needed will be expanded
		this.productsCount = 0;
		this.previousCarts = new Cart[10];//initiating empty array in length 10 will expand if needed
		this.previousCartsCount = 0;
	}
	public int getProductsCount() {
		return productsCount;
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
	public String displayProducts() {
		String printText = "";
		for(int i = 0; i < this.products.length; i++) {
			if (this.products[i] == null) {
				break;
			}
			 printText += this.products[i].toString() + "\n";
		}
		return printText;
	}
	
	//display each previous product using the display method in "Product class"
	public String displayPreviousCarts() {
		String printText = "";
		for(int i = 0; i < this.previousCarts.length; i++) {
			if (this.previousCarts[i] == null) {
				break;
			}
<<<<<<< HEAD
			printText += i + ". " + this.previousCarts[i].toString() + "\n";
=======
			 System.out.println(i + ". " + this.previousCarts[i].toString());
>>>>>>> 92f61b5cc24c4613bb30c7c1b4133f499797098f
		}
		return printText;
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
	@Override
	public String toString() {
		return super.toString() + " " + "Buyer [address=" + address + ", products=" + Arrays.toString(products) + ", previousCarts="
				+ Arrays.toString(previousCarts) + ", productsCount=" + productsCount + ", previousCartsCount="
				+ previousCartsCount + "]";
		
		
	}
}
